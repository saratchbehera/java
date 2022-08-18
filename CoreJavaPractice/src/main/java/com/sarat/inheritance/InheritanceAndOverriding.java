package com.sarat.inheritance;

/**					^
 * p - public		|
 * p - protected	|	low range to high range in access modifiers
 * d - default		|	Only same or above level access modifiers can override a particular method. 
 * p - private		|
 * 
 * 1. parent class object can only access the parent class methods.
 * 2. child class object can access child class as well as parent class methods.
 * 3. a reference type variable of parent i.e. Parent childref = new Child(); can only access parent class methods by default.
 * 4. a child class object cannot create a parent class reference type variable. 
 */
class Parent{

   public void doSomething(){
      System.out.println("In  Parent Public doSomething()");
   }
   
   public void doathing(){
	   System.out.println("In  Parent Public doathing()");
   }   
   
   void overrideTest(){
	   System.out.println("In  Parent default defaultOverrideTest()");
   }   
}

class Child extends Parent{

   public void doSomething(){
      System.out.println("In Child public doSomething()");
   }
   
   public void doSome(){
	   System.out.println("In Child public doSome()");
   }
   
   public void doS(){
	   System.out.println("In Child public doS()");
   }
   
   void overrideTest(){
	   System.out.println("In  Child default defaultOverrideTest()");
   }
}
	
public class InheritanceAndOverriding {

	public static void main(String[] args) {
	
		Parent parent = new Parent(); 
		System.out.println("\n--  Parent parent = new Parent(); --\n");		
		parent.doSomething();
		parent.doathing();
		
		Parent childref = new Child(); 
		System.out.println("\n--  Parent childref = new Child(); --\n");
		childref.doSomething();
		childref.doathing();
		((Child) childref).doS();
		((Child) childref).doSomething();
		//referance variable of type parent only can access parent's methods
		//childref.doSome();
		childref.overrideTest();		
		
		Child child = new Child();	
		System.out.println("\n--  Child child = new Child(); --\n");
		child.doSomething();
		child.doathing();
		
		//how child can be the parent of parent
		//Child childe =  new Parent();
	}

}


