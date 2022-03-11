package echec.frontal;

import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.frontend.events.EventRegistrar;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import echec.frontal.evenements.EvtAfficherFileAttente;
import echec.frontal.evenements.EvtAfficherDetailPartie;
import echec.frontal.taches.Navigation;
import echec.frontal.taches.initialisation;
import echec.frontal.vues.VueFileAttente;
import echec.frontal.vues.VueDetailPartie;
import echec.frontal.vues.VueRacine;
import ca.ntro.app.services.Window;
import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.NtroApp;

public class FrontalEchec implements FrontendFx{

	@Override
	public void createTasks(FrontendTasks tasks) {
		// TODO Auto-generated method stub
		initialisation.creerTaches(tasks);
		Navigation.creerTaches(tasks);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerEvents(EventRegistrar registrar) {
		// TODO Auto-generated method stub
		registrar.registerEvent(EvtAfficherFileAttente.class);
		registrar.registerEvent(EvtAfficherDetailPartie.class);
	}

	@Override
	public void registerViews(ViewRegistrarFx registrar) {
		// TODO Auto-generated method stub
		registrar.registerView(VueRacine.class, "/racine.xml");
		registrar.registerView(VueFileAttente.class, "/file_attente.xml");
		//registrar.registerStylesheet("/dev.css");
		registrar.registerStylesheet("/prod.css");
		registrar.registerDefaultResources("/chaines_fr.properties");
		registrar.registerResources(NtroApp.locale("en"),"/chaines_en.properties");
		registrar.registerView(VueDetailPartie.class, "/detailPartie.xml");
		
	}

}
