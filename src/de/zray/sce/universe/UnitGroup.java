/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.universe;

import de.zray.sce.units.Unit;
import java.util.List;

/**
 *
 * @author Vortex Acherontic
 */
public class UnitGroup {
    private List<Unit> units;
    private String name;
    
    public void addUnit(Unit unit){
        units.add(unit);
    }
    
    public void removeUnit(Unit unit){
        units.remove(unit);
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
}
