package controllers.edit;

import dao.DAOPharmacien;
import entities.Pharmacien;
import org.hibernate.Session;
import windows.entities.WindowPharmacien;

public class EditPharmacienController {

    WindowPharmacien cp;
    Session session;
    Pharmacien ph;

    public EditPharmacienController(WindowPharmacien cp, Session session, Pharmacien ph) {
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
        cp.setTitle("Créer un pharmacien");
        cp.getNumField().setEditable(false);

        cp.getNumField().setText(ph.getPhNum().toString());
        cp.getNomField().setText(ph.getNom());
        cp.getPrenomField().setText(ph.getPrenom());
        cp.getEmailField().setText(ph.getEmail());
        cp.getTelephoneField().setText(ph.getTelephone());
        cp.getPharmacieNum().setText(ph.getPharNum().toString());
    }

    public void submit() {
        Pharmacien p = new Pharmacien();
        p.setPhNum(Integer.parseInt(cp.getNumField().getText()));
        p.setNom(cp.getNomField().getText());
        p.setPrenom(cp.getPrenomField().getText());
        p.setEmail(cp.getEmailField().getText());
        p.setTelephone(cp.getTelephoneField().getText());
        p.setPharNum(Integer.parseInt(cp.getPharmacieNum().getText()));
        DAOPharmacien dao = new DAOPharmacien(session, Pharmacien.class);
        dao.saveOrUpdate(p);
        cp.dispose();
    }

    public void cancel() {
        cp.dispose();
    }
}
