package gym_reservation_program;

import java.util.Scanner;

public class Gym {
	private SoccerPlayer[] sc;
	private BasketBallPlayer[] bsk;
	private Scanner scanner = new Scanner(System.in);
	private static int playerLength = 16;
	
	public Gym() {
		sc = new SoccerPlayer[playerLength];
		bsk = new BasketBallPlayer[playerLength];
	}
	
	private void reserve() {
		System.out.println("Player Type (1: Soccer, 2: BasketBall) >> ");
		int inputType = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Name >> ");
		String name = scanner.nextLine();
		System.out.print("Room Number >> ");
		int roomNumber = scanner.nextInt();
		
		Player type;
		if (inputType == 1) {
			System.out.print("Kick Speed >> ");
			double kickSpeed = scanner.nextDouble();
			SoccerPlayer rgst = new SoccerPlayer(name, kickSpeed);
			type = rgst;
		}
		else {
			BasketBallPlayer rgst = new BasketBallPlayer(name);
			System.out.print("Jump >> ");
			double jump = scanner.nextDouble();
			rgst.setJump(jump);
			type = rgst;
		}
		
		System.out.print("Speed >> ");
		double speed = scanner.nextDouble();
		type.setSpeed(speed);
		scanner.nextLine();
		
		System.out.print("Tools(Separate with Comma(,)) >> ");
		String[] tools = scanner.nextLine().split(",");
		type.setTools(tools);
		
		if (inputType == 1 && sc[roomNumber] == null) sc[roomNumber] = (SoccerPlayer) type;
		else if (inputType == 2 && bsk[roomNumber] == null) bsk[roomNumber] = (BasketBallPlayer) type;
		else System.out.println("The room is already reserved.");
		
	}
	
	private void search() {
		System.out.println("Player Type (1: Soccer, 2: BasketBall) >> ");
		int inputType = scanner.nextInt();
		System.out.print("Room Number >> ");
		int roomNumber = scanner.nextInt();
		
		if (sc[roomNumber] != null && inputType == 1) sc[roomNumber].showDetails();
		else if (bsk[roomNumber] != null && inputType == 2) bsk[roomNumber].showDetails();
		else System.out.println("No reservation.");
	}
	
	private void cancel() {
		scanner.nextLine();
		System.out.print("Name >> ");
		String name = scanner.nextLine();
		int i;
		
		for (i = 0; i < playerLength; i++) {
			if (sc[i] != null) {
				if (sc[i].getName().equals(name)) {
					sc[i] = null;
					break;			
				}
			} else if (bsk[i] != null) {
				if(bsk[i].getName().equals(name)) {
					bsk[i] = null;
					break;
				}
			}
		}
		
		if (i<16) System.out.println("Your reservation is canceled.");
		else System.out.println("Reservation does not exist. Try again.");
	}
	
	private void quit() {
		System.out.println("Thank you!");
	}
	
	public void run() {
		System.out.println("This is a reservation system for gym.");
		System.out.println();
		int state;
		while (true) {
			System.out.print("Reserve: 1, Search: 2, Cancel: 3, Quit: 4 >> ");
			state = scanner.nextInt();
			switch (state) {
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
				return;
			default:
				System.out.println("This is a wrong command.");
			}
			System.out.println();
		}
	}
}
