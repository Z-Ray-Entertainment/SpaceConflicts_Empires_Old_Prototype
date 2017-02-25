/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.gui.main;

import de.zray.zgui.TextureManager;
import org.newdawn.slick.Color;


/**
 *
 * @author vortex
 */
public class GUITextureLib {
    public static String SKIN = "default_blue/";
    public static String GUI_PATH = "scedata/textures/gui/skins/",
            BUTTON_IDLE = GUI_PATH+SKIN+"button.png",
            BUTTON_HOVER = GUI_PATH+SKIN+"button-hovered.png",
            BUTTON_DISABLED = GUI_PATH+SKIN+"button-disabled.png",
            PLAY = GUI_PATH+SKIN+"play.png", PAUSE = GUI_PATH+SKIN+"paused.png", 
            FORWARD = GUI_PATH+SKIN+"forward.png", BACKWARD = GUI_PATH+SKIN+"backward.png",
            SOUND_ON = GUI_PATH+SKIN+"sound-on.png", SOUND_OFF = GUI_PATH+SKIN+"sound-off.png";
    public static Color fontColorActive = Color.green, fontColorDisabled = Color.red;
    public static TextureManager TEXTURE_MANAGER = new TextureManager();
}
