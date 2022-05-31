package controllers.admin;

import windows.admin.Erreur;

public class ErreurController {

    Erreur e;
    String text;

    /**
     * @param e fenêtre d'erreur
     * @param text texte passé en paramètre à afficher
     */

    public ErreurController(Erreur e, String text) {
        this.e = e;
        this.text = text;

        e.getErrorText().setText(text);

        e.getOkBtn().addActionListener(l -> e.dispose());
    }
}
