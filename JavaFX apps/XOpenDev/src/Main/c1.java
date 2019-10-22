package Main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

public class c1 {


    @FXML
    Button b1 = new Button();

    @FXML
    private void bFun() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Main.s.setScene(new Scene(root));

    }
}
