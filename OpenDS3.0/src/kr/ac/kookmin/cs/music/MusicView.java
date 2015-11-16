/**
 * @file MusicHud.java
 * @brief This file is associated with a MusicPlayer
 * @details This file is composed of MusicHud class.
 */

package kr.ac.kookmin.cs.music;


import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import javazoom.jl.decoder.JavaLayerException;
import kr.ac.kookmin.cs.hud.HUDClassTemplate;
import kr.ac.kookmin.cs.hud.HUDManagement;

import com.jme3.font.BitmapFont;
import com.jme3.font.BitmapText;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Node;
import com.jme3.ui.Picture;

import eu.opends.basics.SimulationBasics;
import eu.opends.main.Simulator;

/**
 * @brief This class serves to output information related to the MusicPlayer to HUD
 * @details This class is the simulator , if the user performs a musicplayer function ,
 *          is output information related to the musicplayer to the appropriate position of HUD.
 * @author Lee-MinJae , Jo-KwangHyeon
 */
public class MusicView extends HUDClassTemplate{
	private static SimulationBasics sim;
	private static int hud_state;

	private final int LIST = 0;
	private final int PLAYER = 1;

	private int musicStatus;

	private MusicList list;
	private MP3Player player;

	private int musicListIndex = 0;
	private ArrayList<Path> musicList = new ArrayList<Path>();
	private int mp3FileListIndex = 0;
	private ArrayList<Path> mp3FileList = new ArrayList<Path>();

	/**
	 * GUI
	 */
	private Node musicPanel;
	private Node musicListNode;
	private Node musicPlayerNode;

	private BitmapFont font;

	// element for music player
	private Picture musicCursor;
	private Picture previousIcon;
	private Picture nextIcon;
	private Picture playIcon;
	private Picture pauseIcon;
	private Picture musicEquilizer;
	private BitmapText musicName;

	// element for music panel
	private Picture musicBackground;

	// element for music list
	private BitmapText[] musicListText = new BitmapText[5];
	private Picture musicHighlight;
	private int musicCursorPosX;
	private int musicCursorIndex = 0;
	private int[] musicCursorPosY = new int[5];

	private int x,y;

	private Picture icon_en, icon_dis;

	/**
	 * @brief To initialize the MusicPlayer to HUD.
	 * @details To initialize the position and size of the required icon and list	
	 * @param param a Simulator argument
	 * return Nothing
	 */
	public void init(Simulator simulator)
	{
		sim = simulator;
		musicPanel = new Node("Music Panel");
		musicListNode = new Node("Music List");
		musicPlayerNode = new Node("Music Player");

		font = sim.getAssetManager().loadFont("Interface/Fonts/MSNeoGothic/MSNeoGothic.fnt");

		x=sim.getSettings().getWidth()/2;
		y=sim.getSettings().getHeight()/2-200;

		// element for music player    
		musicBackground = new Picture("musicBackground");
		musicBackground.setImage(sim.getAssetManager(), "Textures/icons/music/directory_listbox.png", true);
		musicBackground.setWidth(322);
		musicBackground.setHeight(160);
		musicBackground.setPosition(690, 158);

		musicPanel.attachChild(musicBackground);
		musicStatus = LIST;

		initMusicList();
		initMusicPlayer();

		/* menu icon initialization */
		icon_en = new Picture("musicIcon_en");
		icon_en.setImage(sim.getAssetManager(), "Textures/icons/menubar/menubar_music.png", true);
		icon_en.setWidth(80);
		icon_en.setHeight(80);

		icon_dis = new Picture("musicIcon_dis");
		icon_dis.setImage(sim.getAssetManager(), "Textures/icons/menubar/menubar_music_c.png", true);
		icon_dis.setWidth(80);
		icon_dis.setHeight(80);

		HUDManagement.setMenuIcon(icon_en, icon_dis, hud_state);
	}

	private void initMusicList()
	{
		list = new MusicList();
		musicList.addAll(list.getDrectoryList());
		mp3FileList.addAll(list.getMp3FileList());
		musicList.addAll(mp3FileList);
		
		for(int i = 0; i < 5; i++){
			musicListText[i] = new BitmapText(font,false);
			musicListText[i].setName("music list");
			musicListText[i].setText("");
			musicListText[i].setSize(font.getCharSet().getRenderedSize());
			musicListText[i].setColor(ColorRGBA.White);
			musicListText[i].setLocalTranslation(x-250,y-20-(32*i),0);
			
			if(i < musicList.size())
				musicListText[i].setText(musicList.get(i).getFileName().toString());
			
			musicCursorPosY[i] = y-43-(32*i);
		}
		
		musicCursorPosX = x - 283;

		musicCursor = new Picture("musicCursor");
		musicCursor.setImage(sim.getAssetManager(), "Textures/icons/music/musicplayer_arrow.png", true);
		musicCursor.setWidth(10);
		musicCursor.setHeight(11);
		musicCursor.setPosition(musicCursorPosX, musicCursorPosY[0]);

		musicHighlight = new Picture("musicHighlight");
		musicHighlight.setImage(sim.getAssetManager(), "Textures/icons/music/directory_highlight.png", true);
		musicHighlight.setWidth(322);
		musicHighlight.setHeight(29);
		musicHighlight.setPosition(690, 288);

		musicListNode.attachChild(musicListText[0]);
		musicListNode.attachChild(musicListText[1]);
		musicListNode.attachChild(musicListText[2]);
		musicListNode.attachChild(musicListText[3]);
		musicListNode.attachChild(musicListText[4]);
		musicListNode.attachChild(musicCursor);
		musicListNode.attachChild(musicHighlight);
	}

