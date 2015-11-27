package kr.ac.kookmin.cs.hud.event;


public class CallbackEvent implements Event {
	private String controllerName;
	public CallbackEvent(String controllerName)
	{
		this.controllerName = controllerName;
	}
	public String getControllerName() { return controllerName; }
}
