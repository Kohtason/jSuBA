/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.wbbcoder.jsuba.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import de.wbbcoder.jsuba.model.shop.ShopDTO;

/**
 *
 * @author SLU
 */
public class ShopService {

    private EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("ShopDTO");

    public ShopService() {
    }
    
    public void createShop(ShopDTO shopDTO) {
        EntityManager em = emf.createEntityManager();
        em.persist(shopDTO);
        em.close();
    }
    
}
