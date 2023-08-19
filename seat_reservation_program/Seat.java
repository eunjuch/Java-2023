package seat_reservation_program;

public class Seat {
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void show() {
		if (this.name == null) System.out.print("--- ");
		else System.out.print(name + " ");
	}
	
	public boolean isMatched(String checkName) {
		return checkName.equals(name);
	}
	
	public void cancel() {
		this.name = null;
	}
	
}
