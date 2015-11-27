package kr.ac.kookmin.cs.music;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import kr.ac.kookmin.cs.basic.AppModel;
import kr.ac.kookmin.cs.hud.HUDController;

public class MusicList implements AppModel {
	private Path currentDir;
	private ArrayList<Path> directoryList = new ArrayList<Path>();
	private ArrayList<Path> mp3FileList = new ArrayList<Path>();
	private int index = 0;
	
	public MusicList(){
		currentDir = Paths.get("assets/Music");
		try {
			currentDir = currentDir.toRealPath(LinkOption.NOFOLLOW_LINKS);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setDirectoryList();
		setMp3FileList();
	}
	
	public ArrayList<Path> getDrectoryList(){
		return directoryList;
	}
	
	public ArrayList<Path> getMp3FileList(){
		return mp3FileList;
	}
	
	public void chageDirectory(Path dir){
		currentDir = dir;
		setDirectoryList();
		setMp3FileList();
	}
	
	private void setDirectoryList(){
		DirectoryStream<Path> dir = null;
		directoryList.clear();
		try {
			dir = Files.newDirectoryStream(currentDir, new DirectoryStream.Filter<Path>() {
			@Override
			public boolean accept(Path entry) throws IOException {
				return Files.isDirectory(entry);
			}
		});
			for(Path file:dir){
//				System.out.println(file.getFileName());
				directoryList.add(file);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void setMp3FileList(){
		DirectoryStream<Path> dir = null;
		mp3FileList.clear();
		try {
			dir = Files.newDirectoryStream(currentDir, "*.mp3");
			for(Path file:dir){
//				System.out.println(file.getFileName());
				mp3FileList.add(file);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void moveNext(){
		if(++index <= directoryList.size() + mp3FileList.size()-1)
			return;
		index = 0;
	}
	
	public void movePrevious(){
		if(--index >= 0)
			return;
		index = directoryList.size() + mp3FileList.size()-1;
	}
	
	public int getIndex(){
		return index;
	}

	public void select() {
		if(index > directoryList.size()-1){
			MusicActionEvent mev = new MusicActionEvent("StateTransition", directoryList, mp3FileList, index);
			HUDController.getInstance().eventHandler(mev);
			return;
		}
		chageDirectory(directoryList.get(index));
	}

	public void setList(ArrayList<Path> directoryList, ArrayList<Path> mp3FileList, int index) {
		this.directoryList = directoryList;
		this.mp3FileList = mp3FileList;
		this.index = index;
	}
}
