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
import java.util.List;

/**
 *
 * Main Class that Starts the Application
 * 
 * @author LaveshPanjwani
 */
public class Coursework2 extends Application {

    @Override
    public void start(Stage primaryStage) {

        Parameters parameters = getParameters();
        List<String> rawArguments = parameters.getRaw();

        if (rawArguments.size() > 0) {
            // Fetch Library File Location
            String fileName = rawArguments.get(0);

            // Create UI Controller that Contains App Logic
            Controller ui = new Controller(fileName);

            // Create UIController to JavaFX Scene
            Scene scene = new Scene(ui);

            // Set Title to Stage
            primaryStage.setTitle("Karaoke");
            // Set Scene in Stage
            primaryStage.setScene(scene);
            // Show Stage
            primaryStage.show();
        } else {
            System.out.println("Missing / Incorrect Library File Location in Arguments");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Launch App
        launch(args);
    }
}
