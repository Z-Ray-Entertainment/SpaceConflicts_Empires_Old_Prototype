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
public class Surface implements Updateable{
    private List<Unit> units;
    
    @Override
    public boolean update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsUnit() {
        if(units != null){
            return units.isEmpty();
        }
        return false;
    }
    
}
