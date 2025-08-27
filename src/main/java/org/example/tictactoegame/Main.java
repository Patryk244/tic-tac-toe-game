package org.example.tictactoegame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        SceneManger sceneManger = new SceneManger(stage);
        sceneManger.switchScene("make-choice.fxml");
    }
}
