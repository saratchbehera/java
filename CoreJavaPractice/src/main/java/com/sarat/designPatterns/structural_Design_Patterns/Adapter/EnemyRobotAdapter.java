package com.sarat.designPatterns.structural_Design_Patterns.Adapter;

public class EnemyRobotAdapter implements EnemyAttacker{
	
	EnemyRobot theRobot;
	
	public EnemyRobotAdapter(EnemyRobot newRobot) {
		theRobot = newRobot;
	}

	@Override
	public void fireWeapon() {
		theRobot.smashWithHand();
		
	}

	@Override
	public void driveForword() {
		theRobot.walkForward();
		
	}

	@Override
	public void assignDriver(String driverName) {
		theRobot.reactToHuman(driverName);
		
	}

}
