package eu.opends.input.action.simulator;

import eu.opends.input.SimulatorActionListener;
import eu.opends.main.Simulator;
import eu.opends.tools.Util;

public class Toggle_wireframe {
	public static void action(boolean value){
		Simulator sim = SimulatorActionListener.getSimulator();
		boolean isWireFrame = SimulatorActionListener.isWireFarme();
		isWireFrame = !isWireFrame;
		SimulatorActionListener.setWireFarme();
		Util.setWireFrame(sim.getSceneNode(), isWireFrame);
	}
}
