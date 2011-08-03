/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.wbbcoder.jsuba.model.item;

import java.util.Date;
import de.wbbcoder.jsuba.model.Brand.BrandDTO;
import de.wbbcoder.jsuba.model.itemCategory.ItemCategoryDTO;
import de.wbbcoder.jsuba.model.shop.ShopDTO;

/**
 *
 * @author SLU
 */
public class ItemDTO {
    
    private int id;
    private String description;
    private BrandDTO brand;
    private double price;
    private ShopDTO shop;
    private int amount;
    private Date buyingDate;
    private ItemCategoryDTO category;
    
    // 1 = kg; 2 = ltr; 3 = stck;
    private int itemType;
    private double packageContent;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPackageContent() {
        return packageContent;
    }

    public void setPackageContent(double packageContent) {
        this.packageContent = packageContent;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ShopDTO getShop() {
        return shop;
    }

    public void setShop(ShopDTO shop) {
        this.shop = shop;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getBuyingDate() {
        return buyingDate;
    }

    public void setBuyingDate(Date buyingDate) {
        this.buyingDate = buyingDate;
    }

    public ItemCategoryDTO getCategory() {
        return category;
    }

    public void setCategory(ItemCategoryDTO category) {
        this.category = category;
    }

    public BrandDTO getBrand() {
        return brand;
    }

    public void setBrand(BrandDTO brand) {
        this.brand = brand;
    }
    
}
