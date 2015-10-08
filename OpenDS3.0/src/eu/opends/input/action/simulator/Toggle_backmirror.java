package eu.opends.input.action.simulator;

import eu.opends.camera.CameraFactory;
import eu.opends.camera.CameraFactory.MirrorMode;
import eu.opends.input.SimulatorActionListener;
import eu.opends.main.Simulator;

public class Toggle_backmirror {
	public static void action(boolean value)
	{
		Simulator sim = SimulatorActionListener.getSimulator();
		if (value)
		{
			CameraFactory camFactory = sim.getCameraFactory();
			MirrorMode mirrorState = camFactory.getMirrorMode();
			
			if(mirrorState == MirrorMode.OFF)
				camFactory.setMirrorMode(MirrorMode.BACK_ONLY);
			else if(mirrorState == MirrorMode.BACK_ONLY)
				camFactory.setMirrorMode(MirrorMode.ALL);
			else if(mirrorState == MirrorMode.ALL)
				camFactory.setMirrorMode(MirrorMode.SIDE_ONLY);
			else
				camFactory.setMirrorMode(MirrorMode.OFF);
		}
	}
}
