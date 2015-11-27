package kr.ac.kookmin.cs.call;

import kr.ac.kookmin.cs.hud.event.ActionEvent;

public class CallActionEvent extends ActionEvent {
	private String sender;

	public CallActionEvent(String actionName, String controllerName, String sender) {
		super(actionName, controllerName);
		this.sender = sender;
	}
	
	public String getSener() { return sender; }
}
