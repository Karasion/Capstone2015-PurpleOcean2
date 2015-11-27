package kr.ac.kookmin.cs.key.action;

import kr.ac.kookmin.cs.hud.HUDController;
import kr.ac.kookmin.cs.hud.event.KeyEvent;

public class Ghub_up {
	public static void action(boolean value)
	{
		if(value){
			HUDController hudController = HUDController.getInstance();
			hudController.eventHandler(new KeyEvent("Up", "HUDController"));
		}
	}
}
