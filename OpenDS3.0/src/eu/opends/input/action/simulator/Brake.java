package eu.opends.input.action.simulator;

import eu.opends.car.SteeringCar;
import eu.opends.input.SimulatorActionListener;
import eu.opends.main.Simulator;

public class Brake {
	public static void action(boolean value)
	{
		SteeringCar car = SimulatorActionListener.getCar();
		Simulator sim = SimulatorActionListener.getSimulator();
		if (value) {
			car.setBrakePedalIntensity(1f);		
			sim.getThreeVehiclePlatoonTask().reportBrakeIntensity(1f);
			car.disableCruiseControlByBrake();
		} else {
			car.setBrakePedalIntensity(0f);
			sim.getThreeVehiclePlatoonTask().reportBrakeIntensity(0f);
		}
	}
}
