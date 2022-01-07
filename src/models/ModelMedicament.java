package models;

import entities.Medicaments;

import javax.swing.table.DefaultTableModel;
import java.util.HashSet;
import java.util.List;

public class ModelMedicament extends DefaultTableModel {
    List<Medicaments> medicaments;
    String[] colNames = {"MEDICCode", "Nom", "Restrictions", "DelaiProduction"};
    HashSet<Medicaments> hashSet = new HashSet<>();

    public ModelMedicament(List<Medicaments> medicaments) {
        this.medicaments = medicaments;
    }

    public int getRowCount() {
        return super.getRowCount();
    }

    @Override
    public int getColumnCount() {
        return (colNames.length +1);
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
        Medicaments m = medicaments.get(row);
        switch(column) {
            case 0: {
                value = m.getMedicCode();
                break;
            }
            case 1 : {
                value = m.getNom();
                break;
            }
            case 2 : {
                value = m.getRestrictions();
                break;
            }
            case 3 : {
                value = m.getDelaiProduction();
                break;
            }
        }
        return value;
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        Medicaments m = medicaments.get(row);
        switch(column) {
            case 1 : {
                m.setNom(aValue.toString());
                break;
            }
            case 2 : {
                m.setRestrictions(aValue.toString());
                break;
            }
            case 3 : {
                m.setDelaiProduction(Integer.parseInt(aValue.toString()));
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
                clazz = String.class;
            }
            case 3 : {
                clazz = Integer.class;
                break;
            }
        }
        return clazz;
    }
}
