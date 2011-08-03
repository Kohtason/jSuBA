/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.wbbcoder.jsuba.model.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import de.wbbcoder.jsuba.constants.LangConstants;
import de.wbbcoder.jsuba.util.LanguageUtil;

/**
 *
 * @author SLU
 */
public class ItemTableModel extends AbstractTableModel {

    private List<HashMap<String, Object>> data;
    private List<TableModelListener> modelListeners;
    private String [] columns;
    
    public ItemTableModel() {
        modelListeners = new ArrayList<TableModelListener>();
        data = new ArrayList<HashMap<String, Object>>();
        
        columns = new String[7];
        columns[0] = LanguageUtil.getInstance().getString(LangConstants.ITEM_NAME);
        columns[1] = LanguageUtil.getInstance().getString(LangConstants.ITEM_PRICE);
        columns[2] = LanguageUtil.getInstance().getString(LangConstants.ITEM_AMOUNT);
        columns[3] = LanguageUtil.getInstance().getString(LangConstants.ITEM_TOTAL_PRICE);
        columns[4] = LanguageUtil.getInstance().getString(LangConstants.CATEGORY);
        columns[5] = LanguageUtil.getInstance().getString(LangConstants.SHOP);
        columns[6] = LanguageUtil.getInstance().getString(LangConstants.ITEM_DATE);
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return getValueAt(rowIndex, columns[columnIndex]);
    }
    
    public Object getValueAt(int rowIndex, String column) {
        return data.get(rowIndex).get(column);
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        setValueAt(aValue, rowIndex, columns[columnIndex]);
    }
    
    public void setValueAt(Object aValue, int rowIndex, String column) {
        data.get(rowIndex).remove(column);
        data.get(rowIndex).put(column, aValue);
    }
    
    @Override
    public void addTableModelListener(TableModelListener l) {
        modelListeners.add(l);
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        modelListeners.remove(l);
    }
    
    public void addRow(ItemDTO item) {
        HashMap<String, Object> newEntry = new HashMap();
        newEntry.put("OBJECTHOLDER", item);
        newEntry.put(columns[0], item.getDescription());
        newEntry.put(columns[1], item.getPrice());
        newEntry.put(columns[2], item.getAmount());
        newEntry.put(columns[3], item.getDescription());
        newEntry.put(columns[4], item.getCategory().getName());
        newEntry.put(columns[5], item.getShop().getName());
        newEntry.put(columns[6], item.getBuyingDate());
        data.add(newEntry);
    }

    public String[] getColumns() {
        return columns;
    }
    
    
}
