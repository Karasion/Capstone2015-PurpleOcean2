package kr.ac.kookmin.cs.hud.event;


public class KeyEvent implements Event {
	private String key;
	private String targetControllerName;
	
	public KeyEvent(String key, String targetControllerName)
	{
		this.key = key;
		this.targetControllerName = targetControllerName;
	}
	
	public String getKey() { return key; }
	public String getTargetControllerName() { return targetControllerName; }
}
