package echec;

import ca.ntro.app.NtroClientFx;
import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.frontend.FrontendRegistrarFx;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import echec.dorsal.DorsalEchec;
import echec.frontal.FrontalEchec;
import echec.modeles.ModeleDetailJeu;
import echec.modeles.valeurs.DetailPartie;

public class ClientEchec implements NtroClientFx{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NtroClientFx.launch(args);
	}

	@Override
	public void registerBackend(BackendRegistrar registrar) {
		// TODO Auto-generated method stub
		registrar.registerBackend(new DorsalEchec());
	}

	@Override
	public void registerFrontend(FrontendRegistrarFx registrar) {
		// TODO Auto-generated method stub
		registrar.registerFrontend(new FrontalEchec());
	}

	@Override
	public void registerMessages(MessageRegistrar registrar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerModels(ModelRegistrar registrar) {
		// TODO Auto-generated method stub
		registrar.registerModel(ModeleDetailJeu.class);
		registrar.registerValue(DetailPartie.class);
	}

}
