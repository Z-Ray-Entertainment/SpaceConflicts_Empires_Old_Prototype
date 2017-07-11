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
import de.zray.se.ai.SEAIWorld;
import javax.vecmath.Vector2d;

/**
 *
 * @author Vortex Acherontic
 */
public class AIPlanet extends SEAI{
    private float distToSun, day, year;
    private double curDay, curYear;
    
    public AIPlanet(SEWorld world, SEActor actor, SEAIWorld aiMod) {
        super(world, actor, aiMod);
        distToSun = (float) (Math.random()*100);
        day = (float) (Math.random()*10);
        year = (float) Math.random();
    }

    @Override
    public void act(double delta) {
        curDay = (curDay+day*delta)%360;
        curYear = (curYear+year*delta)%360;
        Vector2d cords = SEUtils.calcCoordinates(distToSun, curYear);
        parrentActor.getOrientation().setPosition(cords.x, 0, cords.y);
        parrentActor.getOrientation().setRotation(0, curDay, 0);
    }
}
