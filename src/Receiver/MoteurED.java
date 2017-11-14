package Receiver;

public interface MoteurED {
	
	void taper(StringBuffer stringbuffer);
	void inserer(int position);
	void selectionner(int indicedepart, int indicefin);
	void copie(String textcopie);
	void coller(int position);
	void couper();
	void Supprimer();
	
}
