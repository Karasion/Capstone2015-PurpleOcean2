package kr.ac.kookmin.cs.BSA;

import com.jme3.asset.AssetManager;
import com.jme3.scene.Node;
import com.jme3.ui.Picture;

import eu.opends.main.Simulator;

public class BSAView{
	private BSAModel bsaModel;
	private AssetManager assetManager;
	private Node bsaNode = new Node("BSA Node");

	private Picture bsaScreen;
	private float adjustValueX, adjustValueY;

	public BSAView(Simulator sim, BSAModel bsaModel)
	{
		this.bsaModel = bsaModel;
		assetManager = sim.getAssetManager();
		adjustValueX = (float)sim.getSettings().getWidth() / 1920;
		adjustValueY = (float)sim.getSettings().getHeight() / 1080;
		System.out.println("adjustValueX:" + adjustValueX + ", adjustValueY:" + adjustValueY);

		bsaScreen = new Picture("BSA Screen");
		bsaScreen.setImage(assetManager, "Textures/icons/alert/alert_safe.png", true);
		bsaScreen.setWidth(231 * adjustValueX);
		bsaScreen.setHeight(219 * adjustValueY);
		bsaScreen.setPosition(1050 * adjustValueX ,140 * adjustValueY);

		bsaNode.attachChild(bsaScreen);
	}
	public Node getNode() { return bsaNode; }

	public void update()
	{
		switch(bsaModel.getAlertType())
		{
		case "back":
			bsaScreen.setImage(assetManager, "Textures/icons/alert/alert_backside.png", true);
			break;
		case "left":
			bsaScreen.setImage(assetManager, "Textures/icons/alert/alert_leftside.png", true);
			break;
		case "right":
			bsaScreen.setImage(assetManager, "Textures/icons/alert/alert_rightside.png", true);
			break;
		case "safe":
			bsaScreen.setImage(assetManager, "Textures/icons/alert/alert_safe.png", true);
			break;       
		}
	}
}
