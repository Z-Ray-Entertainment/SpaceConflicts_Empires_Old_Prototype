/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce;

import de.zray.sce.scenes.main.SCEMainWorld;
import de.zray.se.MainThread;
import de.zray.se.Settings;
import de.zray.se.ai.SEAIWorld;
import de.zray.se.audio.SEAudioWorld;
import de.zray.se.renderbackend.opengl.GLRenderer;
import de.zray.zgui.exceptions.InvalidRangeException;
import java.io.IOException;

/**
 * @author vortex
 */
public class SCEMain {
    public static void main(String[] args) throws IOException, InvalidRangeException{
        Settings.get().debug.debugMode = Settings.DebugMode.DEBUG_AND_OBJECTS;
        Settings.get().window.resX = 1280;
        Settings.get().window.resY = 720;
        Settings.get().version = de.zray.sce.game.Settings.version+" "+de.zray.sce.game.Settings.suffix;
        Settings.get().title = de.zray.sce.game.Settings.name;
        //test();
        SCEMainWorld mainWorld = new SCEMainWorld();
        SEAIWorld aiWorld = new SEAIWorld(mainWorld);
        SEAudioWorld audioWorld = new SEAudioWorld(mainWorld);
        mainWorld.setAIWorld(aiWorld);
        mainWorld.setAudioWorld(audioWorld);
        mainWorld.init();
        
        final MainThread mainThread = new MainThread();
        mainThread.setRenderBackend(new GLRenderer());
        mainThread.switchWorld(mainWorld);
        
        mainThread.loop();
    }
    
    private static void test(){
        
    }
}
