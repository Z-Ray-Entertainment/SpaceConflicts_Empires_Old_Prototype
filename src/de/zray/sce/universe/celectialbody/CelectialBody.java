/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.universe.celectialbody;

import de.zray.se.world.Actor;
import javax.vecmath.Vector3d;

/**
 *
 * @author vortex
 */
public abstract class CelectialBody {
    private Actor actor;
    private AICelectialBody ai;
    private Vector3d posistion = new Vector3d();
    private Vector3d ownRotaion = new Vector3d();
    private Vector3d angleSpeed = new Vector3d();
    private Vector3d speed = new Vector3d();
    private CelectialBody center;
    private double mass = 0, size = 0;
    
    public boolean hasCenter(){
        return (center != null);
    }
    
    public void setPosition(Vector3d pos){
        this.posistion = pos;
    }
    
    public Vector3d getPosistion(){
        return posistion;
    }
    
    public void setOwnRotation(Vector3d ownRotation){
        this.ownRotaion = ownRotation;
    }
    
    public  Vector3d getOwnRoataion(){
        return ownRotaion;
    }
    
    public void setMass(double mass){
        this.mass = mass;
    }
    
    public double getMass(){
        return mass;
    }
    
    public void setSize(double size){
        this.size = size;
    }
    
    public double getSize(){
        return size;
    }
    
    public void setAngleSpeed(Vector3d angleSpeed){
        this.angleSpeed = angleSpeed;
    }
    
    public Vector3d getAngleSpeed(){
        return angleSpeed;
    }
    
    public void setSpeed(Vector3d speed){
        this.speed = speed;
    }
    
    public Vector3d getSpeed(){
        return speed;
    }
    
    public void setCenter(CelectialBody center){
        this.center = center;
    }
    
    public CelectialBody getCenter(){
        return center;
    }
    
    public void setActor(Actor actor){
        this.actor = actor;
    }
    
    public Actor getActor(){
        return actor;
    }
    
    public void setAI(AICelectialBody ai){
        this.ai = ai;
    }
    
    public AICelectialBody getAI(){
        return ai;
    }
}
