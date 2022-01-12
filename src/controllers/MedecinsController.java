package controllers;


import dao.DAOMedecins;
import entities.Medecins;
import entities.Window;
import models.ModelMedecin;

import javax.swing.*;
import java.util.ArrayList;

public class MedecinsController {

    DAOMedecins dao;

    public MedecinsController(DAOMedecins dao) {
        this.dao = dao;
    }

    public JTable fill() {
        ArrayList<Medecins> dataM = dao.findAll();
        ModelMedecin modelM = new ModelMedecin(dataM);
        String[] colNames = modelM.getColNames();
        for (int i = 0; i < colNames.length; i++) {
            modelM.addColumn(colNames[i]);
        }

        for (int j = 0; j < dataM.size(); j++) {
            Medecins m = dataM.get(j);
            Object[] data = new Object[] {
                    m.getMedNum(),
                    m.getNom(),
                    m.getPrenom(),
                    m.getAdresse(),
                    m.getEmail(),
                    m.getCabNum()
            };
            modelM.insertRow(j, data);
        }

        JTable table = new JTable();
        table.setModel(modelM);
        return table;
    }
}
