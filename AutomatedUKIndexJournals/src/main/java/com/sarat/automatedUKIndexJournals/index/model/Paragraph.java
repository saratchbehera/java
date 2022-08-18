package com.sarat.automatedUKIndexJournals.index.model;

public class Paragraph {
	
	private String paragraphId;
	private String paraId;
	private String documentId;
	private String paraContent;

	public String getParagraphId() {
		return paragraphId;
	}

	public void setParagraphId(String paragraphId) {
		this.paragraphId = paragraphId;
	}

	public String getParaId() {
		return paraId;
	}

	public void setParaId(String paraId) {
		this.paraId = paraId;
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public String getParaContent() {
		return paraContent;
	}

	public void setParaContent(String paraContent) {
		this.paraContent = paraContent;
	}
}