package com.sarat.dom;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class TestDOMparse {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		Document doc = xMLReaderDOM("C:\\Data\\Work\\Workplace\\gitPracticeJava\\Practice\\src\\practice\\sarat\\dom\\assembledDocument.xml");
				//"C:\\Users\\u6039740\\Desktop\\assembledDocument.xml");
		
		if(doc != null) {
			System.out.println("parsed");
		}else {
			System.out.println("parsed failed");
		}

	}
	
	public static Document xMLReaderDOM(String FILE_PATH)
		    throws ParserConfigurationException, SAXException, IOException
		  {
		    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		    factory.setNamespaceAware(true);
		    factory.setValidating(false);
		    
		    DocumentBuilder builder = factory.newDocumentBuilder();
		    Document doc = builder.parse(FILE_PATH);
		    return doc;
		  }

}
