package controllers.create;

import entities.Pharmacien;
import org.hibernate.Session;
import dao.DAOPharmacien;
import windows.entities.WindowPharmacien;

public class CreatePharmacienController {

    WindowPharmacien cp;
    Session session;

    public CreatePharmacienController(WindowPharmacien cp, Session session) {
        this.cp = cp;
        this.session = session;

        cp.setTitle("Créer un pharmacien");
        cp.getNumField().setEditable(false);

        cp.getButtonOK().addActionListener(e -> {
            submit();
        });

        cp.getButtonCancel().addActionListener(e -> {
            cancel();
        });
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
