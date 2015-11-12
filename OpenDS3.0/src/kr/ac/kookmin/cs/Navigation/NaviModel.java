package kr.ac.kookmin.cs.Navigation;

public class NaviModel {
  private String distanceInfo;
  private String directionInfo;
  private String currentSpeedInfo;
  
  public NaviModel(){
    distanceInfo = null;
    directionInfo = "straight";
    currentSpeedInfo = "0";
  }
  
  // getter
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
  
  // setter
  public void setDistanceInfo(String distanceInfo)
  {
    this.distanceInfo = distanceInfo;
  }
  
  public void setDirectionInfo(String directionInfo)
  {
    this.directionInfo = directionInfo;
  }
  
  public void setCurrentSpeedInfo(String currentSpeedInfo)
  {
    this.currentSpeedInfo = currentSpeedInfo;
  }
}

