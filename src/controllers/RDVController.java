package controllers;

import dao.DAORdv;
import entities.Rdv;
import models.ModelRdv;

import javax.swing.*;
import java.util.ArrayList;

public class RDVController {

    DAORdv dao;

    public RDVController(DAORdv dao) {
        this.dao = dao;
    }

    public JTable fill() {
        ArrayList<Rdv> data = dao.findAll();
        ModelRdv model = new ModelRdv(data);
        String[] colNames = model.getColNames();
        for (int i = 0; i < colNames.length; i++) {
            model.addColumn(colNames[i]);
        }

        for (int j = 0; j < data.size(); j++) {
            Rdv rdv = data.get(j);
            Object[] d = new Object[] {
                rdv.getMedNum(),
                rdv.getCliNum(),
                rdv.getDateRdv(),
                rdv.getHeure(),
                rdv.getDuree(),
                rdv.getPrix(),
                rdv.getCommentaires()
            };
            model.insertRow(j, d);
        }

        JTable table = new JTable();
        table.setModel(model);
        return table;
    }
}
