package eu.opends.input.action.simulator;

import eu.opends.car.SteeringCar;
import eu.opends.input.SimulatorActionListener;

public class Reset_car_pos7 {
  public static void action(boolean value) {
    SteeringCar car = SimulatorActionListener.getCar();
    if (value)
    {
        //sim.getObjectManipulationCenter().setPosition("RoadworksSign1", new Vector3f(-740,0,-41));
        car.setToResetPosition(6);
    }
  }
}
