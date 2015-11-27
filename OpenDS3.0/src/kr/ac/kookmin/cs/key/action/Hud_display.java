package kr.ac.kookmin.cs.key.action;

import kr.ac.kookmin.cs.hud.HUDController;
import kr.ac.kookmin.cs.hud.event.ActionEvent;

public class Hud_display {
	private static HUDController hudController = HUDController.getInstance();
	public static void action(boolean value)
	{
		if (value) {
			hudController.eventHandler(new ActionEvent("HUDOnOrOff", "HUDController"));
		}
	}
}
