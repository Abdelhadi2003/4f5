package echec.frontal.vues.donnees;

import ca.ntro.app.frontend.ViewData;
import ca.ntro.core.initialization.Ntro;
import echec.frontal.vues.VueDetailPartie;
import echec.modeles.monde_echec2d.MondeEchec2d;

public class DonneesVuePartie implements ViewData{
	
	private MondeEchec2d mondeEchec2d = new MondeEchec2d();
	private String fpsCourant= "0";
	private static long CALCULER_FPS_A_CHAQUE_X_MILLISECONDES = 200;
	private long horodatageDernierCalculFps = Ntro.time().nowMilliseconds();
	private long imagesAfficheesDepuisDernierCalculFps = 0;
	
	public void afficherSur(VueDetailPartie vuePartie) {
		calculerFpsSiNecessaire();
		
		vuePartie.viderCanvas();
		vuePartie.afficherImagesParSeconde("FPS " + fpsCourant);
		vuePartie.afficherEchec2d(mondeEchec2d);
		
		imagesAfficheesDepuisDernierCalculFps++;
	}
	
	private void calculerFpsSiNecessaire() {
		long horodatageMaintenant = Ntro.time().nowMilliseconds();
		long millisecondesEcoulees = horodatageMaintenant - horodatageDernierCalculFps;
		
		if(millisecondesEcoulees > CALCULER_FPS_A_CHAQUE_X_MILLISECONDES) {
			calculerFpsMaintenant(millisecondesEcoulees);
			
			imagesAfficheesDepuisDernierCalculFps = 0;
			horodatageDernierCalculFps = horodatageMaintenant;
		}
	}
	
	private void calculerFpsMaintenant(long millisecondesEcoulees) {
		double secondesEcoulees = millisecondesEcoulees / 1E3;
		double fps = imagesAfficheesDepuisDernierCalculFps / secondesEcoulees;
		fpsCourant = String.valueOf(Math.round(fps));
	}
	
	public void reagirTempsQuiPasse(double elapsedTime) {
		mondeEchec2d.onTimePasses(elapsedTime);
	}

}
