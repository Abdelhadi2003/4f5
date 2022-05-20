package echec.messages;

import ca.ntro.app.messages.MessageNtro;
import echec.modeles.ModeleDetailJeu;

public class MsgTourDeJeu extends MessageNtro{
private String tourDeJeu;
	
	public MsgTourDeJeu() {
		
	}
	
	public String getTourDeJeu() {
		return tourDeJeu;
	}

	public void setTourDeJeu(String tourDeJeu) {
		this.tourDeJeu = tourDeJeu;
	}
	
	
	
	public void ajouterA(ModeleDetailJeu detailJeu) {
		detailJeu.TourDeJeu(tourDeJeu);
	}
}
