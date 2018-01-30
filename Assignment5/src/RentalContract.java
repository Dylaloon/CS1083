/**
Class that represents a rental contract for a vehicle.
@author Leah Bidlake
@author Natalie Webber
*/
public abstract class RentalContract {
 
	/**
	The number of seats in the rental vehicle.
	*/
	private int capacity;
	
	/**
	Creates a rental contract for a vehicle.
	@param capacity The number of seats in the rental vehicle.
	*/
	public RentalContract (int capacity) {
		this.capacity = capacity;
	}
	
	/**
	Returns the capacity of the rental vehicle.
	@return The number of seats in the rental vehicle.
	*/
	public int getVehicleCapacity () {
		return capacity;
	}
	
	/**
	Returns the daily cost of the rental vehicle.
	@return The cost of the rental vehicle.
	*/
	public abstract double getDailyRentalCost ();

}
	