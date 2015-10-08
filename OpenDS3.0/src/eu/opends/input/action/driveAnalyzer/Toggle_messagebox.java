package eu.opends.input.action.driveAnalyzer;

import eu.opends.input.DriveAnalyzerActionListener;
import eu.opends.main.DriveAnalyzer;
import eu.opends.niftyGui.MessageBoxGUI;
import eu.opends.tools.PanelCenter;

public class Toggle_messagebox {
	static public void action(boolean value)
	{
		DriveAnalyzer analyzer = DriveAnalyzerActionListener.getDriveAnalyzer();
		if (value)
		{
			MessageBoxGUI messageBoxGUI = PanelCenter.getMessageBox();
			messageBoxGUI.toggleDialog();

			analyzer.toggleMessageBoxUpdates();
		}
	}
}
