/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.wbbcoder.jsuba.model.itemCategory;

import java.util.List;
import de.wbbcoder.jsuba.model.item.ItemDTO;

/**
 *
 * @author SLU
 */
public class ItemCategoryDTO {
    
    private int id;
    private String name;
    private ItemCategoryDTO superCategory;
    private List<ItemDTO> items;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemCategoryDTO getSuperCategory() {
        return superCategory;
    }

    public void setSuperCategory(ItemCategoryDTO superCategory) {
        this.superCategory = superCategory;
    }
    
}
