package echec.modeles;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.models.Model;
import echec.frontal.vues.VueFileAttente;
import echec.frontal.vues.fragments.FragmentPiecePerdu;
import echec.modeles.valeurs.DetailPartie;

public class ModeleDetailJeu implements Model {

	public ModeleDetailJeu() {

	}

	private long prochainIdJoueur = 1;
	private String nomJoueur;
	private String nomJoueur2;
	private List<String> piecePerduJoueur1 = new ArrayList<>();
	private List<String> piecePerduJoueur2 = new ArrayList<>();
	private String couleurPieceJoueur1;
	private String couleurPieceJoueur2;
	private String modeDeJeu = "Match Amical";
	private String tourDeJeu = "Joueur 1";
	
	public String getTourDeJeu() {
		return tourDeJeu;
	}

	public void setTourDeJeu(String tourDeJeu) {
		this.tourDeJeu = tourDeJeu;
	}

	private List<DetailPartie> DetailPartieOrdre = new ArrayList<>();

	public String getNomJoueur() {
		return nomJoueur;
	}

	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}

	public String getNomJoueur2() {
		return nomJoueur2;
	}

	public void setNomJoueur2(String nomJoueur2) {
		this.nomJoueur2 = nomJoueur2;
	}

	public List<String> getPiecePerduJoueur1() {
		return piecePerduJoueur1;
	}

	public void setPiecePerduJoueur1(List<String> piecePerduJoueur1) {
		this.piecePerduJoueur1 = piecePerduJoueur1;
	}

	public List<String> getPiecePerduJoueur2() {
		return piecePerduJoueur2;
	}

	public void setPiecePerduJoueur2(List<String> piecePerduJoueur2) {
		this.piecePerduJoueur2 = piecePerduJoueur2;
	}

	public String getCouleurPieceJoueur1() {
		return couleurPieceJoueur1;
	}

	public void setCouleurPieceJoueur1(String couleurPieceJoueur1) {
		this.couleurPieceJoueur1 = couleurPieceJoueur1;
	}

	public String getCouleurPieceJoueur2() {
		return couleurPieceJoueur2;
	}

	public void setCouleurPieceJoueur2(String couleurPieceJoueur2) {
		this.couleurPieceJoueur2 = couleurPieceJoueur2;
	}
	
	public String getModeDeJeu() {
		return modeDeJeu;
	}

	public void setModeDeJeu(String modeDeJeu) {
		this.modeDeJeu = modeDeJeu;
	}
	
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		int numeroJoueur = 1;
		for (DetailPartie detailPartie : DetailPartieOrdre) {
			builder.append(numeroJoueur);
			builder.append(". ");
			builder.append(detailPartie.toString());
			builder.append("\n");

			numeroJoueur++;
		}
		return builder.toString();
	}

	public void choisirNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;

	}

	public void PiecePerduJoueur(String piecePerduJoueur1, String piecePerduJoueur2) {
		// TODO Auto-generated method stub
		this.piecePerduJoueur1.add(piecePerduJoueur1);
		this.piecePerduJoueur2.add(piecePerduJoueur2);
	}

	public void choisirNomJoueur2(String nomJoueur2) {
		// TODO Auto-generated method stub
		this.nomJoueur2 = nomJoueur2;
	}

	public void renitialiserPiecePerdu() {
		// TODO Auto-generated method stub
		piecePerduJoueur1.clear();
		piecePerduJoueur2.clear();
	}

	public void choisirCouleurPieceJoueur1(String couleurPieceJoueur1) {
		// TODO Auto-generated method stub
		this.couleurPieceJoueur1 = couleurPieceJoueur1;
	}

	public void choisirCouleurPieceJoueur2(String couleurPieceJoueur2) {
		// TODO Auto-generated method stub
		this.couleurPieceJoueur2 = couleurPieceJoueur2;
	}

	public void modeDeJeu(String modeDeJeu) {
		// TODO Auto-generated method stub
		this.modeDeJeu = modeDeJeu;
	}

	public void TourDeJeu(String tourDeJeu) {
		// TODO Auto-generated method stub
		this.tourDeJeu = tourDeJeu;
	}

	

	

}
