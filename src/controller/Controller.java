package controller;

import objects.Object2D;
import physics.Force;
import processing.core.PApplet;
import processing.core.PVector;

public abstract class Controller {

    protected final PApplet graphics;

    protected float p = 0;
    protected float i = 0;
    protected float d = 0;

    protected PVector target;
    protected Force forceSetpoint;
    protected final Object2D object;

    public Controller(PApplet pa, Object2D object){
        this.graphics = pa;
        this.object = object;
        this.forceSetpoint = new Force(0, 0);
        this.object.addExternalForce(this.forceSetpoint);
        this.target = new PVector(object.pos().x, object.pos().y);
    }

    public final Force getSetpoint(){
        return this.forceSetpoint;
    }

    public void setTarget(PVector target){
        this.target = new PVector();
        this.target.set(target);
    }

    public void setConstants(float p, float i, float d){
        this.p = p;
        this.i = i;
        this.d = d;
    }

    protected abstract void calculateSetpoint();
    public abstract void update();

}

