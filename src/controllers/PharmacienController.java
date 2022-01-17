package controllers;

import dao.DAOPharmacien;
import entities.Pharmacie;
import entities.Pharmacien;
import models.ModelPharmacie;
import models.ModelPharmacien;

import javax.swing.*;
import java.util.ArrayList;

public class PharmacienController {

    DAOPharmacien dao;

    PharmacienController(DAOPharmacien dao) {
        this.dao = dao;
    }

    public JTable fill() {
        ArrayList<Pharmacien> data = dao.findAll();
        ModelPharmacien model = new ModelPharmacien(data);
        String[] colNames = model.getColNames();
        for (int i = 0; i < colNames.length; i++) {
            model.addColumn(colNames[i]);
        }

        for (int j = 0; j < data.size(); j++) {
            Pharmacien ph = data.get(j);
            Object[] d = new Object[] {
                    ph.getPhNum(),
                    ph.getNom(),
                    ph.getPrenom(),
                    ph.getEmail(),
                    ph.getTelephone(),
                    ph.getPharNum()
            };
            model.insertRow(j, d);
        }

        JTable table = new JTable();
        table.setModel(model);
        return table;
    }

}
