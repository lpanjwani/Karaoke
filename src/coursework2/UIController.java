/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework2;

import java.io.FileNotFoundException;
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

/**
 *
 * @author LaveshPanjwani
 */
public class UIController extends UIView {

    private MediaPlayer player;
    private Song current;
    private List<Song> library = new ArrayList<Song>();
    private List<Song> search = new ArrayList<Song>();
    private Queue<Song> playlist = new LinkedList<Song>();

    public UIController() {
        super();

        mediaStop.setOnAction(this::StopSong);
        mediaPlay.setOnAction(this::PlaySong);
        mediaPause.setOnAction(this::PauseSong);
        mediaSkip.setOnAction(this::SkipSong);
        libraryAdd.setOnAction(this::AddToQueue);

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
            this.library = Utils.ReadTabFile();
            updateLibraryView();
        } catch (FileNotFoundException err) {
            FatalErrorOccurred();
        }
    }

    /*
     * Initialize Media Player
     */
    private void initVideo() {
        try {
            if (!isCurrentSet())
                throw new NullPointerException();

            this.player = new MediaPlayer(new Media(Utils.RelativeFilePath(current.getLocation()).toExternalForm()));
            mediaView.setMediaPlayer(player);
            PlaySong();

        } catch (FileNotFoundException ex) {
            FatalErrorOccurred();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }

    /*
     *
     * Current Song Verification & Controls
     * 
     */

    private Boolean isCurrentSet() {
        if (current == null || current.getName() == null) {
            return false;
        }
        return true;
    }

    private void isEmptySkip() {
        if (!isCurrentSet())
            SkipSong();
    }

    /*
     *
     * JavaFX Song Library & PlayList View Methods
     * 
     */

    /*
     * Update JavaFX Song Library List
     */
    private void updateLibraryView() {
        ObservableList<String> list = FXCollections.observableArrayList();

        List<Song> results = search.size() > 0 ? search : library;

        for (Song song : results) {
            String songName = song.getName();
            String songArtist = song.getArtist();
            list.add(songName + " ft. " + songArtist);
        }

        libraryList.setItems(list);
    }

    /*
     * Update JavaFX Song Queue List
     */
    private void updateQueueView() {
        ObservableList<String> list = FXCollections.observableArrayList();

        for (Song song : playlist) {
            String songName = song.getName();
            String songArtist = song.getArtist();
            list.add(songName + " ft. " + songArtist);
        }

        queueList.setItems(list);

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
        // Fetch & Remove the HEAD from the PlayList / Queue
        this.current = playlist.poll();

        // Update Queue JavaFX View
        updateQueueView();

        // Initialize New Video
        initVideo();
    }

    /*
     * Stop Song (Button Triggered)
     */
    private void SkipSong(Event e) {
        // Skip Song (Programmatically Triggered)
        SkipSong();
    }

    /*
     * Add to Queue (Button Triggered)
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
     *
     * Search Results Section
     * 
     */

    private void ResetSearchResults() {
        search = new ArrayList<Song>();
    }

    private void SearchByName(String substring) {
        for (Song song : library) {
            String songName = song.getName();
            if (songName.contains(substring)) {
                search.add(song);
            }
        }
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
        Alert alert = new Alert(AlertType.ERROR);
        alert.setContentText("Dear User, Fatal Errored in this App's Functionality! Exiting Now!");
        alert.showAndWait();
        System.exit(0);
    }

}
