Ball ball;
Trajectory traj;
PVector target;

void setup(){
  size(1000, 1000);
  frameRate(30);
  
  ball = new Ball(new PVector(500, 500));
  //traj = new PController(ball);
  //traj = new PDController(ball);
  traj = new PIDController(ball);
  traj.setConstants(0.1, 0.005, 0.5);
}

void draw(){
  background(255);
  traj.draw();
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
