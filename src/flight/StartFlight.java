package flight;

//import tasks.*;

public class StartFlight extends FlightManager {

	public StartFlight(int b, int x, int y, boolean c, boolean e) {
		super(b, x, y, c, e);

	}


	public boolean checkSystems() {
		if (checkConnection() && engineStatus == true) {
			return true;
		} else {
			System.out
					.println("Error occured during connectivity or engine malfunction. Trying FailSafeMode...");
			return false;
		}
	}

	public void startEngine() { // #1
		engineStatus = true;
	}

	public void setOnAir(boolean x) {
		onAirStatus = true;
	}

	public boolean getOnAir() {
		return onAirStatus;
	}

	// Setters
	public void setxInitPos(int x) {
		xInitPos = x;
	}

	public void setyInitPos(int y) {
		yInitPos = y;
	}

	//
	public void setxpos(int x) {
		xpos = x;
	}

	public void setypos(int y) {
		ypos = y;
	}

	//
	public void setxGPSpos(int x) {
		xGPSpos = x;
	}

	public void setyGPSpos(int y) {
		yGPSpos = y;
	}

	// Getters

	public int getxInitPos() {
		return xInitPos;
	}

	public int getyInitPos() {
		return yInitPos;
	}

	//
	public int getxpos() {
		return xpos;
	}

	public int getypos() {
		return ypos;
	}

	//
	public int getxGPSpos() {
		return xGPSpos;
	}

	public int getyGPSpos() {
		return yGPSpos;
	}

	public boolean checkConnection() {
		return connection;
	}
}
