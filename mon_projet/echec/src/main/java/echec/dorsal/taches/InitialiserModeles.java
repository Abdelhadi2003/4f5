package echec.dorsal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

import ca.ntro.app.tasks.backend.BackendTasks;
import echec.modeles.ModeleDetailJeu;



public class InitialiserModeles {
	
	public static void creerTaches(BackendTasks tasks) {
		tasks.taskGroup("InitialiserModeles")
	
			.contains(subTasks -> {
				initialiserModeleDetailPartie(subTasks);
			});
	}
	
	private static void initialiserModeleDetailPartie(BackendTasks tasks) {
		
		tasks.task("initialiserModeleDetailPartie")
			.waitsFor(model(ModeleDetailJeu.class))
			.thenExecutes(inputs -> {
				ModeleDetailJeu detailPartie = inputs.get(model(ModeleDetailJeu.class));
			});
	}

}
