package kr.ac.kookmin.cs.hud;

import java.util.ArrayList;
import java.util.Stack;

import kr.ac.kookmin.cs.BSA.BSAController;
import kr.ac.kookmin.cs.BSA.BSAView;
import kr.ac.kookmin.cs.Navigation.*;
import kr.ac.kookmin.cs.basic.AppController;
import kr.ac.kookmin.cs.basic.AppView;

public class HUDModel {
  private NaviController naviController;
  private NaviView naviView;
  private BSAController bsaController;
  private BSAView bsaView;
  
  private ArrayList<AppView> appViewList;
  private ArrayList<AppController> appControllerList;
  private int appIndex = -1;
  
  private Stack<Integer> callBackStack;
  
  public HUDModel(/*NaviController naviController, NaviView naviView*/ ) {
//    this.naviController = naviController;
//    this.naviView = naviView;
    callBackStack = new Stack<Integer>();
    appViewList = new ArrayList<AppView>();
    appControllerList = new ArrayList<AppController>();
  }
  
  public NaviView getNaviView() { return naviView; }
  public NaviController getNaviController() { return naviController; }

  public int getState() {
	  return appIndex;
  }

  public AppController getAppController() {
	  if(appIndex < 0)
		  return null;

	  return appControllerList.get(appIndex);
  }
  
  public void setAppIndex(int index){
	  this.appIndex = index;
  }
  
  public void addNavi(NaviView naviView, NaviController naviController){
	  this.naviView = naviView;
	  this.naviController = naviController;
  }
  public void addBSA(BSAView bsaView, BSAController bsaController){
	  this.bsaView = bsaView;
	  this.bsaController = bsaController;
  }
  public void addAppController(AppController appController){
	  appControllerList.add(appController);
  }
  public void addAppView(AppView appView){
	  appViewList.add(appView);
  }
  public void interrupt(String controllerName){
	  callBackStack.push(new Integer(appIndex));
	  appIndex = getAppIndexByName(controllerName);
  }
  public void callback(){
	  appIndex = callBackStack.pop();
  }
  
  public AppController getAppControllerByName(String controllerName){
	  for(AppController app:appControllerList){
		  if(app.getControllerName()==controllerName)
			  return app;
	  }
	  return null;
  }
  
  private int getAppIndexByName(String controllerName){
	  int i = 0;
	  for(AppController app:appControllerList){
		  if(app.getControllerName()==controllerName)
			  return i;
		  i++;
	  }
	  return -1;
  }
  
  public ArrayList<AppController> getAppControllerList()
  {
	  return appControllerList;
  }
  
  public AppView getAppView(){
	  return appViewList.get(appIndex);
  }

  public BSAView getBSAView() {
	  return bsaView;
  }

  public BSAController getBSAController() {
	  
	  return bsaController;
  }
}
