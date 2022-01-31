package controllers.admin;

import controllers.create.*;
import controllers.edit.*;
import controllers.entities.*;
import dao.*;
import entities.*;
import org.hibernate.Session;
import windows.admin.*;
import windows.entities.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class WindowController {

    Window window;
    Session session;
    User user;
    JTable table;

    public WindowController(Window window, Session session, User user, JTable table) {
        this.window = window;
        this.session = session;
        this.user = user;
        this.table = table;

        window.getTableBox().addActionListener(e -> {
            window.getDataScrolLPane().setViewportView(null);
            addTable();
        });

        window.getLogoutButton().addActionListener(e -> logout());

        window.getAddButton().addActionListener(e -> create());

        window.getEditButton().addActionListener(e -> edit());

        window.getDeleteButton().addActionListener(e -> delete());
    }

    public void logout() {
        window.dispose();
        Logger l = new Logger();
        new LoggerController(l, session);
        l.setVisible(true);
    }

    public void addTable() {
        switch (window.getTableBox().getSelectedIndex()) {
            case 1 : {
                table = new CabinetMedicalController(new DAOCabinetMedical(session, CabinetMedical.class)).fill();
                break;
            } case 2 : {
                table = new ClientsController(new DAOClient(session, Client.class)).fill();
                break;
            } case 3 : {
                table = new CommandesController(new DAOCommandes(session, Commandes.class)).fill();
                break;
            } case 4 : {
                table = new MedecinsController(new DAOMedecins(session, Medecins.class)).fill();
                break;
            } case 5 : {
                table = new MedicamentsController(new DAOMedicaments(session, Medicaments.class)).fill();
                break;
            } case 6 : {
                table = new PharmacieController(new DAOPharmacie(session, Pharmacie.class)).fill();
                break;
            } case 7 : {
                table = new PharmacienController(new DAOPharmacien(session, Pharmacien.class)).fill();
                break;
            } case 8 : {
                table = new RDVController(new DAORdv(session, Rdv.class)).fill();
                break;
            } case 9: {
                table = new StocksController(new DAOStocks(session, Stocks.class)).fill();
                break;
            }
        }
        fillTable(table);
    }

    public void create() {
        switch (window.getTableBox().getSelectedIndex()) {
            case 1 : {
                WindowCabinetMedical ccm = new WindowCabinetMedical();
                new CreateCabinetMedicalController(ccm, session);
                ccm.setVisible(true);
                break;
            } case 2 : {
                WindowClient cc = new WindowClient();
                new CreateClientController(cc, session);
                cc.setVisible(true);
                break;
            } case 3 : {
                WindowCommande cc = new WindowCommande();
                new CreateCommandeController(cc, session);
                cc.setVisible(true);
                break;
            } case 4 : {
                WindowMedecin cm = new WindowMedecin();
                new CreateMedecinController(cm, session);
                cm.setVisible(true);
                break;
            } case 5 : {
                WindowMedicament cm = new WindowMedicament();
                new CreateMedicamentController(cm, session);
                cm.setVisible(true);
                break;
            } case 6 : {
                WindowPharmacie cp = new WindowPharmacie();
                new CreatePharmacieController(cp, session);
                cp.setVisible(true);
                break;
            } case 7 : {
                WindowPharmacien cp = new WindowPharmacien();
                new CreatePharmacienController(cp, session);
                cp.setVisible(true);
                break;
            } case 8 : {
                WindowRdv cr = new WindowRdv();
                new CreateRdvController(cr, session);
                cr.setVisible(true);
                break;
            } case 9 : {
                WindowStock cs = new WindowStock();
                new CreateStockController(cs, session);
                cs.setVisible(true);
                break;
            }
        }
    }

    public void edit() {
        int id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
        switch (window.getTableBox().getSelectedIndex()) {
            case 1 : {
                DAOCabinetMedical dao = new DAOCabinetMedical(session, CabinetMedical.class);
                CabinetMedical cm = dao.findById(id);
                WindowCabinetMedical wcm = new WindowCabinetMedical();
                new EditCabinetMedicalController(wcm, session, cm);
                wcm.setVisible(true);
                break;
            } case 2 : {
                DAOClient dao = new DAOClient(session, Client.class);
                Client c = dao.findById(id);
                WindowClient wc = new WindowClient();
                new EditClientController(wc, session, c);
                wc.setVisible(true);
                break;
            } case 3 : {
                DAOCommandes dao = new DAOCommandes(session, Commandes.class);
                Commandes c = dao.findById(id);
                WindowCommande wc = new WindowCommande();
                new EditCommandeController(wc, session, c);
                wc.setVisible(true);
                break;
            } case 4 : {
                DAOMedecins dao = new DAOMedecins(session, Medecins.class);
                Medecins m = dao.findById(id);
                WindowMedecin wm = new WindowMedecin();
                new EditMedecinController(wm, session, m);
                wm.setVisible(true);
                break;
            } case 5 : {
                DAOMedicaments dao = new DAOMedicaments(session, Medicaments.class);
                Medicaments m = dao.findById(id);
                WindowMedicament wm = new WindowMedicament();
                new EditMedicamentController(wm, session,m);
                wm.setVisible(true);
                break;
            } case 6 : {
                DAOPharmacie dao = new DAOPharmacie(session, Pharmacie.class);
                Pharmacie p = dao.findById(id);
                WindowPharmacie wp = new WindowPharmacie();
                new EditPharmacieController(wp, session, p);
                wp.setVisible(true);
                break;
            } case 7 : {
                DAOPharmacien dao = new DAOPharmacien(session, Pharmacien.class);
                Pharmacien p = dao.findById(id);
                WindowPharmacien wp = new WindowPharmacien();
                new EditPharmacienController(wp, session, p);
                wp.setVisible(true);
                break;
            } case 8 : {
                DAORdv dao = new DAORdv(session, Rdv.class);
                Rdv rdv = dao.findById(id);
                WindowRdv wr = new WindowRdv();
                new EditRdvController(wr, session, rdv);
                wr.setVisible(true);
                break;
            } case 9: {
                DAOStocks dao = new DAOStocks(session, Stocks.class);
                Stocks s = dao.findById(id);
                WindowStock ws = new WindowStock();
                new EditStockController(ws, session, s);
                ws.setVisible(true);
                break;
            }
        }
    }

    public void delete() {
        int id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
        switch (window.getTableBox().getSelectedIndex()) {
            case 1 : {
                DAOCabinetMedical dao = new DAOCabinetMedical(session, CabinetMedical.class);
                CabinetMedical cm = dao.findById(id);
                dao.delete(cm);
                break;
            } case 2 : {
                DAOClient dao = new DAOClient(session, Client.class);
                Client c = dao.findById(id);
                dao.delete(c);
                break;
            } case 3 : {
                DAOCommandes dao = new DAOCommandes(session, Commandes.class);
                Commandes c = dao.findById(id);
                dao.delete(c);
                break;
            } case 4 : {
                DAOMedecins dao = new DAOMedecins(session, Medecins.class);
                Medecins m = dao.findById(id);
                dao.delete(m);
                break;
            } case 5 : {
                DAOMedicaments dao = new DAOMedicaments(session, Medicaments.class);
                Medicaments m = dao.findById(id);
                dao.delete(m);
                break;
            } case 6 : {
                DAOPharmacie dao = new DAOPharmacie(session, Pharmacie.class);
                Pharmacie p = dao.findById(id);
                dao.delete(p);
                break;
            } case 7 : {
                DAOPharmacien dao = new DAOPharmacien(session, Pharmacien.class);
                Pharmacien p = dao.findById(id);
                dao.delete(p);
                break;
            } case 8 : {
                DAORdv dao = new DAORdv(session, Rdv.class);
                Rdv rdv = dao.findById(id);
                dao.delete(rdv);
                break;
            } case 9: {
                DAOStocks dao = new DAOStocks(session, Stocks.class);
                Stocks s = dao.findById(id);
                dao.delete(s);
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
