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

import java.lang.reflect.Method;

import com.jme3.input.controls.ActionListener;
//import com.jme3.math.Vector3f;

import eu.opends.audio.AudioCenter;
import eu.opends.camera.CameraFactory;
import eu.opends.camera.CameraFactory.MirrorMode;
import eu.opends.canbus.CANClient;
import eu.opends.car.Car;
import eu.opends.car.SteeringCar;
import eu.opends.car.LightTexturesContainer.TurnSignalState;
import eu.opends.effects.EffectCenter;
import eu.opends.main.Simulator;
import eu.opends.niftyGui.MessageBoxGUI;
import eu.opends.tools.PanelCenter;
import eu.opends.tools.Util;

/**
 * 
 * @author Rafael Math
 */
public class SimulatorActionListener implements ActionListener
{
	private static float steeringValue = 0;
	private static float accelerationValue = 0;
	private static Simulator sim;
	private static SteeringCar car;
	private static boolean isWireFrame = false;
	
	
	public static float getSteeringValue()
	{
		return steeringValue;
	}
	public static void setSteeringValue(float value)
	{
		steeringValue = value;
	}
	public static float getAccelerationValue()
	{
		return accelerationValue;
	}
	public static void setAccelerationValue(float value)
	{
		accelerationValue = value;
	}
	public static Simulator getSimulator()
	{
		return sim;
	}
	public static SteeringCar getCar()
	{
		return car;
	}
	public static boolean isWireFarme()
	{
		return isWireFrame;
	}
	
	public static void setWireFarme(){
		isWireFrame = !isWireFrame;
	}
	
	
    public SimulatorActionListener(Simulator sim) 
    {
    	this.sim = sim;
    	this.car = sim.getCar();
	}
    
	public void onAction(String binding, boolean value, float tpf)
	{
		try {
//			System.out.println("key : " + binding);
			Class<?> actionClass = Class.forName(binding);
			Method action = actionClass.getMethod("action", new Class[]{boolean.class});
			action.invoke(actionClass, new Object[]{value});
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
