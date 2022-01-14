package controllers;

import windows.Erreur;

public class ErreurController {

    Erreur erreur;
    String text;

    ErreurController(Erreur erreur, String text) {
        this.erreur = erreur;
        this.text = text;

        erreur.getErrorText().setText(text);

        erreur.getOkBtn().addActionListener(e -> {
            erreur.dispose();
        });
    }


}
