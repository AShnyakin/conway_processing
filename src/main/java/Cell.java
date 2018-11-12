import processing.core.PApplet;

import static processing.core.PApplet.sin;

public class Cell {
    // A cell object knows about its location in the grid as well as its size with the variables x, y, w, h.
    float x, y;   // x,y location
    float w, h;   // width and height
    float angle;  // angle for oscillating brightness
    private PApplet parent;

    // Cell Constructor
    Cell(float tempX, float tempY, float tempW, float tempH, float tempAngle, PApplet parent) {
        this.parent = parent;
        x = tempX;
        y = tempY;
        w = tempW;
        h = tempH;
        angle = tempAngle;
    }

    // Oscillation means increase angle
    void oscillate() {
        angle += 0.02;
    }

    void display() {
        parent.stroke(255);
        // Color calculated using sine wave
        float bright = parent.map(sin(angle), -1, 1, 0, 255);
        parent.fill(bright);
        parent.rect(x, y, w, h);
    }

}