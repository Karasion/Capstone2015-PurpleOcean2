package kr.ac.kookmin.cs.hud.event;


public class InterruptEvent implements Event {
	private String controllerName;
	public InterruptEvent(String controllerName)
	{
		this.controllerName = controllerName;
	}
	public String getControllerName() { return controllerName; }
}
