/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.universe;

import de.zray.sce.unigen.properties.UnigenPropertie;
import javax.vecmath.Vector3d;

/**
 *
 * @author Vortex Acherontic
 */
public class Universe extends Orb implements Generateable{
    private UnigenPropertie galaxies, systems, planets, moons, asteroids, wrecks,
            wormholes, blackHoles, npcFactions;
    
    public Universe(UnigenPropertie galaxies, 
            UnigenPropertie systems, UnigenPropertie planets,
            UnigenPropertie moons, UnigenPropertie asteroids,
            UnigenPropertie wrecks, UnigenPropertie wormholes,
            UnigenPropertie blackHoles, UnigenPropertie npcFactions){
        this.galaxies = galaxies;
        this.asteroids = asteroids;
        this.blackHoles = blackHoles;
        this.moons = moons;
        this.npcFactions = npcFactions;
        this.planets = planets;
        this.systems = systems;
        this.wormholes = wormholes;
        this.wrecks = wrecks;
        
        setProperties(new UnigenPropertie[] {asteroids, blackHoles, galaxies, moons, npcFactions, planets, systems, wormholes, wrecks});
        generate();
    }

    @Override
    public boolean update() {
        return super.update(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void applyForce(Vector3d force) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void generate() {
        for(int i = 0; i < galaxies.randomAmount(); i++){
            Galaxy galaxy = new Galaxy();
            galaxy.setProperties(new UnigenPropertie[] {asteroids, blackHoles, moons, planets, systems, wormholes, wrecks});
            addOrb(galaxy);
        }
    }

    @Override
    public void setProperties(UnigenPropertie... prop) {
        this.asteroids = prop[0];
        this.blackHoles = prop[1];
        this.galaxies = prop[2];
        this.moons = prop[3];
        this.npcFactions = prop[4];
        this.planets = prop[5];
        this.systems = prop[6];
        this.wormholes = prop[7];
        this.wrecks = prop[8];
    }
}
