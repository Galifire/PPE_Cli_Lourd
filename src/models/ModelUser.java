package models;

import entities.Stocks;
import entities.User;

import javax.swing.table.DefaultTableModel;
import java.util.HashSet;
import java.util.List;

public class ModelUser extends DefaultTableModel {

    List<User> user;
    String[] colNames = {"Id", "Username", "Password", "Role"};
    HashSet<Stocks> hashSet = new HashSet<>();

    public ModelUser(List<User> user) {
        this.user = user;
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
        return false;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Object value = null;
        User u = user.get(row);
        switch(column) {
            case 0: {
                value = u.getId();
                break;
            }
            case 1 : {
                value = u.getUsername();
                break;
            }
            case 2 : {
                value = u.getPassword();
                break;
            }
            case 3 : {
                value = u.getRole();
                break;
            }
        }
        return value;
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        User u = user.get(row);
        switch(column) {
            case 1 : {
                u.setUsername(aValue.toString());
                break;
            }
            case 2 : {
                u.setPassword(aValue.toString());
                break;
            }
            case 3 : {
                u.setRole(aValue.toString());
            }
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class<?> clazz = null;
        switch(columnIndex) {
            case 0 : {
                clazz = Integer.class;
            }
            case 1 :
            case 2 :
            case 3 : {
                clazz = String.class;
            }
        }
        return clazz;
    }

}
