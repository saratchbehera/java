package com.sarat.designPatterns.behavioral_Design_Patterns.Mediator;

/**
 * Mediator enables decoupling of objects by introducing a layer in between 
 * so that the interaction between objects happen via the layer.
 * 
 * In an enterprise application where we have large number of classes the complexity 
 * also increases proportionately. 
 * 
 * Business logic might be spread across those multiple classes. 
 * There will be interaction between classes. That will be messy.
 * 
 * @author Sarat Behera
 *
 */
public class MediatorDesignPatternTest {

	public static void main(String[] args) {
		
		WhatsupGroup javaGroup = new WhatsupGroupImpl();
		
	    GroupMember sarat = new GroupMemberImpl(javaGroup, "Sarat");
	    GroupMember poornima = new GroupMemberImpl(javaGroup, "Poornima");
	    GroupMember sandeep = new GroupMemberImpl(javaGroup, "Sandeep");
	        
	    javaGroup.registerUser(sarat);
	    javaGroup.registerUser(poornima);
	    javaGroup.registerUser(sandeep);

	    
	    sandeep.send("These java discussions are very good. Get to know a lot of things !!! ");
	    
	    System.out.println("-------------------------------------------------------------------");
	    
	    poornima.send("Let's discuss Design Patterns? ");
	    
	    System.out.println("-------------------------------------------------------------------");
	    sarat.send("Wow that's Great ! Let's do it");

	}

}
