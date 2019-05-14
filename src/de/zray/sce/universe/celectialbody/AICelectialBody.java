/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.universe.celectialbody;

import de.zray.se.ai.SEAI;

/**
 *
 * @author Vortex Acherontic
 */
public class AICelectialBody extends SEAI{
    private CelectialBody body;
    
    
    public AICelectialBody(CelectialBody body){
        super(null, null, null);
        this.body = body;
    }
    
    @Override
    public void act(double delta) {
        if(body.hasCenter()){
            
        } else {
            
        }
    }
}
