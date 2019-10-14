package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application {
    static Stage s ;
    @Override
    public void start(Stage primaryStage) throws Exception{
        s= primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("index.fxml"));
        primaryStage.setTitle("XO");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {

        Controller.p[0].setName(JOptionPane.showInputDialog(null,"Player 1 Enter your name"));
        Controller.p[0].setChoice('x');
        Controller.p[0].setScore(0);
        Controller.p[1].setName(JOptionPane.showInputDialog(null,"Player 2 Enter your name"));
        Controller.p[1].setChoice('o');
        Controller.p[1].setScore(0);
        launch(args);
    }
}
