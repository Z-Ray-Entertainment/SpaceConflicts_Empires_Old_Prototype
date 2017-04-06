/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.gui;

import de.zray.se.InputManager;
import de.zray.se.MainThread;
import de.zray.se.SEWorld;
import de.zray.se.Settings;
import de.zray.se.grapics.Camera;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vortex
 */
public class SCEInputManager extends InputManager{
    SEWorld parentWorld;
    private int mouseLastX, mouseLastY;
    private boolean shift = false;
    private float speedMult = 1;
    
    public SCEInputManager(SEWorld parent){
        this.parentWorld = parent;
    }
    
    @Override
    public void mousePressed(int key, int posX, int posY) {
    }

    @Override
    public void mouseClicked(int key, int posX, int posY) {
    }

    @Override
    public void mouseMoved(int posX, int posY) {
        if(Mouse.isButtonDown(1)){
            int x = Mouse.getX();
            int y = Mouse.getY();

            float thetaY = 360.0f * ( (float)(x-mouseLastX)/(float) Display.getWidth());
            float thetaX = 360.0f * ( (float)(mouseLastY-y)/(float) Display.getHeight());

            Vector3f camRot = parentWorld.getGLModule().getCurrentCamera().getRotation();
            camRot.x -= thetaX;
            camRot.y -= thetaY;
            parentWorld.getGLModule().getCurrentCamera().setRotation(camRot.x, camRot.y, camRot.z);
        }
        mouseLastX = Mouse.getX();
        mouseLastY = Mouse.getY();
    }

    @Override
    public void keyPressed(int key) {
        Vector3f camPos = parentWorld.getGLModule().getCurrentCamera().getPosition();
        float delta = parentWorld.getDeltaInS();
        switch(key){
            case Keyboard.KEY_W :
                camPos.z += 1f*delta*speedMult;
                break;
            case Keyboard.KEY_A :
                camPos.x -= 1f*delta*speedMult;
                break;
            case Keyboard.KEY_S :
                camPos.z -= 1f*delta*speedMult;
                break;
            case Keyboard.KEY_D :
                camPos.x += 1f*delta*speedMult;
                break;
            case Keyboard.KEY_Q :
                camPos.y += 1f*delta*speedMult;
                break;
            case Keyboard.KEY_E :
                camPos.y -= 1f*delta*speedMult;
                break;
            case Keyboard.KEY_LSHIFT :
                speedMult = 10;
                break;
        }
        parentWorld.getGLModule().getCurrentCamera().setPosition(camPos.x, camPos.y, camPos.z);
    }

    @Override
    public void keyTiped(int key){
        switch(key){
            case Keyboard.KEY_F1 :
                parentWorld.getCurrentGUI().toogleShow();
                break;
            case Keyboard.KEY_F2 :
                switch(Settings.get().debug.debugMode){
                    case DEBUG_AND_OBJECTS :
                        Settings.get().debug.debugMode = Settings.DebugMode.DEBUG_OFF;
                        break;
                    case DEBUG_OFF :
                        Settings.get().debug.debugMode = Settings.DebugMode.DEBUG_ON;
                        break;
                    case DEBUG_ON :
                        Settings.get().debug.debugMode = Settings.DebugMode.DEBUG_AND_OBJECTS;
                        break;
                }
                
                break;
            case Keyboard.KEY_LEFT:
                parentWorld.getAudioModule().getBGMPlayList().previousTrack();
                break;
            case Keyboard.KEY_RIGHT:
                parentWorld.getAudioModule().getBGMPlayList().nextTrack();
                break;
            case Keyboard.KEY_SPACE :
                try {
                    parentWorld.getAudioModule().playSoundEffect("scedata/audio/feedback/en/emiax/feedback_ally_and_me.ogg");
                } catch (IOException ex) {
                    Logger.getLogger(SCEInputManager.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case Keyboard.KEY_ESCAPE :
                MainThread.shutdown();
                break;
            case Keyboard.KEY_V :
                Camera.ViewMode vm = parentWorld.getGLModule().getCurrentCamera().getViewMode();
                switch(vm){
                    case EGO:
                        parentWorld.getGLModule().getCurrentCamera().setViewMode(Camera.ViewMode.THIRDPERSON);
                        break;
                    case THIRDPERSON :
                        parentWorld.getGLModule().getCurrentCamera().setViewMode(Camera.ViewMode.EGO);
                        break;
                }
                
                break;
        }
    }

    @Override
    public void keyReleased(int key) {
        switch(key){
            case Keyboard.KEY_LSHIFT :
                speedMult = 1;
                break;
        }
    }
    
}
