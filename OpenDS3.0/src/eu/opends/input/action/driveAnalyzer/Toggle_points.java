package eu.opends.input.action.driveAnalyzer;

import eu.opends.input.DriveAnalyzerActionListener;
import eu.opends.main.DriveAnalyzer;
import eu.opends.main.DriveAnalyzer.VisualizationMode;

public class Toggle_points {
	static public void action(boolean value)
	{
		DriveAnalyzer analyzer = DriveAnalyzerActionListener.getDriveAnalyzer();
		if (value) 
		{
			analyzer.toggleVisualization(VisualizationMode.POINT);
		}
	}
}
