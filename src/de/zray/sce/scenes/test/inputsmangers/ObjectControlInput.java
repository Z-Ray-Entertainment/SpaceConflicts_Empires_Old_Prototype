/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.scenes.test.inputsmangers;

import de.zray.se.inputmanager.InputManager;
import de.zray.se.inputmanager.KeyMap;
import de.zray.se.world.SEActor;
import de.zray.se.world.SEWorld;

/**
 *
 * @author vortex
 */
public class ObjectControlInput extends InputManager{
    private SEActor linkedActor;
    
    
    public ObjectControlInput(SEWorld world, SEActor linkedActor) {
        super(world);
        this.linkedActor = linkedActor;
    }

    @Override
    public void mousePressed(int key, int posX, int posY) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(int key, int posX, int posY) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(int posX, int posY) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(int key) {
        switch(key){
            case KeyMap.KEY_ARROW_UP :
                break;
            case KeyMap.KEY_ARROW_DOWN :
                break;
        }
    }

    @Override
    public void keyTiped(int key) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(int key) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
