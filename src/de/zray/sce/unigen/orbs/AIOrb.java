/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.unigen.orbs;

import de.zray.se.world.Actor;
import de.zray.se.utils.SEUtils;
import de.zray.se.world.World;
import de.zray.se.ai.SEAI;
import de.zray.se.ai.SEAIWorld;
import javax.vecmath.Vector2d;
import javax.vecmath.Vector3d;

/**
 *
 * @author Vortex Acherontic
 */
public class AIOrb extends SEAI{
    public static enum Generate{SUN, PLANET, MOON, NONE};
    public static final int SCALE_SYSTEM = 0, SCALE_GALAXY = 1, SCALE_UNIVERSE = 2;
    public static final double DISTANCE_SCALE[] = {10, 100, 1000000};
    
    private double mass, radius, speed;
    private double rotSpeed, curYear, curDay, distance, selfRotSpeed = 1;
    private AIOrb center;
    
    public AIOrb(World world, Actor actor, SEAIWorld aiMod, AIOrb center, Generate gen){
        super(world, actor, aiMod);
        if(center != null){
            this.center = center;
            distance = (Math.random()*100)+center.getRadius();
            speed = SEUtils.calcSateliteSpeed(center.getMass(), center.getRadius(), distance);
            rotSpeed = SEUtils.calcSpeedInAngleSpeed(speed, distance);
        }
        switch(gen){
            case MOON :
                mass = Math.random()*Math.pow(10, 2.5);
                radius = Math.random()*5;
                distance = (Math.random()*10)+center.getRadius()+radius;
                break;
            case PLANET :
                mass = Math.random()*Math.pow(10, 5);
                radius = Math.random()*10;
                distance = (Math.random()*500)+center.getRadius()+radius;
                break;
            case SUN :
                mass = Math.random()*Math.pow(10, 11);
                radius = Math.random()*100;
                break;
        }
    }

    @Override
    public void act(double delta) {
        if(center != null){
            curYear += (rotSpeed*delta)%360;
            Vector2d cords = SEUtils.calcCoordinates(distance, curYear);
            Vector3d cPos = center.getActor().getOrientation().getPositionVec();
            Vector3d finalPos = new Vector3d(cords.x+cPos.x, cPos.y, cords.y+cPos.z);
            parentActor.getOrientation().setPosition(finalPos.x, finalPos.y, finalPos.z);
        }
        curDay += (selfRotSpeed*delta)%360;
        parentActor.getOrientation().setRotation(0, curDay, 0);
    }
    
    public double getMass(){
        return mass;
    }
    
    public double getRadius(){
        return radius;
    }
}
