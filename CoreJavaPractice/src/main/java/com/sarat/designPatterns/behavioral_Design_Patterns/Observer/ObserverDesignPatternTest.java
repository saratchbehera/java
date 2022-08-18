package com.sarat.designPatterns.behavioral_Design_Patterns.Observer;

/**
 * 
 * <p>****		Observer Design Pattern		****<p>
 * 
 * In observer design pattern multiple observer objects registers with a subject for change notification. 
 * When the state of subject changes, it notifies the observers. 
 * Objects that listen or watch for change are called observers 
 * and the object that is being watched for is called subject. 
 * 
 * Observer Design Pattern is also called as publish-subscribe pattern. 
 * Model view controller (MVC) architecture�s core uses the observer design pattern.
 * 
 * <p>**** 		Important Points	*****<p>
 * 
 * 1. Subject provides interface for observers to register and unregister themselves with the subject.
 * 2. Subject knows who its subscribers are.
 * 3. Multiple observers can subscribe for notifications.
 * 4. Subject publishes the notifications.
 * 5. Subject just sends the notification saying the state has changed. It does not pass any state information.
 * 6. Once the notification is received from subject, observers call the subject and get data that is changed.
 * 
 * The above last two points are not strictly followed in observer design pattern implementation. 
 * Along with the notification, state is also passed in some implementation 
 * so that the observer need not query back to know the status. It is better not to do this way.
 * 
 * <p>****		Observer and Observable Java API 		****<p>
 * 
 * JDK provides Observer and Observable classes as part of util package. 
 * This is not something new and these classes were available since JDK 1.0. 
 * Observer is an interface which needs to be implemented to observe the state change in a observable subject. 
 * Observable is a class which should be extended by a subject. 
 * Observable provides implementation for methods to register or unregister an Observer and to notify the Observer objects.
 * 
 * 
 * Let us take a blog and subscriber example for observer design pattern sample implementation. 
 * Assume that there is a blog and users register to that blog for update. 
 * When a new article is posted in the blog, it will send update to the registered users saying a new article is posted.
 * Then the user will access the blog and read the new article posted. 
 * In this example, blog is the subject and user is the observer.
 * 
 * 
 * java.util.Observer/java.util.Observable (rarely used in real world though) 
 * All implementations of java.util.EventListener (practically all over Swing thus)
 * javax.servlet.http.HttpSessionBindingListener
 * javax.servlet.http.HttpSessionAttributeListener
 * javax.faces.event.PhaseListener
 * 
 * @author Sarat Behera
 *
 */
public class ObserverDesignPatternTest {
	
	public static void main(String args[]) {
		
		BlogHandler blog = new Blog();
		SubscribedUser user1 = new SubscribedUser();
		SubscribedUser user2 = new SubscribedUser();
		
		blog.registerSubscriber(user1);
		blog.registerSubscriber(user2);
		
		((Blog) blog).postNewArticle("Article 1");
		
		user1.getPostedBlogArticles();
		//user2.getPostedBlogArticles();
		
		((Blog) blog).postNewArticle("Article on iphone x");
		((Blog) blog).postNewArticle("Article on iphone 8");

	}

}
