package objects;

import physics.Force;
import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public abstract class Object2D {

    protected PApplet graphics;

    protected ArrayList<Force> forces;
    protected Force netForce;
    protected float mass;

    protected PVector pos;
    protected PVector vel;
    protected PVector acc;

    public Object2D(PApplet pa, float mass, PVector pos, PVector vel, PVector acc){
        this.graphics = pa;
        this.forces = new ArrayList<Force>();
        this.netForce = new Force(0, 0);
        this.mass = mass;
        this.pos = pos;
        this.vel = vel;
        this.acc = acc;
    }

    public Object2D(PApplet pa, float mass, PVector pos, PVector vel){
        this.graphics = pa;
        this.forces = new ArrayList<Force>();
        this.netForce = new Force(0, 0);
        this.mass = mass;
        this.pos = pos;
        this.vel = vel;
        this.acc = new PVector(0,0);
    }

    public Object2D(PApplet pa, float mass, PVector pos){
        this.graphics = pa;
        this.forces = new ArrayList<Force>();
        this.netForce = new Force(0, 0);
        this.mass = mass;
        this.pos = pos;
        this.vel = new PVector(0,0);
        this.acc = new PVector(0,0);
    }

    public Object2D(PApplet pa, float mass){
        this.graphics = pa;
        this.forces = new ArrayList<Force>();
        this.netForce = new Force(0, 0);
        this.mass = mass;
        this.pos = new PVector(0,0);
        this.vel = new PVector(0,0);
        this.acc = new PVector(0,0);
    }

    public PVector getPos(){
        return pos;
    }

    public PVector getVel(){
        return vel;
    }

    public PVector getAcc(){
        return acc;
    }

    protected void setMass(float mass){
        this.mass = mass;
    }

    public void addExternalForce(Force force){
        this.forces.add(force);
    }

    public void addExternalForces(Force... forces){
        for(Force force: forces){
            this.forces.add(force);
        }
    }

    public void addExternalForces(ArrayList<Force> forces){
        for(Force force: forces){
            this.forces.add(force);
        }
    }

    protected void calculateNetForce(){
        this.netForce.sum(this.forces);
    }

    protected void updateMotionVectors(){
        pos.add(vel);
        vel.add(acc);
        acc.set(this.applyForce());
    }

    protected PVector applyForce(){
        Force x = this.netForce.x();
        Force y = this.netForce.y();
        float xAcc = x.vector().x / this.mass;
        float yAcc = y.vector().y / this.mass;
        PVector resultantAcceleration = new PVector(xAcc, yAcc);
        return resultantAcceleration;
    }

    public abstract void update();

}

