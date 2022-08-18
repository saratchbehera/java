package com.sarat.string;

import java.util.concurrent.atomic.AtomicInteger;

class EmpNames
{
	final static AtomicInteger POS = new AtomicInteger(0);
	int pos;
	String name;

	EmpNames(String name)
	{
	pos = POS.addAndGet(1);
	this.name = name;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
}