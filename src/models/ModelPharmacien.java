package models;

import entities.Pharmacien;
import javax.swing.table.DefaultTableModel;
import java.util.HashSet;
import java.util.List;

public class ModelPharmacien extends DefaultTableModel {

    List<Pharmacien> pharmacien;
    String[] colNames = {"PHNum", "Nom", "Prénom", "Email", "Telephone", "PHARNum"};
    HashSet<Pharmacien> hashSet = new HashSet<>();

    public ModelPharmacien(List<Pharmacien> pharmacien) {
        this.pharmacien = pharmacien;
    }

    public String[] getColNames() {
        return this.colNames;
    }

    public int getRowCount() {
        return super.getRowCount();
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
        return false;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Object value = null;
        Pharmacien ph = pharmacien.get(row);
        switch(column) {
            case 0: {
                value = ph.getPhNum();
                break;
            }
            case 1 : {
                value = ph.getNom();
                break;
            }
            case 2 : {
                value = ph.getPrenom();
                break;
            }
            case 3 : {
                value = ph.getEmail();
                break;
            }
            case 4 : {
                value = ph.getTelephone();
                break;
            }
            case 5 : {
                value = ph.getPharNum();
                break;
            }
        }
        return value;
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        Pharmacien ph = pharmacien.get(row);
        switch(column) {
            case 1 : {
                ph.setNom(aValue.toString());
                break;
            }
            case 2 : {
                ph.setPrenom(aValue.toString());
                break;
            }
            case 3 : {
                ph.setEmail(aValue.toString());
                break;
            }
            case 4 : {
                ph.setTelephone(aValue.toString());
                break;
            }
            case 5 : {
                ph.setPharNum(Integer.parseInt(aValue.toString()));
                break;
            }
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class<?> clazz = null;

        switch(columnIndex) {
            case 0 :
            case 5 : {
                clazz = Integer.class;
                break;
            }
            case 1 :
            case 2 :
            case 3 :
            case 4 : {
                clazz = String.class;
                break;
            }
        }
        return clazz;
    }
}
