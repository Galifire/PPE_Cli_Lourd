package controllers.create;

import controllers.admin.ErreurController;
import dao.DAORdv;
import entities.Rdv;
import org.hibernate.Session;
import windows.admin.Erreur;
import windows.entities.WindowRdv;

import java.util.ArrayList;

public class CreateRdvController {

    WindowRdv cr;
    Session session;

    public CreateRdvController(WindowRdv cr, Session session) {
        this.cr = cr;
        this.session = session;

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
        ArrayList<Rdv> rdv = dao.findAll();
        for(Rdv r : rdv) {
            cr.getMedecinField().addItem(r.getMedNum());
            cr.getClientField().addItem(r.getCliNum());
        }

        cr.setTitle("Créer un rendez-vous");
        cr.getNumField().setEditable(false);
    }

    public void submit() {
        Rdv rdv = new Rdv();
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

    public void cancel() {
        cr.dispose();
    }
}
