package com.sarat.automatedUKIndexJournals.index.service;

import com.sarat.automatedUKIndexJournals.index.model.Paragraph;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class GenerateTermListFileSAXServiceImpl extends DefaultHandler {

    private final String ID = "id";
    private final String DOCUMENT = "document";
    private final String PARA = "para";
    private final String PARAGRAPH = "paragraph";

    private boolean isPara;
    private boolean isParagraph;
    private String documentID;

    private StringBuffer paragraphContent = new StringBuffer();

    Paragraph paragraph;
    private List<Paragraph> paragraphList = new ArrayList<>();

    public List<Paragraph> getParagraphList() {
        return paragraphList;
    }

    public void setParagraphList(List<Paragraph> paragraphList) {
        this.paragraphList = paragraphList;
    }

    public Paragraph getParagraph() {
        return paragraph;
    }

    public void setParagraph(Paragraph paragraph) {
        this.paragraph = paragraph;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        try {
            if (qName != null)
                switch (qName) {
                    case DOCUMENT:

                        if (attributes != null && attributes.getLength() > 0) {
                            this.documentID = attributes.getValue(ID);
                        }
                        break;
                    case PARA:
                            isPara = true;
                        if (attributes != null && attributes.getLength() > 0) {
                            if (isParagraph) {
                                paragraph.setParaId(attributes.getValue(ID));
                            }
                        }
                        break;
                    case PARAGRAPH:
                        isParagraph = true;
                        paragraph = new Paragraph();
                        paragraph.setDocumentId(this.documentID);
                        if (attributes != null && attributes.getLength() > 0) {
                            paragraph.setParagraphId(attributes.getValue(ID));
                        }
                        break;
                    default:
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {

    }

    @Override
    public void characters(char[] ch, int start, int length) {
        try {
            String chars = String.copyValueOf(ch, start, length).trim();
            if (chars.length() > 0 && chars.contains("\n"))
                chars = chars.replaceAll("\n", "");

            if (chars.length() > 0) {
                if (isParagraph && isPara) {
                    paragraphContent.append(chars);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {

        try {
            if (qName != null)
                switch (qName) {
                    case PARA:
                            isPara = false;
                            if (isParagraph){
                                paragraph.setParaContent(paragraphContent.toString());
                            }
                        break;
                    case PARAGRAPH:
                        isParagraph = false;
                        paragraphList.add(paragraph);
                        paragraphContent.delete(0, paragraphContent.length());
                        break;
                    default:

                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
