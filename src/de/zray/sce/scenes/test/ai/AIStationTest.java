/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.scenes.test.ai;

import de.zray.se.ai.SEAI;
import de.zray.se.ai.SEAIWorld;
import de.zray.se.world.Actor;
import de.zray.se.world.World;

/**
 *
 * @author vortex
 */
public class AIStationTest extends SEAI{
    private boolean moveLeft = false;
    private final double movementSpeed = 5, moveDistance = 100;
    private byte axis = 0;
    private float turn = 0;
    
    public AIStationTest(World world, Actor actor, SEAIWorld aiMod) {
        super(world, actor, aiMod);
    }

    @Override
    public void act(double delta) {
        double pos[] = getActor().getOrientation().getPosition();
        if(moveLeft){
            pos[axis] -= (movementSpeed*delta);
            if(pos[axis] <= -moveDistance){
                moveLeft = false;
            }
        } else {
            pos[axis] += (movementSpeed*delta);
            if(pos[axis] >= moveDistance){
                moveLeft = true;
            }
        }
        
        turn += 10*delta;
        turn %= 360;
        getActor().getOrientation().setRotation(20, turn, 15);
        getActor().getOrientation().setPosition(pos[0], pos[1], pos[2]);
    }
    
}
