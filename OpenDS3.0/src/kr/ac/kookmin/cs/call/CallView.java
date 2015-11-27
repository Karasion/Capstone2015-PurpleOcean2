package kr.ac.kookmin.cs.call;

import com.jme3.font.BitmapFont;
import com.jme3.font.BitmapText;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Node;
import com.jme3.ui.Picture;

import eu.opends.main.Simulator;
import kr.ac.kookmin.cs.basic.AppModel;
import kr.ac.kookmin.cs.basic.AppView;

public class CallView extends AppView {
	private BitmapText callText;
	private Picture callAccept, callReject;
	private Picture callEnd;
	
	public CallView(Simulator sim) {
		super("CallView", sim);
		
		BitmapFont font = sim.getAssetManager().loadFont("Interface/Fonts/MSNeoGothic/MSNeoGothic.fnt");
		
		callText = new BitmapText(font,false);
	    callText.setName("callText");
	    callText.setText("");
	    callText.setSize(font.getCharSet().getRenderedSize()+10);
	    callText.setColor(ColorRGBA.Yellow);
	    callText.setLocalTranslation(750*super.adjustValueX,340*super.adjustValueY,0);

	    callAccept = new Picture("call Accept");
	    callAccept.setWidth(91*super.adjustValueX);
	    callAccept.setHeight(66*super.adjustValueY);
	    callAccept.setPosition(735*super.adjustValueX, 190*super.adjustValueY);
	    callAccept.setImage(sim.getAssetManager(), "Textures/icons/calling/call_accept.png", true);

	    callReject = new Picture("call Reject");
	    callReject.setWidth(91*super.adjustValueX);
	    callReject.setHeight(66*super.adjustValueY);
	    callReject.setPosition(885, 190*super.adjustValueY);
	    callReject.setImage(sim.getAssetManager(), "Textures/icons/calling/call_reject.png", true);

	    callEnd = new Picture("call End");
	    callEnd.setWidth(58*super.adjustValueX);
	    callEnd.setHeight(78*super.adjustValueX);
	    callEnd.setPosition(810*super.adjustValueX, 190*super.adjustValueY);
	    callEnd.setImage(sim.getAssetManager(), "Textures/icons/calling/call_stop.png", true);
	}
	
	@Override
	public void update(AppModel appModel) {
		CallModel callModel = (CallModel)appModel;
		
		Node callNode = super.getNode();
		callNode.detachAllChildren();
		
		callText.setText(callModel.getSender());
		callNode.attachChild(callText);
		
		if(callModel.getCallState() == 0){
			callNode.attachChild(callAccept);
			callNode.attachChild(callReject);
			return;
		}
		
		callNode.attachChild(callEnd);
	}

}
