package rental;
import java.util.*;

/**
 * Creates a agency containing 6 vehicles with different models, different features, we're printing the results of selections using different filters, then 3 clients rent and return vehicles, we're then seeing which vehicles are rented.
 * 
 *
 */

public class RentalAgencyMain{
  public static void main(String[] args){
    RentalAgency agency = new RentalAgency();
    Vehicle v1 = new Vehicle("Brand 1","Vehicle 1",2010,120);
    agency.addVehicle(v1);
    Vehicle v2 = new Vehicle("Brand 1","Vehicle 2",2010,135);
    agency.addVehicle(v2);
    Vehicle v3 = new Vehicle("Brand 1","Vehicle 3",2010,180);
    agency.addVehicle(v3);
    Vehicle v4 = new Vehicle("Brand 2","Vehicle 4",2010,115);
    agency.addVehicle(v4);
    Vehicle v5 = new Vehicle("Brand 2","Vehicle 5",2010,140);
    agency.addVehicle(v5);
    Vehicle v6 = new Vehicle("Brand 2","Vehicle 6",2010,200);
    agency.addVehicle(v6);
    Client c1 = new Client("Client 1",24);
    Client c2 = new Client("Client 2",38);
    Client c3 = new Client("Client 3",43);
    MaxPriceFilter priceFilter = new MaxPriceFilter(150);
    BrandFilter brandFilter = new BrandFilter("Brand 1");
    AndFilter andFilter = new AndFilter();
    andFilter.addFilter(priceFilter);
    andFilter.addFilter(brandFilter);
    System.out.println("\nWe want the vehicles with a price inferior to 150");
    agency.displaySelection(priceFilter);
    System.out.println("\nWe want the vehicles with the Brand \"Brand 1\"");
    agency.displaySelection(brandFilter);
    System.out.println("\nWe want the vehicles with the Brand \"Brand 1\" and a price inferior to 150");
    agency.displaySelection(andFilter);
    float price;
    price = agency.rentVehicle(c1,v2);
    System.out.println("\nClient 1 (aged "+c1.getAge()+" y/o) rents Vehicle 2 for a price of "+price+"\n");
    price = agency.rentVehicle(c2,v4);
    System.out.println("Client 2 (aged "+c2.getAge()+" y/o) rents Vehicle 4 for a price of "+price+"\n");
    price = agency.rentVehicle(c3,v5);
    System.out.println("Client 3 (aged "+c3.getAge()+" y/o) rents Vehicle 5 for a price of "+price+"\n");
    Collection<Vehicle> rentedVehicles = agency.allRentedVehicles();
    System.out.println("\nList of all rented vehicles : \n");
    for (Vehicle v : rentedVehicles){
      System.out.println(v.getModel() + " : " + v.toString());
    }
    agency.returnVehicle(c2);
    price = agency.rentVehicle(c2,v6);
    System.out.println("\nClient 2 (aged "+c2.getAge()+" y/o) returns Vehicle 4 and rents Vehicle 6 for a price of "+price+"\n");
    agency.returnVehicle(c3);
    System.out.println("Client 3 (aged "+c3.getAge()+" y/o) return Vehicle 5\n");
    rentedVehicles = agency.allRentedVehicles();
    System.out.println("List of all rented vehicles : \n");
    for (Vehicle v : rentedVehicles){
      System.out.println(v.getModel() + " : " + v.toString());
    }

  }
}
