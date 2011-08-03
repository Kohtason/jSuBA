/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.wbbcoder.jsuba.view.items;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import de.wbbcoder.jsuba.constants.LangConstants;
import de.wbbcoder.jsuba.controller.ControllerInterface;
import de.wbbcoder.jsuba.controller.items.DisplayItemsController;
import de.wbbcoder.jsuba.model.item.ItemDTO;
import de.wbbcoder.jsuba.model.item.ItemTableModel;
import de.wbbcoder.jsuba.model.itemCategory.ItemCategoryDTO;
import de.wbbcoder.jsuba.model.shop.ShopDTO;
import de.wbbcoder.jsuba.util.ImageUtil;
import de.wbbcoder.jsuba.util.LanguageUtil;
import de.wbbcoder.jsuba.view.View;

/**
 *
 * @author SLU
 */
public class DisplayItemsView extends View {
    
    private LanguageUtil languageUtil;
    private DisplayItemsController controller;
    private ItemTableModel itemTableModel;

    public DisplayItemsView(DisplayItemsController controller) {
        this.controller = controller;
        languageUtil = LanguageUtil.getInstance();
        itemTableModel = new ItemTableModel();
        init();
    }
    
    private void init() {
        this.setListener(new DisplayItemsListener(this, controller));
        
        this.setLayout(new BorderLayout(10, 10));
        
        table = new JTable(itemTableModel);
        table.setAutoCreateColumnsFromModel(true);
        
        ShopDTO shop = new ShopDTO();
        shop.setName("ALDI");
        
        ItemCategoryDTO category = new ItemCategoryDTO();
        category.setName("Einwegtest");
        
        ItemDTO item = new ItemDTO();
        item.setAmount(2);
        item.setBuyingDate(new Date());
        item.setCategory(category);
        item.setDescription("TestItem");
        item.setShop(shop);
        item.setPackageContent(3);
        item.setPrice(2.99);
        
        itemTableModel.addRow(item);
        
        createItemButton = new JButton(languageUtil.getString(LangConstants.CREATE_ITEM), new ImageUtil().getIcon("16/basket_add.png"));
        createItemButton.addActionListener(this.getListener());
        
        this.add(new JScrollPane(table), BorderLayout.CENTER);
        
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        southPanel.add(createItemButton);
        
        this.add(new JLabel(), BorderLayout.WEST);
        this.add(new JLabel(), BorderLayout.EAST);
        this.add(new JLabel(), BorderLayout.NORTH);
        this.add(southPanel, BorderLayout.SOUTH);
    }

    public JButton getCreateItemButton() {
        return createItemButton;
    }
    
    private JTable table;
    private JButton createItemButton;
    
}
