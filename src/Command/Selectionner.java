package Command;

import Receiver.MoteurED;

public class Selectionner implements Command {
	
	private MoteurED moteur;
	private int indicedepart, indicefin;
	
	public int getIndicedepart() {
		return indicedepart;
	}

	public void setIndicedepart(int indicedepart) {
		this.indicedepart = indicedepart;
	}

	public int getIndicefin() {
		return indicefin;
	}

	public void setIndicefin(int indicefin) {
		this.indicefin = indicefin;
	}
	
	public void changeindice(int debut,int fin) {
		this.indicedepart = debut;
		this.indicefin = fin;
	}
	
	public Selectionner(MoteurED monmoteur) {
		this.moteur = monmoteur;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		moteur.selectionner(this.getIndicedepart(),this.getIndicefin());
		
	}
}
