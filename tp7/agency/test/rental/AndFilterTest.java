package rental;
import org.junit.*;
import static org.junit.Assert.*;
 
public class AndFilterTest{

  private AndFilter interFilter;
  private MaxPriceFilter priceFilter;
  private MaxPriceFilter priceFilter2;
  private BrandFilter brandFilter;

  @Before
  public void before(){
    this.interFilter = new AndFilter();
    this.priceFilter = new MaxPriceFilter(200);
    this.priceFilter2 = new MaxPriceFilter(150);
    this.brandFilter = new BrandFilter("Brand 1");
  }

  @Test
  public void filtersGetAddedToTheBigFilter(){
    assertFalse(this.interFilter.getFilters().contains(this.priceFilter));
    this.interFilter.addFilter(this.priceFilter);
    assertTrue(this.interFilter.getFilters().contains(this.priceFilter));
  }

  @Test
  public void acceptVehiclesWhileHavingSeveralFilters(){
    Vehicle v1 = new Vehicle("Brand 1", "Model 1", 2010, 140);
    Vehicle v2 = new Vehicle("Brand 1", "Model 2", 2010, 175);
    Vehicle v3 = new Vehicle("Brand 2", "Model 3", 2010, 215);
    Vehicle v4 = new Vehicle("Brand 2", "Model 4", 2010, 150);
    assertTrue(this.interFilter.accept(v1));
    assertTrue(this.interFilter.accept(v2));
    assertTrue(this.interFilter.accept(v3));
    assertTrue(this.interFilter.accept(v4));
    //on ne veut que les voitures avec un prix inférieur à 200
    this.interFilter.addFilter(this.priceFilter);
    assertTrue(this.interFilter.accept(v1));
    assertTrue(this.interFilter.accept(v2));
    assertFalse(this.interFilter.accept(v3));
    assertTrue(this.interFilter.accept(v4));
    //on ne veut que les voitures avec un prix inférieur à 200 avec la marque "Brand 1"
    this.interFilter.addFilter(this.brandFilter);
    assertTrue(this.interFilter.accept(v1));
    assertTrue(this.interFilter.accept(v2));
    assertFalse(this.interFilter.accept(v3));
    assertFalse(this.interFilter.accept(v4));
    //on ne veut que les voitures avec un prix inférieur à 150 avec la marque "Brand 1"
    this.interFilter.addFilter(this.priceFilter2);
    assertTrue(this.interFilter.accept(v1));
    assertFalse(this.interFilter.accept(v2));
    assertFalse(this.interFilter.accept(v3));
    assertFalse(this.interFilter.accept(v4));
  }

  public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(rental.AndFilterTest.class);
  }
}
