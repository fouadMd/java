package rental;
import org.junit.*;
import static org.junit.Assert.*;

public class SuspiciousRentalAgencyTest{
 
  @Test
  public void additionnalCostWhenRenting(){
    SuspiciousRentalAgency agency = new SuspiciousRentalAgency();
    Client c1 = new Client ("Client 1",35);
    Client c2 = new Client("Client 2",21);
    Car car1 = new Car("Brand 1","Car 1",2007,140,4);
    Car car2 = new Car("Brand 1","Car 2",2007,140,4);
    agency.addVehicle(car1);
    agency.addVehicle(car2);
    assertEquals(140.0,agency.rentVehicle(c1,car1),0.1);
    assertEquals(154.0,agency.rentVehicle(c2,car2),0.1);
  }

  public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(rental.SuspiciousRentalAgencyTest.class);
  }
}
