package eu.opends.input.action.simulator;

import eu.opends.input.SimulatorActionListener;
import eu.opends.main.Simulator;

public class Toggle_trafficlightmode {
	public static void action(boolean value){
		Simulator sim = SimulatorActionListener.getSimulator();
		if (value)
		{
			sim.getTrafficLightCenter().toggleMode();
			//sim.getPhysicalTraffic().getTrafficCar("car1").loseCargo();
		}
	}
}
