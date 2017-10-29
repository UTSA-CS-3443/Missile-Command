package model;

public class CityModel {

	//variables currently are not needed, but will be added later
	/**Population acts as a damage value for the city (when population reaches zero it is destroyed.
	 * It is also used as a prerequisite for certain production/research upgrades.
	 */
	private int population;

	/**Level/type of production for this city. Displayed to player by icon on the city
	 * Initially, we will automatically set this based on available score points with each
	 * city utilizing a different track.
	 * Later production for each city is independent, player can set each city to any production
	 * ability they possess by purchasing it with score points. While any level can be set, only one
	 * can be used in each city.
	 */
	private int productionLevel;

	/**Level/type of research for this city. Displayed to player by icon on the city
	 * Initially, we will automatically set this based on population with the technologies researched
	 * in order. Later the player can select which technology each city is contributing points towards.
	 */
	private int researchLevel;

	/**Population growth rate to be implemented later (in percent). Determined by difficulty level in
	 * Game Options/New Game
	 */
	private float growthRate;

	/**Creates a new city. Initially done at beginning only, then automatically based on score points
	 * perhaps one of the production options?
	 */
	public CityModel(){

	}

	/**City is hit by projectile (currently any hit destroys city as in original game)
	 * Later, destruction occurs when population falls to 0. Note hits could affect tech and population levels
	 *
	 * @param projectile
	 */
	public void onHit(ProjectileModel projectile){
		onDestroyed();
	}

	/**Play effects for city destruction then set city to destroyed in GameView.
	 *
	 */
	public void onDestroyed(){
		//effects to use here
		//change city in view to destroyed
	}

	/**Runs once cycle, updates population and construction of production and research
	 *
	 */
	public void onCycle(){

	}

	/**potentially used for population/production/research modeling in intermediate implementation.
	 * Player selects for each city where they will concentrate points produced by population, reducing
	 * growth in the other two areas while increasing the growth in the selected area. Depends how much control
	 * we want the player to have on production and research.
	 *
	 * @return
	 */
	public int selectConcentration(){
		return 0;
	}

}
