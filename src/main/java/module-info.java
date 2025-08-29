module org.example.tictactoegame {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens org.example.tictactoegame to javafx.fxml;
    exports org.example.tictactoegame;
}