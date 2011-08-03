/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.wbbcoder.jsuba.view;

import javax.swing.JPanel;

/**
 *
 * @author SLU
 */
public class View extends JPanel {

    private Listener listener;

    public Listener getListener() {
        return listener;
    }

    protected void setListener(Listener listener) {
        this.listener = listener;
    }
    
}
