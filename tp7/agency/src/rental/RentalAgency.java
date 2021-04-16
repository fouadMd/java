package rental;

import java.util.*;

/** a rental vehicle agency, client can rent one vehicle at a time */ 
public class RentalAgency {
    // vehicles of this agency
    private List<Vehicle> theVehicles;

    // maps client and rented vehicle (at most one vehicle by client)
    private Map<Client,Vehicle> rentedVehicles;

    public RentalAgency() {
    	this.theVehicles = new ArrayList<>();
      this.rentedVehicles = new HashMap<>();
    }

    /** adds a vehicle to this agency
    * @param v the added vehicle
    */
    public void addVehicle(Vehicle v) {
    	this.theVehicles.add(v);
    }

    /** provides the list of the vehicles that is accepted by filter
    * @param filter the selection filter
    * @return  the list of the vehicles accepted by filter
    */
    public List<Vehicle> select(VehicleFilter filter) {
    	List<Vehicle> acceptedVehicles = new ArrayList<>();
      for(Vehicle v : theVehicles){
        if (filter.accept(v)) acceptedVehicles.add(v);
      }
        return acceptedVehicles;
    }

    /** displays the vehicles accepted by the filter
    * @param filter the selection filter
    */
    public void displaySelection(VehicleFilter filter) {
      System.out.println("The vehicles accepted for this filter are : \n");
    	List<Vehicle> acceptedVehicles = this.select(filter);
      for (Vehicle v : acceptedVehicles){
        System.out.println(v.getModel() + " : "+v.toString());
      }
    }


    /** returns <em>true</em> iff client c is renting a vehicle
     * @param client the client for which we want to know it has rented a vehicle
    * @return <em>true</em> iff client c is renting a vehicle
    */
    public boolean hasRentedAVehicle(Client client){
    	return this.rentedVehicles.containsKey(client);
    }

    /** returns <em>true</em> iff vehicle v is rented
     * @param v the vehicle we want to check if it is rented
    * @return <em>true</em> iff vehicle v is rented
    */
    public boolean isRented(Vehicle v){
      return this.rentedVehicles.containsValue(v);
    }

   /** client rents a vehicle
    * @param client the renter
    * @param v the rented vehicle
    * @return the daily rental price
    * @exception UnknownVehicleException   if v is not a vehicle of this agency
    * @exception IllegalStateException if v is already rented or client rents already another vehicle
    */
    public float rentVehicle(Client client, Vehicle v) throws UnknownVehicleException, IllegalStateException {
    	if (!this.theVehicles.contains(v)) throw new UnknownVehicleException("This vehicle isn't in the agency");
      if (isRented(v)||hasRentedAVehicle(client)) throw new IllegalStateException("This client can't rent this vehicle");
      this.rentedVehicles.put(client,v);
    	return v.getDailyPrice();
    }


    /** the client returns a rented vehicle. Nothing happens if client didn't have rented a vehicle.
    * @param client the client who returns a vehicle
    */
    public void returnVehicle(Client client){
    	this.rentedVehicles.remove(client);
    }
    /** provides the collection of rented vehicles for this agency
    * @return collection of currently rented vehicles
    */
    public Collection<Vehicle> allRentedVehicles(){
      return this.rentedVehicles.values();
    }

}
