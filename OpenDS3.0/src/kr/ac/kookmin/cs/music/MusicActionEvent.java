package kr.ac.kookmin.cs.music;

import java.nio.file.Path;
import java.util.ArrayList;

import kr.ac.kookmin.cs.hud.event.ActionEvent;

public class MusicActionEvent extends ActionEvent {
	private ArrayList<Path> directoryList;
	private ArrayList<Path> mp3FileList;
	private int indexMp3File;
	public MusicActionEvent(String actionName) {
		super(actionName, "MusicController");
	}
	
	public MusicActionEvent(String actionName, ArrayList<Path> directoryList, ArrayList<Path> mp3FileList, int indexMp3File) {
		super(actionName, "MusicController");
		this.directoryList = directoryList;
		this.mp3FileList = mp3FileList;
		this.indexMp3File = indexMp3File;
	}
	
	public ArrayList<Path> getMp3FileList(){
		return mp3FileList;
	}
	
	public int getIndexMp3File(){
		return indexMp3File;
	}

	public ArrayList<Path> getDirectoryList() {
		return directoryList;
	}
}
