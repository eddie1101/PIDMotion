package main;

import controller.PController;
import controller.PDController;
import controller.PIDController;
import controller.Controller;
import objects.Puck;
import objects.Object2D;

import processing.core.PApplet;
import processing.core.PVector;

public class PIDSim extends PApplet {
    Object2D puck;
    Controller controller;
    PVector target;

    public void settings() {
        size(1200, 900);
    }

    public void setup(){
        puck = new Puck(this, new PVector(width/2f, height/2f));
//        controller = new PController(this, puck);
        controller = new PDController(this, puck);
//        controller = new PIDController(this, puck);

        controller.setConstants(0.01f, 0.005f, 0.2f);
//        target = new PVector(400, 300);
//        controller.setTarget(target);
    }

    public void draw(){
        background(255);
        controller.update();
        if(target != null){
            fill(255, 0, 0);
            ellipse(target.x, target.y, 10, 10);
        }
        fill(0);
        text("Setpoint: " + controller.getSetpoint().vector().x + " " + controller.getSetpoint().vector().y,20, 20);
    }

    public void mouseReleased(){
        target = new PVector(mouseX, mouseY);
        controller.setTarget(target);
    }

    public static void main(String... args) {
        PApplet.main("main.PIDSim");
    }
}
