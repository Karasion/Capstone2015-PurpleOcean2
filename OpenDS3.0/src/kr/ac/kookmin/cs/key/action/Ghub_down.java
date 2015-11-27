package kr.ac.kookmin.cs.key.action;

import kr.ac.kookmin.cs.hud.HUDController;
import kr.ac.kookmin.cs.hud.event.KeyEvent;

public class Ghub_down {
  public static void action(boolean value)
  {
    if (value){
      HUDController hudController = HUDController.getInstance();
      hudController.eventHandler(new KeyEvent("Down", "HUDController"));
    }
  }
}
//Action 내용 구현