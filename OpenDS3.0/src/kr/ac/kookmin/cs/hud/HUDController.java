package kr.ac.kookmin.cs.hud;


public class HUDController {
  private static HUDController hudController = new HUDController();
  private HUDModel hudModel;
  private HUDView hudView;
  
  public HUDController() {}
  
  public void init(HUDModel hudModel, HUDView hudView)
  {
    this.hudModel = hudModel;
    this.hudView = hudView;
    
    hudView.attachNode(hudModel.getNaviView().getNode());
  }
  
  public static HUDController getInstance()
  {
    return hudController;
  }
  
  public void eventHandler(ActionEvent event)
  {
    switch(event.getControllerName())
    {
      case "NaviController":
        hudModel.getNaviController().eventHandler(event); 
        break;
      case "HUDController":
        action(event.getActionName());
        break;
    }
  }
  
  private void action(String actionName)
  {
    switch(actionName)
    {
      case "HUDOnOrOff":
        hudView.HUDOnOrOff();
        break;
      case "HUDVisible":
        hudView.HUDVisible();
        break;
      case "HUDInvisible":
        hudView.HUDInvisible();
        break;
    }
  }

}
