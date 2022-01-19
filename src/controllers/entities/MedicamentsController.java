package controllers.entities;

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
        for (Medicaments m : data) {
            System.out.println(m);
        }
        ModelMedicament model = new ModelMedicament(data);
        String[] colNames = model.getColNames();
        for (int i = 0; i < colNames.length; i++) {
            model.addColumn(colNames[i]);
        }

        for (int j = 0; j < data.size(); j++) {
            Medicaments m = data.get(j);
            Object[] d = new Object[] {
                    m.getMedicNum(),
                    m.getNom(),
                    m.getRestrictions(),
                    m.getDelaiProduction(),
            };
            model.insertRow(j, d);
        }

        JTable table = new JTable();
        table.setModel(model);
        return table;
    }
}
