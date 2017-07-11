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
import de.zray.se.audio.AudioSource;
import de.zray.se.grapics.semesh.SEMaterial;
import de.zray.se.grapics.modelloader.Modelloader;
import de.zray.se.grapics.semesh.SEMesh;
import de.zray.se.grapics.semesh.SEOriantation;
import javax.vecmath.Vector3f;

/**
 *
 * @author Vortex Acherontic
 */
public class SCEMainWorld extends SEWorld{
    
    @Override
    public void init(){
        //addGUI(new GUIMain(this));
        
        SEMesh stationMesh = Modelloader.get().loadModel("scedata/models/cron/warpstation/warpstation.obj");
        stationMesh.setMaterial(new SEMaterial("scedata/models/cron/warpstation/warpstation.jpg"));
        stationMesh.setRenderDist(50);
        SEActor station = new SEActor(stationMesh, null, null, this);
        station.setAI(new AIStation(this, station, this.getAIWorld()));
        station.setOriantation(new SEOriantation(0, 0, -20));
        
        SEMesh stationLOD0_5 = Modelloader.get().loadModel("scedata/models/cron/warpstation/warpstation-0.5.obj");
        stationLOD0_5.setMaterial(new SEMaterial("scedata/models/cron/warpstation/warpstation.jpg"));
        stationLOD0_5.setRenderDist(70);
        stationMesh.addLOD(stationLOD0_5);
        
        SEMesh stationLOD0_25 = Modelloader.get().loadModel("scedata/models/cron/warpstation/warpstation-0.25.obj");
        stationLOD0_25.setMaterial(new SEMaterial("scedata/models/cron/warpstation/warpstation.jpg"));
        stationLOD0_25.setRenderDist(80);
        stationMesh.addLOD(stationLOD0_25);
        
        SEMesh stationLOD0_0 = Modelloader.get().loadModel("scedata/models/cron/warpstation/warpstation-0.0.obj");
        stationLOD0_0.setMaterial(new SEMaterial("scedata/models/cron/warpstation/warpstation.jpg"));
        stationLOD0_0.setRenderDist(100);
        stationMesh.addLOD(stationLOD0_0);
        addSEActor(station);
        
        SEMesh lycanMesh = Modelloader.get().loadModel("scedata/models/wolfrim/lycan/lycan.obj");
        lycanMesh.setMaterial(new SEMaterial("scedata/models/wolfrim/lycan/lycan.png"));
        SEActor lycan = new SEActor(lycanMesh, null, null, this);
        lycan.setAI(new AILycan(this, lycan, this.getAIWorld()));
        addSEActor(lycan);
        
        SEActor lycan2 = new SEActor(lycanMesh, null, null, this);
        lycan.setAI(new AILycan(this, lycan, this.getAIWorld()));
        addSEActor(lycan2);
        
        addSEActor(new Planet().generatePlanet(this));
        
        Vector3f audioPos = new Vector3f(10, 0, 0);
        AudioSource laught = getAudioWorld().loadAudioFile("scedata/audio/sounds/laugh_06.ogg");
        laught.setPosition(audioPos);
        laught.playAsSound(true);
        
        getAudioWorld().loadAudioFile("scedata/audio/bgm/normal/rynos_theme.ogg").playAsMusic(true);
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
    }
}
