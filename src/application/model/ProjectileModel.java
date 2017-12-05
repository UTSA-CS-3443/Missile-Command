package application.model;

import javafx.scene.image.Image;

/**Defines the enemy projectiles, creates the blast when city or ground is hit,
 * and handles the sprite rotation based on flight path.
 *
 * @author Michael Cavazos
 * @author Gregory Pugh
 */
public class ProjectileModel extends SpriteModel{

	/**The force of the explosion (not implemented until city population, this will be used for damage.*/
	private int blastRadius;
	/**used to destroy missile in case missile veers too far from target.*/
	private double targetLocationX = 0;
	/**used to destroy missile if it hits ground*/
	private double targetLocationY = 0;
	/**used to anchor missile trail for rendering*/
	private double startLocationX = 0;
	/**used to anchor missile trail for rendering*/
	private double startLocationY = 0;
	/**Image to render for enemy missles*/
	private static Image projectile = new Image("file:../Inbound/Resources/Projectile-R.png");

	public ProjectileModel(double x, double y){
		super(projectile,10,10);
		this.targetLocationX = x;
		this.targetLocationY = y;
	}

	/**Sets the starting position when missile is created which is determined
	 * after instantiation*/
	public void setStartPos(double x, double y){
		startLocationX = x;
		startLocationY = y;
	}

	/**Return the missile's horizontal start location
	 *
	 * @return
	 */
	public double getStartX(){
		return startLocationX;
	}

	/**Return the missile's vertical start location
	 *
	 * @return
	 */
	public double getStartY(){
		return startLocationY;
	}
}
