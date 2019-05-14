/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.unigen.systemgen;

import de.zray.sce.unigen.orbs.AIOrb;
import de.zray.se.world.Actor;
import de.zray.se.utils.SEUtils;
import de.zray.se.world.World;
import de.zray.se.graphics.semesh.Material;
import de.zray.se.graphics.semesh.Mesh;
import de.zray.se.graphics.shapes.IcoSphere;
import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import javax.vecmath.Color3f;

/**
 *
 * @author vortex
 */
public class SystemGenerator {
    private static final int orbRes = 4;
    
    public List<Actor> generateSystem(int[] planets, int[] moonsPerPlanet, World world){
        List<Actor> system = new LinkedList<Actor>();
        Actor sun = buildSun(world);
        system.add(sun);
        
        int planetsAmmount = SEUtils.get().randomInt(planets[0], planets[1]);
        int overallOrbs = 1;
        
        for(int i = 0; i < planetsAmmount; i++){
            List<Actor> meshes = buildPlanet(sun, world, moonsPerPlanet[0], moonsPerPlanet[1]);
            system.addAll(meshes);
            overallOrbs += meshes.size();
            if(i%10 == 0){
                System.out.println("Generating solarsystem: "+((int) (100d/(double)planetsAmmount*i))+"% of "+planetsAmmount+" done");
            }
        }
        System.out.println("Generated : "+overallOrbs+" Orbs in general. Sun: "+1+" Planets:"+planetsAmmount+" Moons:"+(overallOrbs-1-planetsAmmount));
        
        return system;
    }
    
    private Actor buildSun(World world){
        Material sunMat = new Material(new Color3f(Color.ORANGE));
        sunMat.setBackfaceCulling(true);
        sunMat.setShadeless(true);
        AIOrb sunAI = new AIOrb(world, null, world.getAIWorld(), null, AIOrb.Generate.SUN);
        Mesh sunMesh = new IcoSphere(orbRes).getSEMesh();
        sunMesh.getOffset().setScale(sunAI.getRadius(), sunAI.getRadius(), sunAI.getRadius());
        sunMesh.setRenderMode(Mesh.RenderMode.VBO);
        sunMesh.setMaterial(sunMat);
        Actor sunActor = new Actor(sunMesh, sunAI, null, world);
        sunAI.setActor(sunActor);
        return sunActor;
    }
    
    private List<Actor> buildPlanet(Actor sun, World world, int moonsMin, int moonsMax){
        List<Actor> orbs = new LinkedList<>();
        Material planetMaterial = new Material("scedata/textures/1024/others/debug-128.png");
        planetMaterial.setShadeless(false);
        planetMaterial.setBackfaceCulling(true);
        AIOrb planetAI = new AIOrb(world, null, world.getAIWorld(), (AIOrb) sun.getSEAI(), AIOrb.Generate.PLANET);
        Mesh planetMesh = new IcoSphere(orbRes).getSEMesh();
        planetMesh.getOffset().setScale(planetAI.getRadius(), planetAI.getRadius(), planetAI.getRadius());
        planetMesh.setMaterial(planetMaterial);
        planetMesh.setDisplayMode(Mesh.DisplayMode.SOLID);
        planetMesh.setRenderMode(Mesh.RenderMode.VBO);
        Actor planet = new Actor(planetMesh, planetAI, null, world);
        planetAI.setActor(planet);
        orbs.add(planet);
        for(int i = 0; i < SEUtils.get().randomInt(moonsMin, moonsMax); i++){
            orbs.add(buildMoon(planet, world));
        }
        return orbs;
    }
    
    private Actor buildMoon(Actor planet, World world){
        Material moonMaterial = new Material("scedata/textures/1024/planets/dark-astro.png");
        moonMaterial.setShadeless(false);
        moonMaterial.setBackfaceCulling(true);
        moonMaterial.setTestGen(false);
        AIOrb moonAI = new AIOrb(world, null, world.getAIWorld(), (AIOrb) planet.getSEAI(), AIOrb.Generate.MOON);
        Mesh moonMesh = new IcoSphere(orbRes).getSEMesh();
        moonMesh.setMaterial(moonMaterial);
        moonMesh.getOffset().setScale(moonAI.getRadius(), moonAI.getRadius(), moonAI.getRadius());
        moonMesh.setDisplayMode(Mesh.DisplayMode.SOLID);
        moonMesh.setRenderMode(Mesh.RenderMode.VBO);
        Actor moon = new Actor(moonMesh, moonAI, null, world);
        moonAI.setActor(moon);
        return moon;
    }
}
