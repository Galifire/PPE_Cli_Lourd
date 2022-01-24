package models;

import entities.CabinetMedical;

import javax.swing.table.DefaultTableModel;
import java.util.HashSet;
import java.util.List;

public class ModelCabinetMedical extends DefaultTableModel {

    List<CabinetMedical> cabinetMedical;
    String[] colNames = {"CABNum", "Nom", "Adresse", "Effectif", "Horaires"};
    HashSet<CabinetMedical> hashSet = new HashSet<>();

    public ModelCabinetMedical(List<CabinetMedical> cabinetMedical) {
        this.cabinetMedical = cabinetMedical;
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
        return column != 0;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Object value = null;
        CabinetMedical cm = cabinetMedical.get(row);
        switch(column) {
            case 0: {
                value = cm.getCabNum();
                break;
            }
            case 1 : {
                value = cm.getNom();
                break;
            }
            case 2 : {
                value = cm.getAdresse();
                break;
            }
            case 3 : {
                value = cm.getEffectif();
                break;
            }
            case 4 : {
                value = cm.getHoraires();
                break;
            }
        }
        return value;
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        CabinetMedical cm = cabinetMedical.get(row);
        switch(column) {
            case 1 : {
                cm.setNom(aValue.toString());
                break;
            }
            case 2 : {
                cm.setAdresse(aValue.toString());
                break;
            }
            case 3 : {
                cm.setEffectif(Integer.parseInt(aValue.toString()));
                break;
            }
            case 4 : {
                cm.setHoraires(aValue.toString());
                break;
            }
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class<?> clazz = null;

        switch(columnIndex) {
            case 0 :
            case 3 : {
                clazz = Integer.class;
                break;
            }
            case 1 :
            case 2 :
            case 4 : {
                clazz = String.class;
                break;
            }
        }
        return clazz;
    }
}