	private void initMusicPlayer()
	{
		player = new MP3Player(this);
		
		musicName = new BitmapText(font,false);
		musicName.setName("music name");
		musicName.setText("");
		musicName.setSize(font.getCharSet().getRenderedSize());
		musicName.setLocalTranslation(x-210, y-30, 0);

		previousIcon = new Picture("previous");
		previousIcon.setImage(sim.getAssetManager(), "Textures/icons/music/musicplayer_backSkip.png", true);
		previousIcon.setWidth(46);
		previousIcon.setHeight(46);
		previousIcon.setPosition(x-225, y-180);

		playIcon = new Picture("play");
		playIcon.setImage(sim.getAssetManager(), "Textures/icons/music/musicplayer_play.png", true);
		playIcon.setWidth(64);
		playIcon.setHeight(64);
		playIcon.setPosition(x-155, y-190);

		pauseIcon = new Picture("pause");
		pauseIcon.setImage(sim.getAssetManager(), "Textures/icons/music/musicplayer_pause.png", true);
		pauseIcon.setWidth(64);
		pauseIcon.setHeight(64);
		pauseIcon.setPosition(x-155, y-190);

		nextIcon = new Picture("next");
		nextIcon.setImage(sim.getAssetManager(), "Textures/icons/music/musicplayer_nextSkip.png", true);
		nextIcon.setWidth(46);
		nextIcon.setHeight(46);
		nextIcon.setPosition(x-65,y-180);

		musicEquilizer = new Picture("music equilizer");
		musicEquilizer.setImage(sim.getAssetManager(), "Textures/icons/music/equlizer_arrow_merged.png", true);
		musicEquilizer.setWidth(307);
		musicEquilizer.setHeight(72);
		musicEquilizer.setPosition(690,226);

		musicPlayerNode.attachChild(musicName);
		musicPlayerNode.attachChild(previousIcon);
		musicPlayerNode.attachChild(pauseIcon);
		musicPlayerNode.attachChild(nextIcon);
		musicPlayerNode.attachChild(musicEquilizer);
	}

	/**
	 * @brief This class , to update the HUD MusicPlayer.
	 * @details This method , in a state where the music is selected , 
	 * the name of the music that was selected for musicName, and outputs the musicList while selecting the music
	 * @return nothing
	 */
	public void update()
	{

	}
	/**
	 * @brief This method , Attach the node associated with the MusicPlayer to simulator
	 * @param nothing
	 * @return nothing
	 */
	public void attach()
	{
		musicPlayerAttach();
		HUDManagement.attach(musicPanel);
	}
	/**
	 * @brief This method , Detach the node associated with the MusicPlayer to simulator
	 * @param nothing
	 * @return nothing
	 */
	public void detach()
	{
		HUDManagement.detach(musicPanel);
	}

