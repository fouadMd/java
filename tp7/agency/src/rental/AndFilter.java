package rental;
import java.util.*;
/**
 * An InterFilter performs the intersection of filters. It accepts a vehicle if each of its filter accepts it.
*/ 
public class AndFilter implements VehicleFilter {

    private List<VehicleFilter> theFilters;

    /** creates an InterFilter with no filter */
    public AndFilter() {
		 this.theFilters = new ArrayList<>();
    }

    /** adds a new filter
    * @param f the added filter
    */
    public void addFilter(VehicleFilter f) {
  		this.theFilters.add(f);
    }

    /** get all filters in the AndFilter
     * @return all filters added to the AndFilter
     */
    public List<VehicleFilter> getFilters(){
      return this.theFilters;
    }

    /** Accept the vehicle if each of its filters accepts it
     * @see VehicleFilter#accept(Vehicle) */
    public boolean accept(Vehicle v) {
    	boolean res = true;
      for (VehicleFilter f : this.theFilters){
        res = res && f.accept(v);
      }
    	return res;
    }
}
