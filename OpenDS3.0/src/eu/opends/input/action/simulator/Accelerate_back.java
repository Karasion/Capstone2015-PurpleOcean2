package eu.opends.input.action.simulator;

import eu.opends.car.SteeringCar;
import eu.opends.input.SimulatorActionListener;
import eu.opends.main.Simulator;

public class Accelerate_back {
	public static void action(boolean value){
		float accelerationValue = SimulatorActionListener.getAccelerationValue();
		Simulator sim = SimulatorActionListener.getSimulator();
		SteeringCar car = SimulatorActionListener.getCar();
		if (value) {
			sim.getSteeringTask().getPrimaryTask().reportRedLight();
			accelerationValue += 1;
			//sim.getPhysicalTraffic().getTrafficCar("car2").setBrakeLight(true);
		} else {
			accelerationValue -= 1;
		}
		
		SimulatorActionListener.setAccelerationValue(accelerationValue);
		car.setAcceleratorPedalIntensity(accelerationValue);
	}
}
