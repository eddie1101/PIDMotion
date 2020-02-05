package objects;

import physics.Force;
import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public abstract class Object2D {

    protected final PApplet graphics;

    protected ArrayList<Force> externalForces;
    protected Force friction;
    protected Force netForce;
    protected float mass;

    protected PVector pos;
    protected PVector vel;
    protected PVector acc;

    public Object2D(PApplet pa, float mass, PVector pos, PVector vel, PVector acc){
        this.graphics = pa;
        this.externalForces = new ArrayList<Force>();
        this.netForce = new Force(0, 0);
        this.mass = mass;
        this.pos = pos;
        this.vel = vel;
        this.acc = acc;
    }

    public Object2D(PApplet pa, float mass, PVector pos, PVector vel){
        this.graphics = pa;
        this.externalForces = new ArrayList<Force>();
        this.netForce = new Force(0, 0);
        this.mass = mass;
        this.pos = pos;
        this.vel = vel;
        this.acc = new PVector(0,0);
    }

    public Object2D(PApplet pa, float mass, PVector pos){
        this.graphics = pa;
        this.externalForces = new ArrayList<Force>();
        this.netForce = new Force(0, 0);
        this.mass = mass;
        this.pos = pos;
        this.vel = new PVector(0,0);
        this.acc = new PVector(0,0);
    }

    public Object2D(PApplet pa, float mass){
        this.graphics = pa;
        this.externalForces = new ArrayList<Force>();
        this.netForce = new Force(0, 0);
        this.mass = mass;
        this.pos = new PVector(0,0);
        this.vel = new PVector(0,0);
        this.acc = new PVector(0,0);
    }

    public final PVector pos(){
        return pos;
    }

    public final PVector vel(){
        return vel;
    }

    public final PVector acc(){
        return acc;
    }

    public final float mass(){
        return mass;
    }

    public final Force friction(){ return friction; }

    protected final void setMass(float mass){
        this.mass = mass;
    }

    public final void setFriction(Force friction){
        this.friction = friction;
    }

    public final void addExternalForce(Force force){
        this.externalForces.add(force);
    }

    public final void addExternalForces(Force... forces){
        for(Force force: forces){
            this.externalForces.add(force);
        }
    }

    public final void addExternalForces(ArrayList<Force> forces){
        for(Force force: forces){
            this.externalForces.add(force);
        }
    }

    public final void removeExternalForce(Force force){
        if(this.externalForces.contains(force)){
            externalForces.remove(force);
        }
    }

    public final void clearExternalForces(){
        this.externalForces = new ArrayList<>();
    }

    public final void calculateNetForce(){
        netForce = Force.sum(this.externalForces);
        if(Math.abs(friction.mag()) <= Math.abs(netForce.mag())){
            netForce = Force.sum(netForce, friction);
        }else{
            netForce = friction;
        }
    }

    protected final void updateMotionVectors(){
        pos.add(vel);
        vel.add(acc);
        acc.set(this.applyForce());
    }

    private final PVector applyForce(){
        float xAcc = netForce.xComp() / this.mass;
        float yAcc = netForce.yComp() / this.mass;
        return new PVector(xAcc, yAcc);
    }

    public abstract void update();

}

