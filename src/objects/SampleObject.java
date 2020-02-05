package objects;

import processing.core.*;

public class SampleObject extends Object2D {

    private final int r = 15;

    public SampleObject(PApplet pa, PVector pos){
        super(pa, 1, pos);
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

