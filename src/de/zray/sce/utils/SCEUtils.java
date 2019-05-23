/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.utils;

import java.util.Random;
import org.joml.Vector2d;
import org.joml.Vector3d;


/**
 *
 * @author Vortex Acherontic
 */
public class SCEUtils {
    public static int getRandomInt(int min, int max){
        return (new Random().nextInt(max - min) + 1) + min;
    }
    
    public static Vector2d polarCoordinatesInWorldCoordinates(double radius,
            double angle){
        double x = radius * Math.cos(angle);
        double y = radius * Math.sin(angle);
        return new Vector2d(x, y);
    }
    
    public static Vector3d sphereCoordinatesInWorldCoordinates(double radius,
            double angleHorizontal, double angleVertical){
        double x, y, z;
        
        x = radius * Math.sin(angleVertical) * Math.cos(angleHorizontal);
        y = radius * Math.sin(angleVertical) * Math.sin(angleHorizontal);
        z = radius * Math.cos(angleVertical);
        
        return new Vector3d(x, y, z);
    }
    
    public static double randomKoorinate(double genScale){
        return Math.random()*genScale;
    }
    
    public static double randomAngle(){
        return (Math.random()*360) % 360;
    }
}
