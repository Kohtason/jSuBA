/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.wbbcoder.jsuba.view.items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import de.wbbcoder.jsuba.controller.ControllerInterface;
import de.wbbcoder.jsuba.controller.items.DisplayItemsController;
import de.wbbcoder.jsuba.view.Listener;

/**
 *
 * @author SLU
 */
class DisplayItemsListener extends Listener {
    
    private DisplayItemsController controller;
    private DisplayItemsView view;

    public DisplayItemsListener(DisplayItemsView view, DisplayItemsController controller) {
        this.controller = controller;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(view.getCreateItemButton())) {
            controller.createItem();
        }
    }
    
}
