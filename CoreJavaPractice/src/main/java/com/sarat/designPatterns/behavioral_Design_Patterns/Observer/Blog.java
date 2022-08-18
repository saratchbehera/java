package com.sarat.designPatterns.behavioral_Design_Patterns.Observer;

import java.util.ArrayList;
import java.util.List;

public class Blog implements BlogHandler {
	
	List<Subscribers> subscriberList;
	String article;
	private boolean postFlag = false;
	
	public Blog() {
		this.subscriberList = new ArrayList<Subscribers>();
		postFlag = false;
	}
	
	public boolean getPostFlag() {
		return postFlag;
	}

	public void setPostFlag(boolean postFlag) {
		this.postFlag = postFlag;
	}

	public String getArticle() {
		return article.toString();
	}
	
	public void setArticle(String article) {
		this.article = article;
	}
	

	@Override
	public void registerSubscriber(Subscribers subscribers) {		
		
		if(subscribers == null) {
			System.out.println("No Subcribers");
		}			

		if(!subscriberList.contains(subscribers)) {
			subscriberList.add(subscribers);
			System.out.println("New subscriber added");
		}
	}

	@Override
	public void unRegisterSubscriber(Subscribers subscribers) {
		
		if(subscriberList.contains(subscribers)) {
			subscriberList.remove(subscribers);
			System.out.println("Subscriber removed");
		}

	}

	@Override
	public void notifySubscribers() {
		
		if(getPostFlag()) {
			for (Subscribers subscribers : subscriberList) {
				subscribers.notifySubscribers(this);
			}
		}

	}

	@Override
	public Object getNotification() {
		
		if (getPostFlag()) {
			return "New article posted in the blog. Check it out !!!";
		}
		return "No new article posted";
	}
	
	public void postNewArticle(String article) {
		
		setArticle(article);
		setPostFlag(true);
		this.notifySubscribers();
	}

}
