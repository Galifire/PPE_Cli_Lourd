package controllers.edit;

import controllers.admin.ErreurController;
import entities.Rdv;
import org.hibernate.Session;
import windows.admin.Erreur;
import windows.entities.WindowRdv;

public class EditRdvController {

    WindowRdv cr;
    Session session;
    Rdv rdv;

    public EditRdvController(WindowRdv cr, Session session, Rdv rdv) {
        this.cr = cr;
        this.session = session;
        this.rdv = rdv;

        cr.setTitle("Éditer un rendez-vous");

        cr.getButtonOK().addActionListener(e -> {
            submit();
        });

        cr.getButtonCancel().addActionListener(e -> {
            cancel();
        });
    }

    public void submit() {
        if ((cr.getMedecinField().getText().isEmpty()) || (cr.getClientField().getText().isEmpty()) || (cr.getDateField().getText().isEmpty())) {
            Erreur e = new Erreur();
            new ErreurController(e, "La clé primaire ne peut pas être vide, réessayez.");
            e.setSize(400,200);
            e.setVisible(true);
        } else {
            Rdv rdv = new Rdv();
            rdv.setMedNum(Integer.parseInt(cr.getMedecinField().getText()));
            rdv.setCliNum(Integer.parseInt(cr.getClientField().getText()));
            rdv.setDateRdv(cr.getDateField().getText());
            rdv.setHeure(cr.getHeureField().getText());
            rdv.setDuree(Integer.parseInt(cr.getDureeField().getText()));
            rdv.setPrix(Integer.parseInt(cr.getPrixField().getText()));
            rdv.setCommentaires(cr.getCommentairesField().getText());
            cr.dispose();
        }
    }

    public void cancel() {
        cr.dispose();
    }
}
