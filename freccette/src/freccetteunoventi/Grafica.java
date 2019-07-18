/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freccetteunoventi;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

/**
 * reparto grafica
 *
 * @author Alessio Gandelli
 */
class Grafica extends BorderPane {

    int nGiocatori;
    Label sopra = new Label("gioco del1 20");
    TextField nome, punteggio;
    Partita p;

    /**
     * costruttore setta la disposizione iniziale
     *
     * @param nGiocatori
     */
    public Grafica(int nGiocatori) {
        this.nGiocatori = nGiocatori;
        p = new Partita(nGiocatori, this);
        setTop(sopra);
        setCentro();
        setSotto();
        p.iniziaPartita();

    }

    /**
     * setta l'hbox di bottoni si no nel centro
     */
    private void setCentro() {
        HBox sino = new HBox();
        sino.setAlignment(Pos.CENTER);
        Button si = new Button("si");
        si.addEventHandler(MouseEvent.MOUSE_CLICKED, p);
        Button no = new Button("no");
        no.addEventHandler(MouseEvent.MOUSE_CLICKED, p);

        si.setMinSize(100, 100);
        no.setMinSize(100, 100);
        sino.getChildren().addAll(si, no);
        setCenter(sino);
    }

    /**
     * il sotto dice chi è il giocatore che deve giocare
     */
    private void setSotto() {
        nome = new TextField("giocatore  1");
        nome.setEditable(false);
        punteggio = new TextField("1");
        punteggio.setEditable(false);
        HBox sotto = new HBox(nome, punteggio);
        sotto.setAlignment(Pos.CENTER);
        setBottom(sotto);

    }

    /**
     * aggiorna la schermata quando c'e un cambio turno
     * @param g
     */
    public void aggiorna(Giocatore g) {
        nome.setText("giocatore" + g.getNumeroGiocatori());
        punteggio.setText("" + g.getPunteggio());
    }
    
    /**
     * in caso di  vittoria  di un  giocatore
     * @param numeroGiocatore 
     */
    void vittoria(int numeroGiocatore) {
        Label vittoria = new Label("il vincitore è il giocatore" + numeroGiocatore);
        vittoria.setFont(new Font(30));
        setCenter(vittoria);
    }

}
