/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.zray.sce.gui.main.buttons;

import de.zray.sce.gui.SCEButton;
import de.zray.se.SEWorld;
import de.zray.zgui.GUI;
import de.zray.zgui.exceptions.InvalidRangeException;

/**
 *
 * @author Vortex Acherontic
 */
public class BTNewGame extends SCEButton{
    public BTNewGame(GUI parrent, SEWorld parrentWorld) throws InvalidRangeException {
        super(parrent, parrentWorld);
    }

    @Override
    public void idleAction() {
    }

    @Override
    public void onMouseClickAction(int mouseButton) {
    }

    @Override
    public void onMousePressedAction(int mouseButton) {
    }

    @Override
    public void onOpenGUIAction() {
        //DO To
    }

    @Override
    public void onCloseGUIAction() {
    }

    @Override
    public void onKeyTipedAction(int key) {
    }

    @Override
    public void onKeyPressedAction(int key) {
    }
    
}
