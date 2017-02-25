/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.gui.main;

import de.zray.sce.gui.SCEButton;
import de.zray.sce.gui.main.buttons.BTNewGame;
import de.zray.sce.gui.main.buttons.BTQuit;
import de.zray.sce.gui.main.buttons.BTSystem;
import de.zray.sce.gui.musicplayer.MusicPlayer;
import de.zray.se.SEWorld;
import de.zray.zgui.GUI;
import de.zray.zgui.GUIText;
import de.zray.zgui.Material;
import de.zray.zgui.Orientation;
import de.zray.zgui.TextureManager;
import de.zray.zgui.exceptions.InvalidRangeException;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Color;

/**
 *
 * @author vortex
 */
public class GUIMain extends GUI{
    public GUIMain(SEWorld parrentWorld) throws InvalidRangeException{
        super(GUITextureLib.TEXTURE_MANAGER);
        
        SCEButton btNewGame = new BTNewGame(this, parrentWorld);
        btNewGame.setOrientation(new Orientation(160f, 40f, .5f, .25f, 0));
        btNewGame.setText("New Game");
        addItem(btNewGame);
        
        SCEButton btSystem = new BTSystem(this, parrentWorld);
        btSystem.setOrientation(new Orientation(160f, 40f, .5f, .5f, 0));
        btSystem.setText("System");
        addItem(btSystem);
        
        SCEButton btQuit = new BTQuit(this, parrentWorld);
        btQuit.setOrientation(new Orientation(160f, 40f, .5f, .85f, 0));
        btQuit.setText("Quit");
        addItem(btQuit);
        
        new MusicPlayer(this, GUITextureLib.TEXTURE_MANAGER, parrentWorld, new Vector2f(.5f, .05f));
    }
}
