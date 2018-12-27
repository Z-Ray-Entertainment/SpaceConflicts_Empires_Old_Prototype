/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce;

import de.zray.sce.scenes.main.SCEMainWorld;
import de.zray.sce.scenes.test.DistancePatchTest;
import de.zray.sce.scenes.test.TextureTest;
import de.zray.se.MainThread;
import de.zray.se.Settings;
import de.zray.se.ai.SEAIWorld;
import de.zray.se.audio.SEAudioWorld;
import de.zray.renderbackends.opengl.GLRenderer;
import de.zray.sce.scenes.test.BoundingBoxTest;
import java.io.IOException;

/**
 * @author vortex
 */
public class SCEMain {
    private static SCEMain sceMain = new SCEMain();
    
    public static void main(String[] args) throws IOException, Exception{
        Settings.get().debug.debugMode = Settings.DebugMode.DEBUG_AND_OBJECTS;
        Settings.get().debug.renderOnTop = true;
        Settings.get().debug.showGrid = false;
        Settings.get().scene.dpSizes = null;
        Settings.get().scene.dpSizes = new int[]{100, 10, 1};
        Settings.get().debug.gridStep = 10;
        Settings.get().window.resX = 1280;
        Settings.get().window.resY = 720;
        Settings.get().version = de.zray.sce.game.Settings.version+" "+de.zray.sce.game.Settings.suffix+" | Engine: "+Settings.get().version;
        Settings.get().title = de.zray.sce.game.Settings.name;
        
        if(args.length < 1){
            sceMain.initSCE(0);
        } else {
            sceMain.initSCE(Integer.parseInt(args[0]));
        }
    }
    
    private void initSCE(int scene) throws IOException, Exception{
        final MainThread mainThread = new MainThread();
        if(!mainThread.setRenderBackend(new GLRenderer())){
            throw new Exception("No supported renderer!");
        }
        
        switch(scene){
            case 0 :
                SCEMainWorld mainWorld = new SCEMainWorld();
                SEAIWorld aiWorld = new SEAIWorld(mainWorld);
                SEAudioWorld audioWorld = new SEAudioWorld(mainWorld);
                mainWorld.setAIWorld(aiWorld);
                mainWorld.setAudioWorld(audioWorld);
                mainWorld.init();
                mainThread.switchWorld(mainWorld);
                break;
            case 1 :
                TextureTest textureTest = new TextureTest();
                textureTest.init();
                mainThread.switchWorld(textureTest);
                break;
            case 2 :
                DistancePatchTest dpTest = new DistancePatchTest();
                dpTest.setAIWorld(new SEAIWorld(dpTest));
                dpTest.init();
                mainThread.switchWorld(dpTest);
                break;
            case 3 :
                BoundingBoxTest bbTest = new BoundingBoxTest();
                bbTest.setAIWorld(new SEAIWorld(bbTest));
                bbTest.init();
                mainThread.switchWorld(bbTest);
                break;
        }
        
        mainThread.loop();
    }
}
