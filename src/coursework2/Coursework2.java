/**
 * Karaoke Application
 * 
 * Provides a JavaFX Graphical User Interface with various controls such as Play, Pause, Stop, Next to control songs.
 * Provided Library & PlayList Functionality like major streaming services such as Spotify 
 * 
 * @author LaveshPanjwani
 */
package coursework2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * Main Class that Starts the Application
 * 
 * @author LaveshPanjwani
 */
public class Coursework2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create UI Controller that Contains App Logic
        UIController ui = new UIController();

        // Create UIController to JavaFX Scene
        Scene scene = new Scene(ui);

        // Set Title to Stage
        primaryStage.setTitle("Karaoke");
        // Set Scene in Stage
        primaryStage.setScene(scene);
        // Show Stage
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Launch App
        launch(args);
    }
}
