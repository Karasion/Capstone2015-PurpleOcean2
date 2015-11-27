package kr.ac.kookmin.cs.basic;

import com.jme3.asset.AssetManager;
import com.jme3.scene.Node;
import com.jme3.ui.Picture;

import eu.opends.main.Simulator;

public abstract class AppView {	
	private Node appNode;
	private AssetManager assetManager;
	private Picture enableIcon, disableIcon;
	protected float adjustValueX, adjustValueY;
	
	public AppView(String appNodeName, Simulator sim){
		this.appNode = new Node(appNodeName);
		assetManager = sim.getAssetManager();
		adjustValueX = (float)sim.getSettings().getWidth() / 1920;
	    adjustValueY = (float)sim.getSettings().getHeight() / 1080;
	}
	protected AssetManager getAssetManager()
	{
		return assetManager;
	}
	protected void setEnableIcon(String name, String path, float width, float height)
	{
		enableIcon = new Picture(name);
		enableIcon.setImage(assetManager, path, true);
		enableIcon.setWidth(width*adjustValueX);
		enableIcon.setHeight(height*adjustValueY);
	}
	protected void setDisableIcon(String name, String path, float width, float height)
	{
		disableIcon = new Picture(name);
		disableIcon.setImage(assetManager, path, true);
		disableIcon.setWidth(width*adjustValueX);
		disableIcon.setHeight(height*adjustValueY);
	}
	public Picture getEnableIcon()
	{
		return enableIcon;
	}
	public Picture getDisableIcon()
	{
		return disableIcon;
	}
	public Node getNode()
	{
		return appNode;
	}
	abstract public void update(AppModel appModel);
}
