package echec.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import echec.frontal.evenements.EvtAfficherFileAttente;
import echec.frontal.evenements.EvtAfficherDetailPartie;
import echec.frontal.vues.VueFileAttente;
import echec.frontal.vues.VueDetailPartie;
import echec.frontal.vues.VueRacine;

public class Navigation {


	public static void creerTaches(FrontendTasks tasks) {
	tasks.taskGroup("Navigation")
		.waitsFor("Initialisation")
		.andContains(subTasks -> {

			afficherVueFileAttente(subTasks);
			creerVueDetailPartie(subTasks);
			afficherVueDetailPartie(subTasks);
		});
	}

	private static void creerVueDetailPartie(FrontendTasks tasks) {
		tasks.task(create(VueDetailPartie.class))
			.waitsFor(viewLoader(VueDetailPartie.class))
			.thenExecutesAndReturnsValue(inputs -> {
				ViewLoader<VueDetailPartie> viewLoader = inputs.get(viewLoader(VueDetailPartie.class));
				VueDetailPartie vueDetailPartie = viewLoader.createView();
				return vueDetailPartie;
			});
	}

	private static void afficherVueDetailPartie(FrontendTasks tasks) {
		tasks.task("afficherVueDetailPartie")
			.waitsFor(created(VueDetailPartie.class))
			.waitsFor(event(EvtAfficherDetailPartie.class))
			.thenExecutes(inputs -> {
				VueRacine vueRacine = inputs.get(created(VueRacine.class));
				VueDetailPartie vueDetailPartie = inputs.get(created(VueDetailPartie.class));

				vueRacine.afficherSousVue(vueDetailPartie);
			});
	}

	private static void afficherVueFileAttente(FrontendTasks tasks) {
		tasks.task("afficherVueFileAttente")
			.waitsFor(event(EvtAfficherFileAttente.class))
			.thenExecutes(inputs -> {
				VueRacine vueRacine = inputs.get(created(VueRacine.class));
				VueFileAttente vueFileAttente = inputs.get(created(VueFileAttente.class));
				vueRacine.afficherSousVue(vueFileAttente);
			});

	}

}