/**
Represents a cruise.
@author Leah Bidlake
*/

public class Cruise{
	
	/**
	Name of the ship.
	*/
	private String ship;
	
	/**
	Name of the cruise line.
	*/
	private String cruiseLine;
	
	/**
	List of bookings for the cruise.
	*/
	private Booking[] manifest;
	

	/**
	Creates a Cruise which includes the ship, the cruise line and
	the list of bookings for the cruise.
	@param ship Name of the ship.
	@param cruiseLine Name of cruise line.
	@param manifest List of bookings.
	*/
	public Cruise(String ship, String cruiseLine, Booking[] manifest){
		this.ship = ship;
		this.cruiseLine = cruiseLine;
		this.manifest = manifest;
	}
	
	/**
	Returns the number of total passengers on the ship.
	@return The total passengers on the ship.
	*/
	public int numPassengers(){
		int total = 0;
		for(Booking temp : manifest){
			total += temp.getOccupants();
		}
		return total;
	}
	
	/**
	Returns the name of the ship, the cruise line, and the list
	of bookings including the membership number, last and first 
	name of member, and number of occupants for each booking.
	@return Information about the cruise.
	*/
	public String toString(){
		String result = ship + " of " + cruiseLine + "\n";
		for(Booking temp : manifest)
			result += temp.getMemberId() + "\t" + temp.getLast() + 
			", " + temp.getFirst() + "\n\tOccupants: " +
			temp.getOccupants() + "\n\n";
		
		return result;
	}
}