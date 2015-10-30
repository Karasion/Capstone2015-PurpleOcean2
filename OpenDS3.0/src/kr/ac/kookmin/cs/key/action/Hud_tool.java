package kr.ac.kookmin.cs.key.action;

import kr.ac.kookmin.cs.tool.HudLayoutTool;

public class Hud_tool {
  public static void action(boolean value)
  {
    if(value)
    {
      if(HudLayoutTool.hudToolActF)
      {
        HudLayoutTool.hudToolActF=false;
        HudLayoutTool.exitHudTool();
      }
      else
      {
        HudLayoutTool.hudToolActF=true;
        HudLayoutTool.startHudTool();
      }
    }
  }
}
