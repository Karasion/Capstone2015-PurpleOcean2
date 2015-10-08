package eu.opends.input.action.driveAnalyzer;

import eu.opends.input.DriveAnalyzerActionListener;
import eu.opends.main.DriveAnalyzer;

public class Toggle_keymapping {
	static public void action(boolean value)
	{
		DriveAnalyzer analyzer = DriveAnalyzerActionListener.getDriveAnalyzer();
		if (value)
			analyzer.getKeyMappingGUI().toggleDialog();
	}
}
