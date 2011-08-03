/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.wbbcoder.jsuba.view.shops;

import com.sun.tools.internal.xjc.api.J2SJAXBModel;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import de.wbbcoder.jsuba.controller.ControllerInterface;
import de.wbbcoder.jsuba.view.main.AppWindow;

/**
 *
 * @author SLU
 */
public class CreateShopView extends JOptionPane {
    
    ControllerInterface controller;

    public CreateShopView(AppWindow appWindow, ControllerInterface controller) {
        this.controller = controller;
        JOptionPane.showInputDialog(appWindow, "", "", JOptionPane.OK_CANCEL_OPTION);
        this.init();
    }
    
    private void init() {
        
//        this.pack();
//        
//        // BOUNDS
//        int width = this.getWidth();
//        int height = this.getHeight();
//        int posX = (int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - width) / 2);
//        int posY = (int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - height) / 2);
//        this.setBounds(posX, posY, width, height);
//        
        this.setVisible(true);
    }
}
