package kr.ac.kookmin.cs.call;

import kr.ac.kookmin.cs.basic.AppModel;
import kr.ac.kookmin.cs.bluetooth.ProcessConnectionThread;

public class CallModel implements AppModel {
	private int call_state = 0;
	private String sender;

	public int getCallState(){
		return call_state;
	}

	public void setCallState(int state){
		call_state = state;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public void setEnd(){
		call_state = 0;
	}

	public void endCall(){
		ProcessConnectionThread.sendData("endCall");
		call_state = 0;
		sender = null;
	}

	public void onCall(){
		ProcessConnectionThread.sendData("onCall");
		call_state = 1;
	}
}
