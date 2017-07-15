/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.unigen.orbs;

import de.zray.se.SEActor;
import de.zray.se.SEUtils;
import de.zray.se.SEWorld;
import de.zray.se.grapics.semesh.SEMaterial;
import de.zray.se.grapics.semesh.SEMesh;
import de.zray.se.grapics.shapes.IcoSphere;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import javax.vecmath.Color3f;

/**
 *
 * @author vortex
 */
public class SystemGenerator {
    public List<SEActor> generateSystem(int[] planets, int[] moonsPerPlanet, SEWorld world){
        List<SEActor> system = new LinkedList<SEActor>();
        SEActor sun = buildSun(world);
        system.add(sun);
        
        int planetsAmmount = SEUtils.randomInt(planets[0], planets[1]);
        
        for(int i = 0; i < planetsAmmount; i++){
            system.addAll(buildPlanet(sun, world, moonsPerPlanet[0], moonsPerPlanet[1]));
            System.out.println("Generating solarsystem: "+(100d/(double)planetsAmmount*i)+"% of "+planetsAmmount+" done");
        }
        
        return system;
    }
    
    private SEActor buildSun(SEWorld world){
        SEMaterial sunMat = new SEMaterial(new Color3f(Color.ORANGE));
        sunMat.setBackfaceCulling(true);
        sunMat.setShadeless(true);
        AIOrb sunAI = new AIOrb(world, null, world.getAIWorld(), null, AIOrb.Generate.SUN);
        SEMesh sunMesh = new IcoSphere((float) sunAI.getRadius(), 4).getSEMesh();
        sunMesh.setRenderMode(SEMesh.RenderMode.VBO);
        sunMesh.setMaterial(sunMat);
        SEActor sunActor = new SEActor(sunMesh, sunAI, null, world);
        sunAI.setActor(sunActor);
        return sunActor;
    }
    
    private List<SEActor> buildPlanet(SEActor sun, SEWorld world, int moonsMin, int moonsMax){
        List<SEActor> orbs = new LinkedList<>();
        SEMaterial planetMaterial = new SEMaterial(new Color3f(Color.GREEN));
        planetMaterial.setShadeless(true);
        planetMaterial.setBackfaceCulling(true);
        AIOrb planetAI = new AIOrb(world, null, world.getAIWorld(), (AIOrb) sun.getSEAI(), AIOrb.Generate.PLANET);
        SEMesh planetMesh = new IcoSphere((float) planetAI.getRadius(), 4).getSEMesh();
        planetMesh.setMaterial(planetMaterial);
        planetMesh.setDisplayMode(SEMesh.DisplayMode.SOLID);
        planetMesh.setRenderMode(SEMesh.RenderMode.VBO);
        SEActor planet = new SEActor(planetMesh, planetAI, null, world);
        planetAI.setActor(planet);
        orbs.add(planet);
        for(int i = 0; i < SEUtils.randomInt(moonsMin, moonsMax); i++){
            orbs.add(buildMoon(planet, world));
        }
        return orbs;
    }
    
    private SEActor buildMoon(SEActor planet, SEWorld world){
        SEMaterial moonMaterial = new SEMaterial(new Color3f(Color.DARK_GRAY));
        moonMaterial.setShadeless(true);
        moonMaterial.setBackfaceCulling(true);
        AIOrb moonAI = new AIOrb(world, null, world.getAIWorld(), (AIOrb) planet.getSEAI(), AIOrb.Generate.MOON);
        SEMesh moonMesh = new IcoSphere((float) moonAI.getRadius(), 4).getSEMesh();
        moonMesh.setMaterial(moonMaterial);
        moonMesh.setDisplayMode(SEMesh.DisplayMode.SOLID);
        moonMesh.setRenderMode(SEMesh.RenderMode.VBO);
        SEActor moon = new SEActor(moonMesh, moonAI, null, world);
        moonAI.setActor(moon);
        return moon;
    }
}
