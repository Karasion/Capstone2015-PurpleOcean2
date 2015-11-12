package kr.ac.kookmin.cs.hud;

import kr.ac.kookmin.cs.Navigation.*;

public class HUDModel {
  
  private NaviController naviController;
  private NaviView naviView;
  
  public HUDModel(NaviController naviController, NaviView naviView ) {
    this.naviController = naviController;
    this.naviView = naviView;
  }
  
  public NaviView getNaviView() { return naviView; }
  public NaviController getNaviController() { return naviController; }
  
  
}
