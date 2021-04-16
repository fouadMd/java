package rental;

/**
 * A class defining motorbikes with the same properties as a Vehicle, but with its
 * 
 */

public class Motorbike extends Vehicle{

  private int capacity;

  /**
	 * creates a motorbike with given informations
	 *
	 * @param brand the motorbike's brand
	 * @param model the motorbike's model
	 * @param productionYear the motorbike's production year
	 * @param dailyRentalPrice the daily rental price
   * @param capacity the motorbike's cylinder capacity (in cm^3)
	 */
  public Motorbike(String brand, String model, int productionYear, float dailyRentalPrice, int capacity){
    super(brand,model,productionYear,dailyRentalPrice);
    this.capacity = capacity;
  }

  /** get the motorbike's cylinder capacity
   * @return the motorbike's cylinder capacity
   */
  public int getCapacity(){
    return this.capacity;
  }

  /** Get a String representation of the motorbike
	 * @return A string representation of the vehicle with its production year, its brand, its rental price and its engine cylinder capacity
	 */
  public String toString(){
    return super.toString() + " " + this.capacity;
  }
}
