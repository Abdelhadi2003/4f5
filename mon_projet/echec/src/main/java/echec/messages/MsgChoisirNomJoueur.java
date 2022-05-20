package echec.messages;

import ca.ntro.app.messages.MessageNtro;
import echec.modeles.ModeleDetailJeu;

public class MsgChoisirNomJoueur extends MessageNtro{
private String nomJoueur;
	
	public MsgChoisirNomJoueur() {
		
	}
	
	public String getNomJoueur() {
		return nomJoueur;
	}

	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}
	
	
	
	public void ajouterA(ModeleDetailJeu detailJeu) {
		detailJeu.choisirNomJoueur(nomJoueur);
	}
}
