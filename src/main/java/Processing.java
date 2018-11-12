import processing.core.PApplet;

public class Processing extends PApplet{

    Cell[][] board;

    int cols = 32;
    int rows = 18;

    public void settings(){
        size(320, 180);
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
        PApplet.main("Processing");
    }

}
