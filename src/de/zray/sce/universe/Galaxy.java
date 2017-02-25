/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.universe;

import de.zray.sce.game.Orientation;
import de.zray.sce.game.Settings;
import de.zray.sce.unigen.properties.UnigenPropertie;
import de.zray.sce.utils.SCEUtils;
import javax.vecmath.Vector3d;

/**
 *
 * @author Vortex Acherontic
 */
public class Galaxy extends Orb implements Generateable{
    
    public Galaxy(){
        Vector3d pos = new Vector3d(SCEUtils.randomKoorinate(Settings.genScaleUniverse),
                SCEUtils.randomKoorinate(Settings.genScaleUniverse),
                SCEUtils.randomKoorinate(Settings.genScaleUniverse));
        Vector3d rot = new Vector3d(SCEUtils.randomAngle(), 
                SCEUtils.randomAngle(), SCEUtils.randomAngle());
        setOrientation(new Orientation(pos, rot));
    }
    
    @Override
    public void applyForce(Vector3d force) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsUnit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void generate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setProperties(UnigenPropertie... prop) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
