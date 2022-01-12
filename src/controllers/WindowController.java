package controllers;

import dao.DAOCabinetMedical;
import dao.DAOMedecins;
import entities.CabinetMedical;
import entities.Medecins;
import entities.User;
import entities.Window;
import org.hibernate.Session;

import javax.swing.*;

public class WindowController {

    Window window;
    Session session;

    public WindowController(Window window, Session session) {
        this.window = window;
        this.session = session;

        window.getLoggedLabel().setText("Logged in !");

        window.getTableBox().addActionListener(e -> {
            window.getDataScrolLPane().setViewportView(null);
            addTable();
        });
    }

    public void addTable() {
        switch (window.getTableBox().getSelectedIndex()) {
            case 1 : {
                CabinetMedicalController cmc = new CabinetMedicalController(new DAOCabinetMedical(session, CabinetMedical.class));
                fillTable(cmc.fill());
                break;
            }
            case 4 : {
                MedecinsController mc = new MedecinsController(new DAOMedecins(session, Medecins.class));
                fillTable(mc.fill());
                break;
            }
        }
    }

    public void fillTable(JTable table) {
        window.getDataScrolLPane().setViewportView(table);
        window.setVisible(true);
    }
}
