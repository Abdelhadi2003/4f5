package echec;

import ca.ntro.app.ServerRegistrar;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import echec.messages.MsgChoisirCouleurPieceJoueur1;
import echec.messages.MsgChoisirCouleurPieceJoueur2;
import echec.messages.MsgChoisirNomJoueur;
import echec.messages.MsgChoisirNomJoueur2;
import echec.messages.MsgModeDeJeu;
import echec.messages.MsgPiecePerdu;
import echec.messages.MsgRenitialiserPiecePerdu;
import echec.messages.MsgTourDeJeu;
import echec.modeles.ModeleDetailJeu;
import echec.modeles.monde_echec2d.Balle2d;
import echec.modeles.monde_echec2d.MondeEchec2d;
import echec.modeles.monde_echec2d.Objet2d;
import echec.modeles.valeurs.DetailPartie;

public class Declarations {
	public static void declarerMessages(MessageRegistrar registrar) {
		registrar.registerMessage(MsgChoisirNomJoueur.class);
		registrar.registerMessage(MsgChoisirNomJoueur2.class);
		registrar.registerMessage(MsgPiecePerdu.class);
		registrar.registerMessage(MsgRenitialiserPiecePerdu.class);
		registrar.registerMessage(MsgChoisirCouleurPieceJoueur1.class);
		registrar.registerMessage(MsgChoisirCouleurPieceJoueur2.class);
		registrar.registerMessage(MsgModeDeJeu.class);
		registrar.registerMessage(MsgTourDeJeu.class);
	}
	
	public static void declarerModeles(ModelRegistrar registrar) {
		registrar.registerValue(DetailPartie.class);
		registrar.registerModel(ModeleDetailJeu.class);
		registrar.registerValue(MondeEchec2d.class);
		registrar.registerValue(Balle2d.class);
		registrar.registerValue(Objet2d.class);
	}
	
	public static void declarerServeur(ServerRegistrar registrar) {
		registrar.registerName("localhost");
		registrar.registerPort(8002);
	}

}
