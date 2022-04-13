package echec.dorsal;

import ca.ntro.app.ServerRegistrar;
import ca.ntro.app.backend.RemoteBackendNtro;
import echec.Declarations;

public class DorsalEchecDistant extends RemoteBackendNtro{

	@Override
	public void registerServer(ServerRegistrar registrar) {
		// TODO Auto-generated method stub
		Declarations.declarerServeur(registrar);
	}

}
