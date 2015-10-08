package eu.opends.input.action.simulator;

import eu.opends.car.SteeringCar;
import eu.opends.input.SimulatorActionListener;

public class Cruise_control {
  public static void action(boolean value) {
    SteeringCar car = SimulatorActionListener.getCar();
    if (value)
      car.setCruiseControl(!car.isCruiseControl());
  }
}
