/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.gui.musicplayer;

import de.zray.sce.gui.SCEButton;
import de.zray.se.SEWorld;
import de.zray.zgui.GUI;
import de.zray.zgui.Orientation;

/**
 *
 * @author Vortex Acherontic
 */
public class MainBTPrevTrack extends SCEButton{
    public MainBTPrevTrack(Orientation ori, GUI parrent, SEWorld parrentWorld) {
        super(ori, parrent, parrentWorld);
    }

    @Override
    public void idleAction() {
    }

    @Override
    public void onMouseClickAction(int mouseButton) {
        action();
    }

    @Override
    public void onMousePressedAction(int mouseButton) {}

    @Override
    public void onOpenGUIAction() {
    }

    @Override
    public void onCloseGUIAction() {
    }

    @Override
    public void onKeyTipedAction(int key){
        
    }

    @Override
    public void onKeyPressedAction(int key) {
    }
    
    private void action(){
        getParrentWorld().getAudioModule().getBGMPlayList().previousTrack();
    }
}
