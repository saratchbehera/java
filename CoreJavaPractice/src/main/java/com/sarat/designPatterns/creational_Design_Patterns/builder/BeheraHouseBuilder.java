package com.sarat.designPatterns.creational_Design_Patterns.builder;

public class BeheraHouseBuilder implements HouseBuilder{
	
	private House house;

	public BeheraHouseBuilder() {
		this.house = new House();
	}

	public void buildBasement() {
		house.setBasement("Ice Bars");
	}

	public void buildStructure() {
		house.setStructure("Ice Blocks");
	}

	public void buildInterior() {
		house.setInterior("Ice Carvings");
	}

	public void bulidRoof() {
		house.setRoof("Ice Dome");
	}

	public House getHouse() {
		return this.house;
	}

}
