package eu.opends.input.action.simulator;

import eu.opends.input.SimulatorActionListener;
import eu.opends.main.Simulator;

public class Toggle_pause {
	public static void action(boolean value){
		Simulator sim = SimulatorActionListener.getSimulator();
		if (value) {
			// toggle camera
			sim.setPause(!sim.isPause());
		}
	}
}
