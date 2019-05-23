/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.scenes.main;

import de.zray.se.Engine;
import de.zray.se.world.World;
import de.zray.se.inputmanager.InputManager;
import org.joml.Vector3f;
import static org.lwjgl.glfw.GLFW.*;

/**
 *
 * @author vortex
 */
public class SpectatorInput extends InputManager{
    private int multi = 1;
    private double movementSpeed = 10;
    
    public SpectatorInput(World world) {
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
        Vector3f pos = new Vector3f();
        Vector3f rot = new Vector3f();
        switch(key){
            case GLFW_KEY_Q :
                pos = getWorld().getCurrentCamera().getPosition();
                pos.y += movementSpeed*Engine.get().getDeltaInSec()*multi;
                getWorld().getCurrentCamera().setPosition(pos.x, pos.y, pos.z);
                break;
            case GLFW_KEY_E :
                pos = getWorld().getCurrentCamera().getPosition();
                pos.y -= movementSpeed*Engine.get().getDeltaInSec()*multi;
                getWorld().getCurrentCamera().setPosition(pos.x, pos.y, pos.z);
                break;
            case GLFW_KEY_W :
                pos = getWorld().getCurrentCamera().getPosition();
                pos.z -= movementSpeed*Engine.get().getDeltaInSec()*multi;
                getWorld().getCurrentCamera().setPosition(pos.x, pos.y, pos.z);
                break;
            case GLFW_KEY_S :
                pos = getWorld().getCurrentCamera().getPosition();
                pos.z += movementSpeed*Engine.get().getDeltaInSec()*multi;
                getWorld().getCurrentCamera().setPosition(pos.x, pos.y, pos.z);
                break;
            case GLFW_KEY_A :
                pos = getWorld().getCurrentCamera().getPosition();
                pos.x -= movementSpeed*Engine.get().getDeltaInSec()*multi;
                getWorld().getCurrentCamera().setPosition(pos.x, pos.y, pos.z);
                break;
            case GLFW_KEY_D :
                pos = getWorld().getCurrentCamera().getPosition();
                pos.x += movementSpeed*Engine.get().getDeltaInSec()*multi;
                getWorld().getCurrentCamera().setPosition(pos.x, pos.y, pos.z);
                break;
            case GLFW_KEY_DOWN :
                rot = getWorld().getCurrentCamera().getRotation();
                rot.x += (100*Engine.get().getDeltaInSec())%360*multi;
                getWorld().getCurrentCamera().setRotation(rot.x, rot.y, rot.z);
                break;
            case GLFW_KEY_UP :
                rot = getWorld().getCurrentCamera().getRotation();
                rot.x -= (100*Engine.get().getDeltaInSec())%360*multi;
                getWorld().getCurrentCamera().setRotation(rot.x, rot.y, rot.z);
                break;
            case GLFW_KEY_LEFT :
                rot = getWorld().getCurrentCamera().getRotation();
                rot.y += (100*Engine.get().getDeltaInSec())%360*multi;
                getWorld().getCurrentCamera().setRotation(rot.x, rot.y, rot.z);
                break;
            case GLFW_KEY_RIGHT :
                rot = getWorld().getCurrentCamera().getRotation();
                rot.y -= (100*Engine.get().getDeltaInSec())%360*multi;
                getWorld().getCurrentCamera().setRotation(rot.x, rot.y, rot.z);
                break;
        }
    }

    @Override
    public void keyTiped(int key) {
        switch(key){
            case GLFW_KEY_LEFT_SHIFT :
                multi = 10;
                break;
        }
    }

    @Override
    public void keyReleased(int key) {
        switch(key){
            case GLFW_KEY_ESCAPE :
                System.exit(0);
                break;
            case GLFW_KEY_LEFT_SHIFT :
                multi = 1;
                break;
        }
    }
    
}
