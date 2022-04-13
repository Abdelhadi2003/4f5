package echec;

import ca.ntro.app.NtroServerJdk;
import ca.ntro.app.ServerRegistrarJdkImpl;
import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import echec.dorsal.DorsalEchec;

public class ServeurEchec implements NtroServerJdk {

	public static void main(String[] args) {
		NtroServerJdk.launch(args);
	}
	
	@Override
	public void registerBackend(BackendRegistrar registrar) {
		// TODO Auto-generated method stub
		registrar.registerBackend(new DorsalEchec());
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

	@Override
	public void registerServer(ServerRegistrarJdkImpl registrar) {
		// TODO Auto-generated method stub
		Declarations.declarerServeur(registrar);
	}

}
