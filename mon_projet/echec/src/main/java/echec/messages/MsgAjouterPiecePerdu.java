package echec.messages;

import ca.ntro.app.messages.MessageNtro;
import echec.modeles.ModeleDetailJeu;

public class MsgAjouterPiecePerdu extends MessageNtro {
	private String nomPiecePerdu;
	
	public MsgAjouterPiecePerdu() {
		
	}
	
	public String getNomPiecePerdu() {
		return nomPiecePerdu;
	}

	public void setNomPiecePerdu(String nomPiecePerdu) {
		this.nomPiecePerdu = nomPiecePerdu;
	}
	
	public void ajouterA(ModeleDetailJeu detailJeu) {
		detailJeu.ajouterPiecePerduPour(nomPiecePerdu);
	}

	
}
