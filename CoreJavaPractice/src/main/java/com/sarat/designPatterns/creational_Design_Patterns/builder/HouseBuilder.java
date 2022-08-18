package com.sarat.designPatterns.creational_Design_Patterns.builder;

public interface HouseBuilder {

	public void buildBasement();

	public void buildStructure();

	public void bulidRoof();

	public void buildInterior();

	public House getHouse();
}
