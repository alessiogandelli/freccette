/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freccetteunoventi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

/**
 *  questo programma fa da segnapunti per un gioco di freccette che consiste nel
 *  colpire progressivamente tutti i numeri da 1 a 20, l'interfaccia chiedera se 
 *  si è colpito o no, si hanno 3 freccette a testa 
 * @author Alessio Gandelli
 */
public class Freccetteunoventi extends Application {
    int ngiocatori;
    @Override
    
    /**
     * mostra una finestra che chiede il numero di giocatori e crea una grafoica 
     */
    public void start(Stage primaryStage) {
        popup();
        Grafica g= new Grafica(ngiocatori);
        Scene scene = new Scene(g,500,500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void popup() {
        TextInputDialog dialog = new TextInputDialog("2");
        dialog.setTitle("numero di  giocatori  ");
        dialog.setHeaderText("");
        dialog.setContentText("Answer label:");
        String s = dialog.showAndWait().get();
        ngiocatori= Integer.parseInt(s);
    }

}
