package eu.opends.input.action.simulator;

import eu.opends.camera.CameraFactory;
import eu.opends.input.SimulatorActionListener;
import eu.opends.main.Simulator;

public class Toggle_topview {
	public static void action(boolean value)
	{
		Simulator sim = SimulatorActionListener.getSimulator();
		if (value)
		{
			CameraFactory camFactory = sim.getCameraFactory();

			if(camFactory.isTopViewEnabled())
				camFactory.setTopViewEnabled(false);
			else
				camFactory.setTopViewEnabled(true);
		}
	}
}
