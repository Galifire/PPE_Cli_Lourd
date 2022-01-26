package models;

import entities.Rdv;

import javax.swing.table.DefaultTableModel;
import java.util.HashSet;
import java.util.List;

public class ModelRdv extends DefaultTableModel {
    List<Rdv> rendezvous;
    String[] colNames = {"RDVNum", "MEDNum", "CLINum", "DateRdv", "Heure", "Duree", "Prix"};
    HashSet<Rdv> hashSet = new HashSet<>();

    public ModelRdv(List<Rdv> rendezvous) {
        this.rendezvous = rendezvous;
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
        Rdv rdv = rendezvous.get(row);
        switch(column) {
            case 0 : {
                value = rdv.getRdvNum();
                break;
            }
            case 1 : {
                value = rdv.getMedNum();
                break;
            }
            case 2 : {
                value = rdv.getCliNum();
                break;
            }
            case 3 : {
                value = rdv.getDateRdv();
                break;
            }
            case 4 : {
                value = rdv.getHeure();
                break;
            }
            case 5 : {
                value = rdv.getDuree();
                break;
            }
            case 6 : {
                value = rdv.getPrix();
                break;
            }
            case 7 : {
                value = rdv.getCommentaires();
                break;
            }
        }
        return value;
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        Rdv rdv = rendezvous.get(row);
        switch(column) {
            case 0 : {
                rdv.setRdvNum(Integer.parseInt(aValue.toString()));
            }
            case 1 : {
                rdv.setMedNum(Integer.parseInt(aValue.toString()));
                break;
            }
            case 2 : {
                rdv.setCliNum(Integer.parseInt(aValue.toString()));
                break;
            }
            case 3 : {
                rdv.setDateRdv(aValue.toString());
                break;
            }
            case 4 : {
                rdv.setHeure(aValue.toString());
                break;
            }
            case 5 : {
                rdv.setDuree(Integer.parseInt(aValue.toString()));
                break;
            }
            case 6 : {
                rdv.setPrix(Integer.parseInt(aValue.toString()));
                break;
            }
            case 7 : {
                rdv.setCommentaires(aValue.toString());
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
            case 2 :
            case 5 :
            case 6 : {
                clazz = Integer.class;
                break;
            }
            case 3 :
            case 4 : {
                clazz = String.class;
                break;
            }
        }
        return clazz;
    }
}
