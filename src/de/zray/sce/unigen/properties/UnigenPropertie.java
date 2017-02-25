/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.unigen.properties;

import de.zray.sce.utils.SCEUtils;
import java.util.Random;


/**
 *
 * @author Vortex Acherontic
 */
public abstract class UnigenPropertie {
    private int range[] = new int[2];
    
    public UnigenPropertie(int min, int max){
        range[0] = min;
        range[1] = max;
    }
    
    public int randomAmount(){
            return SCEUtils.getRandomInt(range[0], range[1]);
    }
}
