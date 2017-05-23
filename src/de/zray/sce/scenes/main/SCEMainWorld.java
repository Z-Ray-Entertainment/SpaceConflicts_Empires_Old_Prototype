/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.scenes.main;

import de.zray.sce.scenes.main.ais.AILycan;
import de.zray.sce.scenes.main.ais.AIStation;
import de.zray.sce.unigen.orbs.Planet;
import de.zray.se.SEActor;
import de.zray.se.SEWorld;
import de.zray.se.grapics.semesh.SEMaterial;
import de.zray.se.grapics.modelloader.Modelloader;
import de.zray.se.grapics.semesh.SEMesh;
import de.zray.se.grapics.semesh.SEOriantation;

/**
 *
 * @author Vortex Acherontic
 */
public class SCEMainWorld extends SEWorld{
    
    @Override
    public void init(){
        //addGUI(new GUIMain(this));
        
        SEActor station = new SEActor("scedata/models/cron/warpstation/warpstation.obj", new SEMaterial("scedata/models/cron/warpstation/warpstation.jpg"));
        station.setAI(new AIStation(this, station, this.getAIWorld()));
        station.getSEMesh().setOrientation(new SEOriantation(0, 0, -20));
        station.getSEMesh().setRenderDist(50);
        SEMesh stationLOD0_5 = Modelloader.get().loadModel("scedata/models/cron/warpstation/warpstation-0.5.obj");
        stationLOD0_5.setMaterial(new SEMaterial("scedata/models/cron/warpstation/warpstation.jpg"));
        station.getSEMesh().addLOD(stationLOD0_5, 70);
        
        SEMesh stationLOD0_25 = Modelloader.get().loadModel("scedata/models/cron/warpstation/warpstation-0.25.obj");
        stationLOD0_25.setMaterial(new SEMaterial("scedata/models/cron/warpstation/warpstation.jpg"));
        station.getSEMesh().addLOD(stationLOD0_25, 80);
        
        SEMesh stationLOD0_0 = Modelloader.get().loadModel("scedata/models/cron/warpstation/warpstation-0.0.obj");
        stationLOD0_0.setMaterial(new SEMaterial("scedata/models/cron/warpstation/warpstation.jpg"));
        station.getSEMesh().addLOD(stationLOD0_0, 100);
        addSEActor(station);
        
        SEActor lycan = new SEActor("scedata/models/wolfrim/lycan/lycan.obj", new SEMaterial("scedata/models/wolfrim/lycan/lycan.png"));
        lycan.setAI(new AILycan(this, lycan, this.getAIWorld()));
        addSEActor(lycan);
        
        SEActor lycan2 = new SEActor("scedata/models/wolfrim/lycan/lycan.obj", new SEMaterial("scedata/models/wolfrim/lycan/lycan.png"));
        lycan2.setAI(new AILycan(this, lycan2, this.getAIWorld()));
        addSEActor(lycan2);
        
        addSEActor(new Planet().generatePlanet(this));
        
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
    }
}
