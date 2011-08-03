/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.wbbcoder.jsuba.view.main;

import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;
import de.wbbcoder.jsuba.util.ImageUtil;

/**
 *
 * @author SLU
 */
public class SplashScreen extends JWindow {

    public SplashScreen() {
        init();
    }
 
    private void init() {
        // BOUNDS
        int width = 300;
        int height = 100;
        int posX = (int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - width) / 2);
        int posY = (int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - height) / 2);
        this.setBounds(posX, posY, width, height);
        
        //JLabel loadingLabel = new JLabel(new ImageUtil().getIcon("loading.gif"));
        JLabel loadingLabel = new JLabel("Loading...");
        this.add(loadingLabel);
        
        this.setVisible(true);
    }
    
}
