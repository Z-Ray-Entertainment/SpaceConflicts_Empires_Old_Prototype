/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.universe;

import de.zray.sce.universe.celectialbody.CelectialBody;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author vortex
 */
public class Universe {
    private List<CelectialBody> bodies = new LinkedList();
    
    public void addBodie(CelectialBody body){
        this.bodies.add(body);
    }
    
    public List<CelectialBody> getBodies(){
        return bodies;
    }
}
