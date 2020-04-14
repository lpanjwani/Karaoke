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

public abstract class UIView extends VBox {

    protected final SplitPane mainWrapper;
    protected final AnchorPane libraryWrapper;
    protected final Label libraryText;
    protected final ListView libraryList;
    protected final TextField librarySearch;
    protected final Button libraryAdd;
    protected final ImageView libraryAddImage;
    protected final Button button;
    protected final AnchorPane mediaWrapper;
    protected final MediaView mediaView;
    protected final Button mediaStop;
    protected final ImageView mediaStopImage;
    protected final Button mediaPlay;
    protected final Button mediaPause;
    protected final ImageView mediaPauseImage;
    protected final Button mediaSkip;
    protected final ImageView mediaSkipImage;
    protected final ImageView mediaPlayImage;
    protected final AnchorPane queueWrapper;
    protected final Label queueText;
    protected final ListView queueList;
    protected final Button queueRemove;
    protected final ImageView queueRemoveImage;

    public UIView() {

        mainWrapper = new SplitPane();
        libraryWrapper = new AnchorPane();
        libraryText = new Label();
        libraryList = new ListView();
        librarySearch = new TextField();
        libraryAdd = new Button();
        libraryAddImage = new ImageView();
        button = new Button();
        mediaWrapper = new AnchorPane();
        mediaView = new MediaView();
        mediaStop = new Button();
        mediaStopImage = new ImageView();
        mediaPlay = new Button();
        mediaPause = new Button();
        mediaPauseImage = new ImageView();
        mediaSkip = new Button();
        mediaSkipImage = new ImageView();
        mediaPlayImage = new ImageView();
        queueWrapper = new AnchorPane();
        queueText = new Label();
        queueList = new ListView();
        queueRemove = new Button();
        queueRemoveImage = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(1280.0);

        VBox.setVgrow(mainWrapper, javafx.scene.layout.Priority.ALWAYS);
        mainWrapper.setDividerPositions(0.19270298047276466, 0.8042137718396711);
        mainWrapper.setFocusTraversable(true);
        mainWrapper.setMaxHeight(USE_PREF_SIZE);
        mainWrapper.setMaxWidth(USE_PREF_SIZE);
        mainWrapper.setMinHeight(USE_PREF_SIZE);
        mainWrapper.setMinWidth(USE_PREF_SIZE);
        mainWrapper.setPrefHeight(600.0);
        mainWrapper.setPrefWidth(1280.0);

        libraryWrapper.setMaxHeight(USE_PREF_SIZE);
        libraryWrapper.setMaxWidth(USE_PREF_SIZE);
        libraryWrapper.setMinHeight(USE_PREF_SIZE);
        libraryWrapper.setMinWidth(USE_PREF_SIZE);
        libraryWrapper.setPrefHeight(600.0);
        libraryWrapper.setPrefWidth(215.0);

        libraryText.setAlignment(javafx.geometry.Pos.CENTER);
        libraryText.setLayoutX(11.0);
        libraryText.setLayoutY(15.0);
        libraryText.setMinWidth(60.0);
        libraryText.setPrefWidth(-1.0);
        libraryText.setStyle("");
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
        libraryList.setPrefHeight(394.0);
        libraryList.setPrefWidth(191.0);

        librarySearch.setLayoutX(14.0);
        librarySearch.setLayoutY(72.0);
        librarySearch.setMaxHeight(USE_PREF_SIZE);
        librarySearch.setMaxWidth(USE_PREF_SIZE);
        librarySearch.setMinHeight(USE_PREF_SIZE);
        librarySearch.setMinWidth(USE_PREF_SIZE);
        librarySearch.setPrefHeight(26.0);
        librarySearch.setPrefWidth(134.0);
        librarySearch.setPromptText("Search By Name");

        libraryAdd.setLayoutX(84.0);
        libraryAdd.setLayoutY(524.0);
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

        button.setLayoutX(154.0);
        button.setLayoutY(72.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(26.0);
        button.setPrefWidth(53.0);
        button.setText("Search");

        mediaWrapper.setId("Content");
        mediaWrapper.setMaxHeight(USE_PREF_SIZE);
        mediaWrapper.setMaxWidth(USE_PREF_SIZE);
        mediaWrapper.setMinHeight(USE_PREF_SIZE);
        mediaWrapper.setMinWidth(USE_PREF_SIZE);
        mediaWrapper.setPrefHeight(600.0);
        mediaWrapper.setPrefWidth(850.0);

        mediaView.setFitHeight(600.0);
        mediaView.setFitWidth(850.0);
        DoubleProperty mvw = mediaView.fitWidthProperty();
        DoubleProperty mvh = mediaView.fitHeightProperty();
        mvw.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
        mvh.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));
        mediaView.setPreserveRatio(true);

