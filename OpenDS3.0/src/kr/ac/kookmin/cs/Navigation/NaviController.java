package kr.ac.kookmin.cs.Navigation;

import kr.ac.kookmin.cs.hud.ActionEvent;
import eu.opends.main.Simulator;

public class NaviController {
  private NaviView naviView;
  private NaviModel naviModel; 
  
  public NaviController(Simulator sim) {
    naviModel = new NaviModel();
    naviView = new NaviView(sim, naviModel);
    naviView.update();
  }
  
  public NaviView getNaviView() { return naviView; }
  
  public void eventHandler(ActionEvent event) {
    NaviActionEvent ev = (NaviActionEvent)event;
      switch(ev.getActionName())
      {
        case "DirectionTrigger":
          naviModel.setDirectionInfo(ev.getDirectionInfo());
          naviModel.setDistanceInfo(ev.getDistanceInfo());
          break;
        case "UpdateCurrentSpeed":
          naviModel.setCurrentSpeedInfo(ev.getCurrentSpeedInfo());
          break;
      }
      naviView.update();
  }
                                               
}
