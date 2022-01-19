package controllers.admin;

import controllers.entities.*;
import dao.*;
import entities.*;
import org.hibernate.Session;
import windows.admin.Logger;
import windows.admin.Window;

import javax.swing.*;

public class WindowController {

    Window window;
    Session session;
    User user;

    public WindowController(Window window, Session session, User user) {
        this.window = window;
        this.session = session;
        this.user = user;

        window.getTableBox().addActionListener(e -> {
            window.getDataScrolLPane().setViewportView(null);
            addTable();
        });

        window.getLogoutButton().addActionListener(e -> {
            logout();
        });
    }

    public void logout() {
        window.dispose();
        Logger l = new Logger();
        new LoggerController(l, session);
        l.setSize(800,600);
        l.setVisible(true);
    }

    public void addTable() {
        switch (window.getTableBox().getSelectedIndex()) {
            case 1 : {
                fillTable(new CabinetMedicalController(new DAOCabinetMedical(session, CabinetMedical.class)).fill());
                break;
            } case 2 : {
                fillTable(new ClientsController(new DAOClient(session, Client.class)).fill());
                break;
            } case 3 : {
                fillTable(new CommandesController(new DAOCommandes(session, Commandes.class)).fill());
                break;
            } case 4 : {
                fillTable(new MedecinsController(new DAOMedecins(session, Medecins.class)).fill());
                break;
            } case 5 : {
                fillTable(new MedicamentsController(new DAOMedicaments(session, Medicaments.class)).fill());
                break;
            } case 6 : {
                fillTable(new PharmacieController(new DAOPharmacie(session, Pharmacie.class)).fill());
                break;
            } case 7 : {
                fillTable(new PharmacienController(new DAOPharmacien(session, Pharmacien.class)).fill());
                break;
            } case 8 : {
                fillTable(new StocksController(new DAOStocks(session, Stocks.class)).fill());
                break;
            }
        }
    }

    public void fillTable(JTable table) {
        table.setSize((int) (0.8*window.getWidth()), (int) (0.8*window.getHeight()));
        window.getDataScrolLPane().setViewportView(table);
        window.setVisible(true);
    }
}
