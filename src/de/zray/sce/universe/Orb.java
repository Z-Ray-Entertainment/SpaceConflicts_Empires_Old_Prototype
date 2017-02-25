/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.universe;

import de.zray.sce.units.Unit;
import de.zray.sce.game.Orientation;
import java.util.LinkedList;
import java.util.List;
import javax.vecmath.Vector3d;
/**
 *
 * @author Vortex Acherontic
 */
public abstract class Orb implements Updateable{
    private Orientation ori;
    private double gravity;
    private List<Orb> orbs;
    private List<Unit> units;
    
    public abstract void applyForce(Vector3d  force);

    public void setOrientation(Orientation ori){
        this.ori = ori;
    }
    
    public Orientation getOrientation(){
        return ori;
    }
    
    public void setGravity(double gravity){
        this.gravity = gravity;
    }
    
    public double getGravity(){
        return gravity;
    }
    
    @Override
    public boolean update() {
        if(containsUnit()){
            if(units != null){
                for(Unit tmp : units){
                    if(!tmp.update()){
                        return false;
                    }
                }
            }
            if(orbs != null){
                for(Orb tmp : orbs){
                    if(!tmp.update()){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public boolean containsUnit() {
        if(units != null && !units.isEmpty()){
            return true;
        }
        else{
            if(orbs != null){
                for(Orb tmp : orbs){
                    if(tmp.containsUnit()){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public void addOrb(Orb orb){
        if(orbs == null){
            orbs = new LinkedList<>();
        }
        orbs.add(orb);
    }
    
    public void removeOrb(Orb orb){
        orbs.remove(orb);
    }
    
    public void addUnit(Unit unit){
        if(units == null){
            units = new LinkedList<>();
        }
        units.add(unit);
    }
    
    public void removeUnit(Unit unit){
        units.remove(unit);
    }
}
