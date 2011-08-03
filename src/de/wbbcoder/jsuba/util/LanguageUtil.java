/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.wbbcoder.jsuba.util;

import java.util.ResourceBundle;

/**
 *
 * @author SLU
 */
public class LanguageUtil {
    
    private static LanguageUtil languageUtil;
    private ResourceBundle bundle;
    
    private LanguageUtil() {
        bundle = ResourceBundle.getBundle("de.wbbcoder.jsuba.properties.lang.jSuBA");
    }
    
    public static LanguageUtil getInstance() {
        if(null == languageUtil) {
            languageUtil = new LanguageUtil();
        }
        return languageUtil;
    }
    
    public String getString(String s) {
        return bundle.getString(s);
    }
    
}
