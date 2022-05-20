package echec.dorsal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

import ca.ntro.app.tasks.backend.BackendTasks;
import echec.messages.MsgChoisirCouleurPieceJoueur1;
import echec.messages.MsgChoisirCouleurPieceJoueur2;
import echec.messages.MsgChoisirNomJoueur;
import echec.messages.MsgChoisirNomJoueur2;
import echec.messages.MsgModeDeJeu;
import echec.messages.MsgPiecePerdu;
import echec.messages.MsgRenitialiserPiecePerdu;
import echec.messages.MsgTourDeJeu;
import echec.modeles.ModeleDetailJeu;

public class ModifierFileAttente {

	public static void creerTaches(BackendTasks tasks) {

		tasks.taskGroup("ModifierFileAttente")

				.waitsFor("InitialiserModeles")

				.andContains(subTasks -> {
					choisirNomJoueur(subTasks);
					choisirNomJoueur2(subTasks);
					choisirCouleurPieceJoueur1(subTasks);
					choisirCouleurPieceJoueur2(subTasks);
					piecePerduHasard(subTasks);
					renitialiserPiecePerdu(subTasks);
					modeDeJeu(subTasks);
					tourDeJeu(subTasks);
				});
	}

	
	private static void choisirNomJoueur(BackendTasks tasks) {
        tasks.task("choisirNomJoueur")
            .waitsFor(message(MsgChoisirNomJoueur.class))
            .thenExecutes(inputs -> { 
            	MsgChoisirNomJoueur msgChoisirNomJoueur = inputs.get(message(MsgChoisirNomJoueur.class));
            	ModeleDetailJeu detailJeu = inputs.get(model(ModeleDetailJeu.class));
            	msgChoisirNomJoueur.ajouterA(detailJeu);
            });
    }
	
	private static void choisirNomJoueur2(BackendTasks tasks) {
        tasks.task("choisirNomJoueur2")
            .waitsFor(message(MsgChoisirNomJoueur2.class))
            .thenExecutes(inputs -> { 
            	MsgChoisirNomJoueur2 msgChoisirNomJoueur2 = inputs.get(message(MsgChoisirNomJoueur2.class));
            	ModeleDetailJeu detailJeu = inputs.get(model(ModeleDetailJeu.class));
            	msgChoisirNomJoueur2.ajouterA(detailJeu);
            });
    }
	
	private static void choisirCouleurPieceJoueur1(BackendTasks tasks) {
        tasks.task("choisirCouleurPieceJoueur1")
            .waitsFor(message(MsgChoisirCouleurPieceJoueur1.class))
            .thenExecutes(inputs -> { 
            	MsgChoisirCouleurPieceJoueur1 msgChoisirCouleurPieceJoueur1 = inputs.get(message(MsgChoisirCouleurPieceJoueur1.class));
            	ModeleDetailJeu detailJeu = inputs.get(model(ModeleDetailJeu.class));
            	msgChoisirCouleurPieceJoueur1.ajouterA(detailJeu);
            });
    }
	
	private static void choisirCouleurPieceJoueur2(BackendTasks tasks) {
        tasks.task("choisirCouleurPieceJoueur2")
            .waitsFor(message(MsgChoisirCouleurPieceJoueur2.class))
            .thenExecutes(inputs -> { 
            	MsgChoisirCouleurPieceJoueur2 msgChoisirCouleurPieceJoueur2 = inputs.get(message(MsgChoisirCouleurPieceJoueur2.class));
            	ModeleDetailJeu detailJeu = inputs.get(model(ModeleDetailJeu.class));
            	msgChoisirCouleurPieceJoueur2.ajouterA(detailJeu);
            });
    }
	
	private static void piecePerduHasard(BackendTasks tasks) {
		tasks.task("piecePerduHasard")
			.waitsFor(message(MsgPiecePerdu.class))
			.thenExecutes(inputs -> {
				MsgPiecePerdu msgPiecePerdu = inputs.get(message(MsgPiecePerdu.class));
				ModeleDetailJeu detailJeu = inputs.get(model(ModeleDetailJeu.class));
				msgPiecePerdu.ajouterA(detailJeu);
				msgPiecePerdu.broadcast();
		});
	}
	
	private static void renitialiserPiecePerdu(BackendTasks tasks) {
		tasks.task("renitialiserPiecePerdu")
			.waitsFor(message(MsgRenitialiserPiecePerdu.class))
			.thenExecutes(inputs -> {
				MsgRenitialiserPiecePerdu msgRenitialiserPiecePerdu = inputs.get(message(MsgRenitialiserPiecePerdu.class));
				ModeleDetailJeu detailJeu = inputs.get(model(ModeleDetailJeu.class));
				msgRenitialiserPiecePerdu.renitialiserPiecePerdu(detailJeu);
			});
	}
	
	private static void modeDeJeu(BackendTasks tasks) {
		tasks.task("modeDeJeu")
			.waitsFor(message(MsgModeDeJeu.class))
			.thenExecutes(inputs -> {
				MsgModeDeJeu msgModeDeJeu = inputs.get(message(MsgModeDeJeu.class));
				ModeleDetailJeu detailJeu = inputs.get(model(ModeleDetailJeu.class));
				msgModeDeJeu.ajouterA(detailJeu);
			});
	}
	
	private static void tourDeJeu(BackendTasks tasks) {
		tasks.task("tourDeJeu")
			.waitsFor(message(MsgTourDeJeu.class))
			.thenExecutes(inputs -> {
				MsgTourDeJeu msgTourDeJeu = inputs.get(message(MsgTourDeJeu.class));
				ModeleDetailJeu detailJeu = inputs.get(model(ModeleDetailJeu.class));
				msgTourDeJeu.ajouterA(detailJeu);
			});
	}

}
