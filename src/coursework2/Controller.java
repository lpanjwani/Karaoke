
/**
 * UI Controller Class 
 * 
 * Deals with App & Business Logic of the Karaoke Application including Library & Queue/PlayList
 * Controlling UI Components set in UIView Class
 * Using Utils Class for Reading Files
 * 
 * @author Lavesh Panjwani
 */
package coursework2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 * UI Controller Class
 * 
 * @author Lavesh Panjwani
 */
public class Controller extends View {

    private String fileName;
    private MediaPlayer player;
    private Song current;
    private int currentPlayRemaining;
    private List<Song> library = new ArrayList<Song>();
    private List<Song> search = new ArrayList<Song>();
    private Queue<Song> playlist = new LinkedList<Song>();

    /*
     * Constructor
     */
    public Controller(String libraryFileName) {
        super();

        /*
         * Button Click Actions
         */
        // Player Play Action
        mediaPlay.setOnAction(this::PlaySong);
        // Player Stop Action
        mediaStop.setOnAction(this::StopSong);
        // Player Pause Action
        mediaPause.setOnAction(this::PauseSong);
        // Player Skip Action
        mediaSkip.setOnAction(this::SkipSong);
        // Add to Queue Action
        libraryAdd.setOnAction(this::AddToQueue);
        // Remove form Queue Action
        queueRemove.setOnAction(this::RemoveFromQueue);
        // Library Search By Name Action
        librarySearchName.setOnAction(this::SearchByName);
        // Library Search Reset Action
        librarySearchReset.setOnAction(this::ResetSearchResults);
        // Library Include Button
        libraryIncludeButton.setOnAction(this::includeSong);

        // Store File Name
        this.fileName = libraryFileName;

        // Initiate Song Library
        initLibrary();
    }

    /*
     *
     * Initialization Section
     * 
     */

    /*
     * Initialize Library from File
     */
    private void initLibrary() {
        try {
            // Load Song Data into Library
            library = Utils.ReadTabFile(fileName);

            // Update JavaFX Library ListView
            updateLibraryView();
        } catch (FileNotFoundException err) {
            // Throw Fatal Error Alert when Song File is not available
            FatalErrorOccurred();
        }
    }

    /*
     * Initialize Media Player
     */
    private void initVideo() {
        try {
            // Check if Song is Available to Play or Throw Exception
            if (!isCurrentSet())
                throw new NullPointerException();

            // Get Relative Song Location
            player = new MediaPlayer(new Media(Utils.RelativeFilePath(current.getLocation()).toExternalForm()));

            // Get Current Song PlayTime
            currentPlayRemaining = current.getPlayTime();

            // Get Song Play Time & Convert to Durations Class
            Duration totalTime = Duration.seconds((long) currentPlayRemaining);

            // Set Player End Time
            player.setStopTime(totalTime);

            // Player Reached End Point Event Listener
            player.setOnEndOfMedia(new Runnable() {

                // Execute Method at End Time
                @Override
                public void run() {
                    // Execute onSongEnd Method
                    onSongEnd();
                }
            });

            // Include Media Player in JavaFX MediaView
            mediaView.setMediaPlayer(player);

            // Play Song Method
            PlaySong();

        } catch (
        // Throw Error if MP4 not found
        FileNotFoundException ex) {
            // Throw Fatal Error
            FatalErrorOccurred();
        } catch (NullPointerException ex) {
            // Print Stack Trace for Null Pointer
            ex.printStackTrace();
        }
    }

    /*
     * Event Listener for Song End Reached
     */
    private void onSongEnd() {
        // Retrieve Played Time in Seconds
        int playedTime = (int) player.getCurrentTime().toSeconds();

        // Decrement Remaining PlayTime with PlayTime in this Cycle
        currentPlayRemaining -= playedTime;

        // Check if there is still some Remaining PlayTime
        if (currentPlayRemaining > 0) {
            // Get Remaining Song Play Time & Convert to Durations Class
            Duration totalTime = Duration.seconds((long) currentPlayRemaining);

            // Set Player Stop Time
            player.setStopTime(totalTime);

            // Seek to Start of Video
            player.seek(Duration.ZERO);

            // Play Song
            player.play();
        } else {
            // Song is finished played & skip to next song in Queue
            SkipSong();
        }
    }

    /*
     *
     * Current Song Helper Functions
     * 
     */

