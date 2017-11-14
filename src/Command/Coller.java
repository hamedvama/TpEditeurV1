package Command;

import Receiver.MoteurED;

public class Coller implements Command {
	
	private int position;
	private MoteurED monmoteur;

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	
	
	public Coller(MoteurED monmoteur) {

		this.monmoteur = monmoteur;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println(this.position);
		monmoteur.coller(position);
	}

}
