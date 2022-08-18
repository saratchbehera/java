package com.sarat.designPatterns.structural_Design_Patterns.Facade;

public class Shopkeeper {
	
	private MobileShop iphone;
	private MobileShop samsung;
	
	public Shopkeeper() {
		iphone = new Iphone();
		samsung = new Samsung();
	}
	
	public void iphoneSale() {
		iphone.modelNo();
		iphone.price();
	}
	
	public void samsungSale() {
		samsung.modelNo();
		samsung.price();
	}

}
