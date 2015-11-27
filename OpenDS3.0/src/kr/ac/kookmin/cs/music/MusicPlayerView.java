package kr.ac.kookmin.cs.music;

import com.jme3.font.BitmapFont;
import com.jme3.font.BitmapText;
import com.jme3.ui.Picture;

import eu.opends.main.Simulator;
import kr.ac.kookmin.cs.basic.AppModel;
import kr.ac.kookmin.cs.basic.AppView;

public class MusicPlayerView extends AppView {
	
	// element for music player
	private Picture previousIcon;
	private Picture nextIcon;
	private Picture playIcon;
	private Picture pauseIcon;
	private Picture musicEquilizer;
	private BitmapText musicName;
	
	private BitmapFont font;

	public MusicPlayerView(Simulator sim) {
		super("MusicPlayerView", sim);
		
		font = sim.getAssetManager().loadFont("Interface/Fonts/MSNeoGothic/MSNeoGothic.fnt");
		musicName = new BitmapText(font,false);
		musicName.setName("music name");
		musicName.setText("");
		musicName.setSize(font.getCharSet().getRenderedSize());
		musicName.setLocalTranslation(750, 310, 0);

		previousIcon = new Picture("previous");
		previousIcon.setImage(sim.getAssetManager(), "Textures/icons/music/musicplayer_backSkip.png", true);
		previousIcon.setWidth(46);
		previousIcon.setHeight(46);
		previousIcon.setPosition(735, 160);

		playIcon = new Picture("play");
		playIcon.setImage(sim.getAssetManager(), "Textures/icons/music/musicplayer_play.png", true);
		playIcon.setWidth(64);
		playIcon.setHeight(64);
		playIcon.setPosition(805, 150);

		pauseIcon = new Picture("pause");
		pauseIcon.setImage(sim.getAssetManager(), "Textures/icons/music/musicplayer_pause.png", true);
		pauseIcon.setWidth(64);
		pauseIcon.setHeight(64);
		pauseIcon.setPosition(805, 150);

		nextIcon = new Picture("next");
		nextIcon.setImage(sim.getAssetManager(), "Textures/icons/music/musicplayer_nextSkip.png", true);
		nextIcon.setWidth(46);
		nextIcon.setHeight(46);
		nextIcon.setPosition(895,160);

		musicEquilizer = new Picture("music equilizer");
		musicEquilizer.setImage(sim.getAssetManager(), "Textures/icons/music/equlizer_arrow_merged.png", true);
		musicEquilizer.setWidth(307);
		musicEquilizer.setHeight(72);
		musicEquilizer.setPosition(690,226);
		
		getNode().attachChild(musicName);
		getNode().attachChild(nextIcon);
		getNode().attachChild(previousIcon);
		getNode().attachChild(musicEquilizer);
		getNode().attachChild(playIcon);
	}
	
	@Override
	public void update(AppModel appModel) {
		MusicPlayer musicPlayer = (MusicPlayer) appModel;
		
		musicName.setText(musicPlayer.getMusicName());
		
		if(musicPlayer.isPlaying()){
			getNode().detachChild(playIcon);
			getNode().attachChild(pauseIcon);
		}
		else{
			getNode().detachChild(pauseIcon);
			getNode().attachChild(playIcon);
		}
			
	}
}
