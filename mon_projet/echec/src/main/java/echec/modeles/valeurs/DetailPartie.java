package echec.modeles.valeurs;

import ca.ntro.app.models.Value;

public class DetailPartie implements Value{
	
	public DetailPartie() {
		
	}
	
	private String idJoueur;
	private String piecePerdu;
	public String getIdJoueur() {
		return idJoueur;
	}
	public void setIdJoueur(String idJoueur) {
		this.idJoueur = idJoueur;
	}
	public String getPiecePerdu() {
		return piecePerdu;
	}
	public void setPiecePerdu(String piecePerdu) {
		this.piecePerdu = piecePerdu;
	}
	
	
	

}
