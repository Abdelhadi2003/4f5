package pong.frontal;

import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.frontend.events.EventRegistrar;
import ca.ntro.app.services.Window;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import pong.frontal.taches.initialisation;
import pong.frontal.vues.VueFileAttente;
import pong.frontal.vues.VueRacine;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

public class FrontalPong implements FrontendFx{

	@Override
	public void createTasks(FrontendTasks tasks) {
		// TODO Auto-generated method stub
		initialisation.creerTaches(tasks);
		tasks.task("afficherFenetre")
		.waitsFor(window())
		.thenExecutes(inputs -> {
			Window window = inputs.get(window());
			window.show();
		});
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerEvents(EventRegistrar registrar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerViews(ViewRegistrarFx registrar) {
		// TODO Auto-generated method stub
		registrar.registerView(VueRacine.class, "/racine.xml");
		registrar.registerView(VueFileAttente.class, "/file_attente.xml");
	}

}
