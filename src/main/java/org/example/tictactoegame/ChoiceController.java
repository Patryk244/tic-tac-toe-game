package org.example.tictactoegame;
import javafx.scene.control.Button;
import java.io.IOException;

public class ChoiceController {
    public Button medium;
    public Button big;
    public Button small;

    public void smallBoard() throws IOException {
        GameController controller = (GameController) SceneManger.switchScene("/org/example/tictactoegame/board.fxml");
        controller.setBoardSize(3);
    }

    public void mediumBoard() throws IOException {
        GameController controller = (GameController) SceneManger.switchScene("/org/example/tictactoegame/board.fxml");
        controller.setBoardSize(6);
    }

    public void bigBoard() throws IOException {
        GameController controller = (GameController) SceneManger.switchScene("/org/example/tictactoegame/board.fxml");
        controller.setBoardSize(8);
    }
}