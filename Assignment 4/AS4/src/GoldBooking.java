/**
Represents a booking made by a customer with Gold status (2000).
@author Leah Bidlake 
*/

public class GoldBooking extends Booking{

	/**
	Location of stateroom on the ship.
	*/
	private char location;
	
	/**
	Discount on non-preferred locations.
	*/
	private final double LOCDISC = 75;
	
	/**
	Additional cost of preferred decks.
	*/
	private final double DECKCOST = 175;
	
	/**
	Creates a Gold Booking.
	@param memberId Customer's membership ID.
	@param first Customer's first name.
	@param last Customer's last name.
	@param occupants Stateroom occupants.
	@param excursion Number of excursion's purchased.
	@param deckLevel Deck level stateroom is located on.
	@param location Location of stateroom on the ship.
	*/
	public GoldBooking(int memberId, String first, String last, int occupants, int excursion, int deckLevel, char location) throws InvalidBookingException{
		super(memberId, first, last, occupants, excursion, deckLevel);
	
		this.location = location;
		if (location != 'F' && location != 'A' && location != 'M') {
			
			throw new InvalidBookingException("Input must be F A or M");
		}
	}
	
	/**
	Returns the location of the stateroom.
	@return The location of the stateroom.
	*/
	public char getLocation(){
		return location;
	}
	
	/**
	Calculates the cost of the booking and rewards the points (20%)
	earned from the booking (points are not rounded up).
	@return The cost of the booking.
	*/
	@Override
	public double calcCost(){
		double cost = super.calcCost();
		if(getDeckLevel() > 10)
			cost += 175;
		if(location == 'A' || location == 'F' )
			cost -= 75;
	
		earnPoints((int)(cost*.20));
		
		return cost;
	}
	
}