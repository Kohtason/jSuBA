/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.wbbcoder.jsuba.view.components;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import de.wbbcoder.jsuba.util.ImageUtil;

/**
 *
 * @author SLU
 */
public class InfoButton extends JLabel {
    
    private String infoText;
    private int maxWidth = 50;
    
    public InfoButton(String infoText) {
        this.setInfoText(infoText);
        init();
    }
    
    private void init() {
        this.setIcon(new ImageUtil().getIcon("16/information.png"));
        this.setBorder(new EmptyBorder(0, 2, 0, 2));
        this.setToolTipText(infoText);
    }
    
    public void setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
        this.setInfoText(infoText);
    }
    
    public void setInfoText(String infoText) {
        infoText = infoText.trim();
        infoText.replaceAll("<html>", "");
        infoText.replaceAll("</html>", "");
        StringBuilder sb = new StringBuilder(infoText);
        int changes = 0;
        for (int i = maxWidth; i < infoText.length(); i += maxWidth) {
            int pos = 0;
            for (int a = i; infoText.charAt(a) != ' '; a--) {
                pos = a;
            }
            int newPos = pos - 1 - (changes * 4);
            if(newPos > 0) {
                sb.insert(newPos, "<br>");
            }
            changes++;
        }
        sb.append("</html>");
        sb.insert(0, "<html>");
        this.infoText = sb.toString();
    }
    
}
