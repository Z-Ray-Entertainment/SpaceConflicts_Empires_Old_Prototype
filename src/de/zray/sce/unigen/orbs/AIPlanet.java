/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.unigen.orbs;

import de.zray.se.SEActor;
import de.zray.se.SEUtils;
import de.zray.se.SEWorld;
import de.zray.se.ai.SEAI;
import de.zray.se.ai.SEAIModule;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

/**
 *
 * @author Vortex Acherontic
 */
public class AIPlanet extends SEAI{
    private float distToSun, day, year;
    private float curDay, curYear;
    
    public AIPlanet(SEWorld world, SEActor actor, SEAIModule aiMod) {
        super(world, actor, aiMod);
        distToSun = (float) (Math.random()*100);
        day = (float) (Math.random()*10);
        year = (float) Math.random();
    }

    @Override
    public void act(float delta) {
        curDay = (curDay+day*delta)%360;
        curYear = (curYear+year*delta)%360;
        Vector2f cords = SEUtils.calcCoordinates(distToSun, curYear);
        parrentActor.getSEMesh().getOrientation().setPosition(cords.x, 0, cords.y);
        parrentActor.getSEMesh().getOrientation().setRotation(0, curDay, 0);
    }
}
