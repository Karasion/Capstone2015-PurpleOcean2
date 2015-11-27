package kr.ac.kookmin.cs.BSA;

import kr.ac.kookmin.cs.hud.event.ActionEvent;

public class BSAActionEvent extends ActionEvent {
	private String alertType;

	public BSAActionEvent(String actionName, String controllerName, String alertType )
	{
		super(actionName,controllerName);
		this.alertType = alertType;
	}

	public String getAlertType() { return alertType; }
}
