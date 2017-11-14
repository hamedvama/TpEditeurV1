package Command;

import Receiver.MoteurED;

public class Couper implements Command {

	private MoteurED monmoteur;

	public Couper(MoteurED monmoteur) {
		this.monmoteur = monmoteur;
		
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		this.monmoteur.couper();
		
	}

}
