package controllers;

import dao.DAOUser;
import entities.Stocks;
import entities.User;
import models.ModelStock;
import models.ModelUser;

import javax.swing.*;
import java.util.ArrayList;

public class UserController {

    DAOUser dao;

    public UserController(DAOUser dao) {
        this.dao = dao;
    }

    public JTable fill() {
        ArrayList<User> data = dao.findAll();
        ModelUser model = new ModelUser(data);
        String[] colNames = model.getColNames();
        for (int i = 0; i < colNames.length; i++) {
            model.addColumn(colNames[i]);
        }

        for (int j = 0; j < data.size(); j++) {
            User u = data.get(j);
            Object[] d = new Object[] {
                    u.getId(),
                    u.getUsername(),
                    u.getPassword(),
                    u.getRole()
            };
            model.insertRow(j, d);
        }

        JTable table = new JTable();
        table.setModel(model);
        return table;
    }


}
