/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.wbbcoder.jsuba.controller.main;


import java.util.logging.Level;
import java.util.logging.Logger;
import de.wbbcoder.jsuba.controller.ControllerInterface;
import de.wbbcoder.jsuba.controller.items.CreateItemController;
import de.wbbcoder.jsuba.controller.items.DisplayItemsController;
import de.wbbcoder.jsuba.controller.shops.CreateShopController;
import de.wbbcoder.jsuba.view.main.AppWindow;
import de.wbbcoder.jsuba.view.main.SplashScreen;

/**
 *
 * @author SLU
 */
public class AppWindowController {
    
    private AppWindow appWindow;
    private ControllerInterface controller;

    public AppWindowController() {
        SplashScreen splashScreen = new SplashScreen();   
        appWindow = new AppWindow(this);
        
        // Default entrypoint for the application
        this.viewItems();
        
        appWindow.setVisible(true);
        splashScreen.dispose();   
        splashScreen = null;
        
        // DBTEST
        dbTest();
    }
    
    private void dbTest() {

        
        
    }
    
    private boolean terminateController() {
        boolean success = false;
        if(null == controller) {
            success = true;
        } else {
            success = controller.terminate();
        }
        return success;
    }
    
    public void createItem() {
        if(this.terminateController()) {
            controller = new CreateItemController(appWindow);
        }
    }
    
    public void viewItems() {
        if(this.terminateController()) {
            controller = new DisplayItemsController(appWindow);
        }
    }
    
    public void createShop() {
         if(this.terminateController()) {
            controller = new CreateShopController(appWindow);
        }       
    }
    
}
