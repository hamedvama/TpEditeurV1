package Observeur;

import Observeur.Observeur;

public interface Sujet {
	public StringBuffer getValue();
	
	
	
	public void detach(Observeur ob);

	void attach(Observeur ob);


}
