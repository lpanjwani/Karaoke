
/**
 * UI View Class 
 * 
 * Deals with Placing & Setting JavaFX Components 
 * 
 * @author Lavesh Panjwani
 */

package coursework2;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;

/**
 * 
 * @author Lavesh Panjwani
 */
public abstract class UIView extends VBox {

    protected final SplitPane mainWrapper;
    protected final AnchorPane libraryWrapper;
    protected final Label libraryText;
    protected final ListView libraryList;
    protected final TextField librarySearchField;
    protected final Button libraryAdd;
    protected final ImageView libraryAddImage;
    protected final Button librarySearchName;
    protected final Button librarySearchReset;
    protected final AnchorPane mediaWrapper;
    protected final MediaView mediaView;
    protected final Button mediaStop;
    protected final ImageView mediaStopImage;
    protected final Button mediaPlay;
    protected final ImageView mediaPlayImage;
    protected final Button mediaPause;
    protected final ImageView mediaPauseImage;
    protected final Button mediaSkip;
    protected final ImageView mediaSkipImage;
    protected final AnchorPane queueWrapper;
    protected final Label queueText;
    protected final Button queueRemove;
    protected final ImageView queueRemoveImage;
    protected final Label queueCurrentLabel;
    protected final ListView queueList;
    protected DoubleProperty mvw;
    protected DoubleProperty mvh;

