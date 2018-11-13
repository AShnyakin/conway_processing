import processing.core.PApplet;

public class Oscillation extends PApplet{

    Cell[][] board;

    int cols = 80;
    int rows = 80;

    public void settings(){
        size(800, 800);
        board = new Cell[cols][rows];

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                // init objects
                board[i][j] = new Cell(i*10, j*10, 10, 10, i + j, this);
            }
        }
    }

    public void draw(){
        background(0);
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                // Oscillate and display each object
                board[i][j].oscillate();
                board[i][j].display();
            }
        }
    }

    public static void main(String... args){
        PApplet.main("Oscillation");
    }

}
