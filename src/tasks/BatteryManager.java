package tasks;

public class BatteryManager implements iBBox {
	private int batteryCapacity = 100;
	private boolean contigency;

	public void updateBattery(int x) {
		if (batteryCapacity > x) {
			batteryCapacity -= x;
		} else {
			System.out.println("Something is draining a lot of battery...!");
			bbx.logActivity("Something is draining a lot of battery...!");
			this.canContinue();
		}
	}

	public int getBatteryCap() {
		bbx.logActivity("Battery Cap: at " + batteryCapacity + "%");
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
