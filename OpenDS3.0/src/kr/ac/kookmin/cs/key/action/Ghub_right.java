package kr.ac.kookmin.cs.key.action;

import kr.ac.kookmin.cs.hud.HUDController;
import kr.ac.kookmin.cs.hud.event.KeyEvent;

public class Ghub_right {
	public static void action(boolean value)
	{
		if (value) {
			HUDController hudController = HUDController.getInstance();
			hudController.eventHandler(new KeyEvent("Right", "HUDController"));
		}
	}
}
