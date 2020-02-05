package objects;

import processing.core.*;

public class Puck extends Object2D {

    private final int r = 15;

    public Puck(PApplet pa, PVector pos){
        super(pa, 3, pos);
    }

    public void update(){
        this.calculateNetForce();
        this.updateMotionVectors();
        this.draw();
    }

    public void draw(){
        graphics.stroke(0);
        graphics.fill(0);
        graphics.ellipse(pos.x, pos.y, r, r);
    }

}

