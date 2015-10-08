package eu.opends.input.action.simulator;

import eu.opends.input.SimulatorActionListener;
import eu.opends.main.Simulator;

public class Toggle_cinematics {
  public static void action(boolean value) {
    Simulator sim = SimulatorActionListener.getSimulator();
    if (value)
    {
        if(sim.getCameraFlight() != null)
            sim.getCameraFlight().toggleStop();
        
        sim.getSteeringTask().start();
    }
  }
}
