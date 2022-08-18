package com.sarat.automatedUKIndexJournals.index.controller;

import com.sarat.automatedUKIndexJournals.index.service.GenerateTermListFileSAXServiceImpl;
import com.sarat.automatedUKIndexJournals.index.model.LevelOneTerm;
import com.sarat.automatedUKIndexJournals.index.model.LevelTwoTerm;
import com.sarat.automatedUKIndexJournals.index.model.Paragraph;
import com.sarat.automatedUKIndexJournals.index.service.GenerateIntermediateFileSAXServiceImpl;
import com.sarat.automatedUKIndexJournals.index.util.NaturalOrderComparator;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.*;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenerateIndexEntriesController {

    static SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
    //private static String INDEX_FILE = "C:\\Users\\u6039740\\OneDrive - Thomson Reuters Incorporated\\Work\\Workplace\\UKIndexJournalsUploadDir\\EHRLR_Index_2018_EHRLR_Bound_Volume_Print_.xml";
    public static String BASE_DIR = "C:\\Users\\u6039740\\OneDrive - Thomson Reuters Incorporated\\Work\\Workplace\\UKIndexJournalsUploadDir\\GIE POC\\";
    //public static String INDEX_FILE = BASE_DIR + "HumanRights.xml";
    public static String INDEX_FILE = BASE_DIR + "temp_HumanRights.xml";
    public static String OUTPUT_FILE = "";
    public static String DOCUMENT_NEED_TO_BE_INDEXED = BASE_DIR + "2018_EHRLR_Issue_1_Art_1_Eicke.xml";
    //public static String DOCUMENT_NEED_TO_BE_INDEXED = BASE_DIR + "LastParaTest.xml";

    private static final String INDEXTXTFILE = "GenerateIndexEntriesReport.txt";
    private static final String ERRORINPROCESSINGTERMSTXT = "NonProcessedTermsReport.txt";

    private static Set<String> errorPatternsSet = new HashSet<>();
    private static Set<String> errorProcessingSet = new HashSet<>();
    private static StringBuffer errorProcessingTerms = new StringBuffer();

    public StringBuffer getErrorProcessingTerms() {
        return errorProcessingTerms;
    }

    public void setErrorProcessingTerms(StringBuffer errorProcessingTerms) {
        this.errorProcessingTerms = errorProcessingTerms;
    }


    public static void main(String[] args) {
        generateIndexes(DOCUMENT_NEED_TO_BE_INDEXED, INDEX_FILE, BASE_DIR);
    }

    private static void generateIndexes(String DOCUMENT_NEED_TO_BE_INDEXED, String INDEX_FILE, String BASE_DIR) {

        String DOCUMENT_NEED_TO_BE_INDEXED_ESCAPE_ENTITIES = DOCUMENT_NEED_TO_BE_INDEXED.substring(0, DOCUMENT_NEED_TO_BE_INDEXED.lastIndexOf(".xml")) + "_escapeEntities.xml";
        String INTERMEDIATE_FILE = DOCUMENT_NEED_TO_BE_INDEXED.substring(0, DOCUMENT_NEED_TO_BE_INDEXED.lastIndexOf(".xml")) + "_intermediate.xml";

        File documentNeedToBeIndexed = new File(DOCUMENT_NEED_TO_BE_INDEXED_ESCAPE_ENTITIES);

        if (documentNeedToBeIndexed.exists() && documentNeedToBeIndexed.delete()) {
            System.out.println("Temp file has been deleted");
        }

        if(escapeEntities(DOCUMENT_NEED_TO_BE_INDEXED, DOCUMENT_NEED_TO_BE_INDEXED_ESCAPE_ENTITIES)) {

            System.out.println("");

            GenerateIntermediateFileSAXServiceImpl generateIntermediateFileSAX = new GenerateIntermediateFileSAXServiceImpl();
            generateIntermediateFileSAXHandler(DOCUMENT_NEED_TO_BE_INDEXED_ESCAPE_ENTITIES, INTERMEDIATE_FILE, generateIntermediateFileSAX);

            String INTERMEDIATE_FILE_ESCAPE_ENTITIES = INTERMEDIATE_FILE.substring(0, INTERMEDIATE_FILE.lastIndexOf(".xml")) + "_escapeEntities.xml";

            if (escapeEntities(INTERMEDIATE_FILE, INTERMEDIATE_FILE_ESCAPE_ENTITIES)) {

                GenerateTermListFileSAXServiceImpl generateTermListFileSAX = new GenerateTermListFileSAXServiceImpl();
                generateIntermediateFileSAXHandler(INTERMEDIATE_FILE_ESCAPE_ENTITIES, "", generateTermListFileSAX);

                System.out.println("Paragraph Size :: " + generateTermListFileSAX.getParagraphList().size());

                if (!INDEX_FILE.isEmpty()) {
                    try {
                        List<LevelOneTerm> termsList = ReadL1L2Terms(new File(INDEX_FILE));

                        if (generateTermListFileSAX.getParagraphList().size() > 0)
                            findL2DesignatorEntries(termsList, generateTermListFileSAX.getParagraphList());

                    } catch (IOException io) {
                        io.printStackTrace();
                    }
                }
            }
        }


    }

    public static void generateIntermediateFileSAXHandler(String inputFilePath, String outputFilePath, Object SAXHandler) {
        try {
            System.out.println("Input  File :: " + inputFilePath);
            System.out.println("Output File :: " + outputFilePath);

            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();

            File xmlFile = new File(inputFilePath);
            InputStream inputStream = new FileInputStream(xmlFile);
            InputStreamReader inputReader = new InputStreamReader(inputStream, "UTF-8");
            InputSource inputSource = new InputSource(inputReader);
            inputSource.setEncoding("UTF-8");

            if (SAXHandler instanceof GenerateIntermediateFileSAXServiceImpl && !outputFilePath.isEmpty()) {
                ((GenerateIntermediateFileSAXServiceImpl) SAXHandler).setPrintWriter(new PrintWriter(new FileOutputStream(outputFilePath)));
                saxParser.parse(inputSource, (GenerateIntermediateFileSAXServiceImpl) SAXHandler);
            }else if (SAXHandler instanceof GenerateTermListFileSAXServiceImpl){
                saxParser.parse(inputSource, (GenerateTermListFileSAXServiceImpl) SAXHandler);
            }

        } catch (IOException | SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static List<LevelOneTerm> ReadL1L2Terms(File termListFile) throws IOException {

        List<LevelOneTerm> l1List = new ArrayList<>();
        try {
            if (!termListFile.exists()) {
                System.out.println("The file termList.xml is not there");
            } else
                System.out.println("L1L2 TermList file :: " + termListFile.getCanonicalPath());

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder;

            dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(termListFile);
            doc.getDocumentElement().normalize();

            XPath xPath = XPathFactory.newInstance().newXPath();

            String expression = "//l1";
            NodeList termsList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);
            System.out.println(sdf.format(new Date()) + " - " + "termsList data mapping in progress ... ");
            for (int i = 0; i < termsList.getLength(); i++) {
                Node nNode = termsList.item(i);

                NodeList children = nNode.getChildNodes();
                Set<String> l2s = new HashSet<String>();

                LevelOneTerm l1 = new LevelOneTerm();

                Set<LevelTwoTerm> l2List = new HashSet<>();

                for (int k = 0; k < children.getLength(); k++) {
                    Node child = children.item(k);
                    LevelTwoTerm l2 = new LevelTwoTerm();
                    if (child != null && child.getNodeType() != Node.TEXT_NODE) {
                        if (child.getFirstChild() != null && child.getFirstChild().getNodeType() == Node.TEXT_NODE) {
                            if (child.getFirstChild().getNodeValue() != null) {

                                NodeList syns = child.getChildNodes();
                                Set<String> synonymsSet = new HashSet<String>();
                                for (int s = 0; s < syns.getLength(); s++) {
                                    Node syn = syns.item(s);
                                    if (syn != null && syn.getNodeType() != Node.TEXT_NODE) {
                                        if (syn.getFirstChild() != null && syn.getFirstChild().getNodeType() == Node.TEXT_NODE) {
                                            if (syn.getFirstChild().getNodeValue() != null) {
                                                synonymsSet.add(syn.getFirstChild().getNodeValue().trim());
                                            }
                                        }
                                    }
                                }
                                l2.setSynonyms(synonymsSet);
                                l2s.add(child.getFirstChild().getNodeValue().trim());
                            }
                            l2.setLevelTwoTermName(child.getFirstChild().getNodeValue().trim());
                            l2List.add(l2);
                        }
                    } else {
                        if (child != null && !child.getNodeValue().trim().equals("")) {
                            l1.setLevelOneTermName(child.getNodeValue().trim());
                        }
                    }
                }

                l1.setLevelTwoTerms(l2List);
                l1List.add(l1);
            }

        } catch (IOException | SAXException | ParserConfigurationException | XPathExpressionException e) {
            e.printStackTrace();
        }

        return l1List;
    }

    public static boolean escapeEntities(String sInFileName, String sOutFileName) {
        try {
            FileInputStream in = new FileInputStream(sInFileName);
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(sOutFileName)));

            if (in == null) {
                return false;
            }

            char cChar;
            int nInt;

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            nInt = bufferedReader.read();

            while (nInt != -1) {
                cChar = (char) nInt;

                if (cChar == '&') {
                    out.print("&amp;");
                } else {
                    out.print(cChar);
                }

                nInt = bufferedReader.read();
            }

            out.flush();
            out.close();
            in.close();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static List<LevelOneTerm> findL2DesignatorEntries(List<LevelOneTerm> l1List, List<Paragraph> paragraphList) throws IOException {

        if(!paragraphList.isEmpty())
            System.out.println(sdf.format(new Date())+" - "+"Paragraphs mapped to objects");

        List<LevelOneTerm> l1Final = new ArrayList<>();

        if (l1List != null && !l1List.isEmpty()) {

            Matcher matcher;
            for (LevelOneTerm l1Val : l1List) {

                String l1Name = l1Val.getLevelOneTermName();
                if (l1Name.equals("ACCESS TO JUSTICE"))
                    System.out.println();
                LevelOneTerm l1Temp = new LevelOneTerm();
                Set<LevelTwoTerm> l2s = new HashSet<>();

                for (LevelTwoTerm l2 : l1Val.getLevelTwoTerms()) {
                    Set<String> contentReference = new TreeSet<String>();
                    LevelTwoTerm l2Temp = new LevelTwoTerm();
                    l2Temp.setLevelTwoTermName(l2.getLevelTwoTermName());
                    if (l2.getLevelTwoTermName().equals("Case law"))
                        System.out.println();

                    for (Paragraph p : paragraphList) {
                        l1Temp.setLevelOneTermID(p.getParagraphId());
                        if (p != null) {
                            matcher = checkl1l2presence(l1Name, p.getParaContent());
                            if (matcher != null && matcher.find()) {
                                matcher = checkl1l2presence(l2.getLevelTwoTermName(), p.getParaContent());
                                if (matcher != null && matcher.find()) {
                                    //designators.add(section.getDesignator());
                                    contentReference.add(p.getParaId());
                                    //l2Temp.setLevelTwoTermID(p.getParaId());
                                }

                                if (l2.getSynonyms() != null) {
                                    for (String sy : l2.getSynonyms()) {
                                        matcher = checkl1l2presence(sy, p.getParaContent());
                                        if (matcher != null && matcher.find()) {
                                            //designators.add(section.getDesignator());
                                            contentReference.add(p.getParaId());
                                            //l2Temp.setLevelTwoTermID(p.getParaId());
                                        }
                                    }
                                }
                            }

                        }
                    }
                    l2Temp.setContentReference(contentReference);

                    if (!contentReference.isEmpty())
                        l2s.add(l2Temp);
                }

                l1Temp.setLevelOneTermName(l1Name);
                l1Temp.setLevelTwoTerms(l2s);

                if (!l2s.isEmpty()) {
                    l1Final.add(l1Temp);
                }
            }

            if (!errorPatternsSet.isEmpty()) {
                System.out.println("Indexing done with few exceptions :: Below is list of l1/l2 not processed ::\n");

                for (String err : errorPatternsSet)
                    System.out.println(err);

                if (!errorProcessingSet.isEmpty())
                    for (String terms : errorProcessingSet) {
                        errorProcessingTerms.append(terms + "\n");
                    }
            }
            if (errorProcessingTerms.length() > 0)
                createFile(errorProcessingTerms.toString(), BASE_DIR, ERRORINPROCESSINGTERMSTXT);
            else
                createFile("No error terms in the termsList File", BASE_DIR, ERRORINPROCESSINGTERMSTXT);

            System.out.println();

            if (!l1Final.isEmpty()) {
                System.out.println(sdf.format(new Date()) + " - " + "indexing is done.");
                createTermListOutputTXTFile(l1Final, BASE_DIR, INDEXTXTFILE);
                    try {
                        JAXBContext contextObj = JAXBContext.newInstance(
                                LevelOneTerm.class, LevelTwoTerm.class
                        );

                        Marshaller marshallerObj = contextObj.createMarshaller();
                        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

                        marshallerObj.marshal(l1Final, new FileOutputStream(BASE_DIR + "termsList.xml"));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                //createOutputTermListFile(l1Final, BASE_DIR+INDEXTXTFILE);
            } else {
                createFile("No matching terms from the termsList File in the selected content", BASE_DIR, INDEXTXTFILE);
            }
        }
        return l1Final;
    }



    private static Matcher checkl1l2presence(String name, String paragraphContent) {
        try {

            String regex = "\\b" + name + "\\b";
            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = null;

            if (paragraphContent != null) {
                matcher = pattern.matcher(paragraphContent.toUpperCase());
            }
            return matcher;

        } catch (Exception ex) {
            errorProcessingSet.add(name);
            errorPatternsSet.add(ex.getMessage());
            return null;
        }
    }


    public static void createFile(String content, String xmlFilePath, String fileName) {
        File file = null;
        FileWriter fr = null;
        try {
            file = new File(xmlFilePath + fileName);
            if (file.exists()) {
                System.out.println("File Created :: " + xmlFilePath + fileName);
                fr = new FileWriter(file);
                fr.write(content);
            } else {
                file = new File(xmlFilePath + fileName);
                fr = new FileWriter(file);
                fr.write(content);
                System.out.println("File Created :: " + xmlFilePath + fileName);
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createOutputTermListFile(List<LevelOneTerm> l1Final, String INDEX_FILE_PATH) {
        File txtFilePathFile = null;
        if (!new File(INDEX_FILE_PATH).exists())
            txtFilePathFile = new File(INDEX_FILE_PATH);

        try {
            FileWriter fw = new FileWriter(INDEX_FILE_PATH);
            LinkedList<String> contentReferenceRangeList = new LinkedList<String>();
            Collections.sort(l1Final, new NaturalOrderComparator());
            for (LevelOneTerm l1 : l1Final) {
                fw.write("<L1>" + l1.getLevelOneTermName() + "\n");
                Set<LevelTwoTerm> l2list = new TreeSet<LevelTwoTerm>(new NaturalOrderComparator());
                l2list.addAll(l1.getLevelTwoTerms());
                for (LevelTwoTerm l2 : l2list) {
                    fw.write("<L2>" + l2.getLevelTwoTermName() + ", <CITE>");
                    LinkedList<String> contentReference = new LinkedList<String>();
                    contentReference.addAll(l2.getContentReference());
                    Collections.sort(contentReference, new NaturalOrderComparator());
                    //System.out.println(contentReference);
                    contentReferenceRangeList = getDesignatorRangeList(contentReference);
                    //System.out.println("Designator included Range :: \n"+designatorRangeList);
                    for (String d : contentReferenceRangeList) {
                        if (!(d.equals(contentReferenceRangeList.getLast()))) {
                            fw.write(d + ", ");
                        } else {
                            fw.write(d);
                        }
                    }
                    fw.write("\n");
                }
            }

            fw.close();
            System.out.println("Index File Location : "+INDEX_FILE_PATH);
            System.out.println(sdf.format(new Date()) + " - " + "index.txt file generated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createTermListOutputTXTFile(List<LevelOneTerm> l1Final, String BASE_DIR, String INDEXTXTFILE) {

        final String txtFilePath = BASE_DIR + INDEXTXTFILE;
        File txtFilePathFile = null;
        if (!new File(txtFilePath).exists())
            txtFilePathFile = new File(txtFilePath);

        try {
            FileWriter fw = new FileWriter(txtFilePath);
            LinkedList<String> contentReferenceRangeList = new LinkedList<String>();
            Collections.sort(l1Final, new NaturalOrderComparator());
            for (LevelOneTerm l1 : l1Final) {
                fw.write("<L1>" + l1.getLevelOneTermName() + "\n");
                Set<LevelTwoTerm> l2list = new TreeSet<LevelTwoTerm>(new NaturalOrderComparator());
                l2list.addAll(l1.getLevelTwoTerms());
                for (LevelTwoTerm l2 : l2list) {
                    fw.write("<L2>" + l2.getLevelTwoTermName() + ", <CITE>");
                    LinkedList<String> contentReference = new LinkedList<String>();
                    contentReference.addAll(l2.getContentReference());
                    Collections.sort(contentReference, new NaturalOrderComparator());
                    //System.out.println(contentReference);
                    contentReferenceRangeList = getDesignatorRangeList(contentReference);
                    //System.out.println("Designator included Range :: \n"+designatorRangeList);
                    for (String d : contentReferenceRangeList) {
                        if (!(d.equals(contentReferenceRangeList.getLast()))) {
                            fw.write(d + ", ");
                        } else {
                            fw.write(d);
                        }
                    }
                    fw.write("\n");
                }
            }

            fw.close();
            System.out.println("Index File Location : "+txtFilePath);
            System.out.println(sdf.format(new Date()) + " - " + "index.txt file generated");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * this adds sequence to the list
     * i.e. 19:1, 19:2, 19:3, 19:4, 19:5
     * will be converted to
     * 19:1 to 19:5
     *
     * @param designatorList
     * @return
     **/
    public static LinkedList<String> getDesignatorRangeList(List<String> designatorList) {
        //System.out.println("designatorList  :: "+designatorList);
        List<String> tempContiniousDesignatorList = new LinkedList<String>();
        LinkedList<String> continiousDesignatorList = new LinkedList<String>();

        for (int i = 0; i < designatorList.size(); ) {

            String first = designatorList.get(i);
            String[] firstArr = first.split(":");
            //System.out.println("firstArr :: "+ Arrays.asList(firstArr));
            if (i < designatorList.size() - 1) {
                String second = designatorList.get(++i);
                String[] secondArr = second.split(":");
                //System.out.println("secondArr :: "+ Arrays.asList(secondArr));
                //Check for initials like 11.40 and 11:50, this firstArr[0] and secondArr[0] will match the 11 from 11:40
                if (firstArr[0].equals(secondArr[0])) {
                    if ((!secondArr[1].matches(".*[a-zA-Z].*") || !firstArr[1].matches(".*[a-zA-Z].*"))
                            && (Integer.parseInt((secondArr[1].split("\\.")[0])
                            .matches(".*[a-zA-Z].*") ? getSeperatedSectionArray(secondArr[1].split("\\.")[0])[0] : secondArr[1].split("\\.")[0])
                            - Integer.parseInt((firstArr[1].split("\\.")[0])
                            .matches(".*[a-zA-Z].*") ? getSeperatedSectionArray(firstArr[1].split("\\.")[0])[0] : firstArr[1].split("\\.")[0])
                            <= 1)) {

                        if (!(first.split(":")[1]).matches(".*[a-zA-Z].*"))
                            tempContiniousDesignatorList.add(first);
                        else
                            continue;

                        if (!(second.split(":")[1]).matches(".*[a-zA-Z].*"))
                            tempContiniousDesignatorList.add(second);
                        else
                            continue;


                        first = second;
                        if (i < designatorList.size() - 1) {
                            second = designatorList.get(++i);

                            if ((second.split(":")[1]).matches(".*[a-zA-Z].*")) {

                                if (tempContiniousDesignatorList.size() > 2)
                                    continiousDesignatorList.add(tempContiniousDesignatorList.get(0) + " to " + first);
                                else
                                    continiousDesignatorList.addAll(tempContiniousDesignatorList);
                                tempContiniousDesignatorList.clear();
                            }
                            if (!(second.split(":")[1]).matches(".*[a-zA-Z].*")) {
                                if ((Integer.parseInt(second.split(":")[1].split("\\.")[0]) - Integer.parseInt(first.split(":")[1].split("\\.")[0]) > 1)
                                        || (Integer.parseInt(first.split(":")[1].split("\\.")[0]) - Integer.parseInt(second.split(":")[1].split("\\.")[0]) > 1)
                                ) {
                                    //tempContiniousDesignatorList.add(first);
                                    //System.out.println(tempContiniousDesignatorList);
                                    if (tempContiniousDesignatorList.size() > 2)
                                        continiousDesignatorList.add(tempContiniousDesignatorList.get(0) + " to " + first);
                                    else
                                        continiousDesignatorList.addAll(tempContiniousDesignatorList);
                                    tempContiniousDesignatorList.clear();
                                }
                            } else
                                continue;
                        } else {
                            if (tempContiniousDesignatorList.size() > 2) {
                                continiousDesignatorList.add(tempContiniousDesignatorList.get(0) + " to " + first);
                                break;
                            } else {
                                continiousDesignatorList.addAll(tempContiniousDesignatorList);
                                break;
                            }
                        }

                        continue;

                    } else {
                        if (!(first.split(":")[1]).matches(".*[a-zA-Z].*")) {
                            tempContiniousDesignatorList.add(first);
                            if (tempContiniousDesignatorList.size() > 1)
                                continiousDesignatorList.add(tempContiniousDesignatorList.get(0) + " to " + first);
                            else
                                continiousDesignatorList.add(first);

                            tempContiniousDesignatorList.clear();
                        } else {
                            if (tempContiniousDesignatorList.size() > 1) {
                                continiousDesignatorList.add(tempContiniousDesignatorList.get(0) + " to " + tempContiniousDesignatorList.get(tempContiniousDesignatorList.size() - 1));
                                continiousDesignatorList.add(first);
                            } else
                                continiousDesignatorList.add(first);

                            tempContiniousDesignatorList.clear();
                        }
                    }
                } else {
                    tempContiniousDesignatorList.add(first);
                    //System.out.println(tempContiniousDesignatorList);
                    if (tempContiniousDesignatorList.size() > 1)
                        continiousDesignatorList.add(tempContiniousDesignatorList.get(0) + " to " + first);
                    else
                        continiousDesignatorList.add(first);

                    tempContiniousDesignatorList.clear();
                }
            } else {
                if (tempContiniousDesignatorList.size() > 0)
                    continiousDesignatorList.add(tempContiniousDesignatorList.get(0) + " to " + first);
                else
                    continiousDesignatorList.add(first);

                //System.out.println(first);
                break;
            }

        }

        return continiousDesignatorList;
    }

    public static String[] getSeperatedSectionArray(String sectionNo) {
        //System.out.println(sectionNo.toCharArray());
        String number = "";
        String numPostFix = "";
        char preTemp = 0;
        char preTempDigit = 0;
        for (char c : sectionNo.toCharArray()) {
            //System.out.println(c);
            if ((Character.isDigit(c))) {
                if (Character.isDigit(preTemp) && preTemp != 0)
                    number += Character.toString(c);
                else
                    number = Character.toString(c);
                preTemp = c;
            } else if (Character.isLetter(c)) {
                if (!Character.isLetter(preTemp) && preTemp != 0)
                    numPostFix += Character.toString(c);
                else if (Character.isLetter(preTemp) && preTemp != 0)
                    numPostFix += Character.toString(c);
                preTemp = c;
            }
        }

        String[] sep = {number, numPostFix};
        //System.out.println("Seperated :: number :: "+ number + " chars :: "+numPostFix);
        //System.out.println(Arrays.asList(sep));

        return sep;
    }
}
