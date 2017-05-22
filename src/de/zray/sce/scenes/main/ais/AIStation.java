/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.scenes.main.ais;

import de.zray.se.SEActor;
import de.zray.se.SEWorld;
import de.zray.se.ai.SEAI;
import de.zray.se.ai.SEAIModule;

/**
 *
 * @author Vortex Acherontic
 */
public class AIStation extends SEAI{
    private float turn = 0;
    
    public AIStation(SEWorld world, SEActor actor, SEAIModule aiMod) {
        super(world, actor, aiMod);
    }

    @Override
    public void act(double delta) {
        turn += 1*delta;
        turn %= 360;
        parrentActor.getSEMesh().getOrientation().setRotation(20, turn, 15);
    }
    
}
