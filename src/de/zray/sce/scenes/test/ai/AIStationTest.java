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
    private double start = 0;
    private final double movementSpeed = 1, moveDistance = 10;
    
    public AIStationTest(World world, Actor actor, SEAIWorld aiMod) {
        super(world, actor, aiMod);
    }

    @Override
    public void act(double delta) {
        double pos[] = getActor().getOrientation().getPosition();
        if(moveLeft){
            pos[0] -= (movementSpeed*delta);
            if(pos[0] <= -moveDistance){
                moveLeft = false;
            }
        } else {
            pos[0] += (movementSpeed*delta);
            if(pos[0] >= moveDistance){
                moveLeft = true;
            }
        }
        getActor().getOrientation().setPosition(pos[0], pos[1], pos[2]);
    }
    
}
