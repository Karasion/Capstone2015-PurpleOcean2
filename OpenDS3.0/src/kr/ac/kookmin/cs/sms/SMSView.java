package kr.ac.kookmin.cs.sms;

import com.jme3.font.BitmapFont;
import com.jme3.font.BitmapText;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Node;

import eu.opends.main.Simulator;
import kr.ac.kookmin.cs.basic.AppModel;
import kr.ac.kookmin.cs.basic.AppView;

public class SMSView extends AppView {
	  private BitmapText smsText;
	  
	  public SMSView(Simulator sim){
	    super("SMSView", sim);
	    super.setEnableIcon("MusicIcon_en", "Textures/icons/menubar/menubar_sms.png", 80, 80);
		super.setDisableIcon("MusicIcon_dis", "Textures/icons/menubar/menubar_sms_c.png", 80, 80);
		
		BitmapFont ko_Font = super.getAssetManager().loadFont("Interface/Fonts/MSNeoGothic/MSNeoGothic.fnt");	    
	    
	    smsText = new BitmapText(ko_Font,false);
	    smsText.setName("smsText");
	    smsText.setText("");
	    smsText.setSize(ko_Font.getCharSet().getRenderedSize());
	    smsText.setColor(ColorRGBA.White);
	    smsText.setLocalTranslation(710 * adjustValueX,340 * adjustValueY,0);
	    
	    super.getNode().attachChild(smsText);
	  }
	@Override
	public void update(AppModel appModel) {
		SMSModel smsModel = (SMSModel) appModel;

		super.getEnableIcon().setImage(super.getAssetManager(), "Textures/icons/menubar/menubar_sms.png", true);
		super.getDisableIcon().setImage(super.getAssetManager(), "Textures/icons/menubar/menubar_sms_c.png", true);

		smsText.setText(smsModel.getNewMsg());

	}
	public void setNewMSG() {
		super.getEnableIcon().setImage(super.getAssetManager(), "Textures/icons/menubar/menubar_sms_badge.png", true);
		super.getDisableIcon().setImage(super.getAssetManager(), "Textures/icons/menubar/menubar_sms_badge_c.png", true);
	}
}
