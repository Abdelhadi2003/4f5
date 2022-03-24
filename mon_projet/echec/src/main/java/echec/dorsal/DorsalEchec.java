package echec.dorsal;

import ca.ntro.app.backend.LocalBackendNtro;
import ca.ntro.app.tasks.backend.BackendTasks;
import echec.dorsal.taches.InitialiserModeles;
import echec.dorsal.taches.ModifierFileAttente;

public class DorsalEchec extends LocalBackendNtro{

	@Override
	public void createTasks(BackendTasks tasks) {
		// TODO Auto-generated method stub
		InitialiserModeles.creerTaches(tasks);
		ModifierFileAttente.creerTaches(tasks);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}
