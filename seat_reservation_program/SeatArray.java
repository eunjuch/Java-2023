package seat_reservation_program;

public class SeatArray {
	private char seatType;
	private Seat[] seats;
	private static int seatLength = 16;
	
	public SeatArray(char seatType) {
		this.seatType = seatType;
		seats = new Seat[seatLength];
		for (int i = 0; i < seatLength; i++) {
			this.seats[i] = new Seat();
		}
	}
	
	public void reserve(int seatNumber, String name) {
		if (seatNumber < 1 || seatNumber > seatLength) 
			System.out.println("Wrong input. Try Again!");
		else seats[seatNumber - 1].setName(name);
	}
	
	public void show() {
		System.out.print(seatType + " >> ");
		for (int i = 0; i < seatLength; i++) {
			seats[i].show();
		}
		System.out.println();
	}
	
	public void cancel(String name) {
		boolean check = false;
		for (int i = 0; i < seatLength; i++) {
			if (seats[i].isMatched(name)) {
				seats[i].cancel();
				check = true;
				break;
			}
		}
		if (!check) System.out.println("Wrong input. Try Again!");
	}
}
