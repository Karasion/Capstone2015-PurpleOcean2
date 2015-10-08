/*
*  This file is part of OpenDS (Open Source Driving Simulator).
*  Copyright (C) 2015 Rafael Math
*
*  OpenDS is free software: you can redistribute it and/or modify
*  it under the terms of the GNU General Public License as published by
*  the Free Software Foundation, either version 3 of the License, or
*  (at your option) any later version.
*
*  OpenDS is distributed in the hope that it will be useful,
*  but WITHOUT ANY WARRANTY; without even the implied warranty of
*  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*  GNU General Public License for more details.
*
*  You should have received a copy of the GNU General Public License
*  along with OpenDS. If not, see <http://www.gnu.org/licenses/>.
*/

package eu.opends.input;

import java.util.ArrayList;

import eu.opends.basics.SimulationBasics;

/**
 * 
 * @author Rafael Math
 */
public class KeyMapping
{
	private static ArrayList<Key> simulatorAnalogKeyMappingList = new ArrayList<Key>();
	private static ArrayList<Key> simulatorActionKeyMappingList = new ArrayList<Key>();
	private static ArrayList<Key> driveAnalyzerAnalogKeyMappingList = new ArrayList<Key>();
	private static ArrayList<Key> driveAnalyzerActionKeyMappingList = new ArrayList<Key>();
	
	private static KeyMapping keyMapping = new KeyMapping();
	
	// look up table of joystick buttons
	/*
	inputManager.addMapping(KeyMapping.TOGGLE_AUTOMATIC.getID(), new JoyButtonTrigger(0,1));
	inputManager.addMapping(KeyMapping.TOGGLE_CAM.getID(), new JoyButtonTrigger(0,3));
	inputManager.addMapping(KeyMapping.REPORT_LANDMARK.getID(), new JoyButtonTrigger(0,7));
	inputManager.addMapping(KeyMapping.SHIFT_DOWN.getID(), new JoyButtonTrigger(0,8));
	inputManager.addMapping(KeyMapping.SHIFT_UP.getID(), new JoyButtonTrigger(0,9));
	inputManager.addMapping(KeyMapping.CLOSE_INSTRUCTION_SCREEN.getID(), new JoyButtonTrigger(0,14));
	inputManager.addListener(simulatorActionListener, KeyMapping.TOGGLE_CAM.getID());
	 */
	
	private KeyMapping()
	{	
	}
	
	public static KeyMapping getInstance()
	{
		return keyMapping;
	}
	
	public static ArrayList<Key> getSimulatorActionKeyMappingList()
	{
		return simulatorActionKeyMappingList;
	}
	
	public static void setSimulatorActionKeyMappingList(Key key)
	{
		simulatorActionKeyMappingList.add(key);
	}

	public static ArrayList<Key> getSimulatorAnalogKeyMappingList() 
	{		
		return simulatorAnalogKeyMappingList;
	}
	
	public static void setSimulatorAnalogKeyMappingList(Key key) 
	{		
		simulatorAnalogKeyMappingList.add(key);
	}
	
	
	public static ArrayList<Key> getDriveAnalyzerActionKeyMappingList() 
	{
		return driveAnalyzerActionKeyMappingList;
	}
	
	public static void setDriveAnalyzerActionKeyMappingList(Key key) 
	{
		driveAnalyzerActionKeyMappingList.add(key);
	}
	
	public static ArrayList<Key> getDriveAnalyzerAnalogKeyMappingList() 
	{
//		SimulationBasics.getDrivingTask().getSettingsLoader().lookUpKeyMappings(keyMappingList);
		
		return driveAnalyzerAnalogKeyMappingList;
	}
	
	public static void setDriveAnalyzerAnalogKeyMappingList(Key key) 
	{
//		SimulationBasics.getDrivingTask().getSettingsLoader().lookUpKeyMappings(keyMappingList);
		
		driveAnalyzerAnalogKeyMappingList.add(key);
	}
}
