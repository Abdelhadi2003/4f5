package echec.modeles.valeurs;

import ca.ntro.app.models.Value;

public class DetailPartie implements Value{
	
	public DetailPartie() {
		
	}
	
	public DetailPartie(String idJoueur, String nomPiecePerdu) {
		setIdJoueur(idJoueur);
		setPiecePerdu(nomPiecePerdu);
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
	
	@Override
	public String toString() {
		return piecePerdu;
	}
	

}
