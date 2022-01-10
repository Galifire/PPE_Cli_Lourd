package entities;


import dao.DAOGeneric;
import models.ModelMedecin;
import org.hibernate.Session;

import javax.swing.*;
import java.util.HashSet;
import java.util.List;

public class Controller {

    Window window;
    DAOGeneric dao;
    List<Medecins> dataM;

    public Controller(Window window, DAOGeneric dao) {
        this.window = window;
        this.dao = dao;

        dataM = dao.findAll();
        ModelMedecin modelM = new ModelMedecin(dataM);
        String[] colNames = modelM.getColNames();
        for (int i = 0; i < colNames.length; i++) {
            modelM.addColumn(colNames[i]);
        }
        JTable table = new JTable();
        table.setModel(modelM);
        window.getDataScrolLPane().setViewportView(table);
        window.setSize(800,600);
        window.setVisible(true);
    }
}
