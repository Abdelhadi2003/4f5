package echec.messages;

import ca.ntro.app.messages.MessageNtro;
import echec.modeles.ModeleDetailJeu;

public class MsgChoisirNomJoueur2 extends MessageNtro{
private String nomJoueur2;
	
	public MsgChoisirNomJoueur2() {
		
	}
	
	public String getNomJoueur2() {
		return nomJoueur2;
	}

	public void setNomJoueur2(String nomJoueur2) {
		this.nomJoueur2 = nomJoueur2;
	}
	
	
	
	public void ajouterA(ModeleDetailJeu detailJeu) {
		detailJeu.choisirNomJoueur2(nomJoueur2);
	}
}
