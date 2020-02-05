package controller;

import objects.Object2D;
import processing.core.PApplet;

public class PController extends Controller {

    public PController(PApplet pa, Object2D object){
        super(pa, object);
    }

    @Override
    public void update(){
        this.calculateSetpoint();
        object.update();
    }

    @Override
    protected void calculateSetpoint(){
        this.forceSetpoint.setVector(-p * (object.pos().x - target.x), -p * (object.pos().y - target.y));
    }

}
