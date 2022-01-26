package controllers.edit;

import org.hibernate.Session;
import windows.entities.*;
import dao.*;
import entities.*;

import java.util.ArrayList;

public class IdSelectorController {

    IdSelector id;
    Session session;
    int selectedTable;

    public IdSelectorController(IdSelector id, Session session, int selectedTable) {
        this.id = id;
        this.session = session;
        this.selectedTable = selectedTable;

        id.getIdBox().addActionListener(e -> {
            fillBox(selectedTable);
        });

        id.getButtonOK().addActionListener(e -> {
            onOk(selectedTable);
        });

        id.getButtonCancel().addActionListener(e -> {
            onCancel();
        });
    }

    public void fillBox(int tableIndex) {
        id.getIdBox().removeAll();
        switch(tableIndex) {
            case 1 : {
                DAOCabinetMedical dao = new DAOCabinetMedical(session, CabinetMedical.class);
                ArrayList<CabinetMedical> list = dao.findAll();
                for (CabinetMedical cm : list) {
                    id.getIdBox().addItem(cm.getCabNum());
                }
                break;
            } case 2 : {
                DAOClient dao = new DAOClient(session, Client.class);
                ArrayList<Client> list = dao.findAll();
                for (Client c : list) {
                    id.getIdBox().addItem(c.getCliNum());
                }
                break;
            } case 3 : {
                DAOCommandes dao = new DAOCommandes(session, Commandes.class);
                ArrayList<Commandes> list = dao.findAll();
                for (Commandes c : list) {
                    id.getIdBox().addItem(c.getCdeNum());
                }
                break;
            } case 4 : {
                DAOMedecins dao = new DAOMedecins(session, Medecins.class);
                ArrayList<Medecins> list = dao.findAll();
                for (Medecins m : list) {
                    id.getIdBox().addItem(m.getMedNum());
                }
                break;
            } case 5 : {
                DAOMedicaments dao = new DAOMedicaments(session, Medicaments.class);
                ArrayList<Medicaments> list = dao.findAll();
                for (Medicaments m : list) {
                    id.getIdBox().addItem(m.getMedicNum());
                }
                break;
            } case 6 : {
                DAOPharmacie dao = new DAOPharmacie(session, Pharmacie.class);
                ArrayList<Pharmacie> list = dao.findAll();
                for (Pharmacie ph : list) {
                    id.getIdBox().addItem(ph.getPharNum());
                }
                break;
            } case 7 : {
                DAOPharmacien dao = new DAOPharmacien(session, Pharmacien.class);
                ArrayList<Pharmacien> list = dao.findAll();
                for (Pharmacien ph : list) {
                    id.getIdBox().addItem(ph.getPhNum());
                }
                break;
            } case 8 : {
                DAORdv dao = new DAORdv(session, Rdv.class);
                ArrayList<Rdv> list = dao.findAll();
                for (Rdv rdv : list) {
                    id.getIdBox().addItem(rdv.getRdvNum());
                }
                break;
            } case 9 : {
                DAOStocks dao = new DAOStocks(session, Stocks.class);
                ArrayList<Stocks> list = dao.findAll();
                for (Stocks s : list) {
                    id.getIdBox().addItem(s.getStockNum());
                }
                break;
            }
        }
        id.setVisible(true);
    }

    public void onOk(int tableIndex) {
        id.dispose();
        int idSelected = id.getIdBox().getSelectedIndex() + 1;
        switch(tableIndex) {
            case 1 : {
                DAOCabinetMedical dao = new DAOCabinetMedical(session, CabinetMedical.class);
                WindowCabinetMedical wcm = new WindowCabinetMedical();
                new EditCabinetMedicalController(wcm, session,dao.findById(idSelected));
                wcm.setSize(800,600);
                wcm.setVisible(true);
                break;
            } case 2 : {
                DAOClient dao = new DAOClient(session, Client.class);
                WindowClient wc = new WindowClient();
                new EditClientController(wc, session, dao.findById(idSelected));
                wc.setSize(800,600);
                wc.setVisible(true);
                break;
            } case 3 : {
                DAOCommandes dao = new DAOCommandes(session, Commandes.class);
                WindowCommande wc = new WindowCommande();
                new EditCommandeController(wc, session, dao.findById(idSelected));
                wc.setSize(800,600);
                wc.setVisible(true);
                break;
            } case 4 : {
                DAOMedecins dao = new DAOMedecins(session, Medecins.class);
                WindowMedecin wm = new WindowMedecin();
                new EditMedecinController(wm, session, dao.findById(idSelected));
                wm.setSize(800,600);
                wm.setVisible(true);
                break;
            } case 5 : {
                DAOMedicaments dao = new DAOMedicaments(session, Medicaments.class);
                WindowMedicament wm = new WindowMedicament();
                new EditMedicamentController(wm, session, dao.findById(idSelected));
                wm.setSize(800,600);
                wm.setVisible(true);
                break;
            } case 6 : {
                DAOPharmacie dao = new DAOPharmacie(session, Pharmacie.class);
                WindowPharmacie wp = new WindowPharmacie();
                new EditPharmacieController(wp, session, dao.findById(idSelected));
                wp.setSize(800,600);
                wp.setVisible(true);
                break;
            } case 7 : {
                DAOPharmacien dao = new DAOPharmacien(session, Pharmacien.class);
                WindowPharmacien wp = new WindowPharmacien();
                new EditPharmacienController(wp, session, dao.findById(idSelected));
                wp.setSize(800,600);
                wp.setVisible(true);
                break;
            } case 8 : {
                DAORdv dao = new DAORdv(session, Rdv.class);
                WindowRdv wr = new WindowRdv();
                new EditRdvController(wr, session, dao.findById(idSelected));
                wr.setSize(800,600);
                wr.setVisible(true);
                break;
            } case 9 : {
                DAOStocks dao = new DAOStocks(session, Rdv.class);
                WindowStock ws = new WindowStock();
                new EditStockController(ws, session, dao.findById(idSelected));
                ws.setSize(800,600);
                ws.setVisible(true);
                break;
            }
        }
    }

    public void onCancel() {
        id.dispose();
    }
}
