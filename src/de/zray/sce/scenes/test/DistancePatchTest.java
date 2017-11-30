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
import de.zray.se.graphics.semesh.SEMaterial;
import de.zray.se.graphics.semesh.SEMesh;
import de.zray.se.world.SEActor;
import de.zray.se.world.SEWorld;

/**
 *
 * @author vortex
 */
public class DistancePatchTest extends SEWorld{

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
        
        SEMesh stationMesh = Modelloader.get().loadModel("scedata/models/cron/warpstation/warpstation.obj");
        SEMaterial stationMat = new SEMaterial("scedata/models/cron/warpstation/warpstation.png");
        stationMat.setDiffuseColor(0.5f, 0.5f, 0.5f, 0f);
        stationMat.setShadeless(true);
        stationMat.setBackfaceCulling(true);
        stationMesh.setMaterial(stationMat);
        stationMesh.setRenderDist(1000);
        stationMesh.setRenderMode(SEMesh.RenderMode.DIRECT);
        AIStationTest stationAI = new AIStationTest(this, null, getAIWorld());
        SEActor station = new SEActor(stationMesh, stationAI, null, this);
        stationAI.setActor(station);
        station.getOrientation().setScale(0.5, 0.5, 0.5);
        station.getOrientation().setPosition(0, 0, -20);
        addSEActor(station);
    }
}
