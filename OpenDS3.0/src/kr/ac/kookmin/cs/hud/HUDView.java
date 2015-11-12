package kr.ac.kookmin.cs.hud;

import com.jme3.scene.Node;
import com.jme3.ui.Picture;

import eu.opends.main.Simulator;

public class HUDView {
	private Simulator sim;
	private Node hud;
	
	public HUDView(Simulator sim)
	{
		Picture backGround;
		float adjustValueX = sim.getSettings().getWidth()/1920;
		float adjustValueY = sim.getSettings().getHeight()/1080;
		this.sim = sim;
		hud = new Node("hud");
		backGround = new Picture("bg");
	    backGround.setWidth(841);
	    backGround.setHeight(338);
	    backGround.setPosition(580*adjustValueX, 30*adjustValueY);
	    backGround.setImage(sim.getAssetManager(), "Textures/icons/panel/panel.png", true);
	}
	
	public Node getHUDNode()
	{
		return hud;
	}
	
	public void attachNode(Node node)
	{
		hud.attachChild(node);
	}
	
	public void detachNode(Node node)
	{
		hud.detachChild(node);
	}
}
