/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.units;

import de.zray.sce.universe.Updateable;

/**
 *
 * @author Vortex Acherontic
 */
public abstract class Upgrade implements Updateable{
    private Unit unit;
    
    public Upgrade(Unit unit){
        this.unit = unit;
    }
    
    public abstract void upgrade();
}
