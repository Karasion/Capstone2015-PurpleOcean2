package eu.opends.input.action.simulator;

import eu.opends.car.LightTexturesContainer.TurnSignalState;
import eu.opends.car.SteeringCar;
import eu.opends.input.SimulatorActionListener;

public class Turn_left {
  
  public static void action(boolean value) {
    SteeringCar car = SimulatorActionListener.getCar();
    if (value) 
    {
        if(car.getTurnSignal() == TurnSignalState.LEFT)
            car.setTurnSignal(TurnSignalState.OFF);
        else
            car.setTurnSignal(TurnSignalState.LEFT);
    }
  }
}
