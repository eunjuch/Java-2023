package gym_reservation_program;

public class BasketBallPlayer implements Player {
	private String name;
	private double speed;
	private String tools[];
	private double jump;
	
	public BasketBallPlayer(String name) {
		this.name = name;
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
		
		if (speed == 0.0) System.out.print("Speed: No information");
		else System.out.println("Speed: " + this.speed);
		
		if (tools == null) System.out.print("Tools: No information");
		else {
			System.out.print("Tools: " + tools[0]);
			for (int i = 1; i < tools.length; i++) {
				System.out.print(", " + tools[i]);
			}
			System.out.println();
		}
		
		if (jump == 0.0) System.out.print("Jump: No information");
		else System.out.println("Jump: " + this.jump);
	}
	
	public void setJump(double jump) {
		this.jump = jump;
	}
}
