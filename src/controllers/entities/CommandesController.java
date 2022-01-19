package controllers.entities;

import dao.DAOCommandes;
import entities.Commandes;
import models.ModelCommandes;

import javax.swing.*;
import java.util.ArrayList;

public class CommandesController {

    DAOCommandes dao;

    public CommandesController(DAOCommandes dao) {
        this.dao = dao;
    }

    public JTable fill() {
        ArrayList<Commandes> data = dao.findAll();
        ModelCommandes model = new ModelCommandes(data);
        String[] colNames = model.getColNames();
        for (int i = 0; i < colNames.length; i++) {
            model.addColumn(colNames[i]);
        }

        for (int j = 0; j < data.size(); j++) {
            Commandes c = data.get(j);
            Object[] d = new Object[] {
                    c.getCdeNum(),
                    c.getCliNum(),
                    c.getMedicNum(),
                    c.getDateCde(),
                    c.getQte(),
            };
            model.insertRow(j, d);
        }

        JTable table = new JTable();
        table.setModel(model);
        return table;
    }
}
