/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.scenes.test;

import de.zray.se.SEActor;
import de.zray.se.SEWorld;
import de.zray.se.grapics.semesh.SEMesh;
import de.zray.se.grapics.shapes.Plane;

/**
 *
 * @author vortex
 */
public class TextureTest extends SEWorld{

    @Override
    public void init() {
        SEMesh plane = new Plane(1, 1, false).getSEMesh();
        
        addSEActor(new SEActor(plane, null, null, this));
    }
    
}
