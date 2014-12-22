package flight;

public class EndFlight extends FlightManager{
	
	public EndFlight(StartFlight that){
		super(that.batteryCapacity, that.xpos, that.ypos, that.connection, that.engineStatus);
		
	}

}
