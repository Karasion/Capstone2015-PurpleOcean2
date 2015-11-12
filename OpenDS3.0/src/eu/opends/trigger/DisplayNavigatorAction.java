package eu.opends.trigger;

import kr.ac.kookmin.cs.Navigation.NaviActionEvent;
import kr.ac.kookmin.cs.hud.HUDController;
import kr.ac.kookmin.cs.hud.HUDManagement;

//Im gisung, Hong sunghyeon
public class DisplayNavigatorAction extends TriggerAction {
	String naviType;
	String distance;
	
	public DisplayNavigatorAction(String naviType, String distance)
	{
		super();
		this.naviType = naviType;
		this.distance = distance;
	}
	
	// override
	protected void execute()
	{
		//HUDManagement.setNaviType(naviType, distance);
	  HUDController.getInstance().eventHandler(new NaviActionEvent("DirectionTrigger","NaviController",distance, naviType));
	}
	// override
	public String toString()
	{
		return "DisplayNavigatorAction: " + naviType;
	}

}
