package application.model;

import java.util.ArrayList;
import java.util.Random;

/**Handles the generation of enemy waves and targets them to a city location or player's gun.
 *
 * @author Gregory Pugh
 */
public class ProjectileWave {

	/**List of projectiles in this wave.*/
	private ArrayList<ProjectileModel> wave = new ArrayList<ProjectileModel>();
	/**Array of city locations*/
	private double cityLocationX[] = {50, 140, 230, 410, 500, 590};
	/**Speed adjustment to change projectile speed*/
	private int speedAdjustment = 2;
	/**Number of projectiles to spawn in this wave.*/
	private int numProjectiles = 5;

	public ProjectileWave(){

	}

	/**Creates an individual projectile and sets its target.
	 *
	 */
	public void spawnEnemyMissile(){
		double TargetLocationX = 0;			//initialize horizontal target location.
		double TargetLocationY = 330;		//initialize and set vertical target location
		Random rand = new Random();			//random number generator

		//randomly select target
		int xTarget = rand.nextInt(6);
		//if it is a city, get that city's location.
		if (xTarget<6){
			TargetLocationX = cityLocationX[xTarget];
		//otherwise it's the gun
		}else{
			TargetLocationX = 320;
			TargetLocationY = 280;
		}

		//create the missile
		ProjectileModel proj = new ProjectileModel(TargetLocationX, TargetLocationY);

		//set a random start position off screen and save the position
		int xPos = (rand.nextInt(801)) - 50;
		proj.setPosition(xPos, -10);
		proj.setStartPos(xPos, -10);

		//correct the projectile velocity for distance to target (otherwise they miss)
		double xDistance = (TargetLocationX - proj.getPositionX());
		double yDistance = (TargetLocationY - proj.getPositionY());
		double distance = Math.sqrt(xDistance * xDistance + yDistance * yDistance);
		proj.setVelocity(speedAdjustment*xDistance/distance, speedAdjustment*yDistance/distance);

		//add the missle to the wave array
		this.wave.add(proj);
	}

	/**Get the current wave generated
	 *
	 * @return		the currently generated wave of missles
	 */
	public ArrayList<ProjectileModel> getWave(){
		//reset for new wave
		resetWave();

		//spawn each projectile in this wave
		for (int i = 0; i < this.numProjectiles;i++){
			spawnEnemyMissile();
		}
		return this.wave;
	}

	/**Empty wave array.*/
	public void resetWave(){
		//clear the entire array
		this.wave.clear();;
	}
}
