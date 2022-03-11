package echec.modeles;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.models.Model;
import echec.modeles.valeurs.DetailPartie;

public class ModeleDetailJeu implements Model {
	
	public ModeleDetailJeu() {
		
	}
	
	private List<DetailPartie> DetailPartie = new ArrayList<>();

	public List<DetailPartie> getDetailPartie() {
		return DetailPartie;
	}

	public void setDetailPartie(List<DetailPartie> detailPartie) {
		DetailPartie = detailPartie;
	}
	
	

}
