package com.sarat.designPatterns.behavioral_Design_Patterns.Observer;

public class SubscribedUser implements Subscribers{
	
	private BlogHandler currentArticle;

	public BlogHandler getCurrentArticle() {
		return currentArticle;
	}

	public void setCurrentArticle(BlogHandler currentArticle) {
		this.currentArticle = currentArticle;
	}

	@Override
	public void notifySubscribers(BlogHandler blog) {
		setCurrentArticle(blog);
		String message = blog.getNotification().toString();
		System.out.println("Dear User, "+message);
	}

	@Override
	public void getPostedBlogArticles() {
		if(currentArticle != null && ((Blog)currentArticle).getPostFlag()) {
			System.out.println(((Blog)currentArticle).getArticle().toString());
		}else {
			System.out.println("No Articles are posted recently");
		}
				
	}

}
