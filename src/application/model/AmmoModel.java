package application.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**Model for the ammo bunker and the player's ammo.
 *
 * @author Gregory Pugh
 */
public class AmmoModel extends SpriteModel {

	/**Image for bunker.*/
	private static Image ammo = new Image("file:../Inbound/Resources/bunker.bmp");
	/**Image for ammo display.*/
	private static Image round = new Image("file:../Inbound/Resources/Projectile-G.png");
	/**Amount of ammunition player has remaining.*/
	private int ammoCount = 0;

	public AmmoModel() {
		super(ammo, 110, 70);
		this.ammoCount = 30;
	}

	/**Gets the current ammo count.*/
	public int getAmmoCount(){
		return ammoCount;
	}

	/**Sets the ammo count to the value.
	 *
	 * @param ammoCount		value
	 */
	public void setAmmoCount(int ammoCount){
		this.ammoCount = ammoCount -1;
	}

	/**Draws the ammo in the bunker based on the current value of ammoCount
	 *
	 * @param gamePane		Garphic context that is rendering the ammo bunker.
	 */
	public void drawAmmo(GraphicsContext gamePane){
		//calculate number of rounds to display
		int ammoRows = this.ammoCount/10;
		int ammoSingles = this.ammoCount%10;

		//display full rows
		for (int i = 0; i < ammoRows; i++){
			for (int j = 0; j < 10; j++){
				gamePane.drawImage(round, this.getPositionX() - this.getWidth()/2 + 5 + j*10
						, this.getPositionY() - this.getHeight()/2 + 5 + i*15, 10, 10);
			}
		}
		//display remaining rounds on last row
		for (int j = 0; j < ammoSingles; j++){
			gamePane.drawImage(round, this.getPositionX() - this.getWidth()/2 + 5 + j*10
					, this.getPositionY() - this.getHeight()/2 + 5 + (ammoRows)*15, 10, 10);

		}
	}

}
