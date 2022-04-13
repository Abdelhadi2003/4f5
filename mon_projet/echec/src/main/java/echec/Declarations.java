package echec;

import ca.ntro.app.ServerRegistrar;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import echec.messages.MsgAjouterPiecePerdu;
import echec.modeles.ModeleDetailJeu;
import echec.modeles.monde_echec2d.Balle2d;
import echec.modeles.monde_echec2d.MondeEchec2d;
import echec.modeles.monde_echec2d.Objet2d;
import echec.modeles.valeurs.DetailPartie;

public class Declarations {
	public static void declarerMessages(MessageRegistrar registrar) {
		registrar.registerMessage(MsgAjouterPiecePerdu.class);
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
