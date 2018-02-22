/**
Represents a booking made by a customer with Platinum status (1000).
@author Leah Bidlake 
*/

public class PlatBooking extends Booking{

	/**
	Add-on for stateroom.
	*/
	private char addon;
	
	/**
	Additional cost of preferred decks.
	*/
	private final double DECKCOST = 215;
	
	/**
	Additional cost of add-on.
	*/
	private final double ADDCOST = 245;
	
	/**
	Creates a Platinum Booking.
	@param memberId Customer's membership ID.
	@param first Customer's first name.
	@param last Customer's last name.
	@param occupants Stateroom occupants.
	@param excursion Number of excursion's purchased.
	@param deckLevel Deck level stateroom is located on.
	@param addon Customer's selection of porthole or balcony.
	*/
	public PlatBooking(int memberId, String first, String last, int occupants, int excursion, int deckLevel, char addon)throws InvalidBookingException{
		super(memberId, first, last, occupants, excursion, deckLevel);
		
		this.addon = addon;
		if (addon != 'P' && addon != 'B') {
			throw new InvalidBookingException("Input Must Be P or B");
		}
	}
	
	/**
	Returns the add-on for the stateroom.
	@return The add-on for the stateroom.
	*/
	public char getAddon(){
		return addon;
	}
	
	/**
	Calculates the cost of the booking and rewards the points (30%)
	earned from the booking (points are not rounded up).
	@return The cost of the booking.
	*/
	@Override
	public double calcCost(){
		double cost = super.calcCost();
		if(getDeckLevel() > 20)
			cost += DECKCOST;
		if(addon == 'P')
			cost += ADDCOST;
		else
			cost += ADDCOST*2;
			
		earnPoints((int)(cost*.30));
		
		return cost;
	}
		
}