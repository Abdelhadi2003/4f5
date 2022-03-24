package echec.frontal.taches;
import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.core.reflection.observer.Modified;
import echec.frontal.vues.VueFileAttente;
import echec.modeles.ModeleDetailJeu;

public class AfficherFileAttente {
	public static void creerTaches(FrontendTasks tasks) {
		tasks.taskGroup("AfficherFileAttente")
			.waitsFor("Initialisation")
			.andContains(subTasks -> {
				afficherFileAttente(subTasks);
			});
	}
	
	public static void afficherFileAttente(FrontendTasks tasks) {
		tasks.task("afficherFileAttente")
			.waitsFor(modified(ModeleDetailJeu.class))
			.executes(inputs -> {
				VueFileAttente vueFileAttente = inputs.get(created(VueFileAttente.class));
				Modified<ModeleDetailJeu> detailJeu = inputs.get(modified(ModeleDetailJeu.class));
				
				ModeleDetailJeu ancienneFile = detailJeu.previousValue();
				ModeleDetailJeu fileCourante = detailJeu.currentValue();
				fileCourante.afficherSur(vueFileAttente);
			});
	}

}
