package eu.opends.input.action.simulator;

import eu.opends.car.SteeringCar;
import eu.opends.input.SimulatorActionListener;
import eu.opends.main.Simulator;

public class Accelerate {	
	public static void action(boolean value)
	{
		float accelerationValue = SimulatorActionListener.getAccelerationValue();
		Simulator sim = SimulatorActionListener.getSimulator();
		SteeringCar car = SimulatorActionListener.getCar();
		if (value) {
			sim.getSteeringTask().getPrimaryTask().reportGreenLight();
			accelerationValue -= 1;
			//sim.getPhysicalTraffic().getTrafficCar("car2").setBrakeLight(false);
		} else {
			accelerationValue += 1;
		}
		
		SimulatorActionListener.setAccelerationValue(accelerationValue);		
		sim.getThreeVehiclePlatoonTask().reportAcceleratorIntensity(Math.abs(accelerationValue));
		car.setAcceleratorPedalIntensity(accelerationValue);
	}
}