    public UIView() {

        mainWrapper = new SplitPane();
        libraryWrapper = new AnchorPane();
        libraryText = new Label();
        libraryList = new ListView();
        librarySearchField = new TextField();
        libraryAdd = new Button();
        libraryAddImage = new ImageView();
        librarySearchName = new Button();
        librarySearchReset = new Button();
        mediaWrapper = new AnchorPane();
        mediaView = new MediaView();
        mediaStop = new Button();
        mediaStopImage = new ImageView();
        mediaPlay = new Button();
        mediaPlayImage = new ImageView();
        mediaPause = new Button();
        mediaPauseImage = new ImageView();
        mediaSkip = new Button();
        mediaSkipImage = new ImageView();
        queueWrapper = new AnchorPane();
        queueText = new Label();
        queueRemove = new Button();
        queueRemoveImage = new ImageView();
        queueCurrentLabel = new Label();
        queueList = new ListView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(700.0);
        setPrefWidth(1800.0);

        VBox.setVgrow(mainWrapper, javafx.scene.layout.Priority.ALWAYS);
        mainWrapper.setDividerPositions(0.19270298047276466, 0.8042137718396711);
        mainWrapper.setFocusTraversable(true);
        mainWrapper.setMaxHeight(USE_PREF_SIZE);
        mainWrapper.setMaxWidth(USE_PREF_SIZE);
        mainWrapper.setMinHeight(USE_PREF_SIZE);
        mainWrapper.setMinWidth(USE_PREF_SIZE);
        mainWrapper.setPrefHeight(700.0);
        mainWrapper.setPrefWidth(1800.0);

        libraryWrapper.setMaxHeight(USE_PREF_SIZE);
        libraryWrapper.setMaxWidth(USE_PREF_SIZE);
        libraryWrapper.setMinHeight(USE_PREF_SIZE);
        libraryWrapper.setMinWidth(USE_PREF_SIZE);
        libraryWrapper.setPrefHeight(700.0);
        libraryWrapper.setPrefWidth(300.0);

        libraryText.setAlignment(javafx.geometry.Pos.CENTER);
        libraryText.setLayoutX(11.0);
        libraryText.setLayoutY(15.0);
        libraryText.setMinWidth(60.0);
        libraryText.setPrefWidth(-1.0);
        libraryText.setText("Library");
        libraryText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        libraryText.setWrapText(false);
        libraryText.setFont(new Font(18.0));

        libraryList.setLayoutX(15.0);
        libraryList.setLayoutY(113.0);
        libraryList.setMaxHeight(USE_PREF_SIZE);
        libraryList.setMaxWidth(USE_PREF_SIZE);
        libraryList.setMinHeight(USE_PREF_SIZE);
        libraryList.setMinWidth(USE_PREF_SIZE);
        libraryList.setPrefHeight(522.0);
        libraryList.setPrefWidth(273.0);

        librarySearchField.setLayoutX(14.0);
        librarySearchField.setLayoutY(72.0);
        librarySearchField.setMaxHeight(USE_PREF_SIZE);
        librarySearchField.setMaxWidth(USE_PREF_SIZE);
        librarySearchField.setMinHeight(USE_PREF_SIZE);
        librarySearchField.setMinWidth(USE_PREF_SIZE);
        librarySearchField.setPrefHeight(26.0);
        librarySearchField.setPrefWidth(149.0);
        librarySearchField.setPromptText("Search");

        libraryAdd.setLayoutX(129.0);
        libraryAdd.setLayoutY(644.0);
        libraryAdd.setMnemonicParsing(false);
        libraryAdd.setPrefHeight(36.0);
        libraryAdd.setPrefWidth(33.0);
        libraryAdd.setStyle("-fx-background-radius: 100;");

        libraryAddImage.setFitHeight(23.0);
        libraryAddImage.setFitWidth(16.0);
        libraryAddImage.setPickOnBounds(true);
        libraryAddImage.setPreserveRatio(true);
        libraryAddImage.setImage(new Image(getClass().getResource("Icons/plus.png").toExternalForm()));
        libraryAdd.setGraphic(libraryAddImage);

        librarySearchName.setLayoutX(171.0);
        librarySearchName.setLayoutY(72.0);
        librarySearchName.setMnemonicParsing(false);
        librarySearchName.setPrefHeight(26.0);
        librarySearchName.setPrefWidth(53.0);
        librarySearchName.setText("Name");

        librarySearchReset.setLayoutX(232.0);
        librarySearchReset.setLayoutY(72.0);
        librarySearchReset.setMnemonicParsing(false);
        librarySearchReset.setPrefHeight(26.0);
        librarySearchReset.setPrefWidth(53.0);
        librarySearchReset.setText("Reset");

        mediaWrapper.setId("Content");
        mediaWrapper.setMaxHeight(USE_PREF_SIZE);
        mediaWrapper.setMaxWidth(USE_PREF_SIZE);
        mediaWrapper.setMinHeight(USE_PREF_SIZE);
        mediaWrapper.setMinWidth(USE_PREF_SIZE);
        mediaWrapper.setPrefHeight(700.0);
        mediaWrapper.setPrefWidth(1200.0);

        mediaView.setFitHeight(700.0);
        mediaView.setFitWidth(1200.0);
        mediaView.setPreserveRatio(true);

        mediaStop.setLayoutX(522.0);
        mediaStop.setLayoutY(643.0);
        mediaStop.setMnemonicParsing(false);
        mediaStop.setPrefHeight(36.0);
        mediaStop.setPrefWidth(33.0);
        mediaStop.setStyle("-fx-background-radius: 100;");

        mediaStopImage.setFitHeight(23.0);
        mediaStopImage.setFitWidth(16.0);
        mediaStopImage.setPickOnBounds(true);
        mediaStopImage.setPreserveRatio(true);
        mediaStopImage.setImage(new Image(getClass().getResource("Icons/stop.png").toExternalForm()));
        mediaStop.setGraphic(mediaStopImage);

        mediaPlay.setLayoutX(571.0);
        mediaPlay.setLayoutY(643.0);
        mediaPlay.setMnemonicParsing(false);
        mediaPlay.setPrefHeight(36.0);
        mediaPlay.setPrefWidth(33.0);
        mediaPlay.setStyle("-fx-background-radius: 100;");

        mediaPlayImage.setFitHeight(23.0);
        mediaPlayImage.setFitWidth(16.0);
        mediaPlayImage.setPickOnBounds(true);
        mediaPlayImage.setPreserveRatio(true);
        mediaPlayImage.setImage(new Image(getClass().getResource("Icons/play.png").toExternalForm()));
        mediaPlay.setGraphic(mediaPlayImage);

        mvw = mediaView.fitWidthProperty();
        mvh = mediaView.fitHeightProperty();
        mvw.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
        mvh.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));

        mediaPause.setLayoutX(618.0);
        mediaPause.setLayoutY(643.0);
        mediaPause.setMnemonicParsing(false);
        mediaPause.setPrefHeight(36.0);
        mediaPause.setPrefWidth(33.0);
        mediaPause.setStyle("-fx-background-radius: 100;");

        mediaPauseImage.setFitHeight(23.0);
        mediaPauseImage.setFitWidth(16.0);
        mediaPauseImage.setPickOnBounds(true);
        mediaPauseImage.setPreserveRatio(true);
        mediaPauseImage.setImage(new Image(getClass().getResource("Icons/pause.png").toExternalForm()));
        mediaPause.setGraphic(mediaPauseImage);

        mediaSkip.setLayoutX(663.0);
        mediaSkip.setLayoutY(643.0);
        mediaSkip.setMnemonicParsing(false);
        mediaSkip.setPrefHeight(36.0);
        mediaSkip.setPrefWidth(33.0);
        mediaSkip.setStyle("-fx-background-radius: 100;");

        mediaSkipImage.setFitHeight(23.0);
        mediaSkipImage.setFitWidth(16.0);
        mediaSkipImage.setPickOnBounds(true);
        mediaSkipImage.setPreserveRatio(true);
        mediaSkipImage.setImage(new Image(getClass().getResource("Icons/step-forward.png").toExternalForm()));
        mediaSkip.setGraphic(mediaSkipImage);

        queueWrapper.setMaxHeight(USE_PREF_SIZE);
        queueWrapper.setMaxWidth(USE_PREF_SIZE);
        queueWrapper.setMinHeight(USE_PREF_SIZE);
        queueWrapper.setMinWidth(USE_PREF_SIZE);
        queueWrapper.setPrefHeight(700.0);
        queueWrapper.setPrefWidth(300.0);

        queueText.setAlignment(javafx.geometry.Pos.CENTER);
        queueText.setLayoutX(16.0);
        queueText.setLayoutY(14.0);
        queueText.setText("Queue");
        queueText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        queueText.setWrapText(false);

        queueRemove.setLayoutX(140.0);
        queueRemove.setLayoutY(631.0);
        queueRemove.setMnemonicParsing(false);
        queueRemove.setPrefHeight(36.0);
        queueRemove.setPrefWidth(33.0);
        queueRemove.setStyle("-fx-background-radius: 100;");

        queueRemoveImage.setFitHeight(23.0);
        queueRemoveImage.setFitWidth(16.0);
        queueRemoveImage.setPickOnBounds(true);
        queueRemoveImage.setPreserveRatio(true);
        queueRemoveImage.setImage(new Image(getClass().getResource("Icons/minus.png").toExternalForm()));
        queueRemove.setGraphic(queueRemoveImage);

        queueCurrentLabel.setLayoutX(15.0);
        queueCurrentLabel.setLayoutY(57.0);
        queueCurrentLabel.setPrefHeight(27.0);
        queueCurrentLabel.setPrefWidth(270.0);
        queueCurrentLabel.setStyle("-fx-text-alignment: center;");
        queueCurrentLabel.setText("Current Song: None");
        queueCurrentLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        queueCurrentLabel.setWrapText(true);

        queueList.setLayoutX(13.0);
        queueList.setLayoutY(92.0);
        queueList.setMaxHeight(USE_PREF_SIZE);
        queueList.setMaxWidth(USE_PREF_SIZE);
        queueList.setMinHeight(USE_PREF_SIZE);
        queueList.setMinWidth(USE_PREF_SIZE);
        queueList.setPrefHeight(522.0);
        queueList.setPrefWidth(273.0);

        libraryWrapper.getChildren().add(libraryText);
        libraryWrapper.getChildren().add(libraryList);
        libraryWrapper.getChildren().add(librarySearchField);
        libraryWrapper.getChildren().add(libraryAdd);
        libraryWrapper.getChildren().add(librarySearchName);
        libraryWrapper.getChildren().add(librarySearchReset);
        mainWrapper.getItems().add(libraryWrapper);
        mediaWrapper.getChildren().add(mediaView);
        mediaWrapper.getChildren().add(mediaStop);
        mediaWrapper.getChildren().add(mediaPlay);
        mediaWrapper.getChildren().add(mediaPause);
        mediaWrapper.getChildren().add(mediaSkip);
        mainWrapper.getItems().add(mediaWrapper);
        queueWrapper.getChildren().add(queueText);
        queueWrapper.getChildren().add(queueRemove);
        queueWrapper.getChildren().add(queueCurrentLabel);
        queueWrapper.getChildren().add(queueList);
        mainWrapper.getItems().add(queueWrapper);
        getChildren().add(mainWrapper);
    }
}
