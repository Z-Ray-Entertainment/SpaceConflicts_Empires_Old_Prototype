/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.universe.celectialbody.solarsystem;

import de.zray.sce.universe.celectialbody.CelectialBody;

/**
 *
 * @author vortex
 */
public class Sun extends CelectialBody {
    public static enum MagnitudeType{BROWN_DWARF, WHITE_DWARF, RED_DWARF, SUB_DWARF, 
    DWARF, SUB_GIANT, GIANT, BRIGHT_GIANT, SUPER_GIANT, HYPER_GIANT, BLACK_HOLE}
    public static enum SpectralType{O, B, A, F, G, K, M, L, T}
    
    private MagnitudeType mag;
    private SpectralType spec;
    
    public void setMagnitudeType(MagnitudeType mag){
        this.mag = mag;
    }
    
    public MagnitudeType getMagnitude(){
        return mag;
    }
    
    public void setSpectralType(SpectralType spec){
        this.spec = spec;
    }
    
    public SpectralType getSpectralType(){
        return spec;
    }
}
