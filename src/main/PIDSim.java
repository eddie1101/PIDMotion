package main;

import controller.PDController;
import controller.Controller;
import controller.PIDController;
import objects.SampleObject;
import objects.Object2D;

import physics.Environment;
import physics.SampleEnvironment;
import processing.core.PApplet;
import processing.core.PVector;

public class PIDSim extends PApplet {
    Object2D object;
    Controller controller;
    Environment environment;
    PVector target;

    public void settings() {
        size(1200, 900);
    }

    public void setup(){
        object = new SampleObject(this, new PVector(width/2f, height/2f));
        controller = new PDController(this, object);
        controller.setConstants(0.01f, 0.00005f, 0.2f);
        environment = new SampleEnvironment(0.2f, 4);
        environment.addObject(object);
    }

    public void draw(){

        background(255);

        controller.update();
        environment.update();

        if(target != null){
            fill(255, 0, 0);
            ellipse(target.x, target.y, 10, 10);
        }

        fill(0);
        text("Setpoint: " + controller.getSetpoint().vector().x + " " + controller.getSetpoint().vector().y,20, 20);

        if(frameCount >= 500){
//            object.calculateNetForce();
//            controller.update();
        }

    }

    public void mouseReleased(){
        target = new PVector(mouseX, mouseY);
        controller.setTarget(target);
    }

    public static void main(String... args) {
        PApplet.main("main.PIDSim");
    }
}
