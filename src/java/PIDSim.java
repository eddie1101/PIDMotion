package java;

import processing.core.PApplet;
import processing.core.PVector;

public class PIDSim extends PApplet {
    Object2D puck;
    Trajectory traj;
    PVector target;

    public void setup(){
        size(1200, 900);
        frameRate(3);

        puck = new Puck(new PVector(width/2, height/2));
        traj = new PDController(puck);
        traj.setConstants(0.1f, 0.005f, 1.0f);

    }

    public void draw(){
        background(255);
        System.out.println();
        traj.update();
        if(target != null){
            fill(255, 0, 0);
            ellipse(target.x, target.y, 10, 10);
        }
        fill(0);
        text("Setpoint: " + traj.getSetpoint().vector().x + " " + traj.getSetpoint().vector().y,20, 20);
    }

    public void mouseReleased(){
        target = new PVector(mouseX, mouseY);
        traj.setTarget(target);
    }

    public static void main(String... args) {
        PApplet.main("PIDSim");
    }
}
