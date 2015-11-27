package kr.ac.kookmin.cs.music;

import kr.ac.kookmin.cs.basic.AppController;
import kr.ac.kookmin.cs.hud.HUDController;
import kr.ac.kookmin.cs.hud.event.ActionEvent;
import kr.ac.kookmin.cs.hud.event.KeyEvent;

public class MusicPlayerController extends AppController {
	private MusicPlayer musicPlayer;
	private MusicPlayerView musicPlayerView;
	public MusicPlayerController(MusicPlayer musicPlayer, MusicPlayerView musicPlayerView) {
		super("MusicPlayerController");
		this.musicPlayer = musicPlayer;
		this.musicPlayerView = musicPlayerView;
	}

	@Override
	protected void actionEventHendler(ActionEvent ev) {
		switch(ev.getActionName()){
		case "StateTransition":
			MusicActionEvent mev = (MusicActionEvent) ev;
			musicPlayer.setList(mev.getDirectoryList(), mev.getMp3FileList(), mev.getIndexMp3File());
			break;
		}
	}

	@Override
	protected void keyEventHendler(KeyEvent ev) {
		switch(ev.getKey()){
		case "Left":
			musicPlayer.previous();
			break;
		case "Right":
			musicPlayer.next();
			break;
		case "Push":
			if(musicPlayer.isPlaying()){
				musicPlayer.pause();
				break;
			}
			musicPlayer.resume();
			break;
		case "Down":
			HUDController.getInstance().eventHandler(new ActionEvent("Escape", controllerName));
			break;
		case "Up":
			MusicActionEvent mev = new MusicActionEvent("StateTransition", musicPlayer.getDirectoryList(), musicPlayer.getMp3List(), musicPlayer.getMp3Index());
			HUDController.getInstance().eventHandler(mev);
			break;
		}
		musicPlayerView.update(musicPlayer);
	}

	@Override
	protected void pause() {
		if(musicPlayer.isPlaying())
			musicPlayer.pause();
	}

	@Override
	protected void resume() {
		if(musicPlayer.isPaused())
			musicPlayer.resume();
	}

	public void changeMusicName() {
		musicPlayerView.update(musicPlayer);
	}

}
