/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.unigen.orbs;

import de.zray.se.SEActor;
import de.zray.se.SEWorld;
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
        rootSphere.setRenderDist(25);
        rootSphere.setBackfaceCulling(true);
        rootSphere.setDisplayMpode(SEMesh.DisplayMode.WIRED);
        rootSphere.setRenderMode(SEMesh.RenderMode.VBO);
        
        SEMesh lod_1 = new IcoSphere(radius, 3).getSEMesh();
        lod_1.setBackfaceCulling(true);
        lod_1.setDisplayMpode(SEMesh.DisplayMode.WIRED);
        lod_1.setRenderMode(SEMesh.RenderMode.VBO);
        
        SEMesh lod_2 = new IcoSphere(radius, 2).getSEMesh();
        lod_2.setBackfaceCulling(true);
        lod_2.setDisplayMpode(SEMesh.DisplayMode.WIRED);
        lod_2.setRenderMode(SEMesh.RenderMode.VBO);
        
        SEMesh lod_3 = new Plane(radius, radius, false).getSEMesh();
        lod_3.setBackfaceCulling(true);
        lod_3.setDisplayMpode(SEMesh.DisplayMode.WIRED);
        lod_3.setRenderMode(SEMesh.RenderMode.VBO);
        
        rootSphere.addLOD(lod_1, 50);
        rootSphere.addLOD(lod_2, 100);
        rootSphere.addLOD(lod_3, 1000);
        
        SEActor planet = new SEActor(rootSphere, null, null, system);
        planet.setAI(new AIPlanet(system, planet, system.getAIModule()));
        return planet;
    }
}
