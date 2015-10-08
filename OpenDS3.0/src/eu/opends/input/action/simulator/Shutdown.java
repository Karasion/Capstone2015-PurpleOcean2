package eu.opends.input.action.simulator;

import eu.opends.input.SimulatorActionListener;
import eu.opends.main.Simulator;

public class Shutdown {
	public static void action(boolean value)
	{
		Simulator sim = SimulatorActionListener.getSimulator();
		if (value) 
		{
			if(Simulator.oculusRiftAttached)
				sim.stop();
			else
				sim.getShutDownGUI().toggleDialog();
		}
	}
}
