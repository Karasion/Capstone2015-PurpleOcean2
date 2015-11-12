package kr.ac.kookmin.cs.key.action;

import kr.ac.kookmin.cs.hud.ActionEvent;
import kr.ac.kookmin.cs.hud.HUDController;
import kr.ac.kookmin.cs.hud.HUDManagement;

public class Hud_display {
  private static HUDController hudController = HUDController.getInstance();
  public static void action(boolean value)
  {
    if (value)
    {
//      if(HUDManagement.getKeyFlag() == false && HUDManagement.isCameraEgo() == true){
//        HUDManagement.keyFlagSetting();
//        HUDManagement.hudAttach();
//      }
//      else if(HUDManagement.getKeyFlag() == true && HUDManagement.isCameraEgo() == true){
//        HUDManagement.keyFlagSetting();
//        HUDManagement.hudDetach();
//      } 
      hudController.eventHandler(new ActionEvent("HUDOnOrOff", "HUDController"));
    }
  }
}
