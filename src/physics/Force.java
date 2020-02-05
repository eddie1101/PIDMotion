package physics;

import processing.core.PVector;

import java.util.ArrayList;

public final class Force{

    protected PVector force;

    public Force(){
        force = new PVector();
    }

    public Force(PVector force){
        this.force = force;
    }

    public Force(float comp_x, float comp_y){
        this.force = new PVector(comp_x, comp_y);
    }

    public float mag(){
        return this.force.mag();
    }

    public PVector vector(){
        return this.force;
    }

    public Force x(){
        return new Force(this.force.x, 0);
    }

    public PVector xVec(){
        return new PVector(this.force.x, 0);
    }

    public Force y(){
        return new Force(0, this.force.y);
    }

    public PVector yVec(){
        return new PVector(0, this.force.y);
    }

    public float xComp(){
        return this.force.x;
    }

    public float yComp(){
        return this.force.y;
    }

    public void setVector(PVector force){
        this.force.set(force);
    }

    public void setVector(float x, float y){
        this.force.set(new PVector(x, y));
    }

    public void addVector(Force force){
        this.force.add(force.vector());
    }

    public static Force sum(ArrayList<Force> forces){
        Force result = new Force(0, 0);
        for(Force force: forces){
            result.addVector(force);
        }
        return result;
    }

    public static Force sum(Force... forces){
        Force result = new Force(0, 0);
        for(Force force: forces){
            result.addVector(force);
        }
        return result;
    }

    @Override
    public String toString(){
        return this.force.toString() + " mag: " + force.mag();
    }

}

