/**
Represents a booking made by a customer.
@author Leah Bidlake 
*/

import java.text.NumberFormat;

public abstract class Booking implements Comparable<Booking>{
	
	/**
	Customer's first name.
	*/
	private String first;
	
	/**
	Customer's last name.
	*/
	private String last;
	
	/**
	Customer's member ID.
	*/
	private int memberId;
	
	/**
	Occupancy for stateroom.
	*/
	private int occupants;
	
	/**
	Number of excursions.
	*/
	private int excursion;
	
	/**
	Deck level of stateroom.
	*/
	private int deckLevel;
	
	/**
	Customer's total points.
	*/
	private int points;
	
	/**
	Cost per occupant.
	*/
	private final double BASECOST = 1200;
	
	/**
	Cost per excursion.
	*/
	private final double EXCCOST = 97;
	
	/**
	Creates a Booking and rewards the customer with 100 points.
	@param memberId Customer's membership ID.
	@param first Customer's first name.
	@param last Customer's last name.
	@param occupants Stateroom occupants.
	@param excursion Number of excursion's purchased.
	@param deckLevel Deck level the stateroom is on.
	*/
	public Booking(int memberId, String first, String last, int occupants, int excursion, int deckLevel){
		this.first = first;
		this.last = last;
		this.memberId = memberId;
		this.occupants = occupants;
		this.excursion = excursion;
		this.deckLevel = deckLevel;
		points = 100;
	}
	
	/**
	Calculates the cost of the booking based on the occupants 
	and number of excursions.
	@return The cost of the booking.
	*/
	public double calcCost(){
		return (occupants*BASECOST + excursion*EXCCOST);
	}
	
	/**
	Returns the first name of the member who made the booking.
	@return The member's first name.
	*/
	public String getFirst(){
		return first;
	}
	
	/**
	Returns the last name of the member who made the booking.
	@return The member's last name.
	*/
	public String getLast(){
		return last;
	}
	
	/**
	Returns the membership number the booking was made with.
	@return The membership number.
	*/
	public int getMemberId(){
		return memberId;
	}
	
	/**
	Returns the number of occupants the booking was made for.
	@return The number of occupants.
	*/
	public int getOccupants(){
		return occupants;
	}
	
	/**
	Returns the number of excursions purchased.
	@return The number of excursions.
	*/
	public int getExcursion(){
		return excursion;
	}
	
	/**
	Returns the deck level the stateroom is located on.
	@return The deck level of the stateroom.
	*/
	public int getDeckLevel(){
		return deckLevel;
	}
	
	/**
	Returns the total reward points collected by the member.
	@return The number of reward points.
	*/
	public int getPoints(){
		return points;
	}
	
	/**
	Adds reward points to the total reward points as they are earned.
	@param pts The reward points earned.
	*/
	public void earnPoints(int pts){
		points += pts;
	}
	
	public int compareTo(Booking other){
		if(this.last.equals(other.last))
			if(this.first.equals(other.first))
				return (this.memberId - other.memberId);
			else
				return this.first.compareTo(other.first);
		else
			return this.last.compareTo(other.last);
	}
	
	/**
	Returns the member number, last name, first name, cost of
	the booking and the total points.
	@return Information about the booking.
	*/
	public String toString(){
		NumberFormat form = NumberFormat.getCurrencyInstance();
		String result = "\n" + memberId + "\t" + last + ", " + first + 
			"\n\tCost: " + form.format(calcCost()) + 
			"\n\tPoints: " + points;
		return result;
	}
}