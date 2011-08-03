/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.wbbcoder.jsuba.view.items;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import de.wbbcoder.jsuba.constants.LangConstants;
import de.wbbcoder.jsuba.controller.ControllerInterface;
import de.wbbcoder.jsuba.model.Brand.BrandDTO;
import de.wbbcoder.jsuba.model.item.ItemDTO;
import de.wbbcoder.jsuba.util.LanguageUtil;
import de.wbbcoder.jsuba.view.View;
import de.wbbcoder.jsuba.view.components.InfoButton;
import de.wbbcoder.jsuba.view.components.Spacer;

/**
 *
 * @author SLU
 */
public class CreateItemView extends View {
  
    private LanguageUtil languageUtil;
    private ControllerInterface controller;
    private GridBagLayout layout;
    private List<BrandDTO> suggestedBrands;
    private List<ItemDTO> suggestedItems;
    
    public CreateItemView(ControllerInterface controller, List<BrandDTO> brands, List<ItemDTO> items) {
        this.controller = controller;
        languageUtil = LanguageUtil.getInstance();
        init();
        this.setSuggestedBrands(brands);
        this.setSuggestedItems(items);
    }
    
    private void init() {
        layout = new GridBagLayout();
        this.setLayout(layout);

        brandInput = new JComboBox();
        brandInput.setEditable(true);
        nameInput = new JComboBox();
        nameInput.setEditable(true);
        
        this.addComponent(new JLabel(languageUtil.getString(LangConstants.CREATE_ITEM)), 1, 1, 6, 1);
        this.addComponent(new Spacer(Spacer.TAPSTOP), 1, 3, 1, 1);
        this.addComponent(new JLabel(languageUtil.getString(LangConstants.ITEM_NAME)+": "), 2, 3, 1, 1);
        this.addComponent(brandInput, 3, 3, 1, 1);
        this.addComponent(new Spacer(Spacer.SEP_BETWEEN_COMPONENTS), 4, 3, 1, 1);
        this.addComponent(nameInput, 5, 3, 1, 1);
        this.addComponent(new InfoButton(languageUtil.getString(LangConstants.INFOTEXT_ITEMNAME)), 6, 3, 1, 1);
        
        
        this.addComponent(new Spacer(Spacer.SEP_BETWEEN_COMPONENTS), 10, 10, 1, 1, 1, 1);
    }
    
    private JComboBox brandInput;
    private JComboBox nameInput;

    private void addComponent(
            Component c,
            int x, int y,
            int width, int height) {
        this.addComponent(c, x, y, width, height, 0, 0);
    }
    
    private void addComponent(
            Component c,
            int x, int y,
            int width, int height,
            double weightx, double weighty) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        layout.setConstraints(c, gbc);
        this.add(c);
    }

    public void setSuggestedBrands(List<BrandDTO> suggestedBrands) {
        brandInput.removeAllItems();
        this.suggestedBrands = suggestedBrands;
        for (BrandDTO brand : this.suggestedBrands) {
            brandInput.addItem(new BrandName(brand));
        }
    }

    public void setSuggestedItems(List<ItemDTO> suggestedItems) {
        nameInput.removeAllItems();
        this.suggestedItems = suggestedItems;
        for (ItemDTO item : this.suggestedItems) {
            nameInput.addItem(new ItemName(item));
        }
    }
    
    private class BrandName {
        private BrandDTO brand;
        private String brandName;
        
        public BrandName(BrandDTO brand) {
            this.brand = brand;
            this.brandName = brand.getName();
        }
        
        @Override
        public String toString() {
            return brandName;
        }
    }
    
    private class ItemName {
        private ItemDTO item;
        private String itemName;
        
        public ItemName(ItemDTO item) {
            this.item = item;
            this.itemName = item.getDescription();
        }
        
        @Override
        public String toString() {
            return itemName;
        }
    }
    
}
