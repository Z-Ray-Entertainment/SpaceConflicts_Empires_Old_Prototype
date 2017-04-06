/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.test.cmds;

import de.zray.sce.test.Console;
import de.zray.coretex.AbstractCommand;
import de.zray.coretex.Parameter;
import java.util.List;

/**
 *
 * @author Vortex Acherontic
 */
public class ToogleDispatcherHook extends AbstractCommand{
    Console console;
    
    public ToogleDispatcherHook(Console console) {
        super("togglehook", null);
        this.console = console;
    }

    @Override
    public String action(List<Parameter> params) {
        console.toogleHook();
        return "Logger hook toggled.";
    }
    
}
