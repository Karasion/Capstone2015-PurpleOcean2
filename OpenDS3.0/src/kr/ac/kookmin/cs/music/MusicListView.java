package kr.ac.kookmin.cs.music;

import java.nio.file.Path;
import java.util.ArrayList;

import com.jme3.font.BitmapFont;
import com.jme3.font.BitmapText;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.Node;
import com.jme3.ui.Picture;

import eu.opends.main.Simulator;
import kr.ac.kookmin.cs.basic.AppModel;
import kr.ac.kookmin.cs.basic.AppView;

public class MusicListView extends AppView {

	private BitmapFont font;
	

	private Picture musicBackground;
	private Picture musicCursor;
	// element for music list
	private BitmapText[] musicListText = new BitmapText[5];
	private Picture musicHighlight;
	private int musicCursorPosX;
	private int musicCursorIndex = 0;
	private int[] musicCursorPosY = new int[5];
	
	public MusicListView(Simulator sim) {
		super("MusicListView", sim);
		font = sim.getAssetManager().loadFont("Interface/Fonts/MSNeoGothic/MSNeoGothic.fnt");
		for(int i = 0; i < 5; i++){
			musicListText[i] = new BitmapText(font,false);
			musicListText[i].setName("music list");
			musicListText[i].setText("");
			musicListText[i].setSize(font.getCharSet().getRenderedSize());
			musicListText[i].setColor(ColorRGBA.White);
			musicListText[i].setLocalTranslation(730,320-(32*i),0);

			musicCursorPosY[i] = 320-(32*i);
			getNode().attachChild(musicListText[i]);
		}

		musicCursorPosX = 742;
		
		musicBackground = new Picture("musicBackground");
		musicBackground.setImage(super.getAssetManager(), "Textures/icons/music/directory_listbox.png", true);
		musicBackground.setWidth(322*super.adjustValueX);
		musicBackground.setHeight(160*super.adjustValueY);
		musicBackground.setPosition(690*super.adjustValueX, 158*super.adjustValueY);

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
		
		getNode().attachChild(musicHighlight);
		getNode().attachChild(musicCursor);
		getNode().attachChild(musicBackground);
	}

	@Override
	public void update(AppModel appModel) {
		MusicList musicList = (MusicList) appModel;
		int index = musicList.getIndex();
		int start = index/5;
		int cursorPos = index%5;
		ArrayList<Path> list = new ArrayList<Path>();
		list.addAll(musicList.getDrectoryList());
		list.addAll(musicList.getMp3FileList());
		
		for(int i = 0; i < 5; i++){
			if(start*5 + i > list.size()-1){
				musicListText[i].setText("");
				continue;
			}
			musicListText[i].setText(list.get(start*5+i).toString());
		}
		musicCursor.setPosition(musicCursorPosX, musicCursorPosY[cursorPos]);
		musicHighlight.setPosition(690, 288-(32*cursorPos));
	}
}
