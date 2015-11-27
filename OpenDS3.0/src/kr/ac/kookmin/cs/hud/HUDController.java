package kr.ac.kookmin.cs.hud;

import java.util.ArrayList;

import kr.ac.kookmin.cs.basic.AppController;
import kr.ac.kookmin.cs.hud.event.*;
import kr.ac.kookmin.cs.hud.menu.HUDMenuView;


public class HUDController {
  private static HUDController hudController = new HUDController();
  private HUDModel hudModel;
  private HUDView hudView;
  private HUDMenuView hudMenuView;
  
  public HUDController() {}
  
  public void init(HUDModel hudModel, HUDView hudView, HUDMenuView hudMenuView)
  {
    this.hudModel = hudModel;
    this.hudView = hudView;
    this.hudMenuView = hudMenuView;
    
    hudView.attachNode(hudModel.getNaviView().getNode());
    hudView.attachNode(hudModel.getBSAView().getNode());
    hudView.attachNode(hudMenuView.getHudMenuNode());
  }
  
  public static HUDController getInstance()
  {
    return hudController;
  }
  
  public void eventHandler(Event event)
  {
    if(event instanceof ActionEvent){
    	actionEventHandler((ActionEvent) event);
    }else if(event instanceof KeyEvent){
    	keyEventHandler((KeyEvent) event);
    }else if(event instanceof InterruptEvent){
    	InterruptEvent ev = (InterruptEvent) event;
    	hudModel.interrupt(ev.getControllerName());
    	ArrayList<AppController> appConList = hudModel.getAppControllerList();
    	for(AppController appCon : appConList){
    		if(appCon.getControllerName() != ev.getControllerName())
    			appCon.eventHendler((InterruptEvent) event);
    	}
    	hudMenuView.setViewDisableIcon();
    	hudView.attachNode(hudModel.getAppView().getNode());
    }else if(event instanceof CallbackEvent){
    	CallbackEvent ev = (CallbackEvent) event;
    	hudView.detachNode(hudModel.getAppView().getNode());
    	hudMenuView.menuSelect();
    	hudModel.callback();
    	ArrayList<AppController> appConList = hudModel.getAppControllerList();
    	for(AppController appCon : appConList){
    		if(appCon.getControllerName() != ev.getControllerName())
    			appCon.eventHendler((CallbackEvent) event);
    	}
    	
    }
  }
  
  private void keyEventHandler(KeyEvent event) {
	  if(hudModel.getState() >= 0){
		  System.out.println("hudState" + hudModel.getState());
		  hudModel.getAppController().eventHendler(event);
		  return;
	  }
	  keyAction(event);
  }

  public void actionEventHandler(ActionEvent event)
  {
	  String controllerName = event.getControllerName();
	  switch(controllerName)
	  {
	  case "NaviController":
		  hudModel.getNaviController().eventHandler(event); 
		  break;
	  case "BSAController":
		  hudModel.getBSAController().eventHandler(event); 
		  break;
	  case "HUDController":
		  action(event.getActionName());
		  break;
	  default:
		  AppController appCon = hudModel.getAppControllerByName(controllerName);
		  appCon.eventHendler(event);
		  break;
	  }
  }
  
  private void keyAction(KeyEvent event) {
	  switch(event.getKey()){
	  case "Right":
		  hudMenuView.moveRightCursorPos();
		  break;
	  case "Left":
		  hudMenuView.moveLeftCursorPos();
		  break;
	  case "Push":
		  hudMenuView.menuSelect();
		  hudModel.setAppIndex(hudMenuView.getCursorIndex());
		  System.out.println(hudMenuView.getCursorIndex());
		  hudView.attachNode(hudModel.getAppView().getNode());		  
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
	  case "Escape":
		  hudView.detachNode(hudModel.getAppView().getNode());
		  hudMenuView.setViewEnableIcon();
		  hudModel.setAppIndex(-1);
		  break;
	  }
  }
}
