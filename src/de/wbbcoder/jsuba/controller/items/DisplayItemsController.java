/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.wbbcoder.jsuba.controller.items;

import de.wbbcoder.jsuba.controller.ControllerInterface;
import de.wbbcoder.jsuba.view.items.DisplayItemsView;
import de.wbbcoder.jsuba.view.main.AppWindow;

/**
 *
 * @author SLU
 */
public class DisplayItemsController implements ControllerInterface {

    private AppWindow appWindow;
    private DisplayItemsView view;
    
    public DisplayItemsController(AppWindow appWindow) {
        this.appWindow = appWindow;
        view = new DisplayItemsView(this);
        appWindow.setView(view);
    }
    
    @Override
    public void receiveEvent() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean terminate() {
       // throw new UnsupportedOperationException("Not supported yet.");
        return true;
    }
    
    public void createItem() {
        appWindow.getController().createItem();
    }
    
}
