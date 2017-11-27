/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.scenes.test;

import de.zray.sce.scenes.main.SpectatorInput;
import de.zray.se.world.SEActor;
import de.zray.se.world.SEWorld;
import de.zray.se.graphics.semesh.SEMesh;
import de.zray.se.graphics.shapes.Plane;
import de.zray.se.graphics.Camera;
import de.zray.se.graphics.semesh.SEMaterial;

/**
 *
 * @author vortex
 */
public class TextureTest extends SEWorld{

    @Override
    public void init() {
        addInputManager(new SpectatorInput(this));
        SEMesh plane = new Plane(1, 1, false).getSEMesh();
        plane.getOrientation().setRotation(-90, 0, 0);
        plane.getOrientation().setPosition(0, 0, -10);
        //plane.setMaterial(new SEMaterial("scedata/models/wolfrim/lycan/lycan.png"));
        plane.setMaterial(new SEMaterial("scedata/models/cron/warpstation/warpstation.png"));
        plane.setRenderMode(SEMesh.RenderMode.VBO);
        plane.getMaterial().setShadeless(true);
        
        Camera cam = new Camera();
        cam.setPerspectiveRendering(true);
        cam.setViewMode(Camera.ViewMode.EGO);
        cam.setRotation(90, 0, 0);
        int camId= addCamera(cam);
        setActiveCamera(camId);
        
        addSEActor(new SEActor(plane, null, null, this));
    }
    
}
