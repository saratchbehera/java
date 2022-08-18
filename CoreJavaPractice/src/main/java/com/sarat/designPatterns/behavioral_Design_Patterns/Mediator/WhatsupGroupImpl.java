package com.sarat.designPatterns.behavioral_Design_Patterns.Mediator;

import java.util.ArrayList;
import java.util.List;

public class WhatsupGroupImpl implements WhatsupGroup {
	
	private List<GroupMember> members;

	public WhatsupGroupImpl()
	  {
	    this.members = new ArrayList<GroupMember>();
	  }

	@Override
	public void registerUser(GroupMember member) {
		this.members.add(member);
	}

	@Override
	public void sendMessage(String msg, GroupMember member) {
		for (GroupMember u : this.members) {
			// message should not be received by the user sending it
			if (u != member) {
				u.receive(msg);
			}
		}
	}
}
