package controllers;

import dao.DAOMedicaments;
import entities.Medicaments;
import models.ModelMedicament;

import javax.swing.*;
import java.util.ArrayList;

public class MedicamentsController {

    DAOMedicaments dao;

    public MedicamentsController(DAOMedicaments dao) {
        this.dao = dao;
    }

    public JTable fill() {
        ArrayList<Medicaments> data = dao.findAll();
        ModelMedicament model = new ModelMedicament(data);
        String[] colNames = model.getColNames();
        for (int i = 0; i < colNames.length; i++) {
            model.addColumn(colNames[i]);
        }

        for (int j = 0; j < data.size(); j++) {
            Medicaments c = data.get(j);
            Object[] d = new Object[] {
                    c.getMedicCode(),
                    c.getNom(),
                    c.getRestrictions(),
                    c.getDelaiProduction(),
            };
            model.insertRow(j, d);
        }

        JTable table = new JTable();
        table.setModel(model);
        return table;
    }
}