    /*
     * Check if Current Song is Valid/Available/Set
     */
    private Boolean isCurrentSet() {
        // Check for Current Exists
        if (current == null || current.getName() == null) {
            // Return False to current is not Valid/Available/Set
            return false;
        }
        // Return True to current is Valid/Available/Set
        return true;
    }

    /*
     * Start Song if Queue / PlayList is Empty
     */
    private void isEmptySkip() {
        // Check if Current Song is Valid/Available/Set
        if (!isCurrentSet())
            SkipSong(); // Skip Song since Current is not Valid/Available/Set
    }

    /*
     * Set Playing Information based on Queue
     */
    private void setCurrentText() {
        // Check if Current Song is Valid/Available/Set
        if (isCurrentSet()) {
            queueCurrentLabel.setText("Currently Playing: " + current.getName() + "ft." + current.getArtist());
        } else {
            // No Song in Queue Text Label
            queueCurrentLabel.setText("Stopped");
        }
    }

    /*
     *
     * JavaFX Song Library & PlayList View Methods
     * 
     */

    /*
     * Include/Add User Entered Song in Library & Songs File
     */
    private void includeSong(Event e) {
        try {
            // Get Song Name Entered by User
            String name = libraryAddName.getText();
            // Get Artist Name Entered by User
            String artist = libraryAddArtistName.getText();
            // Get Play Time Entered by User
            int playTime = Integer.parseInt(libraryAddRuntime.getText());
            // Get File Name Entered by User
            String videoFileName = libraryAddVideoFile.getText();

            // Check for Empty Fields
            if (name.length() < 1 || artist.length() < 1 || fileName.length() < 1) {
                // Throw No Such Field Exception if fields are empty
                throw new NoSuchFieldException();
            }

            // Add Song to Library
            library.add(new Song(name, artist, playTime, videoFileName));

            // Update JavaFX Library ListView to include New Song
            updateLibraryView();

            // Create Tab Separated Text to append in Song File
            String appendText = name + '\t' + artist + '\t' + playTime + '\t' + videoFileName;

            // Append Text to File
            Utils.AppendFile(fileName, appendText);

            // Reset Song Name Field to Blank
            libraryAddName.setText("");
            // Reset Artist Name Field to Blank
            libraryAddArtistName.setText("");
            // Reset Play Time Field to Blank
            libraryAddRuntime.setText("");
            // Reset Video File Name Field to Blank
            libraryAddVideoFile.setText("");

            // Create New Alert with Confirmation Body
            Alert alert = new Alert(AlertType.CONFIRMATION);

            // Set Alert Dialogue Content Text
            alert.setContentText("Song Added!");

            // Show & acknowledge User Response
            alert.showAndWait();
        } catch (NoSuchFieldException err) {
            // Create New Alert with Error Body
            Alert alert = new Alert(AlertType.ERROR);

            // Set Alert Dialogue Content Text
            alert.setContentText("Dear User, Missing Entry Fields! Please enter all fields to add a song.");

            // Show & acknowledge User Response
            alert.showAndWait();
        } catch (NumberFormatException err) {
            // Create New Alert with Error Body
            Alert alert = new Alert(AlertType.ERROR);

            // Set Alert Dialogue Content Text
            alert.setContentText("Dear User, Please enter Song Play Time in Seconds!");

            // Show & acknowledge User Response
            alert.showAndWait();
        } catch (IOException err) {
            // Print Error Stack Trace
            err.printStackTrace();

            // Create New Alert with Error Body
            Alert alert = new Alert(AlertType.ERROR);

            // Set Alert Dialogue Content Text
            alert.setContentText("Dear User, Please close the song file to add a song!");

            // Show & acknowledge User Response
            alert.showAndWait();
        }
    }

    /*
     * Update JavaFX Song Library List
     */
    private void updateLibraryView() {
        // Create New JavaFX Observable List for Displaying
        ObservableList<String> list = FXCollections.observableArrayList();

        // Select List to Display with Search Displaying Conditionally when Active
        List<Song> results = search.size() > 0 ? search : library;

        // Iterate over Song Library/Results List
        for (Song song : results) {
            // Fetch Song Name from Song Class
            String songName = song.getName();
            // Fetch Song's Artist Name from Library
            String songArtist = song.getArtist();

            // Add to List after Formatted String
            list.add(songName + " ft. " + songArtist);
        }

        // Set JavaFX Display Items from List
        libraryList.setItems(list);
    }

