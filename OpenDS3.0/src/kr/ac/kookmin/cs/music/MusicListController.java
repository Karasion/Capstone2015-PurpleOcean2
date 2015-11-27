package kr.ac.kookmin.cs.music;

import kr.ac.kookmin.cs.basic.AppController;
import kr.ac.kookmin.cs.hud.HUDController;
import kr.ac.kookmin.cs.hud.event.ActionEvent;
import kr.ac.kookmin.cs.hud.event.KeyEvent;

public class MusicListController extends AppController {
	private MusicList musicList;
	private MusicListView musicListView;
	
	public MusicListController(MusicList musicList, MusicListView musicListView) {
		super("MusicListController");
		this.musicList = musicList;
		this.musicListView = musicListView;
		musicListView.update(musicList);
	}

	@Override
	protected void actionEventHendler(ActionEvent ev) {
		switch(ev.getActionName()){
		case "StateTransition":
			MusicActionEvent mev = (MusicActionEvent) ev;
			musicList.setList(mev.getDirectoryList(), mev.getMp3FileList(), mev.getIndexMp3File());
			break;
		}
		musicListView.update(musicList);
	}

	@Override
	protected void keyEventHendler(KeyEvent ev) {
		switch(ev.getKey()){
		case "Left" :
			MusicActionEvent mev = new MusicActionEvent("StateTransition", musicList.getDrectoryList(), musicList.getMp3FileList(), musicList.getIndex());
			HUDController.getInstance().eventHandler(mev);
			break;
		case "Right" :
			HUDController.getInstance().eventHandler(new ActionEvent("Escape", controllerName));
			break;
		case "Up" :
			musicList.movePrevious();
			break;
		case "Down" :
			musicList.moveNext();
			break;
		case "Push" :
			musicList.select();
			break;
		}
		musicListView.update(musicList);
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
