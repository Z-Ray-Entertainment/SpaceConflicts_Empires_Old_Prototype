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
import javax.vecmath.Vector3d;

/**
 *
 * @author Vortex Acherontic
 */
public class AIOrb extends SEAI{
    public static final int SCALE_SYSTEM = 0, SCALE_GALAXY = 1, SCALE_UNIVERSE = 2;
    public static final double DISTANCE_SCALE[] = {10, 100, 1000000};
    
    private double mass, radius, speed;
    private double rotSpeed, curYear, curDay, distance, selfRotSpeed = 1;
    private AIOrb center;
    
    public AIOrb(SEWorld world, SEActor actor, SEAIWorld aiMod, AIOrb center){
        super(world, actor, aiMod);
        if(center != null){
            this.center = center;
            distance = (Math.random()*1000)+center.getRadius();
            speed = SEUtils.calcSateliteSpeed(center.getMass(), center.getRadius(), distance);
            rotSpeed = SEUtils.calcSpeedInAngleSpeed(speed, distance);
        }
        mass = Math.random()*Math.pow(10, 10);
        radius = Math.random()*10;
    }

    @Override
    public void act(double delta) {
        if(center != null){
            curYear += (rotSpeed*delta)%360;
            Vector2d cords = SEUtils.calcCoordinates(distance, curYear);
            Vector3d cPos = center.getActor().getOrientation().getPositionVec();
            Vector3d finalPos = new Vector3d(cords.x+cPos.x, cPos.y, cords.y+cPos.z);
            parrentActor.getOrientation().setPosition(finalPos.x, finalPos.y, finalPos.z);
        }
        curDay += (selfRotSpeed*delta)%360;
        parrentActor.getOrientation().setRotation(0, curDay, 0);
    }
    
    public double getMass(){
        return mass;
    }
    
    public double getRadius(){
        return radius;
    }
}