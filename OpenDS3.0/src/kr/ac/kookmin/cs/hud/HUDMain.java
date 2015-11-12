package kr.ac.kookmin.cs.hud;

import kr.ac.kookmin.cs.Navigation.NaviActionEvent;
import kr.ac.kookmin.cs.Navigation.NaviController;
import eu.opends.main.Simulator;

public class HUDMain {
  
  private static HUDMain hudMain = new HUDMain();
  private Simulator sim;
  private HUDController hudController = HUDController.getInstance();
  
  public HUDMain() {}
  
  public void init(Simulator sim)
  {
    this.sim = sim;
    NaviController naviController = new NaviController(sim);
    
    HUDModel hudModel = new HUDModel(naviController, naviController.getNaviView());
    HUDView hudView = new HUDView(sim, hudModel);
    hudController.init(hudModel, hudView);
    
  }
  
  public void update()
  {
    hudController.eventHandler(new NaviActionEvent("UpdateCurrentSpeed","NaviController",String.valueOf((int)sim.getCar().getCurrentSpeedKmh())));
    
  }
  
  public static HUDMain getInstance() { return hudMain; }

}
