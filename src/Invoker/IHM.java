package Invoker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.HashMap;

import javax.swing.*;

import Command.*;
import Observeur.Observeur;
import Observeur.Sujet;
import Receiver.MoteurEDImpl;

public class IHM extends JFrame implements ActionListener, MouseListener, KeyListener,Observeur {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private JButton btncopier = new JButton("copier"), btncouper = new JButton("couper");
    private JButton btncoller = new JButton("coller");

    private JTextArea leJtext = new JTextArea();
    private JPanel pan1 = new JPanel();

    private int indicedepart, indicefin, position, positioncolle;
    private StringBuffer monstrgbuf, texttaper;	
    private String textselect;

    private Command selectionner, taper, copier, couper, coller;

    public IHM() {
        super();
        this.setTitle("Mon Editeur");	this.setSize(500, 200);	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        pan1.setBackground(Color.white);
        leJtext.setBackground(Color.lightGray);
       
        
        btncopier.addActionListener(this);	btncouper.addActionListener(this);
        btncoller.addActionListener(this);	;

        pan1.add(btncopier);	pan1.add(btncouper);	pan1.add(btncoller);

        this.add(pan1, BorderLayout.NORTH);
        this.add(leJtext);
        this.setVisible(true);

        leJtext.addMouseListener(this);	leJtext.addKeyListener(this);
       
        this.indicedepart = leJtext.getSelectionStart();	this.indicefin = leJtext.getSelectionEnd();
        this.position = leJtext.getSelectionStart();	this.positioncolle = leJtext.getCaretPosition();
        monstrgbuf = new StringBuffer("");	textselect = "";
     
    }

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

    public StringBuffer getMonstrgbuf() {
        return monstrgbuf;
    }

    public void setMonstrgbuf(StringBuffer monstrgbuf) {
        this.monstrgbuf = monstrgbuf;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public StringBuffer getTexttaper() {
        return texttaper;
    }

    public void setTexttaper(StringBuffer texttaper) {
        this.texttaper = texttaper;
    }


    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub
        this.indicedepart = leJtext.getSelectionStart();
        this.indicefin = leJtext.getSelectionEnd();
        ((Selectionner)selectionner).changeindice(indicedepart, indicefin);
        selectionner.execute();
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub
    	
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {

        if(arg0.getSource() == btncopier){
        	textselect = leJtext.getSelectedText();
        	((Copier)copier).setTextcopie(textselect);
        	copier.execute();
        	
        }else if(arg0.getSource() == btncouper){
        	//leJtext.replaceSelection("");
            this.indicedepart = leJtext.getSelectionStart();
            this.indicefin = leJtext.getSelectionEnd();
            ((Selectionner)selectionner).changeindice(indicedepart, indicefin);
            selectionner.execute();           
        	couper.execute();
        	
        }else if(arg0.getSource() == btncoller){
        	positioncolle = leJtext.getCaretPosition();
        	((Coller)coller).setPosition(positioncolle);
        	coller.execute();	
        }
        
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub


    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        // TODO Auto-generated method stub
        position = leJtext.getCaretPosition();
        texttaper = this.monstrgbuf.insert(position,arg0.getKeyChar());
        ((Taper)taper).setTexttaper(texttaper);
        taper.execute();
        if(arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            System.out.println("Supprimer");
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }
    public void setCommands(HashMap<String, Command> h)  {
		this.couper = h.get("couper");
			this.copier = h.get("copier");
			this.selectionner = h.get("selectionner");
		   this.taper = h.get("taper");
		   this.coller = h.get("coller");

		
	}
 
	@Override
	public void update(Sujet sujet) {
        this.leJtext.setText(sujet.getValue().toString());

	}
}
