package application.model;

import javafx.scene.image.Image;

/**Represents the city sprites. Currently, they are static, but will contain population, research, and production when these are implemented.
 *
 * @author Gregory Pugh
 */
public class CityModel extends SpriteModel {

	/**Image to use for the city sprite*/
	private static Image city = new Image("file:../Inbound/Resources/City.png");

	public CityModel() {
		super(city, 36, 36);
	}
}
