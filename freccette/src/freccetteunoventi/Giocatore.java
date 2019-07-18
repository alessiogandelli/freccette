/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freccetteunoventi;

/**
 *
 * @author Alessio Gandelli
 */
public class Giocatore {

    private int numeroGiocatore;
    private int punteggio;
   
    
    Giocatore(int i) {
        numeroGiocatore= i;
    }
    

    public int getPunteggio() {
        return punteggio;
    }

    

    public int getNumeroGiocatori(){
        return numeroGiocatore;
    }
  

    void incrementaPunteggio() {
        punteggio++;
    }

    
    
}
