Trajectory traj;
PVector target;

void setup(){
  size(1200, 900);
  frameRate(30);
  
  //Initialize traj with a non-null Object2D here.
  
}

void draw(){
  background(255);
  traj.update();
  if(target != null){
    fill(255, 0, 0);
    ellipse(target.x, target.y, 10, 10);
  }
  fill(0);
  text("Setpoint: " + traj.getSetpoint(),20, 20);
}

void mouseReleased(){
  target = new PVector(mouseX, mouseY);
  traj.setTarget(target);
}
