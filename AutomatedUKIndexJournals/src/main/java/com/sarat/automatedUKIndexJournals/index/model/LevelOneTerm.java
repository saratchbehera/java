package com.sarat.automatedUKIndexJournals.index.model;

import javax.xml.bind.annotation.*;
import java.util.Set;

@XmlRootElement(name = "term-entry")
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(propOrder = { "levelOneTermID", "levelOneTermName", "levelTwoTerms" })
public class LevelOneTerm {

    @XmlElement(name = "term")
    private String levelOneTermName;
    @XmlAttribute(name = "id")
    private String levelOneTermID;
    @XmlElement(name = "term-entry")
    private Set<LevelTwoTerm> levelTwoTerms;

    public LevelOneTerm() {
    }

    public LevelOneTerm(String levelOneTermName, String levelOneTermID, Set<LevelTwoTerm> levelTwoTerms) {
        this.levelOneTermName = levelOneTermName;
        this.levelOneTermID = levelOneTermID;
        this.levelTwoTerms = levelTwoTerms;
    }


    public String getLevelOneTermName() {
        return levelOneTermName;
    }

    public void setLevelOneTermName(String levelOneTermName) {
        this.levelOneTermName = levelOneTermName;
    }


    public String getLevelOneTermID() { return levelOneTermID; }

    public void setLevelOneTermID(String levelOneTermID) { this.levelOneTermID = levelOneTermID; }


    public Set<LevelTwoTerm> getLevelTwoTerms() {
        return levelTwoTerms;
    }

    public void setLevelTwoTerms(Set<LevelTwoTerm> levelTwoTerms) {
        this.levelTwoTerms = levelTwoTerms;
    }

    @Override
    public String toString() {
        return "\n" + levelOneTermName +" "+ levelOneTermID + "\n" + levelTwoTerms;
    }
}