package controllers.edit;

import dao.DAOPharmacie;
import entities.Pharmacie;
import org.hibernate.Session;
import windows.entities.WindowPharmacie;

public class EditPharmacieController {

    WindowPharmacie cp;
    Session session;
    Pharmacie ph;

    public EditPharmacieController(WindowPharmacie cp, Session session, Pharmacie ph) {
        this.cp = cp;
        this.session = session;
        this.ph = ph;

        init();

        cp.getButtonOK().addActionListener(e -> {
            submit();
        });

        cp.getButtonCancel().addActionListener(e -> {
            cancel();
        });
    }

    public void init() {
        cp.setTitle("Éditer une pharmacie");
        cp.getNumField().setEditable(false);

        cp.getNumField().setText(ph.getPharNum().toString());
        cp.getNomField().setText(ph.getNom());
        cp.getVilleField().setText(ph.getVille());
        cp.getCodePostalField().setText(ph.getCodePostal());
        cp.getAdresseField().setText(ph.getAdresse());
        cp.getEffectifField().setText(ph.getEffectif().toString());
    }

    public void submit() {
        ph.setNom(cp.getNomField().getText());
        ph.setVille(cp.getVilleField().getText());
        ph.setCodePostal(cp.getCodePostalField().getText());
        ph.setAdresse(cp.getAdresseField().getText());
        ph.setEffectif(Integer.parseInt(cp.getEffectifField().getText()));
        DAOPharmacie dao = new DAOPharmacie(session, Pharmacie.class);
        dao.saveOrUpdate(ph);
        cp.dispose();
    }

    public void cancel() {
        cp.dispose();
    }
}
