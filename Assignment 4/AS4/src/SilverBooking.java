/**
Represents a booking made by a customer with Silver status (3000).
@author Leah Bidlake 
*/

public class SilverBooking extends Booking{

	/**
	Additional cost of preferred decks.
	*/
	private final double DECKCOST = 120;
	
	/**
	Creates a Silver Booking.
	@param memberId Customer's membership ID.
	@param first Customer's first name.
	@param last Customer's last name.
	@param occupants Stateroom occupants.
	@param excursion Number of excursion's purchased.
	@param deckLevel Deck level stateroom is located on.
	*/
	public SilverBooking(int memberId, String first, String last, int occupants, int excursion, int deckLevel){
		super(memberId, first, last, occupants, excursion, deckLevel);
	}
	
	/**
	Calculates the cost of the booking and rewards the points (10%)
	earned from the booking (points are not rounded up).
	@return The cost of the booking.
	*/
	@Override
	public double calcCost(){
		double cost = super.calcCost();
		if(getDeckLevel() > 10)
			cost += DECKCOST;
		
		earnPoints((int)(cost*.1));
		
		return cost;
	}

}