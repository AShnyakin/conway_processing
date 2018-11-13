import processing.core.PApplet;

public class GameOfLife extends PApplet {

    int w = 8;
    int cols, rows;

    int[][] board;

    public void settings() {
        size(800, 800);

        cols = width/w;
        rows = height/w;

        board = new int[cols][rows];

        for (int x = 0; x < cols; x++) {
            for (int y = 0; y < rows; y++) {
                board[x][y] = (int) (Math.random() * 2);
            }
        }
    }

    public void generate() {
        int[][] next = new int[cols][rows];

        for (int x = 0; x < cols; x++) {
            for (int y = 0; y < rows; y++) {

                int neighbors = 0;
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        neighbors += board[(x + i + cols) % rows][(y + j + rows) % rows];
                    }
                }

                neighbors -= board[x][y];

                if ((board[x][y] == 1) && (neighbors < 2)) next[x][y] = 0;
                else if ((board[x][y] == 1) && (neighbors > 3)) next[x][y] = 0;
                else if ((board[x][y] == 0) && (neighbors == 3)) next[x][y] = 1;
                else next[x][y] = board[x][y];
            }
        }
        board = next;
    }

    public void display() {
        for ( int i = 0; i < cols;i++) {
            for ( int j = 0; j < rows;j++) {
                if ((board[i][j] == 1)) fill(0);
                else fill(255);
                stroke(0);
                rect(i*w, j*w, w, w);
            }
        }
    }

    public void draw() {
        background(255);

        generate();
        display();
    }

    public void mousePressed() {
        settings();
    }

    public static void main(String... args){
        PApplet.main("GameOfLife");
    }

}
