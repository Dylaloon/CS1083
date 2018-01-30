/**
 * This class represents the Buisness 
 * rental calculations.
 * @author Dylan Lohnes
 *
 */
public class BuisnessClassRental extends RentalContract{

		/**
		 * Creates a buisness rental object passing in 
		 * the amount of seats wanted.
		 * @param capacity Holds the number of seats needed.
		 */
		public BuisnessClassRental (int capacity){
			super(capacity);
		}

		/**
		 * Calculates the daily rental cost for 
		 * the Buisness rental car.
		 * @return Returns the calculated cost.
		 */
		public double getDailyRentalCost() {
			double dailyCost = 47;
			if (super.getVehicleCapacity() > 7)
					dailyCost += (super.getVehicleCapacity() * 5.50);
			return dailyCost;
		}
		/**
		 * Calculates the Reward points earned.
		 * @return returns the calculated points
		 */
			public int getPoints() {
				return (int)(150 * getDailyRentalCost());
			}
}
