package eu.opends.input.action.simulator;

import eu.opends.car.LightTexturesContainer.TurnSignalState;
import eu.opends.car.SteeringCar;
import eu.opends.input.SimulatorActionListener;

public class Hazard_lights {
  
  public static void action(boolean value) {
    SteeringCar car = SimulatorActionListener.getCar();
    if (value) 
    {
        if(car.getTurnSignal() == TurnSignalState.BOTH)
            car.setTurnSignal(TurnSignalState.OFF);
        else
            car.setTurnSignal(TurnSignalState.BOTH);
    }
  }

}
