package echec.frontal.vues;

import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import echec.frontal.evenements.EvtAfficherFileAttente;
import javafx.fxml.FXML;

public class VuePartie extends ViewFx{

	@FXML
	private Button boutonQuitterDetailPartie;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Ntro.assertNotNull("boutonQuitterPartie", boutonQuitterDetailPartie);
		installerEvtAfficherFileAttente();
	}
	
	private void installerEvtAfficherFileAttente() {
		EvtAfficherFileAttente evtNtro = NtroApp.newEvent(EvtAfficherFileAttente.class);
		boutonQuitterDetailPartie.setOnAction(evtFx -> {
			System.out.println("[VuePartie] clic: " + evtFx.getEventType());
			evtNtro.trigger();
		});
	}

}
