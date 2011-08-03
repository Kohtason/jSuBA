/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.wbbcoder.jsuba.view.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import de.wbbcoder.jsuba.controller.main.AppWindowController;

/**
 *
 * @author SLU
 */
class AppWindowListener implements ActionListener {

    private AppWindow window;
    private AppWindowController controller;
    
    public AppWindowListener(AppWindow window, AppWindowController controller) {
        this.window = window;
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == window.getToolBarItemCreate()) {
            controller.createItem();
        } else if(source == window.getToolBarItemView()) {
            controller.viewItems();
        } else if(source == window.getToolBarShopCreate()) {
            controller.createShop();
        } else {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
    
}
