package flight;

import tasks.iBat;
import tasks.iMap;

public abstract class FlightManager implements iBat, iMap{
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
			System.exit(0);
		}else if (s=="up"){
			this.xGPSpos+=1;
			this.xpos+=1;
			batman.updateBattery(1);
			map1.refreshMap(this.xpos, this.ypos);
			//map1.echoMap();
		}else if (s=="down"){
			this.xGPSpos-=1;
			this.xpos-=1;
			batman.updateBattery(1);
			map1.refreshMap(this.xpos, this.ypos);
			//map1.echoMap();
		}else if (s=="left"){
			this.yGPSpos-=1;
			this.ypos-=1;
			batman.updateBattery(1);
			map1.refreshMap(this.xpos, this.ypos);
			//map1.echoMap();
		}else if (s=="right"){
			this.yGPSpos+=1;
			this.ypos+=1;
			batman.updateBattery(1);
			map1.refreshMap(this.xpos, this.ypos);
			//map1.echoMap();
		}else{
			System.out.println("Didn't move");
		}
	}
}
