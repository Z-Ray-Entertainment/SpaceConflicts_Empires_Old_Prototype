/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.gui;

import de.zray.sce.gui.main.GUITextureLib;
import de.zray.se.SEWorld;
import de.zray.zgui.GUI;
import de.zray.zgui.GUIItem;
import de.zray.zgui.GUIText;
import de.zray.zgui.Material;
import de.zray.zgui.Orientation;
import de.zray.zgui.exceptions.InvalidRangeException;
import org.newdawn.slick.Color;

/**
 *
 * @author vortex
 */
public abstract class SCEButton extends GUIItem{
    private final SEWorld parrentWorld;
    private String textureIdle = GUITextureLib.BUTTON_IDLE, textureHover = GUITextureLib.BUTTON_HOVER,
            textureDisabled = GUITextureLib.BUTTON_DISABLED;
    private float animTextColorBlue = 0, direction = 1;

    public SCEButton(GUI parrentGUI, SEWorld parrentWorld) throws InvalidRangeException{
        super(new Orientation(1, 1, 0, 0, 0), parrentGUI);
        this.parrentWorld = parrentWorld;
        GUIText btText = new GUIText("SCEButton", this.getOrientation(), 50, "scedata/fonts/INFECTED.ttf", Color.green);
        btText.setAllignment(GUIText.TextAllign.CENTER);
        setText(btText);
        setMaterial(new Material(GUITextureLib.TEXTURE_MANAGER, GUITextureLib.BUTTON_IDLE, Material.MaterialMode.GL_MATERIAL));
    }
    
    public SCEButton(Orientation ori, GUI parrent, SEWorld parrentWorld){
        super(ori, parrent);
        this.parrentWorld = parrentWorld;
    }

    public void setStateTextures(String idle, String hover, String disabled){
        textureIdle = idle;
        textureDisabled = disabled;
        textureHover = hover;
    }
    
    public SEWorld getParrentWorld(){
        return parrentWorld;
    }
    
    public void setText(String text){
        this.getGUIText().setText(text);
    }
    
    @Override
    public void update(double delta) {
        switch(getAnimation()){
            case CLICK :
                break;
            case GUI_CLOSE :
                break;
            case GUI_OPEN :
                break;
            case HOVER :
                float fac = 1f*(float)delta*direction;
                if(GUITextureLib.fontColorActive.getRed() > 1){
                    direction = -1;
                }
                else if(GUITextureLib.fontColorActive.getRed() <= 0){
                    direction = 1;
                }
                getMaterial().setColor(GUITextureLib.fontColorActive.getRed()+fac, GUITextureLib.fontColorActive.getGreen()+fac, GUITextureLib.fontColorActive.getBlue()+fac, 1);
                break;
            case IDLE :
                break;
            case RELEASE :
                break;
        }
    }

    @Override
    public void onMouseHoverAction() {
        getMaterial().setIntTexture(getParrentGUI().getTextureManager().getTexture(textureHover));
        
        GUIText text = getGUIText();
        if(text != null){
            text.setColor(new Color(0, 255, animTextColorBlue));
        }
    }

    @Override
    public void onMouseReleaseAction() {
        getMaterial().setIntTexture(getParrentGUI().getTextureManager().getTexture(textureIdle));
        GUIText text = getGUIText();
        if(text != null){
            text.setColor(Color.green);
        }
    }

    @Override
    public void setDisabled(boolean b){
        super.setDisabled(b);
        getMaterial().setIntTexture(getParrentGUI().getTextureManager().getTexture(textureDisabled));
    }
}
