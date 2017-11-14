package Command;

import Receiver.MoteurED;

public class Inserer implements Command {
	
	private int position;
	private MoteurED monmoteur;

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	

	public Inserer(MoteurED monmoteur) {
		this.monmoteur = monmoteur;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		this.monmoteur.inserer(this.getPosition());
	}

}
