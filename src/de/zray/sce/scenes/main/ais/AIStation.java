/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.scenes.main.ais;

import de.zray.se.world.Actor;
import de.zray.se.world.World;
import de.zray.se.ai.SEAI;
import de.zray.se.ai.SEAIWorld;

/**
 *
 * @author Vortex Acherontic
 */
public class AIStation extends SEAI{
    private float turn = 0;
    
    public AIStation(World world, Actor actor, SEAIWorld aiMod) {
        super(world, actor, aiMod);
    }

    @Override
    public void act(double delta) {
        turn += 1*delta;
        turn %= 360;
        parentActor.getOrientation().setRotation(20, turn, 15);
    }
    
}
