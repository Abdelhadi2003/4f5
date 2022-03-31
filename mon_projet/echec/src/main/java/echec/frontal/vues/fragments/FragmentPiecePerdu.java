package echec.frontal.vues.fragments;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import echec.frontal.evenements.EvtAfficherDetailPartie;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FragmentPiecePerdu extends ViewFx {

	@FXML
	private Button boutonOuvrirPartie;
	@FXML
	private Label labelPiecePerdu;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Ntro.assertNotNull("boutonOuvrirPartie", boutonOuvrirPartie);
		Ntro.assertNotNull("labelPiecePerdu", labelPiecePerdu);
		installerEvtAfficherPartie();
	}
	
	private void installerEvtAfficherPartie() {
		EvtAfficherDetailPartie evtNtro = NtroApp.newEvent(EvtAfficherDetailPartie.class);
		boutonOuvrirPartie.setOnAction(evtFx -> {
			evtNtro.trigger();
		});
	}
	
	public void afficherPiecePerdu(String piecePerdu) {
		labelPiecePerdu.setText(piecePerdu);
	}

}
