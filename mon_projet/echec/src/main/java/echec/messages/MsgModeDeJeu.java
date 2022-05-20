package echec.messages;

import ca.ntro.app.messages.MessageNtro;
import echec.modeles.ModeleDetailJeu;

public class MsgModeDeJeu extends MessageNtro{
private String modeDeJeu;
	
	public MsgModeDeJeu() {
		
	}
	
	public String getModeDeJeu() {
		return modeDeJeu;
	}

	public void setModeDeJeu(String modeDeJeu) {
		this.modeDeJeu = modeDeJeu;
	}
	
	
	
	public void ajouterA(ModeleDetailJeu detailJeu) {
		detailJeu.modeDeJeu(modeDeJeu);
	}
}