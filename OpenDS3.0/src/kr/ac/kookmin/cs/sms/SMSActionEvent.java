package kr.ac.kookmin.cs.sms;

import kr.ac.kookmin.cs.hud.event.ActionEvent;

public class SMSActionEvent extends ActionEvent {
	private String msgText;
	private String sender;

	public SMSActionEvent(String actionName, String controllerName, String msgText, String sender) {
		super(actionName, controllerName);
		this.msgText = msgText;
		this.sender = sender;
	}
	
	public String getSender(){
		return sender;
	}
	
	public String getMSGText(){
		return msgText;
	}
}
