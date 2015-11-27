package kr.ac.kookmin.cs.sms;

import kr.ac.kookmin.cs.basic.AppController;
import kr.ac.kookmin.cs.hud.HUDController;
import kr.ac.kookmin.cs.hud.event.ActionEvent;
import kr.ac.kookmin.cs.hud.event.KeyEvent;
import eu.opends.main.Simulator;

public class SMSController extends AppController{
	private SMSView smsView;
	private SMSModel smsModel;
	
	public SMSController(SMSModel smsModel, SMSView smsView){
		super("SMSController");
		this.smsModel = smsModel;
		this.smsView = smsView;
	}
	
	@Override
	protected void actionEventHendler(ActionEvent ev) {
		switch(ev.getActionName()){
		case "SMSRecive":
			SMSActionEvent smsEvent = (SMSActionEvent)ev;
			smsModel.addMsg(smsEvent.getMSGText(), smsEvent.getSender());
			break;
		}
		smsView.update(smsModel);
		smsView.setNewMSG();
	}
	
	@Override
	protected void keyEventHendler(KeyEvent ev) {
		switch(ev.getKey()){
		case "Right":
			smsModel.rightMsg();
			break;
		case "Left":
			smsModel.leftMsg();
			break;
		case "Push":
			System.out.println("smsPush");
			HUDController hudCon = HUDController.getInstance();
			hudCon.eventHandler(new ActionEvent("Escape", "HUDController"));
			break;
		default :
			break;
		}
		smsView.update(smsModel);
	}

	@Override
	protected void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void resume() {
		// TODO Auto-generated method stub
		
	}
}