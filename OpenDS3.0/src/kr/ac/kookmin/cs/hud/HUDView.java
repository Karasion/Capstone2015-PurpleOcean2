package kr.ac.kookmin.cs.hud;

import com.jme3.scene.Node;
import com.jme3.ui.Picture;

import eu.opends.main.Simulator;

public class HUDView {
    private Node guiNode;
    private Node hud;
//    private HUDModel hudModel;
    private boolean hudOnOffFlag = false;
    
    public HUDView(Simulator sim, HUDModel hudModel)
    {
        Picture backGround;
        float adjustValueX = (float)sim.getSettings().getWidth()/1920;
        float adjustValueY = (float)sim.getSettings().getHeight()/1080;
        guiNode = sim.getGuiNode();
//        this.hudModel = hudModel;
        hud = new Node("hud");
        backGround = new Picture("bg");
        backGround.setWidth(841 * adjustValueX);
        backGround.setHeight(338 * adjustValueY);
        backGround.setPosition(580 * adjustValueX, 30 * adjustValueY);
        backGround.setImage(sim.getAssetManager(), "Textures/icons/panel/panel.png", true);
        
        hud.attachChild(backGround);
    }
    
    public Node getHUDNode()
    {
        return hud;
    }
    
    public void HUDOnOrOff()
    {
      if(!hudOnOffFlag) {
        hudOnOffFlag = true;
        HUDVisible();
      }
      else {
        hudOnOffFlag = false;
        HUDInvisible();
      }
    }
    
    public void HUDVisible()
    {
      if(hudOnOffFlag)
        guiNode.attachChild(hud);
    }
    
    public void HUDInvisible()
    {
      guiNode.detachChild(hud);
    }
    
    public void attachNode(Node node)
    {
        hud.attachChild(node);
    }
    
    public void detachNode(Node node)
    {
        hud.detachChild(node);
    }
    
}