package Main;

import java.util.ArrayList;

public class Player {

    private String Name;
    private int Score;
    private char Choice;
    private ArrayList<Integer> Cells = new ArrayList<>();

    public Player(String name, int score, char choice) {
        Name = name;
        Score = score;
        Choice = choice;

    }

    public Player(){}

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public char getChoice() {
        return Choice;
    }

    public void setChoice(char choice) {
        Choice = choice;
    }

    public ArrayList<Integer> getCells() {
        return Cells;
    }

    public void setCells(ArrayList<Integer> cells) {
        Cells = cells;
    }


}
