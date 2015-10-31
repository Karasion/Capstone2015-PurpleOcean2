package kr.ac.kookmin.cs.key.action;

import kr.ac.kookmin.cs.hud.HUDManagement;

public class Ghub_push {
  public static void action(boolean value)
  {
    if (value) {
      if(HUDManagement.getKeyFlag()){
          if(HUDManagement.getState() == HUDManagement.NON_STATE){
              System.out.println("select Menu!");
              HUDManagement.selectMenu();
              System.out.println("state : " + HUDManagement.getState());
          }
          else
              HUDManagement.pushKeyAct();
      }
  }
  }
}
