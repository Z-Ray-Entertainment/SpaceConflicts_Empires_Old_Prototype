/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.scenes.main;

import de.zray.se.MainThread;
import de.zray.se.inputmanager.InputManager;
import de.zray.se.inputmanager.KeyMap;
import javax.vecmath.Vector3f;

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
        System.out.println("KeyPressed!");
        Vector3f pos = new Vector3f();
        switch(key){
            case KeyMap.KEY_Q :
                pos = getWorld().getCurrentCamera().getPosition();
                pos.y += 10*MainThread.getDeltaInSec();
                getWorld().getCurrentCamera().setPosition(pos.x, pos.y, pos.z);
                break;
            case KeyMap.KEY_E :
                pos = getWorld().getCurrentCamera().getPosition();
                pos.y -= 10*MainThread.getDeltaInSec();
                getWorld().getCurrentCamera().setPosition(pos.x, pos.y, pos.z);
                break;
            case KeyMap.KEY_W :
                pos = getWorld().getCurrentCamera().getPosition();
                pos.z -= 10*MainThread.getDeltaInSec();
                getWorld().getCurrentCamera().setPosition(pos.x, pos.y, pos.z);
                break;
            case KeyMap.KEY_S :
                pos = getWorld().getCurrentCamera().getPosition();
                pos.z += 10*MainThread.getDeltaInSec();
                getWorld().getCurrentCamera().setPosition(pos.x, pos.y, pos.z);
                break;
            case KeyMap.KEY_A :
                pos = getWorld().getCurrentCamera().getPosition();
                pos.x -= 10*MainThread.getDeltaInSec();
                getWorld().getCurrentCamera().setPosition(pos.x, pos.y, pos.z);
                break;
            case KeyMap.KEY_D :
                pos = getWorld().getCurrentCamera().getPosition();
                pos.x += 10*MainThread.getDeltaInSec();
                getWorld().getCurrentCamera().setPosition(pos.x, pos.y, pos.z);
                break;
        }
        System.out.println("Pos: "+pos.x+" "+pos.y+" "+pos.z);
    }

    @Override
    public void keyTiped(int key) {
        
    }

    @Override
    public void keyReleased(int key) {
        switch(key){
            case KeyMap.KEY_ESCAPE :
                getWorld().getRenderBackend().requestClose();
                break;
        }
    }
    
}