    /*
     * Update JavaFX Song Queue List
     */
    private void updateQueueView() {
        ObservableList<String> list = FXCollections.observableArrayList();

        // Iterate over Song Queue / PlayList
        for (Song song : playlist) {
            // Fetch Song Name from Song Class
            String songName = song.getName();
            // Fetch Song's Artist Name from Library
            String songArtist = song.getArtist();
            // Add to List after Formatted String
            list.add(songName + " ft. " + songArtist);
        }

        // Set JavaFX Display Items from List
        queueList.setItems(list);

        // Start Song if Queue / PlayList is Empty
        isEmptySkip();
    }

    /*
     *
     * Media Player Controls Section
     * 
     */

    /*
     * Play Song (Programmatically Triggered)
     */
    private void PlaySong() {
        this.player.play();
    }

    /*
     * Play Song (Button Triggered)
     */
    private void PlaySong(Event e) {
        PlaySong();
    }

    /*
     * Pause Song (Button Triggered)
     */
    private void PauseSong(Event e) {
        this.player.pause();
    }

    /*
     * Stop Song (Button Triggered)
     */
    private void StopSong(Event e) {
        this.player.stop();
    }

    /*
     * Pause Song (Programmatically Triggered)
     */
    private void SkipSong() {
        // Check if there is songs in Queue/PlayList
        if (playlist.size() > 0) {
            // Fetch & Remove the HEAD from the PlayList / Queue
            this.current = playlist.poll();

            // Update Queue JavaFX View
            updateQueueView();

            // Initialize New Video
            initVideo();
        } else {
            // No Song Found so Reset Current Song Information
            this.current = null;
        }

        // Set Current Track Information
        setCurrentText();
    }

    /*
     * Stop Song (Button Triggered)
     */
    private void SkipSong(Event e) {
        // Skip Song (Programmatically Triggered)
        SkipSong();
    }

    /*
     * Add to Queue / PlayList (Button Triggered)
     */
    private void AddToQueue(Event e) {
        // Fetch Selected Index from Library Tab
        int index = libraryList.getSelectionModel().getSelectedIndex();

        // Add Entry to PlayList / Queue
        this.playlist.add(library.get(index));

        // Update Queue JavaFX View
        updateQueueView();
    }

    /*
     * Remove From Queue / PlayList (Button Triggered)
     */
    private void RemoveFromQueue(Event e) {
        // Fetch Selected Index from Queue Tab
        int index = queueList.getSelectionModel().getSelectedIndex();

        // Remove Entry to PlayList / Queue
        this.playlist.remove(index);

        // Update Queue JavaFX View
        updateQueueView();
    }

    /*
     *
     * Search Results Section
     * 
     */

    /*
     * Remove Song in Search Results (Programmatically Triggered)
     */
    private void ResetSearchResults() {
        // Reset Search List
        search = new ArrayList<Song>();

        // Reset Text Entered by User
        librarySearchField.setText("");

        // Update Library JavaFX View
        updateLibraryView();
    }

    /*
     * Remove Song in Search Results (Button Triggered)
     */
    private void ResetSearchResults(Event e) {
        // Change to Programmatically Triggered
        ResetSearchResults();
    }

    /*
     * Search Song by Name (Supports Searching by Characters & Keywords) Searching
     * is Case Insensitive (User Focused)
     */
    private void SearchByName(Event e) {
        // Check Text Entered in Search Field
        String substring = librarySearchField.getText().toLowerCase();

        // Iterate over Song Library List
        for (Song song : library) {
            // Retrieve Song Name from Song Class
            String songName = song.getName().toLowerCase();
            // Check if Substring is in Song Name
            if (songName.contains(substring)) {
                // Song matches Search Criteria & Add to Results
                this.search.add(song);
            }
        }

        // Update Library JavaFX View
        updateLibraryView();
    }

    /*
     *
     * Major Error Displaying Section
     * 
     */

    /*
     * Fatal Error Occurred in this App's Functionality
     */
    private void FatalErrorOccurred() {
        // Create New Alert with Error Body
        Alert alert = new Alert(AlertType.ERROR);
        // Set Alert Dialogue Content Text
        alert.setContentText("Dear User, Fatal Errored in this App's Functionality! Exiting Now!");
        // Show & acknowledge User Response
        alert.showAndWait();
        // Exit Java Application
        System.exit(0);
    }
}
