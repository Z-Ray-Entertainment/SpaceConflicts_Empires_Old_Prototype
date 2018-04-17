/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.scenes.test;

import de.zray.sce.scenes.main.SpectatorInput;
import de.zray.se.world.Actor;
import de.zray.se.world.World;
import de.zray.se.graphics.semesh.Mesh;
import de.zray.se.graphics.shapes.Plane;
import de.zray.se.graphics.Camera;
import de.zray.se.graphics.semesh.Material;

/**
 *
 * @author vortex
 */
public class TextureTest extends World{

    @Override
    public void init() {
        addInputManager(new SpectatorInput(this));
        Mesh plane = new Plane(1, 1, false).getSEMesh();
        plane.getOffset().setRotation(-90, 0, 0);
        plane.getOffset().setPosition(0, 0, -10);
        //plane.setMaterial(new SEMaterial("scedata/models/wolfrim/lycan/lycan.png"));
        plane.setMaterial(new Material("scedata/models/cron/warpstation/warpstation.png"));
        plane.setRenderMode(Mesh.RenderMode.VBO);
        plane.getMaterial().setShadeless(true);
        
        Camera cam = new Camera();
        cam.setPerspectiveRendering(true);
        cam.setViewMode(Camera.ViewMode.EGO);
        cam.setRotation(90, 0, 0);
        int camId= addCamera(cam);
        setActiveCamera(camId);
        
        addEntity(new Actor(plane, null, null, this));
    }
    
}
