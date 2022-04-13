package echec.modeles.monde_echec2d;

import ca.ntro.core.initialization.Ntro;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.ArcType;

public class Balle2d extends Objet2d{

	private static final double EPSILON = 1;
	private Image image = new Image("/piece.jpg");
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		setTopLeftX(100);
		setTopLeftY(100);
		setWidth(100);
		setHeight(100);
		setSpeedX(100 + Ntro.random().nextInt(100));
		setSpeedY(100 + Ntro.random().nextInt(100));
		
	}
	
	@Override
	protected boolean onMouseEvent(MouseEvent evtFx, double worldX, double worldY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.drawImage(image, getTopLeftX(), getTopLeftY(), getWidth(), getHeight());
	}

	@Override
	public void onTimePasses(double secondsElapsed) {
		super.onTimePasses(secondsElapsed);
		
		if(balleFrappeMurGauche()) {
			balleRebondiSurMurGauche();
		}else if(balleFrappeMurDroit()){
			balleRebondiSurMurDroit();
		}else if(balleFrappePlafond()) {
			balleRebondiSurPlafond();
		}else if(balleFrappePlancher()) {
			balleRebondiSurPlancher();
		}
	}

	private void balleRebondiSurPlancher() {
		// TODO Auto-generated method stub
		setTopLeftY(getWorld().getHeight() - this.getHeight() - EPSILON);
		setSpeedY(-getSpeedY());
	}

	private boolean balleFrappePlancher() {
		// TODO Auto-generated method stub
		return collidesWith(0, getWorld().getHeight(), getWorld().getWidth(), 1);
	}

	private void balleRebondiSurPlafond() {
		// TODO Auto-generated method stub
		setTopLeftY(0 + EPSILON);
		setSpeedY(-getSpeedY());
	}

	private boolean balleFrappePlafond() {
		// TODO Auto-generated method stub
		return collidesWith(0, 0, getWorld().getWidth(), 1);
	}

	private void balleRebondiSurMurDroit() {
		// TODO Auto-generated method stub
		setTopLeftX(getWorld().getWidth() - this.getWidth() - EPSILON);
		setSpeedX(-getSpeedX());
	}

	private boolean balleFrappeMurDroit() {
		// TODO Auto-generated method stub
		return collidesWith(getWorld().getWidth(), 0, 1, getWorld().getHeight());
	}

	private void balleRebondiSurMurGauche() {
		// TODO Auto-generated method stub
		setTopLeftX(0 + EPSILON);
		setSpeedX(-getSpeedX());
	}

	private boolean balleFrappeMurGauche() {
		// TODO Auto-generated method stub
		return collidesWith(0, 0, 1, getWorld().getHeight());
	}

}
