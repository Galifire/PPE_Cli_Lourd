package controllers.entities;

import dao.DAOCabinetMedical;
import entities.CabinetMedical;
import models.ModelCabinetMedical;

import javax.swing.*;
import java.util.ArrayList;

public class CabinetMedicalController {

    DAOCabinetMedical dao;

    public CabinetMedicalController(DAOCabinetMedical dao) {
        this.dao = dao;
    }

    public JTable fill() {
        ArrayList<CabinetMedical> data = dao.findAll();
        ModelCabinetMedical model = new ModelCabinetMedical(data);
        String[] colNames = model.getColNames();
        for (int i = 0; i < colNames.length; i++) {
            model.addColumn(colNames[i]);
        }

        for (int j = 0; j < data.size(); j++) {
            CabinetMedical cabM = data.get(j);
            Object[] d = new Object[] {
                    cabM.getCabNum(),
                    cabM.getNom(),
                    cabM.getAdresse(),
                    cabM.getEffectif(),
                    cabM.getHoraires(),
            };
            model.insertRow(j, d);
        }

        JTable table = new JTable();
        table.setModel(model);
        return table;
    }
}