package Client;

import java.util.HashMap;

import Command.Coller;
import Command.Command;
import Command.Copier;
import Command.Couper;
import Command.Selectionner;
import Command.Taper;
import Invoker.IHM;
import Observeur.Observeur;
import Observeur.Sujet;
import Receiver.Bufer;
import Receiver.MoteurED;
import Receiver.MoteurEDImpl;
import Receiver.Pressepapier;
import Receiver.Selection;


public class Client {
	
	private static HashMap<String, Command> commmandes;

	public static void main(String[] agrs){
		
	
		Sujet monmoteur = new MoteurEDImpl();
	
		Observeur ih=new IHM();
		
		Bufer bu=new Bufer();
		Selection selection=new Selection();
		Pressepapier presse= new Pressepapier();
		

		monmoteur.attach(ih);
		((MoteurEDImpl)monmoteur).setBuffer(bu);
		((MoteurEDImpl)monmoteur).setLaselection(selection);;
		((MoteurEDImpl)monmoteur).setPressepapier(presse);

		
		commmandes = new HashMap<String, Command>();
		commmandes.put("couper", new Couper((MoteurED)monmoteur));
		commmandes.put("copier", new Copier((MoteurED)monmoteur));
		commmandes.put("coller", new Coller((MoteurED)monmoteur));
		commmandes.put("selectionner", new Selectionner((MoteurED)monmoteur));
		commmandes.put("taper", new Taper((MoteurED)monmoteur));

		((IHM)ih).setCommands(commmandes);
	


	}
}