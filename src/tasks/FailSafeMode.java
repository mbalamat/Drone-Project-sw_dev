package tasks;

public class FailSafeMode implements iBBox, iBat, iMap{
	private boolean isFailSafeModeOn = false;
	private boolean secondarySystems = true;
	private boolean returningHome = false;

	private void killAllSecondarySystems() {
		secondarySystems = false;
	}

	private boolean returningHome() {
		returningHome = true;
		if (secondarySystems == false) {
			return returningHome;
		} else {
			return !returningHome;
		}
	}

	private void sendDistressSignal(boolean x) {
		if (x == true) {
			System.out
					.println("Warning Something went awfully WRONG FailSafeMode is on...");
			bbx.logActivity("Warning Something went awfully WRONG FailSafeMode is on...");
		}
	}

	public boolean initializeFmode() {
		if (!(map1.POIlist.get(0)==null)){	
			isFailSafeModeOn = true;
			killAllSecondarySystems();
			sendDistressSignal(!secondarySystems);
			returningHome();
			bbx.logActivity("Warning Something went awfully WRONG, Returning Home");
		
		}else{
			System.out.println("Home reached...");
			bbx.logActivity("Home Reached");
			System.exit(0);
		}
		return isFailSafeModeOn;
	}
	
	public boolean getFMstatus(){
		return isFailSafeModeOn;
	}
	
//Stand alone testing
	
//	public static void main(String[] args) {
//		FailSafeMode fm = new FailSafeMode();
//		fm.initializeFmode();
//	}

}
