/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.wbbcoder.jsuba.view.components;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author SLU
 */
public class Spacer extends JLabel {
    
    public static final int SEP_BETWEEN_COMPONENTS = 5;
    public static final int TAPSTOP = 20;
    
    public Spacer(int space) {
        super();
        this.setBorder(new EmptyBorder(0, space, 0, 0));
    }
    
}
