package org.example.tictactoegame;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        SceneManger.setStage(stage);
        SceneManger.switchScene("/org/example/tictactoegame/make-choice.fxml.");
    }
}