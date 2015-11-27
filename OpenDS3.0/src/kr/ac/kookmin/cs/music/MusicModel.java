package kr.ac.kookmin.cs.music;

import com.jme3.scene.Spatial;

import kr.ac.kookmin.cs.basic.AppController;
import kr.ac.kookmin.cs.basic.AppModel;

public class MusicModel implements AppModel{
	private final int LIST = 0;
	private final int PLAYER = 1;
	private int state;
	
	private MusicPlayerView musicPlayerView;
	private MusicListView musicListView;
	private MusicPlayerController musicPlayerController;
	private MusicListController musicListController;
	
	public MusicModel(MusicPlayerView musicPlayerView, MusicPlayerController musicPlayerController, MusicListView musicListView, MusicListController musicListController){
		state = LIST;
		this.musicPlayerView = musicPlayerView;
		this.musicPlayerController = musicPlayerController;
		this.musicListView = musicListView;
		this.musicListController = musicListController;		
	}
	
	public int getState() {
		return state; 
	}
	
	public void chageState() {
		if(state == LIST)
			state = PLAYER;
		else
			state = LIST;
	}
	
	public AppController getController() {
		if(state == LIST)
			return musicListController;
		else
			return musicPlayerController;
	}
	
	public AppController getPlayerController(){
		return musicPlayerController;
	}

	public Spatial getNode() {
		if(state == LIST)
			return musicListView.getNode();
		return musicPlayerView.getNode();
	}
}