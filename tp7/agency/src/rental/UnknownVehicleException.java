package rental;

/**
 * A special exception raised when a vehicle is not in an agency
 * 
 */

public class UnknownVehicleException extends RuntimeException{
  /** builds an UnknownVehicleException
   * @param msg the message printed whe the exception is raised
   */
  public UnknownVehicleException(String msg){
    super(msg);
  }
}
