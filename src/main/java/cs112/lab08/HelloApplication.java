package cs112.lab08;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class HelloApplication extends Application {

    //CONSTANTS
    private Button drawCardButton;
    private Label titleLabel, messageLabel;
    private ImageView cardView;
    private final Random RANDOM = new Random();


    //array of LoteriaCards to use for game:
    private static final LoteriaCard[] LOTERIA_CARDS = {
            new LoteriaCard("Las matematicas", "1.png", 1),
            new LoteriaCard("Las ciencias", "2.png", 2),
            new LoteriaCard("La Tecnología", "8.png", 8),
            new LoteriaCard("La ingeniería", "9.png", 9),
    };

    @Override
    public void start(Stage stage) throws IOException {
        //removed FXML code, fill this in with components, scene, stage, etc.
        titleLabel = new Label("Welcome to Loteria!");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        messageLabel = new Label("Click the button below to draw a card!");
        messageLabel.setStyle("-fx-font-size: 14px;");

        drawCardButton = new Button("Draw Random Card");
        drawCardButton.setStyle("-fx-font-size: 16px;-fx-background-color: #0078D4; -fx-text-fill: white;");

        cardView = new ImageView(LOTERIA_CARDS[0].getImage());

        cardView.setFitWidth(300);
        cardView.setPreserveRatio(true);

        drawCardButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleButtonClick();
            }
        });


        VBox cardViewer = new VBox();
        cardViewer.setAlignment(Pos.CENTER);
        cardViewer.getChildren().addAll(titleLabel, cardView, messageLabel, drawCardButton);

        Scene window = new Scene(cardViewer, 350, 500);

        stage.setTitle("Loteria");
        stage.setScene(window);

        stage.show();
    }

    private void handleButtonClick() {
        int randomIndex = RANDOM.nextInt(LOTERIA_CARDS.length);
        LoteriaCard randomCard = LOTERIA_CARDS[randomIndex];

        cardView.setImage(randomCard.getImage());
        messageLabel.setText(randomCard.getCardName());
    }

    public static void main(String[] args) {
        launch();
    }
}