/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.scenes.main;

import de.zray.se.inputmanager.InputManager;
import de.zray.se.inputmanager.KeyMap;

/**
 *
 * @author vortex
 */
public class SCEMainWorldInput extends InputManager{
    public SCEMainWorldInput(SCEMainWorld world) {
        super(world);
    }

    @Override
    public void mousePressed(int key, int posX, int posY) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(int key, int posX, int posY) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(int posX, int posY) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(int key) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTiped(int key) {
        
    }

    @Override
    public void keyReleased(int key) {
        if(key == KeyMap.KEY_ESCAPE){
            getWorld().getRenderBackend().requestClose();
        }
    }
    
}
