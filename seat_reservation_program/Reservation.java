package seat_reservation_program;

import java.util.Scanner;

public class Reservation {
	private SeatArray[] seatArrays;
	private char[] seatTypes = {'S', 'A', 'B'};
	private Scanner scanner;
	
	public Reservation() {
		this.scanner = new Scanner(System.in);
		seatArrays = new SeatArray[seatTypes.length];
		for (int i = 0; i < 3; i++) {
			seatArrays[i] = new SeatArray(seatTypes[i]);
		}
		
	}
	
	private void reserve() {
		System.out.print("Seat Type S(1), A(2), B(3) >> ");
		int input = scanner.nextInt();
		scanner.nextLine();
		seatArrays[input - 1].show();
		
		System.out.print("Name >> ");
		String name = scanner.nextLine();
		System.out.print("Seat Number >> ");
		int num = scanner.nextInt();
		if (num < 1 || num > 16) System.out.println("Wrong input. Try Again!");
		else seatArrays[input - 1].reserve(num, name);
		scanner.nextLine();
		
		System.out.println();
	}
	
	private void search() {
		for (int i = 0; i < 3; i++) {
			seatArrays[i].show();
		}
		System.out.println("This is the end of the search.");
		System.out.println();
	}
	
	private void cancel() {
		System.out.print("Seat Type S(1), A(2), B(3) >> ");
		int input;
		while (true) {
			input = scanner.nextInt();
			scanner.nextLine();
			if (input < 1 || input > 3) System.out.println("Wrong input. Try Again!");
			else break;
		}
		seatArrays[input - 1].show();
		
		System.out.print("Name >> ");
		String name = scanner.nextLine();
		
		seatArrays[input - 1].cancel(name);
		System.out.println();
	}
	
	private void quit() {
		System.out.println("Thank you!");
	}
	
	public void run() {
		System.out.println("This is a reservation system for music concert.\n");
		
		while (true) {
			System.out.println("Reserve: 1, Search: 2, Cancle: 3, Quit: 4 >> ");
			int input = scanner.nextInt();
			scanner.nextLine();
			switch (input) {
			case 1:
				reserve();
				break;
			case 2:
				search();
				break;
			case 3:
				cancel();
				break;
			case 4:
				quit();
				break;
			default:
				System.out.println("Wrong input. Try Again!");
				break;
			}
			if (input == 4) break;
		}
	}
}
