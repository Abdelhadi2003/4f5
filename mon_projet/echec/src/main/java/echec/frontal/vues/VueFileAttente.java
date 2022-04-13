package echec.frontal.vues;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import echec.Session;
import echec.frontal.evenements.EvtAfficherDetailPartie;
import echec.frontal.vues.fragments.FragmentPiecePerdu;
import echec.messages.MsgAjouterPiecePerdu;
import javafx.fxml.FXML;

public class VueFileAttente extends ViewFx {

	
	@FXML
	private Button boutonAjouterPiecePerdu;
	@FXML
	private VBox conteneurPiecePerdu;
	
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Ntro.assertNotNull("boutonAjouterPiecePerdu", boutonAjouterPiecePerdu);
		Ntro.assertNotNull("conteneurPiecePerdu", conteneurPiecePerdu);
		installerMsgAjouterPiecePerdu();
		
	}
	
	public void viderListePiecePerdu() {
		conteneurPiecePerdu.getChildren().clear();
	}
	
	public Pane petitEspaceVertical() {
		Pane petitEspaceVertical = new Pane();
		petitEspaceVertical.getStyleClass().add("petit-espace-vertical");
		return petitEspaceVertical;
	}
	
	public void ajouterPiecePerdu(FragmentPiecePerdu fragmentPiecePerdu) {
		conteneurPiecePerdu.getChildren().add(fragmentPiecePerdu.rootNode());
		conteneurPiecePerdu.getChildren().add(petitEspaceVertical());
	}
	
	private void installerMsgAjouterPiecePerdu() {
		MsgAjouterPiecePerdu msgAjouterPiecePerdu = NtroApp.newMessage(MsgAjouterPiecePerdu.class);
		boutonAjouterPiecePerdu.setOnAction(evtFx -> {
		msgAjouterPiecePerdu.setNomPiecePerdu(Session.piecePerdu);
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
	
}
	
