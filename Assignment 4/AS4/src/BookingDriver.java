/**
Processes a list of bookings to create a manifest.
@author Leah Bidlake 
*/
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class BookingDriver{

	public static void main(String[] args) throws IOException, FileNotFoundException{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter File Name (With extension)");
		File file = new File(scan.nextLine());
		scan = new Scanner (file);

		String cruiseline = scan.nextLine();
		String ship = scan.nextLine();
		
		int num = scan.nextInt();
		scan.nextLine();
		
		Booking[] manifest = new Booking[num];
		int index = 0;
		
		
		while(index < num){
			String booking = scan.nextLine();
			Scanner sc = new Scanner(booking);
			int id, occ, exc, deck;
			String first, last;
			Booking pass = null;
			id = sc.nextInt();
			first = sc.next();
			last = sc.next();
			occ = sc.nextInt();
			exc = sc.nextInt();
			deck = sc.nextInt();
			
			//Silver Booking
			try {
			if(id>=3000){
				pass = new SilverBooking(id, first, last, occ, exc, deck);
			}
			
			else if(id>=2000){
				
				char loc = sc.next().charAt(0);

					pass = new GoldBooking(id, first, last, occ, exc, deck, loc);
				}
			
			else{
				
				char add = sc.next().charAt(0);

					pass = new PlatBooking(id, first, last, occ, exc, deck, add);
			}
				
				manifest[index] = pass;
				index++;
			}
			catch(InvalidBookingException e) {
				System.out.println(e.getMessage());
				}
			
		}
		
		Cruise cruise = new Cruise(ship, cruiseline, manifest);
		
		System.out.println("Original Data:");
			for(Booking temp : manifest)
				System.out.println(temp);
	
		
			System.out.println();
			
			Sorter<Booking> sort = new Sorter<Booking>();
			sort.selectionSort(manifest);
	
		
		System.out.println("Sorted Data: \n");
		System.out.println(cruise);
		System.out.println("Total Passengers: " + cruise.numPassengers());
	}
}