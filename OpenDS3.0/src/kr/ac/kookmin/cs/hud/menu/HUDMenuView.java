package kr.ac.kookmin.cs.hud.menu;

import java.util.ArrayList;

import com.jme3.scene.Node;
import com.jme3.ui.Picture;

import eu.opends.main.Simulator;

public class HUDMenuView {
	private Simulator sim;
	private Node hudMenuNode;
	private Picture cursor;
	private ArrayList<Picture> enableIconList;
	private ArrayList<Picture> disableIconList;
	private ArrayList<Float> cursorPosition;
	private int cursorIndex = 0;
	private int menuNum = 0;
	
	public HUDMenuView(Simulator sim){
		this.sim = sim;
		hudMenuNode = new Node("HUDMenuView");
		enableIconList = new ArrayList<Picture>();
		disableIconList = new ArrayList<Picture>();
		cursorPosition = new ArrayList<Float>();
		cursor = new Picture("HUDMenuCursor");
		cursor.setImage(sim.getAssetManager(), "Textures/icons/menubar/menubar_arrow.png", true);
		cursor.setWidth(90);
		cursor.setHeight(15);
		cursor.setPosition(0, 60);
		hudMenuNode.attachChild(cursor);
	}
	
	private void setMenuIcon()
	{
		float position = (450/menuNum - 80)/2 + 580;
		
		cursorPosition.clear();
		
		for(int i=0; i < menuNum; i++){
			enableIconList.get(i).setPosition((position + (90*i)), 60);
			disableIconList.get(i).setPosition((position + (90*i)), 60);
			cursorPosition.add((position + (90*i))-5);
		}
		cursor.setPosition(cursorPosition.get(0), 60);
	}
	
	public Node getHudMenuNode()
	{
		return hudMenuNode;
	}
	
	public void addMenuIcon(Picture icon_en, Picture icon_dis){
		menuNum++;
		enableIconList.add(icon_en);
		disableIconList.add(icon_dis);
		hudMenuNode.attachChild(icon_en);
		setMenuIcon();
	}
	
	public void menuSelect(){
		hudMenuNode.detachAllChildren();
		for(Picture icon:disableIconList){
			hudMenuNode.attachChild(icon);
		}
		hudMenuNode.detachChildAt(cursorIndex);
		hudMenuNode.attachChild(enableIconList.get(cursorIndex));
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
		hudMenuNode.attachChild(cursor);
	}
	
	public void moveLeftCursorPos()
	{
		if(--cursorIndex < 0)
			cursorIndex = menuNum-1;
		cursor.setPosition(cursorPosition.get(cursorIndex), 60);
	}
	
	public void moveRightCursorPos()
	{
		if(++cursorIndex >= menuNum)
			cursorIndex = 0;
		cursor.setPosition(cursorPosition.get(cursorIndex), 60);
	}
	
	public int getCursorIndex()
	{
		return cursorIndex;
	}
}
