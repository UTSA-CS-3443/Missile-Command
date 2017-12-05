package application.model;

import java.util.ArrayList;
import java.util.Iterator;
import application.Main;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

/**Represents main game. Includes the runtime and animation logic for the game.
 *
 * @author Michael Cavazos
 * @author Gregory Pugh
 * @author Divya Emani
 */
public class GameModel {

	/**List of enemy projectiles.*/
	private ArrayList<ProjectileModel> enemyProjectileList = new ArrayList<ProjectileModel>();
	/**List of player projectiles.*/
	private ArrayList<PlayerProjectileModel> playerProjectileList= new ArrayList<PlayerProjectileModel>();
	/**List of enemy waves.*/
	private ArrayList<ProjectileWave> waveList = new ArrayList<ProjectileWave>();
	/**List of cities.*/
	private ArrayList<CityModel> cityList = new ArrayList<CityModel>();
	/**Player's gun sprite.*/
	PlayerGunModel gun = new PlayerGunModel();
	/**Player's ammunition display.*/
	AmmoModel ammo = new AmmoModel();
	/**Iterator for enemy projectiles.*/
	Iterator<ProjectileModel> enemyProjIter;
	/**Iterator for player projectiles.*/
	Iterator<PlayerProjectileModel> playerProjIter;
	/**Iterator for cities.*/
	Iterator<CityModel> cities;
	/**Player's current score.*/
	private Integer score = 0;
	/**Graphics context for rendering of sprites.*/
	private GraphicsContext gamePane;
	/**Indicator flag to determine if a new wave needs to be generated.*/
	private boolean makeWave = true;
	/**Array containing the positionX values for the cities*/
	private double cityLocationX[] = {50, 140, 230, 410, 500, 590};

	public GameModel(){

	}

	/**Populate the sprites and reset score for a new game.
	 *
	 * @param gamePane		main canvas used for rendering game.
	 * @param scoreLabel	text output of player's current score.
	 */
	public void initGame(GraphicsContext gamePane, Label scoreLabel){
		int i = 0;		//loop counter

		//reset score to 0
		this.setScore(scoreLabel, 0);

		//add cities
		for (i = 0 ; i < 6 ; i++) {
			CityModel city = new CityModel();
			city.setPosition(cityLocationX[i], 330);
			this.cityList.add(city);
		}

		//add player gun and ammo
		this.gun.setPosition(320, 280);

		//add ammo bunker.
		ammo.setPosition(320, 340);

		//populate a wave of enemies
		//TODO: this should go into the animation loop; located here only until
		//wave generation is completed.
		ProjectileWave newWave = new ProjectileWave();
		while(makeWave){
			enemyProjectileList = newWave.getWave();
			makeWave = false;
		}

		/**Animation loop and runtime which handles updates to the game screen.*/
		new AnimationTimer(){
			int gameLevel = 0;				//current game level
			boolean generateWaves = true;	//flag to generate a new wave

			@Override
			public void handle(long arg0) {
				double lastNanoTime = 0;		//last loop time
				//TODO: this is reseting it to 0 everytime, should be moved outside loop, but
				//don't know how this will affect things so leaving it here for now.

				//calculate clock
				double elapsed = (arg0 - lastNanoTime)/1000000000;
				lastNanoTime = arg0;

				//paint background
				gamePane.setFill(Color.LIGHTBLUE);
				gamePane.fillRect(0, 0, 640, 380);
				gamePane.setFill(Color.GREEN);
				gamePane.fillRect(0, 300, 640, 380);

				//populate the cities
				for(CityModel city : cityList)
					city.render(gamePane);

				//populate the player's gun.
				gun.render(gamePane);

				//populate bunker and ammo
				ammo.render(gamePane);
				ammo.drawAmmo(gamePane);

				//populate enemy projectiles
				for(ProjectileModel proj: enemyProjectileList){
					//update position and render
					proj.update(elapsed/100000000);
					proj.render(gamePane);

					//paint tails
					gamePane.setStroke(Color.RED);
					gamePane.strokeLine(proj.getStartX(),proj.getStartY(),proj.getPositionX(),proj.getPositionY());
				}

				//populate player projectiles
				for(PlayerProjectileModel proj: playerProjectileList){
					//update position and render
					proj.update(elapsed/100000000);
					proj.render(gamePane);
				}

				//check for collisions
				enemyProjIter = enemyProjectileList.iterator();
				while(enemyProjIter.hasNext()){
					//get the next enemy projectile
					ProjectileModel curEnemy = enemyProjIter.next();

					//between enemy projectiles and cities
					cities = cityList.iterator();
					while(cities.hasNext()){
						//get next city
						CityModel curCity = cities.next();

						//if the boxes intersect they collided
						if(curEnemy.intersects(curCity)){
							//destroy both sprites and update score
							cities.remove();
							enemyProjIter.remove();
							addScore(scoreLabel,-100);
						}
					}

					//between enemy and player projectiles
					playerProjIter = playerProjectileList.iterator();
					while(playerProjIter.hasNext()){
						//get next player projectile
						PlayerProjectileModel curPlayer = playerProjIter.next();

						//if the boxes intersect they collided
						if(curEnemy.intersects(curPlayer)){
							//destroy both sprites and update score
							playerProjIter.remove();
							enemyProjIter.remove();
							addScore(scoreLabel, 25);
						}
					}

					//check to see if it hit the ground
					if(curEnemy.getPositionY() > 330)
						//destroy sprite
						enemyProjIter.remove();
				}
			}
		}.start();

	}

