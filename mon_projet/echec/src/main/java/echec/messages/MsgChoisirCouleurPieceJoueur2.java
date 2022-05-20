package echec.messages;

import ca.ntro.app.messages.MessageNtro;
import echec.modeles.ModeleDetailJeu;

public class MsgChoisirCouleurPieceJoueur2 extends MessageNtro{
private String couleurPieceJoueur2;
	
	public MsgChoisirCouleurPieceJoueur2() {
		
	}
	
	public String getCouleurPieceJoueur2() {
		return couleurPieceJoueur2;
	}

	public void setCouleurPieceJoueur2(String couleurPieceJoueur2) {
		this.couleurPieceJoueur2 = couleurPieceJoueur2;
	}
	
	public void ajouterA(ModeleDetailJeu detailJeu) {
		detailJeu.choisirCouleurPieceJoueur2(couleurPieceJoueur2);
	}
}