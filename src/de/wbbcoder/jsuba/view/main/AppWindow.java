package de.wbbcoder.jsuba.view.main;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import de.wbbcoder.jsuba.constants.LangConstants;
import de.wbbcoder.jsuba.controller.main.AppWindowController;
import de.wbbcoder.jsuba.util.ImageUtil;
import de.wbbcoder.jsuba.util.LanguageUtil;
import de.wbbcoder.jsuba.view.View;

/**
 *
 * @author SLU
 */
public class AppWindow extends JFrame {
    
    private View view;
    private LanguageUtil languageUtil;
    private AppWindowListener listener;
    private AppWindowController controller;
    
    public AppWindow(AppWindowController controller) {
        languageUtil = LanguageUtil.getInstance();
        this.controller = controller;
        listener = new AppWindowListener(this, controller);
        init();
    }
    
    private void init() {
        
        // CONFIG
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle(languageUtil.getString(LangConstants.APP_NAME));
        this.setIconImage(new ImageUtil().getIcon("32/total_plan_cost.png").getImage());
        
        // LAF
//        try {
//            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(AppWindow.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            Logger.getLogger(AppWindow.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            Logger.getLogger(AppWindow.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (UnsupportedLookAndFeelException ex) {
//            Logger.getLogger(AppWindow.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        // MENU BAR
        toolBar = new JMenuBar();
        
        // Items
        toolBarItem = new JMenu(languageUtil.getString(LangConstants.MENUBAR_ITEM));
        toolBarItem.setIcon(new ImageUtil().getIcon("16/basket.png"));
        toolBarItem.setMnemonic(KeyEvent.VK_E);
        
        toolBarItemView = new JMenuItem(languageUtil.getString(LangConstants.SHOW_ITEMS));
        toolBarItemView.setIcon(new ImageUtil().getIcon("16/basket_edit.png"));
        toolBarItemView.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));
        toolBarItem.add(toolBarItemView);
        toolBarItemView.addActionListener(listener);
        
        toolBarItemCreate = new JMenuItem(languageUtil.getString(LangConstants.CREATE_ITEM));
        toolBarItemCreate.setIcon(new ImageUtil().getIcon("16/basket_add.png"));
        toolBarItemCreate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK));
        toolBarItem.add(toolBarItemCreate);
        toolBarItemCreate.addActionListener(listener);
        
        toolBarItemStatistics = new JMenuItem(languageUtil.getString(LangConstants.STATISTICS));
        toolBarItemStatistics.setIcon(new ImageUtil().getIcon("16/statistics.png"));
        toolBarItemStatistics.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
        toolBarItem.add(toolBarItemStatistics);
        toolBarItemStatistics.addActionListener(listener);
        
        // Categories
        toolBarCategory = new JMenu(languageUtil.getString(LangConstants.MENUBAR_CATEGORIES));
        toolBarCategory.setIcon(new ImageUtil().getIcon("16/tag_blue.png"));
        toolBarCategory.setMnemonic(KeyEvent.VK_K);
        
        toolBarCategoryView = new JMenuItem(languageUtil.getString(LangConstants.SHOW_CATEGORIES));
        toolBarCategoryView.setIcon(new ImageUtil().getIcon("16/tag_blue_edit.png"));
        toolBarCategoryView.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));
        toolBarCategory.add(toolBarCategoryView);
        toolBarCategoryView.addActionListener(listener);
        
        toolBarCategoryCreate = new JMenuItem(languageUtil.getString(LangConstants.CREATE_CATEGORIES));
        toolBarCategoryCreate.setIcon(new ImageUtil().getIcon("16/tag_blue_add.png"));
        toolBarCategoryCreate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK));
        toolBarCategory.add(toolBarCategoryCreate);
        toolBarCategoryCreate.addActionListener(listener);
        
        // Shop
        toolBarShop = new JMenu(languageUtil.getString(LangConstants.MENUBAR_SHOPS));
        toolBarShop.setIcon(new ImageUtil().getIcon("16/building.png"));
        toolBarShop.setMnemonic(KeyEvent.VK_S);
        
        toolBarShopView = new JMenuItem(languageUtil.getString(LangConstants.SHOW_SHOPS));
        toolBarShopView.setIcon(new ImageUtil().getIcon("16/building_edit.png"));
        toolBarShopView.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));
        toolBarShop.add(toolBarShopView);
        toolBarShopView.addActionListener(listener);
        
        toolBarShopCreate = new JMenuItem(languageUtil.getString(LangConstants.CREATE_SHOPS));
        toolBarShopCreate.setIcon(new ImageUtil().getIcon("16/building_add.png"));
        toolBarShopCreate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK));
        toolBarShop.add(toolBarShopCreate);
        toolBarShopCreate.addActionListener(listener);
        
        // Help
        toolBarHelp = new JMenu(languageUtil.getString(LangConstants.MENUBAR_HELP));
        toolBarHelp.setIcon(new ImageUtil().getIcon("16/help.png"));
        toolBarHelp.setMnemonic(KeyEvent.VK_H);
        
        toolBarHelpAbout = new JMenuItem(languageUtil.getString(LangConstants.ABOUT));
        toolBarHelpAbout.setIcon(new ImageUtil().getIcon("16/information.png"));
        toolBarHelpAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.ALT_MASK));
        toolBarHelp.add(toolBarHelpAbout);
        toolBarHelpAbout.addActionListener(listener);
        
        toolBar.add(toolBarItem);
        toolBar.add(toolBarCategory);
        toolBar.add(toolBarShop);
        // TODO -- Seperator
        toolBar.add(toolBarHelp);
        this.setJMenuBar(toolBar);
        
        // MAIN PANEL
        viewContainer = new JPanel();
        this.add(viewContainer);
        
        // BOUNDS
        int width = 700;
        int height = 400;
        int posX = (int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - width) / 2);
        int posY = (int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - height) / 2);
        this.setBounds(posX, posY, width, height);
    }
    
    public void setView(View view) {
        this.remove(viewContainer);
        this.viewContainer = view;
        this.add(viewContainer);
        this.paintComponents(this.getGraphics());
    }

    public JMenuItem getToolBarCategoryCreate() {
        return toolBarCategoryCreate;
    }

    public JMenuItem getToolBarCategoryView() {
        return toolBarCategoryView;
    }

    public JMenuItem getToolBarHelpAbout() {
        return toolBarHelpAbout;
    }

    public JMenuItem getToolBarItemCreate() {
        return toolBarItemCreate;
    }

    public JMenuItem getToolBarItemStatistics() {
        return toolBarItemStatistics;
    }

    public JMenuItem getToolBarItemView() {
        return toolBarItemView;
    }

    public JMenuItem getToolBarShopCreate() {
        return toolBarShopCreate;
    }

    public JMenuItem getToolBarShopView() {
        return toolBarShopView;
    }

    public AppWindowController getController() {
        return controller;
    }
    
    private JMenuBar toolBar;
    private JMenu toolBarItem;
    private JMenuItem toolBarItemCreate;
    private JMenuItem toolBarItemView;
    private JMenuItem toolBarItemStatistics;
    private JMenu toolBarCategory;
    private JMenuItem toolBarCategoryCreate;
    private JMenuItem toolBarCategoryView;
    private JMenu toolBarShop;
    private JMenuItem toolBarShopCreate;
    private JMenuItem toolBarShopView;
    private JMenu toolBarHelp;
    private JMenuItem toolBarHelpAbout;
    
    private JPanel viewContainer;
    
}
