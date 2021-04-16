package rental;
import java.util.*;

/**
 * It's the same as a rental agency but it applies a additionnal cost of 10% if the client is under 25 years old
 * 
 */

public class SuspiciousRentalAgency extends RentalAgency{

  /**
   * clients under 25 have an additionnal cost of 10%
   *
   *@see RentalAgency#rentVehicle(Client,Vehicle)
   */
  public float rentVehicle(Client c, Vehicle v) throws UnknownVehicleException, IllegalStateException{
    if (c.getAge()<25) return (super.rentVehicle(c,v))*1.1f;
    else return super.rentVehicle(c,v);
  }
}
