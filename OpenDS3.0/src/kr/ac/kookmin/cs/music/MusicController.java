package kr.ac.kookmin.cs.music;

import kr.ac.kookmin.cs.basic.AppController;
import kr.ac.kookmin.cs.hud.event.ActionEvent;
import kr.ac.kookmin.cs.hud.event.CallbackEvent;
import kr.ac.kookmin.cs.hud.event.InterruptEvent;
import kr.ac.kookmin.cs.hud.event.KeyEvent;

public class MusicController extends AppController {
	private MusicModel musicModel;
	private MusicView musicView;

	public MusicController(MusicModel musicModel, MusicView musicView) {
		super("MusicController");
		this.musicModel = musicModel;
		this.musicView = musicView;
		musicView.update(musicModel);
	}

	@Override
	protected void actionEventHendler(ActionEvent ev) {
		switch(ev.getActionName()){
		case "StateTransition":
			musicModel.chageState();
			musicModel.getController().eventHendler(ev);;
			break;
		}
		musicView.update(musicModel);
	}

	@Override
	protected void keyEventHendler(KeyEvent ev) {
		musicModel.getController().eventHendler(ev);
	}

	@Override
	protected void pause() {
		musicModel.getPlayerController().eventHendler(new InterruptEvent(controllerName));
	}

	@Override
	protected void resume() {
		musicModel.getPlayerController().eventHendler(new CallbackEvent(controllerName));
	}

}
