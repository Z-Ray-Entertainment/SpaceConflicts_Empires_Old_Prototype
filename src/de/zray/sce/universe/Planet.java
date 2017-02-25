/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.universe;

import de.zray.sce.units.Unit;
import java.util.List;
import javax.vecmath.Vector3d;

/**
 *
 * @author Vortex Acherontic
 */
public class Planet extends Orb{
    private float radius, gravity;
    private Surface surface;
    private List<Unit> units;
    private List<Orb> moons;
    
    @Override
    public boolean update() {
        if(!surface.update()){
            return false;
        }
        for(Unit tmp : units){
            if(!tmp.update()){
                return false;
            }
        }
        for(Orb tmp : moons){
            if(!tmp.update()){
                return false;
            }
        }
        return true;
    }

    @Override
    public void applyForce(Vector3d force) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsUnit() {
        if(surface != null){
            if(surface.containsUnit()){
                return true;
            }
        }
        if(moons != null){
            
        }
        if(!units.isEmpty()){
            return true;
        }
        return false;
    }
}
