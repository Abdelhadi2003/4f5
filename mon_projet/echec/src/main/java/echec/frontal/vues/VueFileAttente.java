package echec.frontal.vues;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import echec.frontal.evenements.EvtAfficherDetailPartie;
import echec.messages.MsgAjouterPiecePerdu;
import javafx.fxml.FXML;

public class VueFileAttente extends ViewFx {

	@FXML
	private Button boutonOuvrirDetailPartie;
	@FXML
	private Button boutonAjouterPiecePerdu;
	@FXML
	private Label labelMessage;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Ntro.assertNotNull("boutonOuvrirParametre", boutonOuvrirDetailPartie);
		Ntro.assertNotNull("boutonAjouterPiecePerdu", boutonAjouterPiecePerdu);
		Ntro.assertNotNull("labelMessage", labelMessage);
		installerEvtAfficherPartie();
		installerMsgAjouterPiecePerdu();
		
	}
	
	private void installerEvtAfficherPartie() {
		EvtAfficherDetailPartie evtNtro = NtroApp.newEvent(EvtAfficherDetailPartie.class);
		boutonOuvrirDetailPartie.setOnAction(evtFx -> {
			System.out.println("[VueDetailPartie] clic:" + evtFx.getEventType());
			evtNtro.trigger();
		});
	}
	private void installerMsgAjouterPiecePerdu() {
		MsgAjouterPiecePerdu msgAjouterPiecePerdu = NtroApp.newMessage(MsgAjouterPiecePerdu.class);
		boutonAjouterPiecePerdu.setOnAction(evtFx -> {
		msgAjouterPiecePerdu.setNomPiecePerdu(nomPiecePerdu());
		msgAjouterPiecePerdu.send();
		});
	}
	
	private String nomPiecePerdu() {
		List<String> PiecePerduJoueur = List.of("roi",
												"reine",
												"fou",
												"tour",
												"cavalier",
												"pion");
		return Ntro.random().choice(PiecePerduJoueur);
	}
	
	public void afficherMessage(String message) {
		labelMessage.setText(message);
	}
}
	
