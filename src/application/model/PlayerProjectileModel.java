package application.model;

import javafx.scene.image.Image;

/**Defines the player's projectiles, creates the blast at the end of the missile's flight,
 * and handles the sprite rotation based on flight path.
 *
 * @author Gregory Pugh
 */
public class PlayerProjectileModel extends SpriteModel{

	/**Strength of the explosion at terminus*/
	private int blastRadius;
	/**Horizontal position of terminus*/
	private double TargetLocationX = 0;
	/**Vertical position of terminus.*/
	private double TargetLocationY = 0;
	/**Image to use for rendering projectile sprite.*/
	private static Image projectile = new Image("file:../Inbound/Resources/Projectile-G.png");
	/**Flight angle of projectile sprite.*/
	private int projectileAngle;

	public PlayerProjectileModel(double x, double y){
		super(projectile,10,10);
		this.TargetLocationX = x;
		this.TargetLocationY = y;
	}

	//TODO: implement explosions at the point player aims.
	//TODO: handle image rotation so missile is pointing in the direction it is moving.
}
