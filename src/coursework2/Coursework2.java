/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author LaveshPanjwani
 */
public class Coursework2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        UIController ui = new UIController();

        Scene scene = new Scene(ui);

        primaryStage.setTitle("Karaoke");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
