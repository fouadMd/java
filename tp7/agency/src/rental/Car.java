package rental;

/** 
 * A class defining Cars with the same properties as a Vehicle, but with a number of passengers
 *
 *
 */

public class Car extends Vehicle{

  private int passengers;

  /**
	 * creates a car with given informations
	 *
	 * @param brand the car's brand
	 * @param model the car's model
	 * @param productionYear the car's production year
	 * @param dailyRentalPrice the daily rental price
   * @param passengers the number of passengers
	 */
  public Car(String brand, String model, int productionYear, float dailyRentalPrice, int passengers){
    super(brand,model,productionYear,dailyRentalPrice);
    this.passengers = passengers;
  }

  /** get the number of passengers the car can get
   * @return the number of passengers of the car
   */
  public int getPassengers(){
    return this.passengers;
  }

  /** Get a String representation of the car
	 * @return A string representation of the vehicle with its production year, its brand, its rental price and its number of passengers
	 */
  public String toString(){
    return super.toString() + " " + this.passengers;
  }
}
