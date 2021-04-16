package rental;
import static org.junit.Assert.*;
import java.util.*;

import org.junit.Before;
import org.junit.Test;

public class RentalAgencyTest {
 
	private RentalAgency agency;
	private Vehicle v1;
	private Vehicle v2;
	private Vehicle v3;
	private MaxPriceFilter filter;
	private Client client;

	@Before
	public void before(){
		this.agency = new RentalAgency();
		this.v1 = new Vehicle ("Brand 1","Model 1", 2010, 100);
		this.agency.addVehicle(v1);
		this.v2 = new Vehicle ("Brand 2","Model 2", 2012, 150);
		this.agency.addVehicle(v2);
		this.v3 = new Vehicle ("Brand 3","Model 3", 2015, 200);
		this.agency.addVehicle(v3);
		this.filter = new MaxPriceFilter(125);
		this.client = new Client("Client lambda",23);
	}

	@Test
	public void vehicleGetsCorrectlyFiltered(){
		List<Vehicle> accepted = this.agency.select(this.filter);
		assertTrue(accepted.contains(v1));
		assertFalse(accepted.contains(v2));
	}

	@Test (expected = UnknownVehicleException.class)
	public void clientTriesToAVehicleNotInAgency(){
		Vehicle v4 = new Vehicle("notInAgency","notInAgency",2019,150);
		this.agency.rentVehicle(this.client,v4);
	}

	@Test (expected = IllegalStateException.class)
	public void clientTriesToRentTwoVehicles(){
		this.agency.rentVehicle(this.client, this.v2);
		this.agency.rentVehicle(this.client, this.v1);
	}

	@Test (expected = IllegalStateException.class)
	public void clientTriesToRentAVehicleAlreadyRented(){
		this.agency.rentVehicle(this.client, this.v1);
		Client client2 = new Client("Client 2",35);
		this.agency.rentVehicle(client2, this.v1);
	}

	@Test
	public void clientRentsVehicle(){
		assertFalse(this.agency.hasRentedAVehicle(this.client));
		assertFalse(this.agency.isRented(this.v3));
		float price = this.agency.rentVehicle(this.client,this.v3);
		assertEquals(200,price,0.1);
		assertTrue(this.agency.hasRentedAVehicle(this.client));
		assertTrue(this.agency.isRented(this.v3));
	}

	@Test
	public void clientReturnsVehicle(){
		this.agency.rentVehicle(this.client,this.v2);
		assertTrue(this.agency.hasRentedAVehicle(this.client));
		assertTrue(this.agency.isRented(this.v2));
		this.agency.returnVehicle(client);
		assertFalse(this.agency.hasRentedAVehicle(this.client));
		assertFalse(this.agency.isRented(this.v2));
	}

	@Test
	public void getRentedVehicles(){
		this.agency.rentVehicle(this.client, this.v1);
		Client client2 = new Client("Client 2",35);
		this.agency.rentVehicle(client2, this.v2);
		Collection<Vehicle> rentedCollection = this.agency.allRentedVehicles();
		assertTrue(rentedCollection.contains(this.v1));
		assertTrue(rentedCollection.contains(this.v2));
		assertFalse(rentedCollection.contains(this.v3));
	}

	@Test
	public void twoClientObjectsWithSameNameCorrespondsToSameClient()
					throws IllegalStateException, UnknownVehicleException {
		RentalAgency agency = new RentalAgency();
		Vehicle v = new Vehicle("Vroum", "Vroum", 2000, 100);
		agency.addVehicle(v);
		Client client1 = new Client("Tim Oleon", 25);
		assertEquals(100, agency.rentVehicle(client1, v),0.0001);
		assertTrue(agency.hasRentedAVehicle(client1));
		// client2 corresponds to same client than client1 since names are equals
		Client client2 = new Client("Tim Oleon", 25);
		// then test should succeed
		assertTrue(agency.hasRentedAVehicle(client2));
	}

	// ---Pour permettre l'execution des tests ----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(rental.RentalAgencyTest.class);
	}

}
