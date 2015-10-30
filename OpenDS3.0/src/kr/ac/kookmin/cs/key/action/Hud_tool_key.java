package kr.ac.kookmin.cs.key.action;

import kr.ac.kookmin.cs.tool.HudLayoutTool;

public class Hud_tool_key {
  public static void action(boolean value)
  {
    if(value)
    {
      if(HudLayoutTool.hudToolActF)
        HudLayoutTool.deleteElement();
    }
  }
}
