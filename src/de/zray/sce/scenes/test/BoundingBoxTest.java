/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.scenes.test;

import de.zray.sce.scenes.main.SpectatorInput;
import de.zray.sce.scenes.main.ais.AILycan;
import de.zray.sce.scenes.main.ais.AIStation;
import de.zray.sce.unigen.orbs.SystemGenerator;
import de.zray.se.graphics.Camera;
import de.zray.se.graphics.LightSource;
import de.zray.se.graphics.modelloader.Modelloader;
import de.zray.se.graphics.semesh.Material;
import de.zray.se.graphics.semesh.Mesh;
import de.zray.se.world.Actor;
import de.zray.se.world.World;
import java.util.List;

/**
 *
 * @author vortex
 */
public class BoundingBoxTest extends World {

    @Override
    public void init() {
        addInputManager(new SpectatorInput(this));
        //addGUI(new GUIMain(this));
        Camera cam = new Camera();
        cam.setPerspectiveRendering(true);
        cam.setViewMode(Camera.ViewMode.EGO);
        cam.setClips(0.1f, 100000);
        cam.setRotation(0, 0, 0);
        
        int mainCam = this.addCamera(cam);
        this.setActiveCamera(mainCam);
        
        System.out.println("========Station========");
        Mesh stationMesh = Modelloader.get().loadModel("scedata/models/cron/warpstation/warpstation.obj");
        Material stationMat = new Material("scedata/models/cron/warpstation/warpstation.png");
        stationMat.setDiffuseColor(0.5f, 0.5f, 0.5f, 0f);
        stationMat.setShadeless(false);
        stationMat.setBackfaceCulling(true);
        stationMesh.setMaterial(stationMat);
        stationMesh.setRenderDist(1000);
        stationMesh.setRenderMode(Mesh.RenderMode.VBO);
        AIStation stationAI = new AIStation(this, null, getAIWorld());
        Actor station = new Actor(stationMesh, stationAI, null, this);
        stationAI.setActor(station);
        station.getOrientation().setScale(0.5, 0.5, 0.5);
        station.getOrientation().setPosition(0, 0, 0);
        addEntity(station);
        
        cam.setLookAt(station.getOrientation().getPositionVec());
        cam.setClips(1, 1000);
        
        LightSource sun = new LightSource();
        sun.setLightType(LightSource.Type.SUN);
        sun.setColor(LightSource.DIFFUSE, 1f, 0.6352f, 0f, 0);
        sun.setColor(LightSource.AMBIENT, 0f, 0f, 0f, 1f);
        sun.setColor(LightSource.SPECULAR, 1, 1, 1, 1);
        addEntity(sun);
    }
    
}
