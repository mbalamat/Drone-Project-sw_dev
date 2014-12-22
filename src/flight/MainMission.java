package flight;

import tasks.*;

public class MainMission extends FlightManager implements iMap, iPhoto, iBat,
		iBBox, iFMode {
	private boolean moved = false;
	private boolean proceed = true;

	public MainMission(StartFlight that) {
		super(that.batteryCapacity, that.xpos, that.ypos, that.connection,
				that.engineStatus);

	}

	public void movetopoint() {// don't forget to remove the top POI after using
								// it
		while (map1.getNextPOI() != null && canProceed()) {
			if (map1.getNextPOI().getY() > this.ypos) {
				while (!(map1.getNextPOI().getY() == this.ypos)) {
					move("right");
					moved = true;
				}
			} else if (map1.getNextPOI().getY() < this.ypos) {
				while (!(map1.getNextPOI().getY() == this.ypos)) {
					move("left");
					moved = true;
				}
			} else {
				if (map1.getNextPOI().getX() > this.xpos) {
					while (!(map1.getNextPOI().getX() == this.xpos)) {
						move("up");
						moved = true;
					}
				} else if (map1.getNextPOI().getX() < this.xpos) {
					while (!(map1.getNextPOI().getX() == this.xpos)) {
						move("down");
						moved = true;
					}
				} else {
					if (map1.getNextPOI().getX() == this.xpos
							&& map1.getNextPOI().getY() == this.ypos) {
						System.out.println("Point of interest reached!!!");
						checkPOI();
					} else {
						System.out
								.println("Cannot reach POI program is going to exit...");
						System.exit(0);
					}
				}

			}
		}
	}

	public void checkGPS() {
		if (xpos == xGPSpos && ypos == yGPSpos) {
			System.out.println("Drone on course");
		} else {
			System.out.println("Drone off course");
		}
	}

	public boolean checkOnAir() {
		return onAirStatus;
	}

	public void checkEOF() {
		if (moved == true && xpos == xInitPos && ypos == yInitPos) {
			System.out.println("Initializing landing sequence");
			// Do something with end flight
		}
	}

	public void checkPOI() {
		// if on POI
		cam.shootIRphoto();
		cam.shootRphoto();
		cam.shootVideo();
		batman.updateBattery(1);
		map1.echoMap();
		map1.rmTopPOI();//------remove TopPOI from ArrayList
	}

	public void getGPScoorFromTeam() {
		map1.getMapFile();
		map1.echoMap();
	}

//	public void checkPosition() {
//
//	}
//
//	public void checkSystems() {
//
//	}
	
	public boolean canProceed(){
		if (batman.canContinue()){
			return true; 
		}else{
			proceed=false;
			fm.initializeFmode();
			return proceed;
		}
	}

	public boolean getMovedStatus() {
		return moved;
	}

	// public static void main(String args[]){
	// batman.updateBattery(5);
	// System.out.println(batman.getBatteryCap());
	// batman.updateBattery(105);
	// System.out.println(batman.getBatteryCap());
	// bbx.sendLogFile();
	// map1.getMapFile();
	// map1.echoMap();
	// }

}
