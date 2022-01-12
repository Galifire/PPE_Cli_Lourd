package models;

import entities.Commandes;

import javax.swing.table.DefaultTableModel;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;

public class ModelCommandes extends DefaultTableModel {

    List<Commandes> commande;
    String[] colNames = {"CDENum", "CLINum", "MEDICCode", "DateCde", "Qte"};
    HashSet<Commandes> hashSet = new HashSet<>();

    public ModelCommandes(List<Commandes> commande) {
        this.commande = commande;
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
        Commandes c = commande.get(row);
        switch(column) {
            case 0: {
                value = c.getCdeNum();
                break;
            }
            case 1 : {
                value = c.getCliNum();
                break;
            }
            case 2 : {
                value = c.getMedicCode();
                break;
            }
            case 3 : {
                value = c.getDateCde();
                break;
            }
            case 4 : {
                value = c.getQte();
                break;
            }
        }
        return value;
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        Commandes c = commande.get(row);
        switch(column) {
            case 1 : {
                c.setCliNum(Integer.parseInt(aValue.toString()));
                break;
            }
            case 2 : {
                c.setMedicCode(aValue.toString());
                break;
            }
            case 3 : {
                c.setDateCde(aValue.toString());
                break;
            }
            case 4 : {
                c.setQte(Integer.parseInt(aValue.toString()));
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
            case 4 : {
                clazz = Integer.class;
                break;
            }
            case 2 :
            case 3 : {
                clazz = String.class;
                break;
            }
        }
        return clazz;
    }
}
