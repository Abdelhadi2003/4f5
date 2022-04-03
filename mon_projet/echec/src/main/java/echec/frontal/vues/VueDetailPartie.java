package echec.frontal.vues;

import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import echec.frontal.evenements.EvtAfficherFileAttente;
import echec.frontal.vues.controles.CanvasPartie;
import echec.modeles.monde_echec2d.MondeEchec2d;
import javafx.fxml.FXML;

public class VueDetailPartie extends ViewFx{

	@FXML
	private Button boutonQuitterDetailPartie;
	@FXML
	private CanvasPartie canvasPartie;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Ntro.assertNotNull("boutonQuitterPartie", boutonQuitterDetailPartie);
		installerEvtAfficherFileAttente();
		Ntro.assertNotNull("canvasPartie", canvasPartie);
		initialiserCanvasPartie();
		
	}
	
	private void installerEvtAfficherFileAttente() {
		EvtAfficherFileAttente evtNtro = NtroApp.newEvent(EvtAfficherFileAttente.class);
		boutonQuitterDetailPartie.setOnAction(evtFx -> {
			System.out.println("[VueDetailPartie] clic: " + evtFx.getEventType());
			evtNtro.trigger();
		});
	}
	
	private void initialiserCanvasPartie() {
		canvasPartie.setWorldWidth(MondeEchec2d.LARGEUR_MONDE);
		canvasPartie.setWorldHeight(MondeEchec2d.HAUTEUR_MONDE);
	}
	
	public void viderCanvas() {
		canvasPartie.clearCanvas();
	}
	
	public void afficherImagesParSeconde(String fps) {
		canvasPartie.displayFps(fps);
	}
	
	public void afficherEchec2d(MondeEchec2d mondeEchec2d) {
		canvasPartie.displayWorld2d(mondeEchec2d);
	}
	
	

}
