package echec.dorsal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

import ca.ntro.app.tasks.backend.BackendTasks;
import echec.messages.MsgAjouterPiecePerdu;
import echec.modeles.ModeleDetailJeu;

public class ModifierFileAttente {

	public static void creerTaches(BackendTasks tasks) {

		tasks.taskGroup("ModifierFileAttente")

				.waitsFor("InitialiserModeles")

				.andContains(subTasks -> {

					ajouterPiecePerdu(subTasks);
				});
	}

	private static void ajouterPiecePerdu(BackendTasks tasks) {
		tasks.task("ajouterPiecePerdu")
			.waitsFor(message(MsgAjouterPiecePerdu.class))
			.thenExecutes(inputs -> {
				MsgAjouterPiecePerdu msgAjouterPiecePerdu = inputs.get(message(MsgAjouterPiecePerdu.class));
				ModeleDetailJeu detailJeu = inputs.get(model(ModeleDetailJeu.class));
				msgAjouterPiecePerdu.ajouterA(detailJeu);
		});
	}

}
