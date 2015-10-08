package eu.opends.input.action.simulator;

import eu.opends.canbus.CANClient;
import eu.opends.car.SteeringCar;
import eu.opends.input.SimulatorActionListener;
import eu.opends.main.Simulator;

public class Steer_right {
	public static void action(boolean value)
	{
		float steeringValue = SimulatorActionListener.getSteeringValue();
		Simulator sim = SimulatorActionListener.getSimulator();
		SteeringCar car = SimulatorActionListener.getCar();
		
		if (value) {
			steeringValue += -.3f;
			//sim.getPhysicalTraffic().getTrafficCar("car2").setTurnSignal(TurnSignalState.RIGHT);
		} else {
			steeringValue += .3f;
		}
		SimulatorActionListener.setSteeringValue(steeringValue);
		
		// if CAN-Client is running suppress external steering
		CANClient canClient = Simulator.getCanClient();
		if(canClient != null)
			canClient.suppressSteering();
		
		sim.getSteeringTask().setSteeringIntensity(-3*steeringValue);
		car.steer(steeringValue);
	}
}
