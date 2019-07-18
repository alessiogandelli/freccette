/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freccetteunoventi;

import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * una  partita che riceve anche gli eventi dei bottoni
 * @author Alessio Gandelli
 */
class Partita implements EventHandler<MouseEvent> {

    int nGiocatori;
    Grafica g;
    ArrayList<Giocatore> giocatori = new ArrayList<>();
    int turno = 0;
    int lanci;

    public Partita(int ngiocatori, Grafica g) {
        nGiocatori = ngiocatori;
        this.g = g;
        //creo i giocatori
        for (int i = 0; i < ngiocatori; i++) {
            giocatori.add(new Giocatore(i + 1));
        }

    }
    /**
     * un turno aggiorna la grafica conil giocatore corrente
     * @param i 
     */
    private void turno(int i) {
        
        g.aggiorna(giocatori.get(i));
        turno = i;
        

    }

    /**
     * gestore degli  eventi ricevuti dai bottoni
     * @param event 
     */
    @Override
    public void handle(MouseEvent event) {
        System.out.println();
        if (((Button) (event.getSource())).getText().equals("si")) {
            giocatori.get(turno).incrementaPunteggio();
            lanci++;
        } else {
            lanci++;
        }

        g.aggiorna(giocatori.get(turno));
        controlloFrecce();

    }

    /**
     * dopo ogni volte che un bottone viene schiacciato viene controllato se ha finito le freccette o se ha vinto
     */
    private void controlloFrecce() {
        if (lanci == 3 && giocatori.get(turno).getPunteggio() < 20) {
            lanci = 0;
            turno++;
            turno(turno % nGiocatori);
        }
        if (giocatori.get(turno).getPunteggio() >= 20) {
            g.vittoria(giocatori.get(turno).getNumeroGiocatori());
        }

    }

    
    public void iniziaPartita() {
        turno(turno);
    }

}
