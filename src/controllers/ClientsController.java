package controllers;

import dao.DAOClient;
import entities.Client;
import models.ModelClient;

import javax.swing.*;
import java.util.ArrayList;

public class ClientsController {

    DAOClient dao;

    public ClientsController(DAOClient dao) {
        this.dao = dao;
    }

    public JTable fill() {
        ArrayList<Client> data = dao.findAll();
        ModelClient model = new ModelClient(data);
        String[] colNames = model.getColNames();
        for (int i = 0; i < colNames.length; i++) {
            model.addColumn(colNames[i]);
        }

        for (int j = 0; j < data.size(); j++) {
            Client c = data.get(j);
            Object[] d = new Object[] {
                    c.getCliNum(),
                    c.getNom(),
                    c.getPrenom(),
                    c.getAdresse(),
                    c.getEmail(),
                    c.getTelephone()
            };
            model.insertRow(j, d);
        }

        JTable table = new JTable();
        table.setModel(model);
        return table;
    }
}
