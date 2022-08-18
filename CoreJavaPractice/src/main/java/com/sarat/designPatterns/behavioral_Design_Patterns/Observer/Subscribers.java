package com.sarat.designPatterns.behavioral_Design_Patterns.Observer;

/**
 * Subscribers is an observer..
 * @author Sarat Behera
 *
 */
public interface Subscribers {

	public void notifySubscribers(BlogHandler blog);

	public void getPostedBlogArticles();
}
