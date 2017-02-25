/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.units;

import de.zray.sce.game.Orientation;
import de.zray.sce.universe.UnitGroup;
import de.zray.sce.universe.Updateable;
import java.util.List;

/**
 *
 * @author Vortex Acherontic
 */
public abstract class Unit implements Updateable{
    private Orientation ori;
    private UnitGroup unitGroup;
    private List<Upgrade> upgrades;
    
    public void setUnitGroup(UnitGroup group){
        this.unitGroup = group;
    }
}
