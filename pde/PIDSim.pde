objects.Object2D puck;
controller.Controller traj;
PVector target;

void setup(){
  size(1200, 900);
  frameRate(3);
  
  puck = new objects.Puck(new PVector(width/2, height/2));
  traj = new controller.PDController(puck);
  traj.setConstants(0.1, 0.005, 1.0);
  
}

void draw(){
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

void mouseReleased(){
  target = new PVector(mouseX, mouseY);
  traj.setTarget(target);
}
