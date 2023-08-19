package gym_reservation_program;

public class SoccerPlayer implements Player {
	private String name;
	private double speed;
	private String tools[];
	private double kickSpeed;
	
	public SoccerPlayer(String name, double kickSpeed) {
		this.name = name;
		this.kickSpeed = kickSpeed;
	}
	
	@Override
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	@Override
	public void setTools(String[] tools) {
		if (tools == null) tools = null;
		else {
			this.tools = new String[tools.length];
			for (int i = 0; i < tools.length; i++) {
				this.tools[i] = tools[i];
			}
		}
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public void showDetails() {
		System.out.println("Name: " + this.name);
		
		if (speed == 0.0) System.out.println("Speed: No information");
		else System.out.println("Speed: " + this.speed);
		
		if (tools == null) System.out.println("Tools: No information");
		else {
			System.out.print("Tools: " + tools[0]);
			for (int i = 1; i < tools.length; i++) {
				System.out.print(", " + tools[i]);
			}
			System.out.println();
		}
		
		System.out.println("KickSpeed: " + this.kickSpeed);
	}
	
	public void setKickSpeed(double kickSpeed) {
		this.kickSpeed = kickSpeed;
	}
	
	
}
