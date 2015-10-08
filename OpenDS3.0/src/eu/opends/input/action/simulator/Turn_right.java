package eu.opends.input.action.simulator;

import eu.opends.car.LightTexturesContainer.TurnSignalState;
import eu.opends.car.SteeringCar;
import eu.opends.input.SimulatorActionListener;

public class Turn_right {
  
  public static void action(boolean value) {
    SteeringCar car = SimulatorActionListener.getCar();
    if (value) 
    {
        if(car.getTurnSignal() == TurnSignalState.RIGHT)
            car.setTurnSignal(TurnSignalState.OFF);
        else
            car.setTurnSignal(TurnSignalState.RIGHT);
    }
  } 
}
