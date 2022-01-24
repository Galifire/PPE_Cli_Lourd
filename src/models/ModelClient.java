package models;

import entities.Client;

import javax.swing.table.DefaultTableModel;
import java.util.HashSet;
import java.util.List;

public class ModelClient extends DefaultTableModel {

    List<Client> client;
    String[] colNames = {"CLINum", "Nom", "Prenom", "Adresse", "Email", "Telephone"};
    HashSet<Client> hashSet = new HashSet<>();

    public ModelClient(List<Client> client) {
        this.client = client;
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
        Client c = client.get(row);
        switch(column) {
            case 0: {
                value = c.getCliNum();
                break;
            }
            case 1 : {
                value = c.getNom();
                break;
            }
            case 2 : {
                value = c.getPrenom();
                break;
            }
            case 3 : {
                value = c.getAdresse();
                break;
            }
            case 4 : {
                value = c.getEmail();
                break;
            }
            case 5 : {
                value = c.getTelephone();
                break;
            }
        }
        return value;
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        Client c = client.get(row);
        switch(column) {
            case 1 : {
                c.setNom(aValue.toString());
                break;
            }
            case 2 : {
                c.setPrenom(aValue.toString());
                break;
            }
            case 3 : {
                c.setAdresse(aValue.toString());
                break;
            }
            case 4 : {
                c.setEmail(aValue.toString());
                break;
            }
            case 5 : {
                c.setTelephone(aValue.toString());
            }
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class<?> clazz = null;

        switch(columnIndex) {
            case 0 : {
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
