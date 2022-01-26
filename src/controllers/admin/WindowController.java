package controllers.admin;

import controllers.create.*;
import controllers.edit.*;
import controllers.entities.*;
import dao.*;
import entities.*;
import org.hibernate.Session;
import windows.admin.Logger;
import windows.admin.Window;
import windows.entities.*;

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

        window.getLogoutButton().addActionListener(e -> logout());

        window.getAddButton().addActionListener(e -> create());

        window.getEditButton().addActionListener(e -> edit());
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
                fillTable(new RDVController(new DAORdv(session, Rdv.class)).fill());
                break;
            } case 9: {
                fillTable(new StocksController(new DAOStocks(session, Stocks.class)).fill());
                break;
            }
        }
    }

    public void create() {
        switch (window.getTableBox().getSelectedIndex()) {
            case 1 : {
                WindowCabinetMedical ccm = new WindowCabinetMedical();
                new CreateCabinetMedicalController(ccm, session);
                ccm.setSize(800,600);
                ccm.setVisible(true);
                break;
            } case 2 : {
                WindowClient cc = new WindowClient();
                new CreateClientController(cc, session);
                cc.setSize(800,600);
                cc.setVisible(true);
                break;
            } case 3 : {
                WindowCommande cc = new WindowCommande();
                new CreateCommandeController(cc, session);
                cc.setSize(800,600);
                cc.setVisible(true);
                break;
            } case 4 : {
                WindowMedecin cm = new WindowMedecin();
                new CreateMedecinController(cm, session);
                cm.setSize(800,600);
                cm.setVisible(true);
                break;
            } case 5 : {
                WindowMedicament cm = new WindowMedicament();
                new CreateMedicamentController(cm, session);
                cm.setSize(800,600);
                cm.setVisible(true);
                break;
            } case 6 : {
                WindowPharmacie cp = new WindowPharmacie();
                new CreatePharmacieController(cp, session);
                cp.setSize(800,600);
                cp.setVisible(true);
                break;
            } case 7 : {
                WindowPharmacien cp = new WindowPharmacien();
                new CreatePharmacienController(cp, session);
                cp.setSize(800,600);
                cp.setVisible(true);
                break;
            } case 8 : {
                WindowRdv cr = new WindowRdv();
                new CreateRdvController(cr, session);
                cr.setSize(800,600);
                cr.setVisible(true);
                break;
            } case 9 : {
                WindowStock cs = new WindowStock();
                new CreateStockController(cs, session);
                cs.setSize(800,600);
                cs.setVisible(true);
                break;
            }
        }
    }

    public void edit() {
        IdSelector id = new IdSelector();
        IdSelectorController idC = new IdSelectorController(id, session, window.getTableBox().getSelectedIndex());
        id.setSize(800,600);
        id.setVisible(true);
    }

    public void fillTable(JTable table) {
        table.setSize((int) (0.8*window.getWidth()), (int) (0.8*window.getHeight()));
        window.getDataScrolLPane().setViewportView(table);
        window.setVisible(true);
    }
}
