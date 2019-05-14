/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.scenes.main;

import de.zray.sce.scenes.main.ais.AILycan;
import de.zray.sce.scenes.main.ais.AIStation;
import de.zray.se.world.Actor;
import de.zray.se.world.World;
import de.zray.se.graphics.Camera;
import de.zray.se.graphics.LightSource;
import de.zray.se.graphics.semesh.Material;
import de.zray.se.graphics.modelloader.Modelloader;
import de.zray.se.graphics.semesh.Mesh;

/**
 *
 * @author Vortex Acherontic
 */
public class SCEMainWorld extends World {
    
    @Override
    public void init(){
        addInputManager(new SpectatorInput(this));
        //addGUI(new GUIMain(this));
        Camera cam = new Camera();
        cam.setPerspectiveRendering(true);
        cam.setViewMode(Camera.ViewMode.EGO);
        cam.setClips(0.1f, 100000);
        cam.setRotation(0, 0, 0);
        
        int mainCam = this.addCamera(cam);
        this.setActiveCamera(mainCam);
        
        Mesh lycanMesh = Modelloader.get().loadModel("scedata/models/wolfrim/lycan/lycan.obj");
        Material lycanMat = new Material("scedata/models/wolfrim/lycan/lycan.png");
        lycanMat.setDiffuseColor(0.5f, 0.5f, 0.5f, 0);
        lycanMesh.setMaterial(lycanMat);
        lycanMesh.setRenderMode(Mesh.RenderMode.VBO);
        Actor lycan = new Actor(lycanMesh, null, null, this);
        lycan.setAI(new AILycan(this, lycan, this.getAIWorld()));
        addEntity(lycan);
        
        Actor lycan2 = new Actor(lycanMesh, null, null, this);
        lycan2.setAI(new AILycan(this, lycan2, this.getAIWorld()));
        addEntity(lycan2);

        /*List<Actor> system = new SystemGenerator().generateSystem(new int[]{1, 10}, new int[]{1, 4}, this);
        for(Actor tmp : system){
            addEntity(tmp);
        }*/
        
        System.out.println("========Station========");
        Mesh stationMesh = Modelloader.get().loadModel("scedata/models/cron/warpstation/warpstation.obj");
        Material stationMat = new Material("scedata/models/cron/warpstation/warpstation.png");
        stationMat.setDiffuseColor(0.5f, 0.5f, 0.5f, 0f);
        stationMat.setShadeless(false);
        stationMat.setBackfaceCulling(true);
        stationMesh.setMaterial(stationMat);
        stationMesh.setRenderDist(50);
        stationMesh.setRenderMode(Mesh.RenderMode.VBO);
        AIStation stationAI = new AIStation(this, null, getAIWorld());
        Actor station = new Actor(stationMesh, stationAI, null, this);
        stationAI.setActor(station);
        station.getOrientation().setScale(0.5, 0.5, 0.5);
        station.getOrientation().setPosition(0, 0, 0);
        
        System.out.println("========Station LODS========");
        Mesh stationLOD0_5 = Modelloader.get().loadModel("scedata/models/cron/warpstation/warpstation-0.5.obj");
        stationLOD0_5.setMaterial(stationMat);
        stationLOD0_5.setRenderDist(70);
        stationLOD0_5.setRenderMode(Mesh.RenderMode.VBO);
        stationMesh.setLOD(stationLOD0_5);
        
        Mesh stationLOD0_25 = Modelloader.get().loadModel("scedata/models/cron/warpstation/warpstation-0.25.obj");
        stationLOD0_25.setMaterial(stationMat);
        stationLOD0_25.setRenderDist(80);
        stationLOD0_25.setRenderMode(Mesh.RenderMode.VBO);
        stationLOD0_5.setLOD(stationLOD0_25);
        
        Mesh stationLOD0_0 = Modelloader.get().loadModel("scedata/models/cron/warpstation/warpstation-0.0.obj");
        stationLOD0_0.setMaterial(stationMat);
        stationLOD0_0.setRenderDist(-1);
        stationLOD0_0.setRenderMode(Mesh.RenderMode.VBO);
        stationLOD0_25.setLOD(stationLOD0_0);
        addEntity(station);
        
        int music = getAudioWorld().loadAudioFile("scedata/audio/bgm/normal/rynos_theme.ogg");
        getAudioWorld().getAudioSource(music).playAsMusic(true);
        //getAudioWorld().loadAudioFile("scedata/audio/bgm/battle/battle2.ogg").playAsMusic(false);
        /*Playlist playlist = new Playlist();
        playlist.addTrack("scedata/audio/bgm/battle/battle1.ogg");
        playlist.addTrack("scedata/audio/bgm/battle/battle2.ogg");
        playlist.addTrack("scedata/audio/bgm/battle/battle3.ogg");
        playlist.addTrack("scedata/audio/bgm/battle/battle4.ogg");
        playlist.addTrack("scedata/audio/bgm/battle/battle5.ogg");
        playlist.addTrack("scedata/audio/bgm/battle/battle6.ogg");
        playlist.addTrack("scedata/audio/bgm/battle/battle7.ogg");
        getAudioModule().setPlaylist(playlist);
        
        setInputManager(new SCEInputManager(this));
        getGLModule().getCurrentCamera().setViewMode(Camera.ViewMode.EGO);
        getGLModule().getCurrentCamera().setPosition(0, 10, 0);*/
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
