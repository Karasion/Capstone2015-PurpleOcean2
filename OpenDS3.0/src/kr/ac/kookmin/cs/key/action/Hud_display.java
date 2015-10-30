package kr.ac.kookmin.cs.key.action;

import kr.ac.kookmin.cs.hud.HUDManagement;

public class Hud_display {
  public static void action(boolean value)
  {
    if (value)
    {
      if(HUDManagement.getKeyFlag() == false && HUDManagement.isCameraEgo() == true){
        HUDManagement.keyFlagSetting();
        HUDManagement.hudAttach();
      }
      else if(HUDManagement.getKeyFlag() == true && HUDManagement.isCameraEgo() == true){
        HUDManagement.keyFlagSetting();
        HUDManagement.hudDetach();
      }
    }
  }
}
