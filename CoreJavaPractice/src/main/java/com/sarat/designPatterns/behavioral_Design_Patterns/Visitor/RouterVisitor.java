package com.sarat.designPatterns.behavioral_Design_Patterns.Visitor;

public interface RouterVisitor {
	
    public void visit(DLinkRouter router);
    public void visit(TPLinkRouter router);
    public void visit(LinkSysRouter router);
}