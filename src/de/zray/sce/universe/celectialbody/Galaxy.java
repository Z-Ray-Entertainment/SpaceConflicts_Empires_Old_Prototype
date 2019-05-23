/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.universe.celectialbody;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author vortex
 */
public class Galaxy extends CelectialBody{
    private List<CelectialBody> bodies = new LinkedList();
    
    public void addCelectialBody(CelectialBody body){
        this.bodies.add(body);
    }
    
    public LinkedList<CelectialBody> getBodyies(){
        return (LinkedList<CelectialBody>) bodies;
    }
}
