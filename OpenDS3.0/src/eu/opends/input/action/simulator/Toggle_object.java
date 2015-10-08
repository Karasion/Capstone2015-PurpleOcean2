package eu.opends.input.action.simulator;

import eu.opends.car.SteeringCar;
import eu.opends.input.SimulatorActionListener;
import eu.opends.main.Simulator;

public class Toggle_object {
  public static void action(boolean value) {
    
    Simulator sim = SimulatorActionListener.getSimulator();
    if (value)
    {
        ((SteeringCar)sim.getCar()).getObjectLocator().toggleThingNode();
    }
  }

}
