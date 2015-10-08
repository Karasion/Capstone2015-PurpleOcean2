package eu.opends.input.action.simulator;

import eu.opends.car.SteeringCar;
import eu.opends.input.SimulatorActionListener;
import eu.opends.main.Simulator;

public class Shift_down {
	public static void action(boolean value){
		Simulator sim = SimulatorActionListener.getSimulator();
		SteeringCar car = SimulatorActionListener.getCar();
		if (value)
		{
			sim.getSteeringTask().getPrimaryTask().reportDoubleRedLight();
			car.getTransmission().shiftDown(false);
		}
	}
}
