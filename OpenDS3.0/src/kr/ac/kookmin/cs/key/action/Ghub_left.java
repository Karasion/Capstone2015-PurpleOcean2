package kr.ac.kookmin.cs.key.action;

import kr.ac.kookmin.cs.hud.HUDManagement;

public class Ghub_left {
  public static void action(boolean value)
  {
    if (value)
    {
        if(HUDManagement.getKeyFlag()){
            if(HUDManagement.getState() == HUDManagement.NON_STATE)
                HUDManagement.leftMoveCursor();
            else
                HUDManagement.leftKeyAct();
        }
    }
  }
}
