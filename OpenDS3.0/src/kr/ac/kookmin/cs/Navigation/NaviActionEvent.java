package kr.ac.kookmin.cs.Navigation;

import kr.ac.kookmin.cs.hud.ActionEvent;

public class NaviActionEvent extends ActionEvent{
  private String distanceInfo;
  private String directionInfo;
  private String currentSpeedInfo;
  
  public NaviActionEvent(String actionName, String controllerName, String currentSpeedInfo)
  {
    super(actionName,controllerName);
    this.currentSpeedInfo = currentSpeedInfo;
  }
  
  public NaviActionEvent(String actionName, String controllerName, String distanceInfo, String directionInfo )
  {
    super(actionName,controllerName);
    this.distanceInfo = distanceInfo;
    this.directionInfo = directionInfo;
  }
  
  public String getDistanceInfo()
  {
    return distanceInfo;
  }
  
  public String getDirectionInfo()
  {
    return directionInfo;
  }
  
  public String getCurrentSpeedInfo()
  {
    return currentSpeedInfo;
  }
 
}
