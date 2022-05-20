package echec.messages;

import ca.ntro.app.messages.MessageNtro;
import echec.modeles.ModeleDetailJeu;

public class MsgChoisirCouleurPieceJoueur1 extends MessageNtro{
private String couleurPieceJoueur1;
	
	public MsgChoisirCouleurPieceJoueur1() {
		
	}
	
	public String getCouleurPieceJoueur1() {
		return couleurPieceJoueur1;
	}

	public void setCouleurPieceJoueur1(String couleurPieceJoueur1) {
		this.couleurPieceJoueur1 = couleurPieceJoueur1;
	}
	
	public void ajouterA(ModeleDetailJeu detailJeu) {
		detailJeu.choisirCouleurPieceJoueur1(couleurPieceJoueur1);
	}
}