package Main;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    private static Player p1 = new Player();
    private static Player p2 = new Player();
    public static Player[] p = {p1,p2};
    @FXML
    Label p1Score = new Label();

    @FXML
    Label p2Score = new Label();

    private int activePlayer=1;
    @FXML
    private Button b1= new Button(),b2= new Button(),b3= new Button(),b4= new Button(),b5= new Button(),b6= new Button(),b7= new Button(),b8= new Button(),b9= new Button();


    private  void switchPlayer(){
        if(activePlayer==1)
            activePlayer=2;
        else
            activePlayer=1;
    }
    int clicked = 0;
    @FXML
    void one(){
        clicked++;
        p[activePlayer-1].getCells().add(1);
        b1.setText(String.valueOf(p[activePlayer-1].getChoice()));
        b1.setDisable(true);
        Winner();
        switchPlayer();

        System.out.println(clicked);
    }
    @FXML
    void two(){
        clicked++;
        p[activePlayer-1].getCells().add(2);
        b2.setText(String.valueOf(p[activePlayer-1].getChoice()));
        b2.setDisable(true);
        Winner();
        switchPlayer();
        System.out.println(clicked);
    }
    @FXML
    void three(){
        clicked++;
        p[activePlayer-1].getCells().add(3);
        b3.setText(String.valueOf(p[activePlayer-1].getChoice()));
        b3.setDisable(true);
        Winner();
        switchPlayer();
        System.out.println(clicked);
    }
    @FXML
    void four(){
        clicked++;
        p[activePlayer-1].getCells().add(4);
        b4.setText(String.valueOf(p[activePlayer-1].getChoice()));
        p[activePlayer-1].getChoice();
        b4.setDisable(true);
        Winner();
        switchPlayer();
        System.out.println(clicked);
    }

    @FXML
    void five(){
        clicked++;
        p[activePlayer-1].getCells().add(5);
        b5.setText(String.valueOf(p[activePlayer-1].getChoice()));
        b5.setDisable(true);
        Winner();
        switchPlayer();
        System.out.println(clicked);
    }
    @FXML
    void six(){
        clicked++;
        p[activePlayer-1].getCells().add(6);
        b6.setText(String.valueOf(p[activePlayer-1].getChoice()));
        b6.setDisable(true);
        Winner();
        switchPlayer();
        System.out.println(clicked);
    }
    @FXML
    void seven(){
        clicked++;
        p[activePlayer-1].getCells().add(7);
        b7.setText(String.valueOf(p[activePlayer-1].getChoice()));
        b7.setDisable(true);
        Winner();
        switchPlayer();
        System.out.println(clicked);
    }
    @FXML
    void eight(){
        clicked++;
        p[activePlayer-1].getCells().add(8);
        b8.setText(String.valueOf(p[activePlayer-1].getChoice()));
        b8.setDisable(true);
        Winner();
        switchPlayer();
        System.out.println(clicked);
    }
    @FXML
    void nine(){
        clicked++;
        p[activePlayer-1].getCells().add(9);
        b9.setText(String.valueOf(p[activePlayer-1].getChoice()));
        b9.setDisable(true);
        Winner();
        switchPlayer();

    }
    void checkNull(){

    }
    void Winner(){

        if (p[activePlayer-1].getCells().contains(1)&&p[activePlayer-1].getCells().contains(2)&&p[activePlayer-1].getCells().contains(3)||p[activePlayer-1].getCells().contains(4)&&p[activePlayer-1].getCells().contains(5)&&p[activePlayer-1].getCells().contains(6)||
                p[activePlayer-1].getCells().contains(7)&&p[activePlayer-1].getCells().contains(8)&&p[activePlayer-1].getCells().contains(9)||p[activePlayer-1].getCells().contains(1)&&p[activePlayer-1].getCells().contains(4)&&p[activePlayer-1].getCells().contains(7)||
                p[activePlayer-1].getCells().contains(2)&&p[activePlayer-1].getCells().contains(5)&&p[activePlayer-1].getCells().contains(8)||p[activePlayer-1].getCells().contains(3)&&p[activePlayer-1].getCells().contains(6)&&p[activePlayer-1].getCells().contains(9)||
                p[activePlayer-1].getCells().contains(1)&&p[activePlayer-1].getCells().contains(5)&&p[activePlayer-1].getCells().contains(9)||p[activePlayer-1].getCells().contains(3)&&p[activePlayer-1].getCells().contains(5)&&p[activePlayer-1].getCells().contains(7)){
                JOptionPane.showMessageDialog(null,p[activePlayer-1].getName() + " Won");
                p[activePlayer-1].setScore(p[activePlayer-1].getScore()+1);
                p1Score.setText(String.valueOf(p[0].getScore()));
                p2Score.setText(String.valueOf(p[1].getScore()));
                reset();
            System.out.println(clicked);
            clicked=0;

        }
        if(clicked>=9 ){
            JOptionPane.showMessageDialog(null,"No One Won","Nul", JOptionPane.INFORMATION_MESSAGE);
            reset();
            clicked= 0;
        }
    }
    void reset(){
        p[0].setCells(new ArrayList<>());
        p[1].setCells(new ArrayList<>());
        b1.setDisable(false);
        b1.setText("");
        b2.setDisable(false);
        b2.setText("");
        b3.setDisable(false);
        b3.setText("");
        b4.setDisable(false);
        b4.setText("");
        b5.setDisable(false);
        b5.setText("");
        b6.setDisable(false);
        b6.setText("");
        b7.setDisable(false);
        b7.setText("");
        b8.setDisable(false);
        b8.setText("");
        b9.setDisable(false);
        b9.setText("");
    }
    @FXML
    Label p1Name = new Label();
    @FXML
    Label p2Name = new Label();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        p1Name.setText(p[0].getName());
        p2Name.setText(p[1].getName());
    }
}