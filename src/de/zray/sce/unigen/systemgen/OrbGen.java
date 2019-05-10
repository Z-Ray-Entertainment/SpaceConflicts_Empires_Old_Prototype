/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.unigen.systemgen;

import de.zray.se.graphics.semesh.Material;
import de.zray.se.utils.SEUtils;
import de.zray.se.world.Actor;
import java.awt.Color;
import javax.vecmath.Color3f;

/**
 *
 * @author vortex
 */
public class OrbGen {
    public static enum OrbType {PLANET, MOON, SUN}
    
    public Actor generateOrb(OrbType type){
        return null;
    }
    
    private Material genMaterial(boolean sun){
        SEUtils seUtils = new SEUtils();
        return new Material(new Color3f(Color.GRAY));

    }

}