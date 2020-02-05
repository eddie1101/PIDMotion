package controller;

import objects.Object2D;
import processing.core.PApplet;
import processing.core.PVector;

public class PIDController extends Controller {

    private float position_error_x = 0;
    private float position_error_y = 0;

    public PIDController(PApplet pa, Object2D object){
        super(pa, object);
    }

    @Override
    public void setTarget(PVector target){
        this.target = new PVector();
        this.target.set(target);
        this.position_error_x = 0;
        this.position_error_y = 0;
    }

    @Override
    public void update(){
        this.calculateSetpoint();
        object.update();
    }

    @Override
    protected void calculateSetpoint(){
        position_error_x += (object.pos().x - target.x);
        position_error_y += (object.pos().y - target.y);
        this.forceSetpoint.setVector((-p * (object.pos().x - target.x)) - (d * object.vel().x) - (i * position_error_x), (-p * (object.pos().y - target.y)) - (d * object.vel().y) - (i * position_error_y));
    }

}

