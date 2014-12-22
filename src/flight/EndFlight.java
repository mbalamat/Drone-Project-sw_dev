package flight;
import tasks.*;

public class EndFlight extends FlightManager implements iMap, iBBox, iFMode{
	
	private boolean onLand=false;	
	
	public EndFlight(MainMission that){
		super(that.batteryCapacity, that.xpos, that.ypos, that.connection, that.engineStatus);
		
	}
	
	public boolean checkPosition(){
		if (this.xpos==map1.getBase().getX() && this.ypos==map1.getBase().getY()){
			onLand=true;
			return true;
		}else{
			return false;
		}
	}
	
	public void movetoBpoint(){
		if (fm.getFMstatus() || checkPosition()){
			while (checkPosition()==false) {
				if (map1.getBase().getY() > this.ypos) {
					while (!(map1.getBase().getY() == this.ypos)) {
						move("right");
					}
				} else if (map1.getBase().getY() < this.ypos) {
					while (!(map1.getBase().getY() == this.ypos)) {
						move("left");
					}
				} else {
					if (map1.getBase().getX() > this.xpos) {
						while (!(map1.getBase().getX() == this.xpos)) {
							move("up");
						}
					} else if (map1.getBase().getX() < this.xpos) {
						while (!(this.xpos==map1.getBase().getX())) {
							move("down");
						}
					} else {
						if (this.xpos==map1.getBase().getX() && this.ypos==map1.getBase().getY()) {
							System.out.println("BASE reached!!!");
							land();
						} else {
							System.out
									.println("Cannot reach BASE is going to exit...");
							System.exit(0);
						}
					}

				}
			}
		}
	}
	
	public void land(){
		if (onLand==true){
			System.out.println("On Landing Point");
			bbx.logActivity("On Landing Point");
			
			System.out.println("Landed Succesfully");
			bbx.logActivity("Landed Succesfully, Closing all systems...");
			
			this.engineStatus=false;
			this.onAirStatus=false;
			this.connection=false;
		}else{
			movetoBpoint();
		}
	}
	


}
