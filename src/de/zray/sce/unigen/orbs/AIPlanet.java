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
    private double massOfCenter, radiusOfCenter, distanceToCenter;
    private double selfRotSpeed = 10, curYear = 0, curDay, angleSpeed;
    
    public AIPlanet(SEWorld world, SEActor actor, SEAIWorld aiMod) {
        super(world, actor, aiMod);
        distanceToCenter = (float) (Math.random()*10);
        radiusOfCenter = 1;
        massOfCenter = 10;
        double speed = SEUtils.calcSateliteSpeed(massOfCenter, radiusOfCenter, distanceToCenter);
        angleSpeed = SEUtils.calcSpeedInAngleSpeed(speed, radiusOfCenter+distanceToCenter);
    }

    @Override
    public void act(double delta) {
        curDay += (10*delta)%360;
        curYear += (angleSpeed*delta)%360;
        Vector2d cords = SEUtils.calcCoordinates(distanceToCenter, curYear);
        parrentActor.getOrientation().setPosition(cords.x, 0, cords.y);
        parrentActor.getOrientation().setRotation(0, curDay, 0);
    }
}
