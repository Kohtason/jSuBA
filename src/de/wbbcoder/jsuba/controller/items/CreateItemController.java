/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.wbbcoder.jsuba.controller.items;

import java.util.ArrayList;
import java.util.List;
import de.wbbcoder.jsuba.controller.ControllerInterface;
import de.wbbcoder.jsuba.model.Brand.BrandDTO;
import de.wbbcoder.jsuba.model.item.ItemDTO;
import de.wbbcoder.jsuba.view.items.CreateItemView;
import de.wbbcoder.jsuba.view.items.CreateItemViewNB;
import de.wbbcoder.jsuba.view.main.AppWindow;

/**
 *
 * @author SLU
 */
public class CreateItemController implements ControllerInterface {

    private AppWindow appWindow;
    private CreateItemViewNB view;
    
    public CreateItemController(AppWindow appWindow) {
        this.appWindow = appWindow;
        
        // TESTCODE TODO ---
        
        BrandDTO rioba = new BrandDTO("Rioba");
        List<BrandDTO> brands = new ArrayList<BrandDTO>(); 
        brands.add(rioba);
        
        ItemDTO item = new ItemDTO();
        item.setBrand(rioba);
        item.setDescription("Schokomuffins");
        List<ItemDTO> items = new ArrayList<ItemDTO>(); 
        items.add(item);
        
        // END TESTCODE TODO ---
        
        
        view = new CreateItemViewNB(this, brands, items);
        appWindow.setView(view);
    }
    
    @Override
    public void receiveEvent() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean terminate() {
        // TODO ----
        return true;
    }
    
}
