package eu.opends.input.action.driveAnalyzer;

import eu.opends.input.DriveAnalyzerActionListener;
import eu.opends.main.DriveAnalyzer;

public class Shutdown {
	static public void action(boolean value)
	{
		DriveAnalyzer analyzer = DriveAnalyzerActionListener.getDriveAnalyzer();
		if (value)
			analyzer.getShutDownGUI().toggleDialog();
	}
}
