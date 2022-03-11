package echec.frontal.vues;

import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import echec.frontal.evenements.EvtAfficherDetailPartie;
import javafx.fxml.FXML;

public class VueFileAttente extends ViewFx {

	@FXML
	private Button boutonOuvrirDetailPartie;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Ntro.assertNotNull("boutonOuvrirParametre", boutonOuvrirDetailPartie);
		installerEvtAfficherPartie();
	}
	
	private void installerEvtAfficherPartie() {
		EvtAfficherDetailPartie evtNtro = NtroApp.newEvent(EvtAfficherDetailPartie.class);
		boutonOuvrirDetailPartie.setOnAction(evtFx -> {
			System.out.println("[VueDetailPartie] clic:" + evtFx.getEventType());
			evtNtro.trigger();
		});
	}

}
