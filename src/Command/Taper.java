package Command;

import Receiver.*;

public class Taper implements Command {

	private MoteurED monmoteur;
	private StringBuffer texttaper;

	public StringBuffer getTexttaper() {
		return texttaper;
	}

	public void setTexttaper(StringBuffer texttaper) {
		this.texttaper = texttaper;
	}

	public Taper() {

	}

	public Taper(MoteurED monmoteur) {
		this.monmoteur = monmoteur;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		monmoteur.taper(this.getTexttaper());

	}
}
