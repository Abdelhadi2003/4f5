package echec.modeles.valeurs;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.models.Value;
import echec.frontal.vues.fragments.FragmentPiecePerdu;

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

	public void afficherSur(FragmentPiecePerdu fragmentPiecePerdu) {
		// TODO Auto-generated method stub
		fragmentPiecePerdu.afficherPiecePerdu(piecePerdu);
	}

	public FragmentPiecePerdu creerFragment(ViewLoader<FragmentPiecePerdu> viewLoaderPiecePerdu) {
		// TODO Auto-generated method stub
		return viewLoaderPiecePerdu.createView();
	}
	

}
