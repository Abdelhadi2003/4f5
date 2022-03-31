package echec.modeles;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.models.Model;
import echec.frontal.vues.VueFileAttente;
import echec.frontal.vues.fragments.FragmentPiecePerdu;
import echec.messages.MsgAjouterPiecePerdu;
import echec.modeles.valeurs.DetailPartie;

public class ModeleDetailJeu implements Model {
	
	public ModeleDetailJeu() {
		
	}
	private long prochainIdJoueur = 1;
	private List<DetailPartie> DetailPartieOrdre = new ArrayList<>();

	public List<DetailPartie> getDetailPartie() {
		return DetailPartieOrdre;
	}

	public void setDetailPartie(List<DetailPartie> detailPartie) {
		DetailPartieOrdre = detailPartie;
	}
	
	public void ajouterPiecePerduPour(String nomPiecePerdu) {
		String idJoueur = genererIdJoueur();
		DetailPartie detailPartie = new DetailPartie(idJoueur, nomPiecePerdu);
		DetailPartieOrdre.add(detailPartie);
	}

	private String genererIdJoueur() {
		// TODO Auto-generated method stub
		String idJoueur = String.valueOf(prochainIdJoueur);
		prochainIdJoueur++;
		return idJoueur;
	}
	
	public void afficherSur(VueFileAttente vueFileAttente,
			ViewLoader<FragmentPiecePerdu> viewLoaderPiecePerdu) {
			vueFileAttente.viderListePiecePerdu();
			for(DetailPartie detailPartie : DetailPartieOrdre) {
				FragmentPiecePerdu fragmentPiecePerdu = detailPartie.creerFragment(viewLoaderPiecePerdu);
				detailPartie.afficherSur(fragmentPiecePerdu);
				vueFileAttente.ajouterPiecePerdu(fragmentPiecePerdu);
			}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		int numeroJoueur = 1;
		for(DetailPartie detailPartie : DetailPartieOrdre) {
			builder.append(numeroJoueur);
			builder.append(". ");
			builder.append(detailPartie.toString());
			builder.append("\n");
			
			numeroJoueur++;
		}
		return builder.toString();
	}
	

}