	/**
	 * @brief This method , Detach the node associated with the MusicPlayer to simulator
	 * @param nothing
	 * @return nothing
	 */
	public static void regist()
	{
		MusicView music = new MusicView();
		hud_state = HUDManagement.regist(music);
	}
	public void pause()
	{
//		if(player.isPlaying())
//			player.pause();
	}
	public void resume()
	{
//		if(player.isPaused())
//			player.resume();
	}
	public void key_act_push()
	{
		if(musicStatus == LIST){
			selectList();
			return;
		}
		if(musicStatus == PLAYER){
			if(player.isPlaying()){
				player.pause();
				musicPlayerNode.detachChild(pauseIcon);
				musicPlayerNode.attachChild(playIcon);
				return;
			}
			player.resume();
			musicPlayerNode.detachChild(playIcon);
			musicPlayerNode.attachChild(pauseIcon);
			return;
		}
	}
	public void key_act_right()
	{
		if(musicStatus == LIST){
			HUDManagement.escapeMenu();
		}
		if(musicStatus == PLAYER){
			player.next();
		}
	}
	public void key_act_left()
	{
		if(musicStatus == LIST){
			musicStatusChange(PLAYER);
		}
		if(musicStatus == PLAYER){
			player.previous();
		}
	}
	public void key_act_down()
	{
		if(musicStatus == LIST){
			downMusicCursor();
		}
		if(musicStatus == PLAYER){
			HUDManagement.escapeMenu();
		}
	}
	public void key_act_up()
	{
		if(musicStatus == LIST){
			upMusicCursor();
		}
		if(musicStatus == PLAYER){
			musicStatusChange(LIST);
		}
	}
	/**
	 * @brief This method is an operation when the music is selected by the HUD
	 * @param nothing
	 * @return nothing
	 * @exception InterruptedException
	 */
	public void selectList()
	{
		Path path = musicList.get(musicListIndex);
		Path pathName;
		if(Files.isDirectory(path)){
//			System.out.println(path);
			list.chageDirectory(path);
			resetList();
			return;
		}
		if(player.isPaused() || player.isPlaying()){
			player.stop();
		}
		try {
			mp3FileList.clear();
			mp3FileList.addAll(list.getMp3FileList());
			mp3FileListIndex = musicListIndex - (musicList.size()-mp3FileList.size()) + 1;
			musicStatusChange(PLAYER);
			
			pathName = path.getFileName();
			musicName.setText(pathName.toString());
			
			player.setPath(path);
			player.play();
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void resetList()
	{
		musicList.clear();
		musicList.addAll(list.getDrectoryList());
		musicList.addAll(list.getMp3FileList());
		for(Path p:musicList){
			System.out.println(p.toString());
		}
		musicListIndex = 0;
		musicCursorIndex = 0;
		changeMusicList();
	}

	/**
	 * @brief This method , move to music cursor
	 * @param nothing
	 * @return nothing
	 */
	private void downMusicCursor()
	{
		if(musicListIndex == musicList.size()-1)
			return;
		musicListIndex++;
		musicCursorIndex++;
		if(musicCursorIndex > 5){
			musicCursorIndex = 0;
			changeMusicList();
		}
		musicHighlight.setPosition(690, 288-(32*musicCursorIndex));
		musicCursor.setPosition(musicCursorPosX, musicCursorPosY[musicCursorIndex]);
	}
	
	private void upMusicCursor()
	{
		if(musicListIndex == 0)
			return;
		musicListIndex--;
		musicCursorIndex--;
		if(musicCursorIndex < 0){
			musicCursorIndex = 4;
			changeMusicList();
		}
		musicHighlight.setPosition(690, 288-(32*musicCursorIndex));
		musicCursor.setPosition(musicCursorPosX, musicCursorPosY[musicCursorIndex]);
	}
	
	private void changeMusicList(){
		Path path;
		for(int i = musicListIndex; i < 5; i++){
			if(i >= musicList.size()){
				musicListText[i].setText("");
				continue;
			}
			path = musicList.get(i);
			path = path.getFileName();
			musicListText[i].setText(path.toString());
		}
	}

	/**
	 * @brief This method , attach the music list and music title
	 * @details Music playing : attach the music title 
			 Music stopped : attach a list of music
	 * @param nothing
	 * @return nothing
	 */
	private void musicPlayerAttach()
	{
		musicPanel.detachAllChildren();
		musicPanel.attachChild(musicBackground);
		if(player.isPlaying() || player.isPaused()){
			musicPanel.attachChild(musicPlayerNode);
			musicStatus = PLAYER;
		}
		else{
			musicPanel.attachChild(musicListNode);
			musicStatus = LIST;
		}
	}
	
	private void musicStatusChange(int status)
	{
		musicStatus = status;
		if(status == PLAYER){
			musicPanel.detachChild(musicListNode);
			musicPanel.attachChild(musicPlayerNode);
		}
		if(status == LIST){
			musicPanel.detachChild(musicPlayerNode);
			musicPanel.attachChild(musicListNode);
		}
	}

	public Path getNextMp3() {
		Path path;
		Path pathName;
		mp3FileListIndex++;
		if(mp3FileListIndex >= mp3FileList.size())
			mp3FileListIndex = 0;
//		System.out.println("Index : " + mp3FileListIndex);
		path = mp3FileList.get(mp3FileListIndex);
		pathName = path.getFileName();
		musicName.setText(pathName.toString());
		return path;
	}

	public Path getPreviousMp3() {
		Path path;
		Path pathName;
		mp3FileListIndex--;
		if(mp3FileListIndex <= 0)
			mp3FileListIndex = mp3FileList.size()-1;
//		System.out.println(mp3FileListIndex);
		path = mp3FileList.get(mp3FileListIndex);
		pathName = path.getFileName();
		musicName.setText(pathName.toString());
		return path;
	}
}
