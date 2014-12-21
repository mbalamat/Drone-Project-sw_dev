package tasks;

public class FailSafeMode {
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
		}
	}

	public boolean initializeFmode() {
		isFailSafeModeOn = true;
		killAllSecondarySystems();
		sendDistressSignal(!secondarySystems);
		returningHome();
		return isFailSafeModeOn;

	}

//	public static void main(String[] args) {
//		FailSafeMode fm = new FailSafeMode();
//		fm.initializeFmode();
//	}

}
