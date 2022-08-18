package com.sarat.designPatterns.behavioral_Design_Patterns.Observer;

/**
 * BlogHandler is the subject.
 * @author Sarat Behera
 *
 */
public interface BlogHandler {
	
	public void registerSubscriber(Subscribers subscribers);

	public void unRegisterSubscriber(Subscribers subscribers);

	public void notifySubscribers();
	
	public Object getNotification();

}
