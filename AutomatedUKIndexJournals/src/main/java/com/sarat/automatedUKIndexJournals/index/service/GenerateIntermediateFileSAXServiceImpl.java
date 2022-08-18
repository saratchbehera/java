package com.sarat.automatedUKIndexJournals.index.service;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.*;
import java.text.SimpleDateFormat;

public class GenerateIntermediateFileSAXServiceImpl extends DefaultHandler {

    private final String ID = "id";
    private final String DOCUMENT = "document";
    private final String TITLE = "title";
    private final String ABSTRACT = "abstract";
    private final String PARA = "para";
    private final String PARAGRAPH = "paragraph";

    private boolean isDocumentTitle;
    private boolean isAbstract;
    private boolean isPara;
    private boolean isTitle;
    private boolean isParagraph;

    private PrintWriter printWriter = null;

    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");

    public PrintWriter getPrintWriter() {
        return printWriter;
    }

    public void setPrintWriter(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    public SimpleDateFormat getSdf() {
        return sdf;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        try {
            if (qName != null)
                switch (qName) {
                    case DOCUMENT:
                        printWriter.print("<" + DOCUMENT + " ");
                        if (attributes != null && attributes.getLength() > 0) {
                            printWriter.print(ID + "=\"" + attributes.getValue(ID) + "\">");
                        }
                        break;
                    case TITLE:
                        if (!isTitle)
                            isDocumentTitle = true;
                        else if (isAbstract) {
                            isTitle = true;
                        }
                        break;
                    case ABSTRACT:
                        isAbstract = true;
                        break;
                    case PARA:
                        if (isAbstract | isParagraph) {
                            isPara = true;
                            printWriter.print("<para ");
                        }
                        if (attributes != null && attributes.getLength() > 0) {
                            printWriter.print(ID + "=\"" + attributes.getValue(ID) + "\">");
                        }
                        break;
                    case PARAGRAPH:
                        isParagraph = true;
                        printWriter.print("<paragraph ");

                        if (attributes != null && attributes.getLength() > 0) {
                            printWriter.print(ID + "=\"" + attributes.getValue(ID) + "\">");
                        }
                        break;
                    default:
                }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            printWriter.flush();
        }
    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {

    }

    @Override
    public void characters(char[] ch, int start, int length) {
        try {
            //String chars = new String(ch, start, length);
            String chars = String.copyValueOf(ch, start, length).trim();
            if (chars != null && chars.contains("\n"))
                chars = chars.replaceAll("\n", "");

            if (chars != null && !chars.isEmpty()) {

                if (isDocumentTitle && !isTitle) {
                    printWriter.print(chars);
                    //System.out.println(chars);
                }

                if (isAbstract) {
                    if (isTitle) {
                        //printWriter.print(chars);
                        // System.out.println(chars);
                    }
                    if (isPara) {
                        printWriter.print(chars);
                        //System.out.println(chars);
                    }
                }

                if (isParagraph) {
                    if (isPara) {
                        printWriter.print(chars);
                        //System.out.println(chars);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            printWriter.flush();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {

        try {
            if (qName != null)
                switch (qName) {
                    case DOCUMENT:
                        printWriter.print("</" + DOCUMENT + ">");
                        break;
                    case TITLE:
                        if (!isTitle)
                            isDocumentTitle = false;
                        else if (isAbstract) {
                            isTitle = false;
                        }
                        break;
                    case ABSTRACT:
                        isAbstract = false;
                        break;
                    case PARA:
                        if (isAbstract | isParagraph) {
                            isPara = false;
                            printWriter.print("</para>");
                        }
                        break;
                    case PARAGRAPH:
                        isParagraph = false;
                        printWriter.print("</paragraph>");
                        //System.out.println("\n\n" + paragraphContent.toString());
                        break;
                    default:

                }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            printWriter.flush();
            if (qName != null && qName.equals(DOCUMENT) && printWriter != null) {
                printWriter.close();
            }
        }
    }
}
