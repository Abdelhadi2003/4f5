package echec.frontal.taches;
import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.core.clock.Tick;
import ca.ntro.core.reflection.observer.Modified;
import echec.frontal.vues.VueDetailPartie;
import echec.frontal.vues.VueFileAttente;
import echec.frontal.vues.donnees.DonneesVueFileAttente;
import echec.frontal.vues.fragments.FragmentPiecePerdu;
import echec.messages.MsgPiecePerdu;
import echec.modeles.ModeleDetailJeu;

public class AfficherFileAttente {
	public static void creerTaches(FrontendTasks tasks) {
		creerDonneesVueFileAttente(tasks);
		tasks.taskGroup("AfficherFileAttente")
			.waitsFor(created(DonneesVueFileAttente.class))
			.andContains(subTasks -> {
				afficherFileAttente(subTasks);
				prochaineImageFileAttente(subTasks);
			});
	}
	
	public static void afficherFileAttente(FrontendTasks tasks) {
		tasks.task("afficherFileAttente")
			.waitsFor(modified(ModeleDetailJeu.class))
			.waitsFor(viewLoader(FragmentPiecePerdu.class))
			.executes(inputs -> {
				VueFileAttente vueFileAttente = inputs.get(created(VueFileAttente.class));
				Modified<ModeleDetailJeu> detailJeu = inputs.get(modified(ModeleDetailJeu.class));			
				ViewLoader<FragmentPiecePerdu> viewLoaderPiecePerdu = inputs.get(viewLoader(FragmentPiecePerdu.class));
			});
	}
	
	public static void afficherPiecePerduHasard(FrontendTasks tasks) {
		tasks.task("afficherPiecePerduHasard")
		.waitsFor(message(MsgPiecePerdu.class))
		.executes(inputs -> {
			VueFileAttente vueFileAttente = inputs.get(created(VueFileAttente.class));
			MsgPiecePerdu msgPiecePerdu = inputs.get(message(MsgPiecePerdu.class));
			msgPiecePerdu.afficherPiecePerduHasardSur(vueFileAttente);
		});
	}
	
	public static void creerDonneesVueFileAttente(FrontendTasks tasks) {
		tasks.task(create(DonneesVueFileAttente.class))
		.waitsFor("Initialisation")
		.executesAndReturnsCreatedValue(inputs -> {
			return new DonneesVueFileAttente();
		});
	}
	
	private static void prochaineImageFileAttente(FrontendTasks subTasks) {
		subTasks.task("prochaineImageFileAttente")
			.waitsFor(clock().nextTick())
			.thenExecutes(inputs -> {
				DonneesVueFileAttente donneesVueFileAttente = inputs.get(created(DonneesVueFileAttente.class));
				VueFileAttente vueFileAttente = inputs.get(created(VueFileAttente.class));
				donneesVueFileAttente.afficherSur(vueFileAttente);
			});
	}
	
	

}
