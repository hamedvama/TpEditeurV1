package Receiver;

import java.util.ArrayList;
import java.util.List;

import Invoker.IHM;
import Observeur.Observeur;
import Observeur.Sujet;

public class MoteurEDImpl implements MoteurED,Sujet {

	private Bufer buffer;
	private Selection laselection;
	private Pressepapier pressepapier;
	private List<Observeur>ListObserveur;

	public MoteurEDImpl() {
		this.buffer=new Bufer();
		this.pressepapier= new Pressepapier();
		this.laselection=new Selection();
		this.ListObserveur=new ArrayList<Observeur>();

	}

	public Bufer getBuffer() {
		return buffer;
	}


	public void setBuffer(Bufer buffer) {
		this.buffer = buffer;
	}

	public Selection getLaselection() {
		return laselection;
	}


	public void setLaselection(Selection laselection) {
		this.laselection = laselection;
	}


	public Pressepapier getPressepapier() {
		return pressepapier;
	}


	public void setPressepapier(Pressepapier pressepapier) {
		this.pressepapier = pressepapier;
	}

	@Override
	public void taper(StringBuffer stringbuffer) {
		// TODO Auto-generated method stub
		buffer.setLestringbuffer(stringbuffer);

		
	}
	
	
	@Override
	public void selectionner(int indicedepart, int indicefin) {
		// TODO Auto-generated method stub
		this.laselection.setDebut(indicedepart);
		this.laselection.setFin(indicefin);
	}

	@Override
	public void copie(String textcopie) {
		// TODO Auto-generated method stub
		this.pressepapier.setPressepap(textcopie);
		System.out.println("le contenu du presse papier est : " + pressepapier.getPressepap());
		
	}

	@Override
	public void couper() {
		// TODO Auto-generated method stub
		this.pressepapier.setPressepap(this.buffer.getLestringbuffer().substring(laselection.getDebut(),
				laselection.getFin()));
		this.buffer.getLestringbuffer().delete(laselection.getDebut(), laselection.getFin());
			this.notifyObs();
		
	}

	@Override
	public void Supprimer() {
		// TODO Auto-generated method stub
		this.buffer.getLestringbuffer().delete(laselection.getDebut(), laselection.getFin());
		this.notifyObs();
	}

	@Override
	public void coller(int position) {
		// TODO Auto-generated method stub
		this.pressepapier.getPressepap();
		StringBuffer lajout = this.buffer.getLestringbuffer().insert(position, this.pressepapier.getPressepap());
	
		this.notifyObs();
	}
	

	@Override
	public void inserer(int position) {
		// TODO Auto-generated method stub
		laselection.setPosition(position);
	}


	@Override
	public StringBuffer getValue() {
		
		return this.buffer.getLestringbuffer();
		
	}

	@Override
	public void detach(Observeur ob) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attach(Observeur ob) {
		this.ListObserveur.add(ob);

	}
	private void notifyObs(){
		for(Observeur o:ListObserveur){
			o.update(this);
		}
	}
}
