package eu.opends.input.action.simulator;

import eu.opends.car.SteeringCar;
import eu.opends.input.SimulatorActionListener;

public class Reset_car_pos5 {
  public static void action(boolean value) {
    SteeringCar car = SimulatorActionListener.getCar();
    if (value)
      car.setToResetPosition(4);
  }
}
