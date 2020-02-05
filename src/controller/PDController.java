package controller;

import objects.Object2D;
import processing.core.PApplet;

public class PDController extends Controller {

    public PDController(PApplet pa, Object2D object){
        super(pa, object);
    }

    @Override
    public void update(){
        this.calculateSetpoint();
        object.update();
    }

    @Override
    protected void calculateSetpoint(){
        this.forceSetpoint.setVector(-p * (object.getPos().x - target.x) - (d * object.getVel().x), -p * (object.getPos().y - target.y) - (d * object.getVel().y));
    }

}

