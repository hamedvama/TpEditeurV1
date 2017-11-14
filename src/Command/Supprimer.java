package Command;

import Receiver.MoteurED;

public class Supprimer implements Command {

    private MoteurED monmoteur;

    @Override
    public void execute() {

        this.monmoteur.Supprimer();
    }
}
