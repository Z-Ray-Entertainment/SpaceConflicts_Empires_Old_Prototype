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
import de.zray.se.grapics.shapes.Plane;

/**
 *
 * @author Vortex Acherontic
 */
public class Planet {
    public SEActor generatePlanet(SEWorld system){
        float radius = (float) (Math.random()*10);
        SEMesh rootSphere = new IcoSphere(radius, 4).getSEMesh();
        SEMaterial surface = createMaterial();
        rootSphere.setRenderDist(25);
        rootSphere.setMaterial(surface);
        rootSphere.setDisplayMode(SEMesh.DisplayMode.WIRED);
        rootSphere.setRenderMode(SEMesh.RenderMode.VBO);
        
        SEMesh lod_1 = new IcoSphere(radius, 3).getSEMesh();
        
        lod_1.setMaterial(surface);
        lod_1.setDisplayMode(SEMesh.DisplayMode.WIRED);
        lod_1.setRenderMode(SEMesh.RenderMode.VBO);
        
        SEMesh lod_2 = new IcoSphere(radius, 2).getSEMesh();
        lod_2.setMaterial(surface);
        lod_2.setDisplayMode(SEMesh.DisplayMode.WIRED);
        lod_2.setRenderMode(SEMesh.RenderMode.VBO);
        
        SEMesh lod_3 = new Plane(radius, radius, false).getSEMesh();
        lod_3.setMaterial(surface);
        lod_3.setDisplayMode(SEMesh.DisplayMode.WIRED);
        lod_3.setRenderMode(SEMesh.RenderMode.VBO);
        
        rootSphere.addLOD(lod_1);
        rootSphere.addLOD(lod_2);
        rootSphere.addLOD(lod_3);
        
        SEActor planet = new SEActor(rootSphere, null, null, system);
        planet.setAI(new AIPlanet(system, planet, system.getAIWorld()));
        return planet;
    }
    
    private SEMaterial createMaterial(){
        SEMaterial surface = new SEMaterial();
        surface.setBackfaceCulling(true);
        return surface;
    }
}
