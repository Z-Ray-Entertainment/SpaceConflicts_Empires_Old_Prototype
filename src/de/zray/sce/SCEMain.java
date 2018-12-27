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
import de.zray.se.EngineSettings;
import de.zray.se.ai.SEAIWorld;
import de.zray.se.audio.SEAudioWorld;
import de.zray.renderbackends.opengl.GLRenderer;
import de.zray.renderbackends.vulkan.VKRenderer;
import de.zray.sce.scenes.test.BoundingBoxTest;
import de.zray.se.logger.SELogger;
import java.io.IOException;

/**
 * @author vortex
 */
public class SCEMain {
    private static final SCEMain sceMain = new SCEMain();
    
    public static void main(String[] args) throws IOException, Exception{
        EngineSettings.get().debug.debugMode = EngineSettings.DebugMode.DEBUG_AND_OBJECTS;
        EngineSettings.get().debug.renderOnTop = true;
        EngineSettings.get().debug.showGrid = false;
        EngineSettings.get().scene.dpSizes = null;
        EngineSettings.get().scene.dpSizes = new int[]{100, 10, 1};
        EngineSettings.get().debug.gridStep = 10;
        EngineSettings.get().window.resX = 1280;
        EngineSettings.get().window.resY = 720;
        EngineSettings.get().version = de.zray.sce.game.Settings.version+" "+de.zray.sce.game.Settings.suffix+" | Engine: "+EngineSettings.get().version;
        EngineSettings.get().title = de.zray.sce.game.Settings.name;
        
        if(args.length <= 0 ){
            sceMain.initSCE(0);
        } else {
            sceMain.initSCE(Integer.parseInt(args[0]));
        }
    }
    
    private void initSCE(int scene) throws IOException, Exception{
        final MainThread mainThread = new MainThread();
        if(!mainThread.setRenderBackend(new VKRenderer())){
            SELogger.get().dispatchMsg(this, SELogger.SELogType.WARNING, new String[]{"Vulkan Renderer not supported!", "Switching to Legacy Open GL Renderer!"}, false);
            if(!mainThread.setRenderBackend(new GLRenderer())){
                throw new Exception("No supported renderer!");
            } else {
                SELogger.get().dispatchMsg(this, SELogger.SELogType.INFO, new String[]{"Using Open GL Renderer"}, false);
            }
        } else {
            SELogger.get().dispatchMsg(this, SELogger.SELogType.INFO, new String[]{"Using Vulkan Renderer"}, false);
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
