/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.gui.musicplayer;

import de.zray.sce.gui.SCEButton;
import de.zray.sce.gui.main.GUITextureLib;
import de.zray.se.SEWorld;
import de.zray.zgui.GUI;
import de.zray.zgui.Orientation;
import org.lwjgl.input.Keyboard;

/**
 *
 * @author Vortex Acherontic
 */
public class MainBTToggelMusic extends SCEButton{
    public MainBTToggelMusic(Orientation ori, GUI parrent, SEWorld parrentWorld) {
        super(ori, parrent, parrentWorld);
    }

    @Override
    public void idleAction() {
    }

    @Override
    public void onMouseClickAction(int mouseButton) {
        if(mouseButton == 0){
            action();
        }
    }

    @Override
    public void onMousePressedAction(int mouseButton) {}

    @Override
    public void onOpenGUIAction(){
    }

    @Override
    public void onCloseGUIAction() {
    }

    @Override
    public void onKeyTipedAction(int key) {
        if(Keyboard.KEY_M == key){
            action();
        }
    }

    @Override
    public void onKeyPressedAction(int key) {
    }
    
    private void action(){
        getParrentWorld().getAudioModule().setBGMMuted(!getParrentWorld().getAudioModule().isBGMMuted());
        if(getParrentWorld().getAudioModule().isBGMMuted()){
            setStateTextures(GUITextureLib.SOUND_OFF, GUITextureLib.SOUND_ON, GUITextureLib.SOUND_OFF);
        }
        else{
            setStateTextures(GUITextureLib.SOUND_ON, GUITextureLib.SOUND_OFF, GUITextureLib.SOUND_ON);
        }
    }
}
