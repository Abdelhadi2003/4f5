package echec.messages;

import ca.ntro.app.messages.MessageNtro;
import echec.frontal.vues.VueFileAttente;
import echec.modeles.ModeleDetailJeu;

public class MsgPiecePerdu extends MessageNtro{
private String piecePerdu;
private String piecePerdu2;
	
	public MsgPiecePerdu() {
		
	}
	
	public String getPiecePerdu() {
		return piecePerdu;
	}

	public void setPiecePerdu(String piecePerdu) {
		this.piecePerdu = piecePerdu;
	}
	
	public String getPiecePerdu2() {
		return piecePerdu2;
	}

	public void setPiecePerdu2(String piecePerdu2) {
		this.piecePerdu2 = piecePerdu2;
	}
	
	public void ajouterA(ModeleDetailJeu detailJeu) {
		detailJeu.PiecePerduJoueur(piecePerdu, piecePerdu2);
		
	}

	public void afficherPiecePerduHasardSur(VueFileAttente vueFileAttente) {
		// TODO Auto-generated method stub
		vueFileAttente.afficherPiecePerduHasard(piecePerdu);
		vueFileAttente.afficherPiecePerduHasard2(piecePerdu2);
	}
	
}
