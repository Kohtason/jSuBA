package de.wbbcoder.jsuba.util;

import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author SLU
 */
public class ImageUtil {
    
    public ImageUtil() {
    }
    
    public ImageIcon getIcon(String icon) {
        URL imgURL = getClass().getClassLoader().getResource("de/wbbcoder/jsuba/images/" + icon);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + icon);
            return new ImageIcon();
        }
    }
    
}
