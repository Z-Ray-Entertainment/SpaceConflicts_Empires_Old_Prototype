/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.unigen.properties;

/**
 *
 * @author Vortex Acherontic
 */
public class InvalidIDException extends Exception{
    public InvalidIDException(){
        super("The specified ID is invalid");
    }
}
