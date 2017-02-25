/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.universe;

import de.zray.se.SEWorld;

/**
 *
 * @author Vortex Acherontic
 */
public class System {
    public SEWorld generateSolarsystem(int scale, Chances chances, long seed){
        int planets, moons, asteroids, wreckage, wormholes, warpStation;
        
        planets = (int) (Math.floor(Math.random())*scale*chances.planet);
        moons = (int) (Math.floor(Math.random())*scale*chances.moon);
        asteroids = (int) (Math.floor(Math.random())*scale*chances.asteroid);
        wreckage = (int) (Math.floor(Math.random())*scale*chances.wreckage);
        wormholes = (int) (Math.floor(Math.random())*scale*chances.wormHole);
        warpStation = (int) (Math.floor(Math.random())*scale*chances.warpStation);
        return generate(planets, moons, wreckage, asteroids, wormholes, warpStation);
    }
    
    private SEWorld generate(int planets, int moons, int wreckage, 
            int asteroids, int wormholes, int warpStations){
        return null;
    }
    
    
}
