package flight;
import tasks.*;

public class MainMission extends FlightManager implements iMap, iPhoto, iBat, iBBox{
	private boolean moved=false;
	
	public MainMission(StartFlight that){
		super(that.batteryCapacity, that.xpos, that.ypos, that.connection, that.engineStatus);
		
	}
	
	public void move(){
		
	}
	
	public void checkGPS(){
		if (xpos==xGPSpos && ypos==yGPSpos){
			System.out.println("Drone on course");
		}else{
			System.out.println("Drone off course");
		}
	}
	
	public boolean checkOnAir(){
		return onAirStatus;
	}
	
	public void checkEOF(){
		if (moved==true && xpos==xInitPos && ypos==yInitPos){
			System.out.println("Initializing landing sequence");
			//Do something with end flight
		}
	}
	
	public void checkPOI(){
		//if on POI
		cam.shootIRphoto();
		cam.shootRphoto();
		cam.shootVideo();
		batman.updateBattery(1);
	}
	
	public void getGPScoorFromTeam(){
		map1.getMapFile();
		map1.echoMap();
	}
	
	
	public void checkPosition(){
		
	}
	
	public void checkSystems(){
		
	}
	
	public void changeMovedStatus(){
		moved=true;
	}

//	public static void main(String args[]){
//		batman.updateBattery(5);
//		System.out.println(batman.getBatteryCap());
//		batman.updateBattery(105);
//		System.out.println(batman.getBatteryCap());
//		bbx.sendLogFile();
//		map1.getMapFile();
//		map1.echoMap();
//	}
	
}
