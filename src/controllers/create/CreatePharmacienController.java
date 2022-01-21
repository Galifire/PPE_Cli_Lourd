package controllers.create;

import controllers.admin.ErreurController;
import entities.Pharmacie;
import entities.Pharmacien;
import org.hibernate.Session;
import windows.admin.Erreur;
import windows.create.CreatePharmacien;

public class CreatePharmacienController {

    CreatePharmacien cp;
    Session session;

    public CreatePharmacienController(CreatePharmacien cp, Session session) {
        this.cp = cp;
        this.session = session;

        cp.getButtonOK().addActionListener(e -> {
            submit();
        });

        cp.getButtonCancel().addActionListener(e -> {
            cancel();
        });
    }

    public void submit() {
        if (cp.getNumField().getText().isEmpty()) {
            Erreur e = new Erreur();
            new ErreurController(e, "La clé primaire ne peut pas être vide, réessayez.");
            e.setSize(400,200);
            e.setVisible(true);
        } else {
            Pharmacien p = new Pharmacien();
            p.setPhNum(Integer.parseInt(cp.getNumField().getText()));
            p.setNom(cp.getNomField().getText());
            p.setPrenom(cp.getPrenomField().getText());
            p.setEmail(cp.getEmailField().getText());
            p.setTelephone(cp.getTelephoneField().getText());
            p.setPharNum(Integer.parseInt(cp.getPharmacieNum().getText()));
            cp.dispose();
        }
    }

    public void cancel() {
        cp.dispose();
    }
}