	/**Runs end game animation and clears the game when player dies.*/
	public void endGame(){
		//display player death
		//check high scores
		//go main menu
		Main.stage.hide();
		Main.stage.setScene(Main.mainMenu);	//needs change
		Main.stage.show();
	}

	/**Get the player's projectile list.
	 *
	 * @return
	 */
	public ArrayList<PlayerProjectileModel> getPlayerProjectileList() {
		return playerProjectileList;
	}

	/**Set the player's projectile list to a new list
	 *
	 * @param playerProjectileList
	 */
	public void setPlayerProjectileList(ArrayList<PlayerProjectileModel> playerProjectileList) {
		this.playerProjectileList = playerProjectileList;
	}

	/**Get the enemyr's projectile list.
	 *
	 * @return
	 */
	public ArrayList<ProjectileModel> getProjectileList() {
		return enemyProjectileList;
	}

	/**Set the enemy's projectile list to a new list
	 *
	 * @param enemyProjectileList
	 */
	public void setProjectileList(ArrayList<ProjectileModel> enemyProjectileList) {
		this.enemyProjectileList = enemyProjectileList;
	}

	/**Get the ammo bunker sprite.
	 *
	 * @return
	 */
	public AmmoModel getAmmo(){
		return ammo;
	}

	/**Get the horizontal location of the city.
	 *
	 * @return
	 */
	public double getCityLocation(int number){
		return this.cityLocationX[number];
	}

	/**advance level flag
	 *
	 * @param score		current score of the player
	 * @return
	 */
	public boolean checkAdvanceLevel(int score){
		return true;
	}

	/**Set the score to the value.
	 *
	 * @param scoreLabel		the display of the player's score
	 * @param score				the current value of the player's score
	 */
	public void setScore(Label scoreLabel, int score){
		this.score = score;
		scoreLabel.setText("Score: " + this.score);
	}

	/**Add the score to the player's current score.
	 *
	 * @param scoreLabel		the display of the player's score
	 * @param score				the value to add
	 */
	public void addScore(Label scoreLabel, int score){
		this.score += score;
		scoreLabel.setText("Score: " + this.score);
	}

	/**Get the player's current score.
	 *
	 * @return
	 */
	public int getScore(){
		return score;
	}
}
