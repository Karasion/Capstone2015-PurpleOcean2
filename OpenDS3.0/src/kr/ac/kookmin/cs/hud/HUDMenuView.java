package kr.ac.kookmin.cs.hud;

import java.util.ArrayList;

import com.jme3.scene.Node;
import com.jme3.ui.Picture;

public class HUDMenuView {
	Node hudMenuNode;
	ArrayList<Picture> enableIconList;
	ArrayList<Picture> disableIconList;
	
	private HUDMenuView(){
		hudMenuNode = new Node("HUDMenuView");
		enableIconList = new ArrayList<Picture>();
		disableIconList = new ArrayList<Picture>();		
	}
	
	private static class HUDMenuViewHolder{
		static final HUDMenuView hudMenuView = new HUDMenuView();
	}
	
	public static HUDMenuView getInstance()
	{
		return HUDMenuViewHolder.hudMenuView;
	}
	
	public Node getHudMenuNode()
	{
		return hudMenuNode;
	}
	
	public void addMenuIcon(Picture icon_en, Picture icon_dis){
		enableIconList.add(icon_en);
		disableIconList.add(icon_dis);
	}
	
	public void menuSelect(int index){
		hudMenuNode.detachAllChildren();
		for(Picture icon:disableIconList){
			hudMenuNode.attachChild(icon);
		}
		hudMenuNode.detachChildAt(index);
		hudMenuNode.attachChild(enableIconList.get(index));
	}
	
	public void setViewDisableIcon(){
		hudMenuNode.detachAllChildren();
		for(Picture icon:disableIconList){
			hudMenuNode.attachChild(icon);
		}
	}
	
	public void setViewEnableIcon(){
		hudMenuNode.detachAllChildren();
		for(Picture icon:enableIconList){
			hudMenuNode.attachChild(icon);
		}
	}
}
