package controllers.create;

import dao.DAOPharmacie;
import entities.Pharmacie;
import org.hibernate.Session;
import windows.entities.WindowPharmacie;

public class CreatePharmacieController {

    WindowPharmacie cp;
    Session session;

    public CreatePharmacieController(WindowPharmacie cp, Session session) {
        this.cp = cp;
        this.session = session;

        cp.setTitle("Créer une pharmacie");
        cp.getNumField().setEditable(false);

        cp.getButtonOK().addActionListener(e -> {
            submit();
        });

        cp.getButtonCancel().addActionListener(e -> {
            cancel();
        });
    }

    public void submit() {
        Pharmacie p = new Pharmacie();
        p.setNom(cp.getNomField().getText());
        p.setVille(cp.getVilleField().getText());
        p.setCodePostal(cp.getCodePostalField().getText());
        p.setAdresse(cp.getAdresseField().getText());
        p.setEffectif(Integer.parseInt(cp.getEffectifField().getText()));
        DAOPharmacie dao = new DAOPharmacie(session, Pharmacie.class);
        dao.saveOrUpdate(p);
        cp.dispose();
    }

    public void cancel() {
        cp.dispose();
    }
}
