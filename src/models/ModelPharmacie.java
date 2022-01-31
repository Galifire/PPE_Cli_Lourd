package models;

import entities.Pharmacie;
import javax.swing.table.DefaultTableModel;
import java.util.HashSet;
import java.util.List;

public class ModelPharmacie extends DefaultTableModel {

    List<Pharmacie> pharmacie;
    String[] colNames = {"PHARNum", "Nom", "Ville", "CodePostal", "Adresse", "Effectif"};
    HashSet<Pharmacie> hashSet = new HashSet<>();

    public ModelPharmacie(List<Pharmacie> pharmacie) {
        this.pharmacie = pharmacie;
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
        Pharmacie ph = pharmacie.get(row);
        switch(column) {
            case 0: {
                value = ph.getPharNum();
                break;
            }
            case 1 : {
                value = ph.getNom();
                break;
            }
            case 2 : {
                value = ph.getVille();
                break;
            }
            case 3 : {
                value = ph.getCodePostal();
                break;
            }
            case 4 : {
                value = ph.getAdresse();
                break;
            }
            case 5 : {
                value = ph.getEffectif();
                break;
            }
        }
        return value;
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        Pharmacie ph = pharmacie.get(row);
        switch(column) {
            case 1 : {
                ph.setNom(aValue.toString());
                break;
            }
            case 2 : {
                ph.setVille(aValue.toString());
                break;
            }
            case 3 : {
                ph.setCodePostal(aValue.toString());
                break;
            }
            case 4 : {
                ph.setAdresse(aValue.toString());
                break;
            }
            case 5 : {
                ph.setEffectif(Integer.parseInt(aValue.toString()));
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
