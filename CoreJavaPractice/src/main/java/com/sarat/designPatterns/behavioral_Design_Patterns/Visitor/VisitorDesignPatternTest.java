package com.sarat.designPatterns.behavioral_Design_Patterns.Visitor;

import junit.framework.TestCase;


/**
 * <p><b>Visitor Design Pattern</b></p>
 * 
 * You need to add a new method to a hierarchy of classes, but the act of adding it might be painful or damaging to the design.
 * So clearly, you want a hierarchy of objects to modify their behavior but without modifying their source code. How to do that? To solve this problem, visitor pattern comes into picture.
 * 
 * 	Visitor – This is an interface or an abstract class used to declare the visit operations for all the types of visitable classes.

 *	ConcreteVisitor – For each type of visitor all the visit methods, declared in abstract visitor, must be implemented. Each Visitor will be responsible for different operations.

 *	Visitable – is an interface which declares the accept operation. This is the entry point which enables an object to be “visited” by the visitor object.

 *	ConcreteVisitable – Those classes implements the Visitable interface or class and defines the accept operation. The visitor object is passed to this object using the accept operation.
 * 
 * @author Sarat Behera
 *
 */
public class VisitorDesignPatternTest extends TestCase{

	private MacConfigurator macConfigurator;
    private LinuxConfigurator linuxConfigurator;
    private DLinkRouter dlink;
    private TPLinkRouter tplink;
    private LinkSysRouter linksys;
     
    public void setUp()
    {
        macConfigurator = new MacConfigurator();
        linuxConfigurator = new LinuxConfigurator();
         
        dlink = new DLinkRouter();
        tplink = new TPLinkRouter();
        linksys = new LinkSysRouter();
    }
     
    public void testDlink()
    {
        dlink.accept(macConfigurator);
        dlink.accept(linuxConfigurator);
    }
     
    public void testTPLink()
    {
        tplink.accept(macConfigurator);
        tplink.accept(linuxConfigurator);
    }
     
    public void testLinkSys()
    {
        linksys.accept(macConfigurator);
        linksys.accept(linuxConfigurator);
    }
}
