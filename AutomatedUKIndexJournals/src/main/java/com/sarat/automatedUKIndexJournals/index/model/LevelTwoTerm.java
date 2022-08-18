package com.sarat.automatedUKIndexJournals.index.model;

import javax.xml.bind.annotation.*;
import java.util.Set;

@XmlRootElement(name = "term-entry")
@XmlSeeAlso({LevelOneTerm.class})
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(propOrder = { "levelTwoTermID", "levelTwoTermName", "contentReference", "synonyms" })
public class LevelTwoTerm {

	@XmlElement(name = "term")
	private String levelTwoTermName;
	@XmlAttribute(name = "id")
	private String levelTwoTermID;
	@XmlElement(name = "content-reference")
	private Set<String> contentReference;
	@XmlElement(name = "synonyms")
	private Set<String> synonyms;

	public LevelTwoTerm() {
	}

	public LevelTwoTerm(String levelTwoTermName, String levelTwoTermID, Set<String> contentReference, Set<String> synonyms) {
		this.levelTwoTermName = levelTwoTermName;
		this.levelTwoTermID = levelTwoTermID;
		this.contentReference = contentReference;
		this.synonyms = synonyms;
	}

	public String getLevelTwoTermID() { return levelTwoTermID; }

	public void setLevelTwoTermID(String levelTwoTermID) { this.levelTwoTermID = levelTwoTermID; }

	public String getLevelTwoTermName() {
		return levelTwoTermName;
	}

	public void setLevelTwoTermName(String levelTwoTermName) {
		this.levelTwoTermName = levelTwoTermName;
	}

	public Set<String> getContentReference() {
		return contentReference;
	}

	public void setContentReference(Set<String> contentReference) {
		this.contentReference = contentReference;
	}

	public Set<String> getSynonyms() {
		return synonyms;
	}

	public void setSynonyms(Set<String> synonyms) {
		this.synonyms = synonyms;
	}

	@Override
	public String toString() {
		if(contentReference != null)
			return levelTwoTermName + " " +levelTwoTermID +" - " + contentReference;
		else
			return levelTwoTermName+ " " +levelTwoTermID ;
	}
}
