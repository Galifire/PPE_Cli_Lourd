package controllers.create;

import controllers.admin.ErreurController;
import entities.Medicaments;
import entities.Pharmacie;
import org.hibernate.Session;
import windows.admin.Erreur;
import windows.create.CreatePharmacie;

public class CreatePharmacieController {

    CreatePharmacie cp;
    Session session;

    public CreatePharmacieController(CreatePharmacie cp, Session session) {
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
            Pharmacie p = new Pharmacie();
            p.setPharNum(Integer.parseInt(cp.getNumField().getText()));
            p.setNom(cp.getNomField().getText());
            p.setVille(cp.getVilleField().getText());
            p.setCodePostal(cp.getCodePostalField().getText());
            p.setAdresse(cp.getAdresseField().getText());
            p.setEffectif(Integer.parseInt(cp.getEffectifField().getText()));
            cp.dispose();
        }
    }

    public void cancel() {
        cp.dispose();
    }
}
