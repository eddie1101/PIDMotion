class Ball{
  
  public static final int r = 15;
  
  PVector pos;
  PVector vel;
  PVector acc;
  
  public Ball(PVector pos, PVector vel, PVector acc){
    this.pos = pos;
    this.vel = vel;
    this.acc = acc;
  }
  
  public Ball(PVector pos, PVector vel){
    this.pos = pos;
    this.vel = vel;
    this.acc = new PVector(0,0);
  }
  
  public Ball(PVector pos){
    this.pos = pos;
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
  
  public void setpoint(PVector setpoint){
    this.acc.set(setpoint);
    this.acc.limit(10);
  }
  
  public void draw(){
    this.update();
    fill(0);
    stroke(0);
    ellipse(pos.x, pos.y, r, r);
  }
  
  private void update(){
    pos.add(vel);
    vel.add(acc);
  }
  
}
