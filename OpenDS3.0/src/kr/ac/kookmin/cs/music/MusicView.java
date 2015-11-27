package kr.ac.kookmin.cs.music;

import com.jme3.asset.AssetManager;
import com.jme3.font.BitmapText;
import com.jme3.scene.Node;
import com.jme3.ui.Picture;

import eu.opends.main.Simulator;
import kr.ac.kookmin.cs.basic.AppModel;
import kr.ac.kookmin.cs.basic.AppView;

public class MusicView extends AppView {

	public MusicView(Simulator sim) {
		super("MusicView", sim);
		super.setEnableIcon("MusicIcon_en", "Textures/icons/menubar/menubar_music.png", 80, 80);
		super.setDisableIcon("MusicIcon_dis", "Textures/icons/menubar/menubar_music_c.png", 80, 80);
		
		/* menu icon initialization */
		super.setEnableIcon("musicIcon_en", "Textures/icons/menubar/menubar_music.png", 80, 80);
		super.setDisableIcon("musicIcon_dis", "Textures/icons/menubar/menubar_music_c.png", 80, 80);
		
		
	}
	@Override
	public void update(AppModel appModel) {	
		MusicModel musicModel = (MusicModel) appModel;
		getNode().detachAllChildren();
		getNode().attachChild(musicModel.getNode());
	}	
}
