package eu.opends.input.action.simulator;

import eu.opends.input.SimulatorActionListener;
import eu.opends.main.Simulator;

public class Start_pause {
	public static void action(boolean value){
		Simulator sim = SimulatorActionListener.getSimulator();
		if (value && (!sim.isPause()))
			sim.setPause(true);
	}
}
