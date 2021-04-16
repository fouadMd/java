/**
 * A class to design bikeStation that can stock Bikes.
 * BikesStation have a unique name and a capacity.
 *
 * @author Medjahed Fouad Ainouch Tarik
 *
 */
public class BikeStation {

    // DEFINIR LES ATTRIBIUTS

		private String name;
		private int capacity;
		private Bike[] tabBike;
		private int nbOfBikes;


    /** Build a BikeStation object
     * @param name a String description of Bikestation name
		 * @param capacity an integer representing the capacity of BikeStation
     */
	public BikeStation(String name, int capacity) {
	     this.name=name;
			 this.capacity=capacity;
			 this.tabBike= new Bike[capacity];
			 this.nbOfBikes=0;
	}

    /** return the name of the BikeStation
     * @return a String representing the name
     */
	public String getName() {
		return this.name;
	}

    /** return the capacity of a BikeStation
     * @return an integer : the capacity of the BikeStation
     */
	public int getCapacity() {
		return this.capacity;
	}

    /** return the numbers of Bike in the BikeStation
     * @return an integer : the number of Bike in the BikeStation
     */
	public int getNumberOfBikes() {
		return this.nbOfBikes;
	}


    /** return the first free slot in a BikeStation
     * @return the integer of index of the first free slot or -1 if there isn't a free slot
     */
	public int firstFreeSlot() {
	    for(int i=0;i<this.capacity;i++){
				if (this.tabBike[i]==null){
					return i;
				}
			}
		return -1;
	}

    /** drop a Bike in a BikeStation
     * @param bike Bike object
		 * @return true if the bike was drop in the first free place or false if it wasn't
     */
	public boolean dropBike(Bike bike) {
		  int place=this.firstFreeSlot();
	    if (place==-1){
				return false;
			}
			else{
				this.tabBike[place]=bike;
				this.nbOfBikes++;
				return true;
			}
		}



    /** take a bike in a Bikestation
     *  @param i an integer description of index
     *  @return the Bike to take in the index i of the BikeStation
     */
	public Bike takeBike(int i) {
	    if (i<0 || i>this.getCapacity()){
			   return null;
			 }
			else if(this.tabBike[i]==null){
				return null;
			}
			else {
				 this.nbOfBikes--;
				 Bike res=this.tabBike[i];
				 this.tabBike[i]=null;
				 return res;
			}
	}


}
