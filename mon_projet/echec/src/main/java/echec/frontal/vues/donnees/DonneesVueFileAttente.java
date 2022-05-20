package echec.frontal.vues.donnees;

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.ViewData;
import ca.ntro.core.initialization.Ntro;

import echec.frontal.vues.VueFileAttente;
import echec.messages.MsgTourDeJeu;


public class DonneesVueFileAttente implements ViewData {

	private int chrono1 = 40;
	private int chrono2 = 40;
	private String tourDeJeu = "chrono1";

	private static long CALCULER_CHRONO_A_CHAQUE_X_MILLISECONDES = 1000;
	private long horodatageDernierCalculChrono = Ntro.time().nowMilliseconds();

	private void calculerChronoSiNecessaire() {
		long horodatageMaintenant = Ntro.time().nowMilliseconds();
		long millisecondesEcoulees = horodatageMaintenant - horodatageDernierCalculChrono;

		if (millisecondesEcoulees > CALCULER_CHRONO_A_CHAQUE_X_MILLISECONDES) {
				calculerChronoMaintenant(millisecondesEcoulees);
				horodatageDernierCalculChrono = horodatageMaintenant;
		}

	}

	private void calculerChronoMaintenant(long millisecondesEcoulees) {
		double secondesEcoulees = Math.round(millisecondesEcoulees / 1E3);
		if (tourDeJeu.equals("chrono1")) {
			chrono1 -= secondesEcoulees;
			if(chrono1 <= 0) {
				MsgTourDeJeu msgTourDeJeu = NtroApp.newMessage(MsgTourDeJeu.class);
				msgTourDeJeu.setTourDeJeu("Joueur 2");
				msgTourDeJeu.send();
				tourDeJeu = "chrono2";
				chrono1 = 40;
			}
		} else if(tourDeJeu.equals("chrono2")) {
			chrono2 -= secondesEcoulees;
			if(chrono2 <= 0) {
				MsgTourDeJeu msgTourDeJeu = NtroApp.newMessage(MsgTourDeJeu.class);
				msgTourDeJeu.setTourDeJeu("Joueur 1");
				msgTourDeJeu.send();
				tourDeJeu = "chrono1";
				chrono2 = 40;
			}
		}

	}


	public void afficherSur(VueFileAttente vueFileAttente) {
		// TODO Auto-generated method stub
		calculerChronoSiNecessaire();
		vueFileAttente.afficherChronometre1(" "+String.valueOf(chrono1) + " sec");
		vueFileAttente.afficherChronometre2(String.valueOf(chrono2) + " sec");
	}

}
