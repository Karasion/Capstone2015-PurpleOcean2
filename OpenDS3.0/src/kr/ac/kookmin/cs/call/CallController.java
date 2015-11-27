package kr.ac.kookmin.cs.call;

import kr.ac.kookmin.cs.basic.AppController;
import kr.ac.kookmin.cs.hud.HUDController;
import kr.ac.kookmin.cs.hud.event.ActionEvent;
import kr.ac.kookmin.cs.hud.event.CallbackEvent;
import kr.ac.kookmin.cs.hud.event.InterruptEvent;
import kr.ac.kookmin.cs.hud.event.KeyEvent;

public class CallController extends AppController {
	private CallView callView;
	private CallModel callModel;

	public CallController(CallModel callModel, CallView callView) {
		super("CallController");
		this.callModel = callModel;
		this.callView = callView;
	}

	@Override
	protected void actionEventHendler(ActionEvent ev) {
		switch(ev.getActionName()){
		case "OnCall":
			callModel.setCallState(1);
			break;
		case "EndCall":
			callModel.setEnd();
			HUDController.getInstance().eventHandler(new CallbackEvent(controllerName));
			break;
		case "RecieveCall":
			CallActionEvent callEvent = (CallActionEvent) ev;
			callModel.setSender(callEvent.getSener());
			HUDController.getInstance().eventHandler(new InterruptEvent(controllerName));
			break;
		}
		callView.update(callModel);
	}

	@Override
	protected void keyEventHendler(KeyEvent ev) {
		switch(ev.getKey()){
		case "Right":
			if(callModel.getCallState() == 0)
				callModel.endCall();
			break;
		case "Left":
			if(callModel.getCallState() == 0)
				callModel.onCall();
			break;
		case "Push":
			if(callModel.getCallState() == 1)
				callModel.endCall();
			break;
		default :
			break;
		}
		callView.update(callModel);
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
