/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.unigen.orbs;

import de.zray.se.SEActor;
import de.zray.se.SEWorld;
import de.zray.se.grapics.semesh.SEMaterial;
import de.zray.se.grapics.semesh.SEMesh;
import de.zray.se.grapics.shapes.IcoSphere;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import javax.vecmath.Color3f;

/**
 *
 * @author vortex
 */
public class SystemGenerator {
    public List<SEActor> generateSystem(int[] planets, int[] monnsPerPlanet, SEWorld world){
        List<SEActor> system = new LinkedList<SEActor>();
        SEActor sun = buildSun(world);
        system.add(sun);
        system.add(buildPlanet(sun, world));
        return system;
    }
    
    private SEActor buildSun(SEWorld world){
        SEMaterial sunMat = new SEMaterial(new Color3f(Color.ORANGE));
        sunMat.setBackfaceCulling(true);
        sunMat.setShadeless(true);
        AIOrb sunAI = new AIOrb(world, null, world.getAIWorld(), null, true);
        SEMesh sunMesh = new IcoSphere((float) sunAI.getRadius(), 4).getSEMesh();
        sunMesh.setRenderMode(SEMesh.RenderMode.VBO);
        sunMesh.setMaterial(sunMat);
        SEActor sunActor = new SEActor(sunMesh, sunAI, null, world);
        sunAI.setActor(sunActor);
        return sunActor;
    }
    
    private SEActor buildPlanet(SEActor sun, SEWorld world){
        SEMaterial planetMaterial = new SEMaterial(new Color3f(Color.GREEN));
        planetMaterial.setShadeless(true);
        planetMaterial.setBackfaceCulling(true);
        AIOrb planetAI = new AIOrb(world, null, world.getAIWorld(), (AIOrb) sun.getSEAI(), false);
        SEMesh planetMesh = new IcoSphere((float) planetAI.getRadius(), 4).getSEMesh();
        planetMesh.setMaterial(planetMaterial);
        planetMesh.setDisplayMode(SEMesh.DisplayMode.SOLID);
        planetMesh.setRenderMode(SEMesh.RenderMode.VBO);
        SEActor planet = new SEActor(planetMesh, planetAI, null, world);
        planetAI.setActor(planet);
        return planet;
    }
}
