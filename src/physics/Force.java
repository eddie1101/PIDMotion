package physics;

import processing.core.PVector;

import java.util.ArrayList;

public class Force{

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

    public PVector vector(){
        return this.force;
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

    public Force sum_copy(Force... forces){
        Force result = new Force(0, 0);
        for(Force force: forces){
            result.addVector(force);
        }
        result.addVector(this);
        return result;
    }

    public Force sum_copy(ArrayList<Force> forces){
        Force result = new Force(0, 0);
        for(Force force: forces){
            result.addVector(force);
        }
        result.addVector(this);
        return result;
    }

    public void sum(ArrayList<Force> forces){
        for(Force force: forces){
            this.addVector(force);
            System.out.println("physics.Force Vectors: " + force.vector().x + ", " + force.vector().y);
        }
    }

    public void sum(Force... forces){
        for(Force force: forces){
            this.addVector(force);
        }
    }

    public Force x(){
        return new Force(this.force.x, 0);
    }

    public Force y(){
        return new Force(0, this.force.y);
    }

}

