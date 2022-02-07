package controllers.edit;

import controllers.admin.ErreurController;
import dao.DAORdv;
import entities.Rdv;
import org.hibernate.Session;
import windows.admin.Erreur;
import windows.entities.WindowRdv;

import java.util.ArrayList;

public class EditRdvController {

    WindowRdv cr;
    Session session;
    Rdv rdv;

    public EditRdvController(WindowRdv cr, Session session, Rdv rdv) {
        this.cr = cr;
        this.session = session;
        this.rdv = rdv;

        init();

        cr.getButtonOK().addActionListener(e -> {
            submit();
        });

        cr.getButtonCancel().addActionListener(e -> {
            cancel();
        });
    }

    public void init() {
        DAORdv dao = new DAORdv(session, Rdv.class);
        ArrayList<Rdv> rd = dao.findAll();
        for(Rdv r : rd) {
            cr.getMedecinField().addItem(r.getMedNum());
            cr.getClientField().addItem(r.getCliNum());

        }

        cr.setTitle("Créer un rendez-vous");
        cr.getNumField().setEditable(false);

        cr.getNumField().setText(rdv.getRdvNum().toString());
        cr.getMedecinField().setSelectedItem(rdv.getMedNum());
        cr.getClientField().setSelectedItem(rdv.getCliNum());
        cr.getDateField().setText(rdv.getDateRdv());
        cr.getHeureField().setText(rdv.getHeure());
        cr.getDureeField().setText(rdv.getDuree().toString());
        cr.getPrixField().setText(rdv.getPrix().toString());
        cr.getCommentairesField().setText(rdv.getCommentaires());
    }

    public void submit() {
        if (cr.getDateField().getText().isEmpty()) {
            Erreur e = new Erreur();
            new ErreurController(e, "La date ne peut pas être vide, réessayez.");
            e.setSize(400,200);
            e.setVisible(true);
        } else {
            rdv.setMedNum(Integer.parseInt(cr.getMedecinField().getSelectedItem().toString()));
            rdv.setCliNum(Integer.parseInt(cr.getClientField().getSelectedItem().toString()));
            rdv.setDateRdv(cr.getDateField().getText());
            rdv.setHeure(cr.getHeureField().getText());
            rdv.setDuree(Integer.parseInt(cr.getDureeField().getText()));
            rdv.setPrix(Integer.parseInt(cr.getPrixField().getText()));
            rdv.setCommentaires(cr.getCommentairesField().getText());
            DAORdv dao = new DAORdv(session, Rdv.class);
            dao.saveOrUpdate(rdv);
            cr.dispose();
        }
    }

    public void cancel() {
        cr.dispose();
    }
}
