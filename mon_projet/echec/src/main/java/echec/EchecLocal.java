package echec;

import ca.ntro.app.NtroClientFx;
import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.frontend.FrontendRegistrarFx;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import echec.dorsal.DorsalEchec;
import echec.dorsal.DorsalEchecDistant;
import echec.frontal.FrontalEchec;
import echec.modeles.ModeleDetailJeu;
import echec.modeles.valeurs.DetailPartie;

public class EchecLocal implements NtroClientFx{

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
		Declarations.declarerMessages(registrar);
	}

	@Override
	public void registerModels(ModelRegistrar registrar) {
		// TODO Auto-generated method stub
		Declarations.declarerModeles(registrar);
	}

	public void declarerModeles(ModelRegistrar registrar) {
		registrar.registerModel(ModeleDetailJeu.class);
		registrar.registerValue(DetailPartie.class);
	}

}
