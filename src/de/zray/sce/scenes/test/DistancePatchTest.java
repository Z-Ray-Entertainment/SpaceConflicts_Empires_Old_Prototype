/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.scenes.test;

import de.zray.sce.scenes.main.SpectatorInput;
import de.zray.sce.scenes.test.ai.AIStationTest;
import de.zray.se.graphics.Camera;
import de.zray.se.graphics.modelloader.Modelloader;
import de.zray.se.graphics.semesh.Material;
import de.zray.se.graphics.semesh.Mesh;
import de.zray.se.world.Actor;
import de.zray.se.world.World;

/**
 *
 * @author vortex
 */
public class DistancePatchTest extends World{

    @Override
    public void init() {
        addInputManager(new SpectatorInput(this));
        Camera cam = new Camera();
        cam.setPerspectiveRendering(true);
        cam.setViewMode(Camera.ViewMode.EGO);
        cam.setClips(0.1f, 10000);
        cam.setRotation(90, 0, 0);
        int mainCam = this.addCamera(cam);
        this.setActiveCamera(mainCam);
        
        Mesh stationMesh = Modelloader.get().loadModel("scedata/models/cron/warpstation/warpstation.obj");
        Material stationMat = new Material("scedata/models/cron/warpstation/warpstation.png");
        stationMat.setDiffuseColor(0.5f, 0.5f, 0.5f, 0f);
        stationMat.setShadeless(true);
        stationMat.setBackfaceCulling(true);
        stationMesh.setMaterial(stationMat);
        stationMesh.setRenderDist(1000);
        stationMesh.setRenderMode(Mesh.RenderMode.VBO);
        AIStationTest stationAI = new AIStationTest(this, null, getAIWorld());
        Actor station = new Actor(stationMesh, stationAI, null, this);
        stationAI.setActor(station);
        station.getOrientation().setScale(0.5, 0.5, 0.5);
        station.getOrientation().setPosition(0, 10, 10);
        addEntity(station);
    }
}
