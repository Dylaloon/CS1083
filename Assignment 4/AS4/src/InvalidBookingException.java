public class InvalidBookingException extends Exception{
		public InvalidBookingException(String message) throws InvalidBookingException {
			super(message);
		}
}