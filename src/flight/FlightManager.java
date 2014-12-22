package flight;

public abstract class FlightManager {
	protected int batteryCapacity;
	protected int xInitPos;
	protected int yInitPos;
	protected int xpos;
	protected int ypos;
	protected int xGPSpos;
	protected int yGPSpos;
	protected boolean connection;
	protected boolean engineStatus;
	protected boolean onAirStatus;

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

//	public int getBatteryCap() {
//		return batteryCapacity;
//	}

//	public void getGPScoorFromTeam() {
//		
//	}

	public void move(String s) {
		// somehow to do it that too
		if (s==null){
			System.out.println("Nowhere to go!!!");
		}else if (s=="up"){
			this.yGPSpos+=1;
			this.ypos+=1;
		}else if (s=="down"){
			this.yGPSpos-=1;
			this.ypos-=1;
		}else if (s=="left"){
			this.xGPSpos-=1;
			this.xpos-=1;
		}else if (s=="right"){
			this.xGPSpos+=1;
			this.xpos+=1;
		}else{
			System.out.println("Didn't move");
		}
	}
}
