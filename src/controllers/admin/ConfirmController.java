package controllers.admin;

import controllers.edit.*;
import dao.*;
import entities.*;
import org.hibernate.Session;
import windows.admin.Confirm;
import windows.entities.*;
import javax.swing.*;
import java.util.Objects;

public class ConfirmController {

    Confirm confirm;
    Session session;
    int tableIndex;
    JTable table;

    /**
     *
     * @param confirm fenêtre de confirmation
     * @param session paramètres de session, si l'utilisateur est bien connecté
     * @param tableIndex index de la table sélectionnée
     * @param table structure de la table
     */

    public ConfirmController(Confirm confirm, Session session, int tableIndex, JTable table) {
        this.confirm = confirm;
        this.session = session;
        this.tableIndex = tableIndex;
        this.table = table;

        confirm.getButtonOK().addActionListener(e -> {
            commitDelete(tableIndex);
        });

        confirm.getButtonCancel().addActionListener(e -> {
            confirm.dispose();
        });
    }

    public void commitDelete(int index) {
        int id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
        switch (index) {
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
        confirm.dispose();
    }
}
