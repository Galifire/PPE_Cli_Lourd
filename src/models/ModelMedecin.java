package models;

import entities.Medecins;

import javax.swing.table.DefaultTableModel;
import java.util.HashSet;
import java.util.List;

public class ModelMedecin extends DefaultTableModel {
    List<Medecins> medecin;
    String[] colNames = {"MEDNum", "Nom", "Prenom", "Adresse", "Email", "Telephone", "CABNum"};
    HashSet<Medecins> hashSet = new HashSet<>();

    public ModelMedecin(List<Medecins> medecin) {
        this.medecin = medecin;
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
        Medecins m = medecin.get(row);
        switch(column) {
            case 0: {
                value = m.getMedNum();
                break;
            }
            case 1 : {
                value = m.getNom();
                break;
            }
            case 2 : {
                value = m.getPrenom();
                break;
            }
            case 3 : {
                value = m.getAdresse();
                break;
            }
            case 4 : {
                value = m.getEmail();
                break;
            }
            case 5 : {
                value = m.getTelephone();
                break;
            }
        }
        return value;
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        Medecins m = medecin.get(row);
        switch(column) {
            case 1 : {
                m.setNom(aValue.toString());
                break;
            }
            case 2 : {
                m.setPrenom(aValue.toString());
                break;
            }
            case 3 : {
                m.setAdresse(aValue.toString());
                break;
            }
            case 4 : {
                m.setEmail(aValue.toString());
                break;
            }
            case 5 : {
                m.setTelephone(aValue.toString());
            }
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class<?> clazz = null;

        switch(columnIndex) {
            case 0 :
            case 6 : {
                clazz = Integer.class;
                break;
            }
            case 1 :
            case 2 :
            case 3 :
            case 4 :
            case 5 : {
                clazz = String.class;
                break;
            }
        }
        return clazz;
    }
}
