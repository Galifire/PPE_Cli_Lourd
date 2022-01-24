package models;

import entities.Stocks;

import javax.swing.table.DefaultTableModel;
import java.util.HashSet;
import java.util.List;

public class ModelStock extends DefaultTableModel {
    List<Stocks> stock;
    String[] colNames = {"MEDICCode", "CABNum", "Qte"};
    HashSet<Stocks> hashSet = new HashSet<>();

    public ModelStock(List<Stocks> stock) {
        this.stock = stock;
    }

    public int getRowCount() {
        return super.getRowCount();
    }

    public String[] getColNames() {
        return this.colNames;
    }

    @Override
    public int getColumnCount() {
        return (colNames.length);
    }

    @Override
    public String getColumnName(int column) {
        return super.getColumnName(column);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return column != 0;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Object value = null;
        Stocks s = stock.get(row);
        switch(column) {
            case 0: {
                value = s.getMedicNum();
                break;
            }
            case 1 : {
                value = s.getPharNum();
                break;
            }
            case 2 : {
                value = s.getQte();
                break;
            }
        }
        return value;
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        Stocks s = stock.get(row);
        switch(column) {
            case 0 : {
                s.setMedicNum(Integer.parseInt(aValue.toString()));
            }
            case 1 : {
                s.setPharNum(Integer.parseInt(aValue.toString()));
                break;
            }
            case 2 : {
                s.setQte(Integer.parseInt(aValue.toString()));
                break;
            }
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class<?> clazz = null;
        switch(columnIndex) {
            case 0 :
            case 1 :
            case 2 : {
                clazz = Integer.class;
            }
        }
        return clazz;
    }
}
