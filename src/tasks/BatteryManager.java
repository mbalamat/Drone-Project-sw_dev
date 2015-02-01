package tasks;

public class BatteryManager implements iBBox {
	private int batteryCapacity; // experimenting with values
	private boolean contigency;
	
	
	
	public void updateBattery(int x) {
		if (batteryCapacity > x) {
			batteryCapacity -= x;
			getBatteryCap();
		} else {
			System.out.println("Something is draining a lot of battery...!");
			bbx.logActivity("Something is draining a lot of battery...!");
			this.canContinue();
		}
	}

	public int getBatteryCap() {
		bbx.logActivity("Battery Cap: at " + batteryCapacity + "%");
		if (this.batteryCapacity<=4){
			System.out.println("Battery extremely low shutting down...");
			System.exit(0);
		}
		return batteryCapacity;
	}

	public boolean canContinue() {
		if (batteryCapacity >= 20) {
			contigency = true;
			return contigency;
		} else {
			return false;
		}
	}

	public void setBatteryCap(int x) {
		batteryCapacity=x;
	}
	
	// testing

	// public static void main(String[] args){
	// BatteryManager batman = new BatteryManager();
	// System.out.println(batman.getBatteryCap());
	// batman.updateBattery(2);
	// System.out.println(batman.getBatteryCap());
	// batman.updateBattery(58);
	// System.out.println(batman.getBatteryCap());
	// batman.updateBattery(58);
	// System.out.println(batman.getBatteryCap());
	//
	// }

}
