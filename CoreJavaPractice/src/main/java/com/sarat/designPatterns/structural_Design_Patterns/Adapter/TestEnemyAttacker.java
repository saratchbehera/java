package com.sarat.designPatterns.structural_Design_Patterns.Adapter;

public class TestEnemyAttacker {

	
	public static void main(String[] args) {
		EnemyTank rx7tank = new EnemyTank();
		EnemyRobot fredTheRobot = new EnemyRobot();
		
		EnemyAttacker robotAdapter = new EnemyRobotAdapter(fredTheRobot);
		
		System.out.println("The Robot");
		
		fredTheRobot.reactToHuman("Sarat");
		fredTheRobot.walkForward();
		fredTheRobot.smashWithHand();
		
		
		System.out.println("The Enemy Tank");
		
		rx7tank.assignDriver("Frank");
		rx7tank.driveForword();
		rx7tank.fireWeapon();
		
		
		System.out.println("The Robot with adapter");
		
		robotAdapter.assignDriver("Mark");
		robotAdapter.driveForword();
		robotAdapter.fireWeapon();
	}
}
