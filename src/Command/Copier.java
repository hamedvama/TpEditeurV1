package Command;

import Receiver.MoteurED;

public class Copier implements Command {
	
	private String textcopie;
	private MoteurED monmoteur;
		
	
	public String getTextcopie() {
		return textcopie;
	}

	public void setTextcopie(String textcopie) {
		this.textcopie = textcopie;
	}

	public Copier(MoteurED monmoteur) {
		this.monmoteur = monmoteur;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		monmoteur.copie(this.getTextcopie());
		
	}

}
