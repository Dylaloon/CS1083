/**
 * This class represents all the methods needed
 * for the driver and GUI class
 * @author Dylan Lohnes
 *
 */
public class EconomyClassRental extends RentalContract {

	/**
	 * Creates the Economy rental object
	 * and passes the number of seats requested.
	 * @param capacity Holds the number of seats requested.
	 */
	public EconomyClassRental (int capacity) {
		super(capacity);
	}
	
	 /**
	  * Calculates the daily cost of the rental car.
	  * @return Returns the daily cost of the rental car.
	  */
	public double getDailyRentalCost() {
		double dailyCost = 50;
		if (super.getVehicleCapacity() > 7){
				dailyCost += (super.getVehicleCapacity() * 5.0);
		}
		else if (super.getVehicleCapacity() <= 7 && super.getVehicleCapacity() >= 5)
		{
				dailyCost += (super.getVehicleCapacity() * 3.50);
		}
		else 
		{
			dailyCost += (super.getVehicleCapacity() * 2);
		}
		return dailyCost;
	}
	 
	/**
	 * Calculates the daily insurance cost for 
	 * the rental
	 * @return Returns the calculated cost
	 */
	public double getInsuranceCost() {
		return 6 + (super.getVehicleCapacity() * 3.50);
	}
}
