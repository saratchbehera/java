package com.sarat.designPatterns.behavioral_Design_Patterns.Mediator;

public class GroupMemberImpl extends GroupMember {

	private static final String CHECK_MARK = "\u2713";
	
	public GroupMemberImpl(WhatsupGroup mediator, String name) {
		super(mediator, name);
	}

	@Override
	public void send(String msg) {
		System.out.println(this.name + ":  "+CHECK_MARK+"  :" + msg + "\n");
		mediator.sendMessage(msg, this);
	}

	@Override
	public void receive(String msg) {
		System.out.println(this.name + ": "+CHECK_MARK + CHECK_MARK+":" + msg);
	}
}
