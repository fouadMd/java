package rental;
import java.util.*;

/**
 * Creates a agency containing 3 Vehicles, 3 Cars and 3 Motorbikes, printing all vehicles with a price inferior to 175, then two client rent a car each. Then it creates a suspicious agency with the same vehicles, it prints again all vehicles with a price inferior to 175 then the clients rent the same vehicles and we see the differences between the two agencies.
 * 
 *
 */

public class HeritageAgencyMain{
  public static void main(String[] args){
    RentalAgency agency = new RentalAgency();
    System.out.println("\nWe're in the normal agency, containing 3 Vehicles, 3 Cars and 3 Motorbikes");
    Vehicle v1 = new Vehicle("Brand 1","Vehicle 1",2010,120);
    agency.addVehicle(v1);
    Vehicle v2 = new Vehicle("Brand 1","Vehicle 2",2010,135);
    agency.addVehicle(v2);
    Vehicle v3 = new Vehicle("Brand 2","Vehicle 3",2012,180);
    agency.addVehicle(v3);
    Car car1 = new Car("Brand 1","Car 1",2007,140,4);
    agency.addVehicle(car1);
    Car car2 = new Car("Brand 2","Car 2",2014,190,5);
    agency.addVehicle(car2);
    Car car3 = new Car("Brand 2","Car 3",2015,210,6);
    agency.addVehicle(car3);
    Motorbike moto1 = new Motorbike("Brand 1", "Moto 1",2014,120,750);
    agency.addVehicle(moto1);
    Motorbike moto2 = new Motorbike("Brand 1", "Moto 2",2014,140,1050);
    agency.addVehicle(moto2);
    Motorbike moto3 = new Motorbike("Brand 2", "Moto 3",2014,160,1200);
    agency.addVehicle(moto3);
    Client c1 = new Client("Client 1",38);
    Client c2 = new Client("Client 2",24);
    MaxPriceFilter priceFilter = new MaxPriceFilter(175);
    System.out.println("\nWe want the products of the agency with a price inferior to 175");
    agency.displaySelection(priceFilter);
    float price1 = agency.rentVehicle(c1,car2);
    System.out.println("\nClient 1 (aged "+c1.getAge()+" y/o) rents Car 2 for a price of "+price1+" in the normal agency\n");
    float price2 = agency.rentVehicle(c2,car3);
    System.out.println("Client 2 (aged "+c2.getAge()+" y/o) rents Car 3 for a price of "+price2+" in the normal agency\n");
    System.out.println("\nThere's a suspicious agency with the exact same vehicles, let's experiment its functioning\n");
    SuspiciousRentalAgency suspicious = new SuspiciousRentalAgency();
    //On ajoute les mêmes Vehicles, Cars et Motorbikes
    suspicious.addVehicle(v1);
    suspicious.addVehicle(v2);
    suspicious.addVehicle(v3);
    suspicious.addVehicle(car1);
    suspicious.addVehicle(car2);
    suspicious.addVehicle(car3);
    suspicious.addVehicle(moto1);
    suspicious.addVehicle(moto2);
    suspicious.addVehicle(moto3);
    System.out.println("Let's test the same filter as earlier, we want the vehicles of the suspicious agency with a price inferior to 175\n");
    suspicious.displaySelection(priceFilter);
    System.out.println("\nThe filter works exactly as in the normal agency, no changes in the prices");
    float s_price1 = suspicious.rentVehicle(c1,car2);
    System.out.println("\nClient 1 (aged "+c1.getAge()+" y/o) rents Car 2 for a price of "+s_price1+" in the suspicious agency");
    System.out.println("This agency has a difference in prices of "+(s_price1-price1)+"\n");
    float s_price2 = suspicious.rentVehicle(c2,car3);
    System.out.println("Client 2 (aged "+c2.getAge()+" y/o) rents Car 3 for a price of "+s_price2+" in the suspicious agency");
    System.out.println("This agency has a difference in prices of "+(s_price2-price2));
    System.out.println("Client 2 had to pay more in the suspicious agency because he is 24 years old while Client 1 (who's 38 years old) didn't have to pay more\n");
  }
}
