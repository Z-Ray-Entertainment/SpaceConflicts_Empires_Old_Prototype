/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.scenes.main;

import de.zray.sce.scenes.main.ais.AILycan;
import de.zray.sce.scenes.main.ais.AIStation;
import de.zray.sce.unigen.orbs.SystemGenerator;
import de.zray.se.SEActor;
import de.zray.se.SEWorld;
import de.zray.se.grapics.Camera;
import de.zray.se.grapics.semesh.SEMaterial;
import de.zray.se.grapics.modelloader.Modelloader;
import de.zray.se.grapics.semesh.SEMesh;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

/**
 *
 * @author Vortex Acherontic
 */
public class SCEMainWorld extends SEWorld implements KeyListener{
    
    @Override
    public void init(){
        addInputManager(new SpectatorInput(this));
        //addGUI(new GUIMain(this));
        Camera cam = new Camera();
        cam.setPerspectiveRendering(true);
        cam.setViewMode(Camera.ViewMode.EGO);
        cam.setRotation(90, 0, 0);
        
        int mainCam = this.addCamera(cam);
        this.setActiveCamera(mainCam);
        
        SEMesh lycanMesh = Modelloader.get().loadModel("scedata/models/wolfrim/lycan/lycan.obj");
        lycanMesh.setMaterial(new SEMaterial("scedata/models/wolfrim/lycan/lycan.png"));
        lycanMesh.setRenderMode(SEMesh.RenderMode.VBO);
        SEActor lycan = new SEActor(lycanMesh, null, null, this);
        lycan.setAI(new AILycan(this, lycan, this.getAIWorld()));
        addSEActor(lycan);
        
        SEActor lycan2 = new SEActor(lycanMesh, null, null, this);
        lycan.setAI(new AILycan(this, lycan, this.getAIWorld()));
        addSEActor(lycan2);

        List<SEActor> system = new SystemGenerator().generateSystem(new int[]{0, 10}, new int[]{0, 8}, this);
        for(SEActor tmp : system){
            addSEActor(tmp);
        }
        
        System.out.println("========Station========");
        SEMesh stationMesh = Modelloader.get().loadModel("scedata/models/cron/warpstation/warpstation.obj");
        SEMaterial stationMat = new SEMaterial("scedata/models/cron/warpstation/warpstation.jpg");
        stationMat.setDiffuseColor(0.5f, 0.5f, 0.5f, 0f);
        stationMat.setShadeless(true);
        stationMat.setBackfaceCulling(true);
        stationMesh.setMaterial(stationMat);
        stationMesh.setRenderDist(1000);
        stationMesh.setRenderMode(SEMesh.RenderMode.DIRECT);
        AIStation stationAI = new AIStation(this, null, getAIWorld());
        SEActor station = new SEActor(stationMesh, stationAI, null, this);
        stationAI.setActor(station);
        station.setAI(new AIStation(this, station, this.getAIWorld()));
        station.getOrientation().setScale(0.5, 0.5, 0.5);
        station.getOrientation().setPosition(0, 0, -20);
        
        System.out.println("========Station LODS========");
        SEMesh stationLOD0_5 = Modelloader.get().loadModel("scedata/models/cron/warpstation/warpstation-0.5.obj");
        stationLOD0_5.setMaterial(stationMat);
        stationLOD0_5.setRenderDist(70);
        stationLOD0_5.setRenderMode(SEMesh.RenderMode.VBO);
        stationMesh.addLOD(stationLOD0_5);
        
        SEMesh stationLOD0_25 = Modelloader.get().loadModel("scedata/models/cron/warpstation/warpstation-0.25.obj");
        stationLOD0_25.setMaterial(stationMat);
        stationLOD0_25.setRenderDist(80);
        stationLOD0_25.setRenderMode(SEMesh.RenderMode.VBO);
        stationMesh.addLOD(stationLOD0_25);
        
        SEMesh stationLOD0_0 = Modelloader.get().loadModel("scedata/models/cron/warpstation/warpstation-0.0.obj");
        stationLOD0_0.setMaterial(stationMat);
        stationLOD0_0.setRenderDist(100);
        stationLOD0_0.setRenderMode(SEMesh.RenderMode.VBO);
        stationMesh.addLOD(stationLOD0_0);
        addSEActor(station);
        
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
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("KeyPressed: "+e.paramString());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("KeyPressed: "+e.paramString());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
