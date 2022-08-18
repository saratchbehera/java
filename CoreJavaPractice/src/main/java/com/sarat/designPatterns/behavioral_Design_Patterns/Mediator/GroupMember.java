package com.sarat.designPatterns.behavioral_Design_Patterns.Mediator;

public abstract class GroupMember {
	
	protected WhatsupGroup mediator;
	protected String name;

	public GroupMember(WhatsupGroup mediator, String name) {
		this.mediator = mediator;
		this.name = name;
	}

	public abstract void send(String msg);

	public abstract void receive(String msg);
}
