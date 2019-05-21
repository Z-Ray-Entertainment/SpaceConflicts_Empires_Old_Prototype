/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.game;

import org.joml.Vector3d;

/**
 *
 * @author Vortex Acherontic
 */
public class Orientation {
    Vector3d speed, position, rotation, dimensions, rotSpeed;
    
    public Orientation(){}
    public Orientation(Vector3d position, Vector3d rotation){
        initGalaxy(position, rotation, null, null, null);
    }
    
    public Orientation(Vector3d position, Vector3d rotation, Vector3d speed){
        initGalaxy(position, rotation, speed, null, null);
    }
    
    public Orientation(Vector3d position, Vector3d rotation, Vector3d speed,
            Vector3d rotSpeed){
        initGalaxy(position, rotation, speed, rotSpeed, null);
    }
    
    private void initGalaxy(Vector3d position, Vector3d rotation, Vector3d speed,
            Vector3d rotSpeed, Vector3d dimension){
        this.position = position;
        this.rotation = rotation;
        this.speed = speed;
        this.rotSpeed = rotSpeed;
        this.dimensions = dimension;
    }
    
    public void setSpeed(Vector3d speed){
        this.speed = speed;
    }
    
    public Vector3d getSpeed(){
        return speed;
    }
    
    public void setPosition(Vector3d position){
        this.position = position;
    }
    
    public Vector3d getPosistion(){
        return position;
    }
    
    public void setRotation(Vector3d rotation){
        this.rotation = rotation;
    }
    
    public Vector3d getRotation(){
        return rotation;
    }
    
    public void setDimension(Vector3d dimension){
        this.dimensions = dimension;
    }
    
    public Vector3d getDimension(){
        return dimensions;
    }
    
    public void setRotationSpeed(Vector3d rotSpeed){
        this.rotSpeed = rotSpeed;
    }
    
    public Vector3d getRotationSpeed(){
        return rotSpeed;
    }
}