        mediaStop.setLayoutX(343.0);
        mediaStop.setLayoutY(526.0);
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

        mediaPlay.setLayoutX(392.0);
        mediaPlay.setLayoutY(526.0);
        mediaPlay.setMnemonicParsing(false);
        mediaPlay.setPrefHeight(36.0);
        mediaPlay.setPrefWidth(33.0);
        mediaPlay.setStyle("-fx-background-radius: 100;");

        mediaPause.setLayoutX(439.0);
        mediaPause.setLayoutY(526.0);
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

        mediaSkip.setLayoutX(484.0);
        mediaSkip.setLayoutY(526.0);
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

        mediaPlayImage.setFitHeight(23.0);
        mediaPlayImage.setFitWidth(16.0);
        mediaPlayImage.setLayoutX(403.0);
        mediaPlayImage.setLayoutY(535.0);
        mediaPlayImage.setPickOnBounds(true);
        mediaPlayImage.setPreserveRatio(true);
        mediaPlayImage.setImage(new Image(getClass().getResource("Icons/play.png").toExternalForm()));

        queueWrapper.setMaxHeight(USE_PREF_SIZE);
        queueWrapper.setMaxWidth(USE_PREF_SIZE);
        queueWrapper.setMinHeight(USE_PREF_SIZE);
        queueWrapper.setMinWidth(USE_PREF_SIZE);
        queueWrapper.setPrefHeight(600.0);
        queueWrapper.setPrefWidth(215.0);

        queueText.setAlignment(javafx.geometry.Pos.CENTER);
        queueText.setLayoutX(16.0);
        queueText.setLayoutY(14.0);
        queueText.setStyle("");
        queueText.setText("Queue");
        queueText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        queueText.setWrapText(false);

        queueList.setLayoutX(11.0);
        queueList.setLayoutY(68.0);
        queueList.setMaxHeight(USE_PREF_SIZE);
        queueList.setMaxWidth(USE_PREF_SIZE);
        queueList.setMinHeight(USE_PREF_SIZE);
        queueList.setMinWidth(USE_PREF_SIZE);
        queueList.setPrefHeight(434.0);
        queueList.setPrefWidth(191.0);

        queueRemove.setLayoutX(94.0);
        queueRemove.setLayoutY(523.0);
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

        libraryWrapper.getChildren().add(libraryText);
        libraryWrapper.getChildren().add(libraryList);
        libraryWrapper.getChildren().add(librarySearch);
        libraryWrapper.getChildren().add(libraryAdd);
        libraryWrapper.getChildren().add(button);
        mainWrapper.getItems().add(libraryWrapper);
        mediaWrapper.getChildren().add(mediaView);
        mediaWrapper.getChildren().add(mediaStop);
        mediaWrapper.getChildren().add(mediaPlay);
        mediaWrapper.getChildren().add(mediaPause);
        mediaWrapper.getChildren().add(mediaSkip);
        mediaWrapper.getChildren().add(mediaPlayImage);
        mainWrapper.getItems().add(mediaWrapper);
        queueWrapper.getChildren().add(queueText);
        queueWrapper.getChildren().add(queueList);
        queueWrapper.getChildren().add(queueRemove);
        mainWrapper.getItems().add(queueWrapper);
        getChildren().add(mainWrapper);

    }
}
