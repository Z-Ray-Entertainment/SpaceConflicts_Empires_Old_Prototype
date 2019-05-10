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
    private static final int SCALE_SYSTEM = 1;
    public static enum Generate{SUN, PLANET, MOON, NONE};
    public static final int SCALE_GALAXY = 1, SCALE_UNIVERSE = 2;
    public static final double DISTANCE_SCALE[] = {10, 100, 1000000};
    
    private double mass, radius, speed;
    private double rotSpeed, curYear, curDay, distance, selfRotSpeed = 1;
    private AIOrb center;
    
    private double radiusDistnace, polar, azimuthal;
    
    public AIOrb(World world, Actor actor, SEAIWorld aiMod, AIOrb center, Generate gen){
        super(world, actor, aiMod);
        switch(gen){
            case MOON :
                mass = randomMoonMass();
                radius = randomMoonRadius();
                distance = (Math.random()*10)+center.getRadius()+radius;
                break;
            case PLANET :
                mass = randomPlanetMass();
                radius = randomPlanetRadius();
                distance = (Math.random()*500)+center.getRadius()+radius;
                break;
            case SUN :
                mass = randomSunMass();
                radius = randomSunRadius();
                break;
        }
        if(center != null){
            this.center = center;
            speed = SEUtils.get().calcSateliteSpeed(center.getMass(), center.getRadius(), distance);
            rotSpeed = SEUtils.get().calcSpeedInAngleSpeed(speed, distance);
            curYear = (Math.random()*360)%360;
            polar = (Math.random()*360)%360;
            azimuthal = (Math.random()*360)%360;
            radiusDistnace = distance;
        }
    }

    @Override
    public void act(double delta) {
        calcMovement(delta);
    }
    
    public double getMass(){
        return mass;
    }
    
    public double getRadius(){
        return radius;
    }
    
    private void calcMovement(double delta){
        if(center != null){
            curYear += (rotSpeed*delta)%360;
            Vector2d cords = SEUtils.get().calcCoordinates(distance, curYear);
            Vector3d cPos = center.getActor().getOrientation().getPositionVec();
            Vector3d finalPos = new Vector3d(cords.x+cPos.x, cPos.y, cords.y+cPos.z);
            parentActor.getOrientation().setPosition(finalPos.x, finalPos.y, finalPos.z);
        }
        curDay += (selfRotSpeed*delta)%360;
        parentActor.getOrientation().setRotation(0, curDay, 0);
    }
    
    private double randomSunMass(){
        return (Math.random()*1000)+100;
    }
    
    private double randomSunRadius(){
        return (Math.random()*10)+10;
    }
    
    private double randomPlanetMass(){
        return (Math.random()*100)+10;
    }
    
    private double randomPlanetRadius(){
        return (Math.random()*1)+1;
    }
    
    private double randomMoonMass(){
        return (Math.random()*10)+1;
    }
    
    private double randomMoonRadius(){
        return (Math.random()*0.1)+0.1;
    }
}
