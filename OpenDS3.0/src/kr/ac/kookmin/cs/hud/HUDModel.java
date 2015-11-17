package kr.ac.kookmin.cs.hud;

import kr.ac.kookmin.cs.BSA.BSAController;
import kr.ac.kookmin.cs.BSA.BSAView;
import kr.ac.kookmin.cs.Navigation.*;

public class HUDModel {
  
  private NaviController naviController;
  private NaviView naviView;
  private BSAController bsaController;
  private BSAView bsaView;
  
  public HUDModel(NaviController naviController, NaviView naviView, BSAController bsaController, BSAView bsaView ) {
    this.naviController = naviController;
    this.naviView = naviView;
    this.bsaController = bsaController;
    this.bsaView = bsaView;
  }
  
  public NaviView getNaviView() { return naviView; }
  public NaviController getNaviController() { return naviController; }
  
  public BSAView getBSAView() { return bsaView; }
  public BSAController getBSAController() { return bsaController; };
  
  
}
