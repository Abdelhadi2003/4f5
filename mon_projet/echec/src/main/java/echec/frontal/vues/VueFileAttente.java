package echec.frontal.vues;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
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
import echec.messages.MsgChoisirCouleurPieceJoueur1;
import echec.messages.MsgChoisirCouleurPieceJoueur2;
import echec.messages.MsgChoisirNomJoueur;
import echec.messages.MsgChoisirNomJoueur2;
import echec.messages.MsgModeDeJeu;
import echec.messages.MsgPiecePerdu;
import echec.messages.MsgRenitialiserPiecePerdu;
import javafx.fxml.FXML;

public class VueFileAttente extends ViewFx {

	@FXML
	private Button boutonOuvrirPartie;
	@FXML
	private ComboBox<String> nomJoueurCombobox;
	@FXML
	private ComboBox<String> nomJoueurCombobox2;
	@FXML
	private ComboBox<String> couleurPieceCombobox1;
	@FXML
	private ComboBox<String> couleurPieceCombobox2;
	@FXML
	private Label piecePerduHasard;
	@FXML
	private Label piecePerduHasard2;
	@FXML
	private Label chronometre1;
	@FXML
	private Label chronometre2;
	@FXML
	private RadioButton matchAmical;
	@FXML
	private RadioButton tournois;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Ntro.assertNotNull("boutonOuvrirPartie", boutonOuvrirPartie);
		Ntro.assertNotNull("nomJoueurCombobox", nomJoueurCombobox);
		Ntro.assertNotNull("nomJoueurCombobox2", nomJoueurCombobox2);
		Ntro.assertNotNull("couleurPieceCombobox1", couleurPieceCombobox1);
		Ntro.assertNotNull("couleurPieceCombobox2", couleurPieceCombobox2);
		Ntro.assertNotNull("piecePerduHasard", piecePerduHasard);
		Ntro.assertNotNull("piecePerduHasard2", piecePerduHasard2);
		Ntro.assertNotNull("chronometre1", chronometre1);
		Ntro.assertNotNull("chronometre1", chronometre2);
		Ntro.assertNotNull("matchAmical", matchAmical);
		Ntro.assertNotNull("tournois", tournois);
		matchAmical.setSelected(true);
		installerEvtAfficherPartie();
		installerMsgChoisirNomJoueur();
		installerMsgChoisirNomJoueur2();
		installerMsgChoisirCouleurPieceJoueur1();
		installerMsgChoisirCouleurPieceJoueur2();
		renitialiserPiecePerduHasard();
		installerMsgPiecePerdu();
		installerMsgModeDeJeu();
	}

	private void installerEvtAfficherPartie() {
		EvtAfficherDetailPartie evtNtro = NtroApp.newEvent(EvtAfficherDetailPartie.class);
		boutonOuvrirPartie.setOnAction(evtFx -> {
			evtNtro.trigger();
		});
	}

	public Pane petitEspaceVertical() {
		Pane petitEspaceVertical = new Pane();
		petitEspaceVertical.getStyleClass().add("petit-espace-vertical");
		return petitEspaceVertical;
	}


	private void viderPiecePerduHasard() {
		piecePerduHasard.setText("");
	}
	
	private void viderPiecePerduHasard2() {
		piecePerduHasard2.setText("");
	}
	private void renitialiserPiecePerduHasard() {
		MsgRenitialiserPiecePerdu msgRenitialiserPiecePerdu = NtroApp.newMessage(MsgRenitialiserPiecePerdu.class);
		viderPiecePerduHasard();
		viderPiecePerduHasard2();
		msgRenitialiserPiecePerdu.send();
	}

	private void installerMsgPiecePerdu() {
		MsgPiecePerdu msgPiecePerdu = NtroApp.newMessage(MsgPiecePerdu.class);
		viderPiecePerduHasard();
		for (int i = 0; i < 3; i++) {
			msgPiecePerdu.setPiecePerdu(nomPiecePerdu());
			msgPiecePerdu.setPiecePerdu2(nomPiecePerdu());
			msgPiecePerdu.send();
			afficherPiecePerduHasard(msgPiecePerdu.getPiecePerdu());
			afficherPiecePerduHasard2(msgPiecePerdu.getPiecePerdu2());
		}
	}

	private void installerMsgChoisirNomJoueur() {
		MsgChoisirNomJoueur msgChoisirNomJoueur = NtroApp.newMessage(MsgChoisirNomJoueur.class);
		nomJoueurCombobox.setOnAction(evtFx -> {
			msgChoisirNomJoueur.setNomJoueur(nomJoueurCombobox.getValue());
			msgChoisirNomJoueur.send();
		});
	}
	
	private void installerMsgChoisirNomJoueur2() {
		MsgChoisirNomJoueur2 msgChoisirNomJoueur2 = NtroApp.newMessage(MsgChoisirNomJoueur2.class);
		nomJoueurCombobox2.setOnAction(evtFx -> {
			msgChoisirNomJoueur2.setNomJoueur2(nomJoueurCombobox2.getValue());
			msgChoisirNomJoueur2.send();
		});
	}
	
	private void installerMsgChoisirCouleurPieceJoueur1() {
		MsgChoisirCouleurPieceJoueur1 msgChoisirCouleurPieceJoueur1 = NtroApp.newMessage(MsgChoisirCouleurPieceJoueur1.class);
		couleurPieceCombobox1.setOnAction(evtFx -> {
			msgChoisirCouleurPieceJoueur1.setCouleurPieceJoueur1(couleurPieceCombobox1.getValue());
			msgChoisirCouleurPieceJoueur1.send();
		});
	}
	
	private void installerMsgChoisirCouleurPieceJoueur2() {
		MsgChoisirCouleurPieceJoueur2 msgChoisirCouleurPieceJoueur2 = NtroApp.newMessage(MsgChoisirCouleurPieceJoueur2.class);
		couleurPieceCombobox2.setOnAction(evtFx -> {
			msgChoisirCouleurPieceJoueur2.setCouleurPieceJoueur2(couleurPieceCombobox2.getValue());
			msgChoisirCouleurPieceJoueur2.send();
		});
	}

	public void afficherPiecePerduHasard(String piecePerdu) {
		String ancienneText = piecePerduHasard.getText();
		piecePerduHasard.setText(ancienneText + " " + piecePerdu);

	}

	public void afficherPiecePerduHasard2(String piecePerdu2) {
		String ancienneText = piecePerduHasard2.getText();
		piecePerduHasard2.setText(ancienneText + " " + piecePerdu2);

	}
	
	private void installerMsgModeDeJeu() {
		MsgModeDeJeu msgModeDeJeu = NtroApp.newMessage(MsgModeDeJeu.class);
		matchAmical.setOnAction(evtFx -> {
			if(matchAmical.isSelected()){
				msgModeDeJeu.setModeDeJeu("Match amical");
				msgModeDeJeu.send();
			} 
		});
		tournois.setOnAction(evtFx -> {
			if(tournois.isSelected()) {
				msgModeDeJeu.setModeDeJeu("Tournois");
				msgModeDeJeu.send();
			}
		});
	}

	private String nomPiecePerdu() {
		List<String> PiecePerduJoueur = List.of("roi", "reine", "fou", "tour", "cavalier", "pion");
		return Ntro.random().choice(PiecePerduJoueur);
	}

	
	public void afficherChronometre1(String chrono1) {
		chronometre1.setText(chrono1);
	}

	public void afficherChronometre2(String chrono2) {
		chronometre2.setText(chrono2);
	}

}
