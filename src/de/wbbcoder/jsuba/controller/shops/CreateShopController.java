/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.wbbcoder.jsuba.controller.shops;

import de.wbbcoder.jsuba.controller.ControllerInterface;
import de.wbbcoder.jsuba.model.shop.ShopDTO;
import de.wbbcoder.jsuba.service.ShopService;
import de.wbbcoder.jsuba.view.main.AppWindow;
import de.wbbcoder.jsuba.view.shops.CreateShopView;

/**
 *
 * @author SLU
 */
public class CreateShopController implements ControllerInterface {

    private AppWindow window;
    private CreateShopView view;
    
    public CreateShopController(AppWindow window) {
        this.window = window;
        // view = new CreateShopView(window, this);
        createDummyShop();
    }
 
    private void createDummyShop() {
        ShopDTO shopDTO = new ShopDTO("ALDI");
        new ShopService().createShop(shopDTO);
        System.out.println("--");
    }

    @Override
    public void receiveEvent() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean terminate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
