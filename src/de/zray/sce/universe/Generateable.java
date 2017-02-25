/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.universe;

import de.zray.sce.unigen.properties.UnigenPropertie;

/**
 *
 * @author Vortex Acherontic
 */
public interface Generateable {
    public void generate();
    public void setProperties(UnigenPropertie... prop);
}
