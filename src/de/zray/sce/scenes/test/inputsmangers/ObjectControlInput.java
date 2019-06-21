/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.scenes.test.inputsmangers;

import de.zray.se.Engine;
import de.zray.se.inputmanager.InputManager;
import de.zray.se.world.Actor;
import de.zray.se.world.World;
import static org.lwjgl.glfw.GLFW.*;

/**
 *
 * @author vortex
 */
public class ObjectControlInput extends InputManager{
    private Actor linkedActor;
    
    
    public ObjectControlInput(World world, Actor linkedActor) {
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
        double x = linkedActor.getOrientation().getPositionVec().x;
        double y = linkedActor.getOrientation().getPositionVec().y;
        double z = linkedActor.getOrientation().getPositionVec().z;
        
        switch(key){
            case GLFW_KEY_UP :
                x += .001 * Engine.get().getDeltaInSec();
                break;
            case GLFW_KEY_DOWN :
                x -= .001 * Engine.get().getDeltaInSec();
                break;
            case GLFW_KEY_LEFT :
                z += .001 * Engine.get().getDeltaInSec();
                break;
            case GLFW_KEY_RIGHT :
                z -= .001 * Engine.get().getDeltaInSec();
                break;
        }
        
        linkedActor.getOrientation().setPosition(x, y, z);
    }

    @Override
    public void keyReleased(int i) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
