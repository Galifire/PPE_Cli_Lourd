package controllers.entities;

import dao.DAOPharmacie;
import entities.Pharmacie;
import models.ModelPharmacie;

import javax.swing.*;
import java.util.ArrayList;

public class PharmacieController {

    DAOPharmacie dao;

    public PharmacieController(DAOPharmacie dao) {
        this.dao = dao;
    }

    public JTable fill() {
        ArrayList<Pharmacie> data = dao.findAll();
        ModelPharmacie model = new ModelPharmacie(data);
        String[] colNames = model.getColNames();
        for (int i = 0; i < colNames.length; i++) {
            model.addColumn(colNames[i]);
        }

        for (int j = 0; j < data.size(); j++) {
            Pharmacie ph = data.get(j);
            Object[] d = new Object[] {
                    ph.getPharNum(),
                    ph.getNom(),
                    ph.getVille(),
                    ph.getCodePostal(),
                    ph.getAdresse(),
                    ph.getEffectif()
            };
            model.insertRow(j, d);
        }

        JTable table = new JTable();
        table.setModel(model);
        return table;
    }
}
