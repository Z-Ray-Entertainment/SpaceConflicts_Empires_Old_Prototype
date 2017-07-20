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
import de.zray.zgui.TextureManager;
import de.zray.zgui.exceptions.InvalidRangeException;
import javax.vecmath.Vector2f;

/**
 *
 * @author Vortex Acherontic
 */
public class MusicPlayer {
    public MusicPlayer(GUI parrentGUI, TextureManager tManager, SEWorld parrentWorld, Vector2f pos) throws InvalidRangeException{
        Orientation btToggleMusicOri = new Orientation(16f, 16f, pos.x, pos.y, 0);
        SCEButton btToggleMusic = new MainBTToggelMusic(btToggleMusicOri, parrentGUI, parrentWorld);
        //btToggleMusic.setMaterial(new Material(tManager, GUITextureLib.SOUND_ON, Material.MaterialMode.GL_MATERIAL));
        btToggleMusic.setStateTextures(GUITextureLib.SOUND_ON, GUITextureLib.SOUND_OFF, GUITextureLib.SOUND_ON);
        parrentGUI.addItem(btToggleMusic);
        
        Orientation btNextTrackOri = new Orientation(16f, 16f, pos.x+.05f, pos.y, 0);
        SCEButton btNextTrack = new MainBTNextTrack(btNextTrackOri, parrentGUI, parrentWorld);
        //btNextTrack.setMaterial(new Material(tManager, GUITextureLib.FORWARD, Material.MaterialMode.GL_MATERIAL));
        btNextTrack.setStateTextures(GUITextureLib.FORWARD, GUITextureLib.FORWARD, GUITextureLib.FORWARD);
        parrentGUI.addItem(btNextTrack);
        
        Orientation btPrevTrackOri = new Orientation(16f, 16f, pos.x-.05f, pos.y, 0);
        SCEButton btPrevTrack = new MainBTNextTrack(btPrevTrackOri, parrentGUI, parrentWorld);
        //btPrevTrack.setMaterial(new Material(tManager, GUITextureLib.BACKWARD, Material.MaterialMode.GL_MATERIAL));
        btPrevTrack.setStateTextures(GUITextureLib.BACKWARD, GUITextureLib.BACKWARD, GUITextureLib.BACKWARD);
        parrentGUI.addItem(btPrevTrack);
    }
}
