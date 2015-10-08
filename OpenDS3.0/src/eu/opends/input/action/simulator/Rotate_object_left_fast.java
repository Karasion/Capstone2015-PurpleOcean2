package eu.opends.input.action.simulator;

import eu.opends.car.SteeringCar;
import eu.opends.input.SimulatorActionListener;
import eu.opends.main.Simulator;

public class Rotate_object_left_fast {
  public static void action(boolean value) {
    Simulator sim = SimulatorActionListener.getSimulator();
    if (value)
    {
        ((SteeringCar)sim.getCar()).getObjectLocator().rotateThingNode(-30);
    }
  }
}
