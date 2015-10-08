package eu.opends.input.action.simulator;

import eu.opends.niftyGui.MessageBoxGUI;
import eu.opends.tools.PanelCenter;

public class Toggle_messagebox {
	public static void action(boolean value){
		if (value)
		{
			MessageBoxGUI messageBoxGUI = PanelCenter.getMessageBox();
			messageBoxGUI.toggleDialog();
		}
	}
}
