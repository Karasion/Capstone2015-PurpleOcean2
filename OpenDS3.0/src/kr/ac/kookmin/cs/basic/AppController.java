package kr.ac.kookmin.cs.basic;

import kr.ac.kookmin.cs.hud.event.*;

public abstract class AppController {
	protected String controllerName;
	
	public AppController(String controllerName)
	{
		this.controllerName = controllerName;
	}
	
	public final void eventHendler(Event ev)
	{
		if(ev instanceof KeyEvent){
			keyEventHendler((KeyEvent) ev);
		}else if(ev instanceof ActionEvent){
			actionEventHendler((ActionEvent) ev);
		}else if(ev instanceof InterruptEvent){
			pause();
		}else if(ev instanceof CallbackEvent){
			resume();
		}else{
			System.out.println(controllerName + " : EvnetHendling is fail");
		}
	}
	
	public String getControllerName()
	{
		return controllerName;
	}
	
	protected abstract void actionEventHendler(ActionEvent ev);
	protected abstract void keyEventHendler(KeyEvent ev);
	protected abstract void pause();
	protected abstract void resume();
}
