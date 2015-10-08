package eu.opends.input.action.simulator;

import eu.opends.audio.AudioCenter;

public class Horn {
	public static void action(boolean value){
		if (value)
			AudioCenter.playSound("horn");
		else
			AudioCenter.stopSound("horn");
	}
}
