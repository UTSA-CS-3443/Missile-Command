package application.model;

import javafx.scene.image.Image;

/**Represents the gun player uses to fire at the enemey.
 *
 * @author Gregory Pugh
 */
public class PlayerGunModel extends SpriteModel{

	/**Image to use when rendering the gun sprite*/
	private static Image gun = new Image("file:../Inbound/Resources/Turret.png");
	/**Angle of the gun sprite*/
	private double gunAngle;

	public PlayerGunModel(){
		super(gun, 24, 24);
	}

	/**Sets the gun angle based on mouse position.
	 *
	 * @param x		horizontal mouse position
	 * @param y		vertical mouse position
	 */
	public void setGunAngle(double x, double y){
		//TODO: implement gun rotation to point gun to mouse location
	}

	/**Returns current direction of gun.
	 *
	 * @return	gun angle
	 */
	public int getGunAngle(){
		return this.getGunAngle();
	}
}
