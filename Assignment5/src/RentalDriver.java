import java.text.NumberFormat;
import java.util.Scanner;
/**
 * This class represents a driver for the
 * Rental Classes
 * @author Dylan Lohnes
 *
 */
public class RentalDriver {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the capacity of vehicle you want to rent");
		
		int cap = scan.nextInt();
		
		System.out.println("Enter 1 if you are a Buisness class customer, 0 if you are not.");
				
		int buis = scan.nextInt();
		RentalContract r3 = null;
		
		switch(buis){
		
		case 0: r3 = new EconomyClassRental(cap);
				break;
		case 1: r3 = new BuisnessClassRental(cap);
				break;
		}
		NumberFormat t1 = NumberFormat.getCurrencyInstance();
		if (r3 instanceof EconomyClassRental)
		{
			System.out.println("Rate: " + t1.format(r3.getDailyRentalCost()));
			System.out.println("Insurance Cost: " + t1.format(((EconomyClassRental) r3).getInsuranceCost()));
			System.out.println("Total Cost: " + t1.format(((EconomyClassRental) r3).getInsuranceCost() + r3.getDailyRentalCost()));
		}
		
		
		else if (r3 instanceof BuisnessClassRental)
		{
			System.out.println("Rate: " + t1.format(r3.getDailyRentalCost()));
			System.out.println("Rewards Points: " + ((BuisnessClassRental)r3).getPoints());
		}
	}
}
