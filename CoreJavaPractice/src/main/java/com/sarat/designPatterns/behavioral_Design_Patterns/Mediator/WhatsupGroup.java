package com.sarat.designPatterns.behavioral_Design_Patterns.Mediator;

/**
 * Mediator
 * @author Sarat Behera
 *
 */
public interface WhatsupGroup {

	public void sendMessage(String msg, GroupMember member);

	void registerUser(GroupMember member);
}
