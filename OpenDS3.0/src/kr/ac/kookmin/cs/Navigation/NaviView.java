package kr.ac.kookmin.cs.Navigation;

import com.jme3.asset.AssetManager;
import com.jme3.font.BitmapFont;
import com.jme3.font.BitmapText;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Node;
import com.jme3.ui.Picture;

import eu.opends.main.Simulator;

public class NaviView {
  private Node naviNode = new Node("naviNode"); 
  private NaviModel naviModel;
  private AssetManager assetManager;
  private Picture navigatorSign;
  private BitmapText currentSpeed;
  private float adjustValueX, adjustValueY;
  
  public NaviView(Simulator sim, NaviModel naviModel){
    BitmapFont ko_Font = sim.getAssetManager().loadFont("Interface/Fonts/MSNeoGothic/MSNeoGothic.fnt");
    this.naviModel = naviModel;
    assetManager = sim.getAssetManager();
    adjustValueX = (float)sim.getSettings().getWidth() / 1920;
    adjustValueY = (float)sim.getSettings().getHeight() / 1080;
    
    navigatorSign = new Picture("NavigatorSign");
    navigatorSign.setWidth(52 * adjustValueX);
    navigatorSign.setHeight(101 * adjustValueY);
    navigatorSign.setPosition(1130 * adjustValueX, 190 * adjustValueY);
    
    currentSpeed = new BitmapText(ko_Font,false);
    currentSpeed.setName("currentSpeedText");
    currentSpeed.setText("");
    currentSpeed.setSize(ko_Font.getCharSet().getRenderedSize()+10);
    currentSpeed.setColor(ColorRGBA.White);
    currentSpeed.setLocalTranslation(1130 * adjustValueX, 170 * adjustValueY ,0);
    
    naviNode.attachChild(navigatorSign);
    naviNode.attachChild(currentSpeed);
  }
  
  public Node getNode() 
  {
    return naviNode;
  }
  
   void update()
  {
    currentSpeed.setText(naviModel.getCurrentSpeedInfo() + "km/h");
    switch(naviModel.getDirectionInfo())
    {
      case "right":
        navigatorSign.setWidth(98 * adjustValueX);
        navigatorSign.setHeight(136 * adjustValueY);
        navigatorSign.setImage(assetManager, "Textures/icons/navi/arrow_right.png", true);
        break;
      case "left":
        navigatorSign.setWidth(98 * adjustValueX);
        navigatorSign.setHeight(136 * adjustValueY);
        navigatorSign.setImage(assetManager, "Textures/icons/navi/arrow_left.png", true);
        break;
      case "straight":
        navigatorSign.setWidth(66 * adjustValueX);
        navigatorSign.setHeight(136 * adjustValueY);
        navigatorSign.setImage(assetManager, "Textures/icons/navi/arrow_straight.png", true);
        break;
    }
  }
  
}
