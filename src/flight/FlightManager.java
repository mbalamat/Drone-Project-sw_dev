package flight;

public abstract class FlightManager {
	private int batteryCapacity;
	private int xInitPos;
	private int yInitPos;
	private int xpos;
	private int ypos;
	private int xGPSpos;
	private int yGPSpos;
	private boolean connection;
	private boolean engineStatus;
	private boolean onAirStatus;

	public FlightManager(int b, int x, int y, boolean c, boolean e) {//FM constructor
		this.batteryCapacity=b;
		this.xInitPos=x;
		this.yInitPos=y;
		this.xpos=x;
		this.ypos=y;
		this.xGPSpos=x;
		this.yGPSpos=y;
		this.connection=c;
		this.engineStatus=e;
	}

	public int getBatteryCap() {
		return batteryCapacity;
	}

	public void getGPScoorFromTeam() {
		
	}

	public void move() {
		// somehow to do it that too
	}
}
