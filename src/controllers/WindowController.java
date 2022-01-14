package controllers;

import dao.*;
import entities.*;
import org.hibernate.Session;
import windows.Logger;
import windows.Window;

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
                CabinetMedicalController controller = new CabinetMedicalController(new DAOCabinetMedical(session, CabinetMedical.class));
                fillTable(controller.fill());
                break;
            }
            case 2 : {
                ClientsController controller = new ClientsController(new DAOClient(session, Client.class));
                fillTable(controller.fill());
                break;
            }
            case 3 : {
                CommandesController controller = new CommandesController(new DAOCommandes(session, Commandes.class));
                fillTable(controller.fill());
                break;
            }
            case 4 : {
                MedecinsController controller = new MedecinsController(new DAOMedecins(session, Medecins.class));
                fillTable(controller.fill());
                break;
            }
            case 5 : {
                MedicamentsController controller = new MedicamentsController(new DAOMedicaments(session, Medicaments.class));
                fillTable(controller.fill());
                break;
            }
            case 6 : {
                RDVController controller = new RDVController(new DAORdv(session, Rdv.class));
                fillTable(controller.fill());
                break;
            }
            case 7 : {
                StocksController controller = new StocksController(new DAOStocks(session, Stocks.class));
                fillTable(controller.fill());
                break;
            }
        }
    }

    public void fillTable(JTable table) {
        window.getDataScrolLPane().setViewportView(table);
        window.setVisible(true);
    }
}
