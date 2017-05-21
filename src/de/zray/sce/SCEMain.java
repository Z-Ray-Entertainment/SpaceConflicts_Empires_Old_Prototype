/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce;

import de.zray.sce.scenes.main.SCEMainWorld;
import de.zray.sce.test.Console;
import de.zray.se.MainThread;
import de.zray.se.SEWorld;
import de.zray.se.Settings;
import de.zray.se.logger.SELogger;
import de.zray.se.renderbackend.GLRenderer;
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
        //test();
        //SCEMainWorld mainWorld = new SCEMainWorld();
        MainThread mainThread = new MainThread();
        mainThread.setRenderBackend(new GLRenderer());
        mainThread.loop(null);
    }
    
    private static void test(){
        Console console = new Console();
        console.setVisible(true);
        SELogger.get().registerDispatcherHook(console);
    }
}
