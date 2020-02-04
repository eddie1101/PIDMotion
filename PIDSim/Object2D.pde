abstract class Object2D{
  
  protected ArrayList<Force> forces;
  protected Force netForce;
  protected float mass;
  
  protected PVector pos;
  protected PVector vel;
  protected PVector acc;
  
  public Object2D(PVector pos, PVector vel, PVector acc){
    this.forces = new ArrayList<Force>();
    this.netForce = new Force(0, 0);
    this.pos = pos;
    this.vel = vel;
    this.acc = acc;
  }
  
  public Object2D(PVector pos, PVector vel){
    this.forces = new ArrayList<Force>();
    this.netForce = new Force(0, 0);
    this.pos = pos;
    this.vel = vel;
    this.acc = new PVector(0,0);
  }
  
  public Object2D(PVector pos){
    this.forces = new ArrayList<Force>();
    this.netForce = new Force(0, 0);
    this.pos = pos;
    this.vel = new PVector(0,0);
    this.acc = new PVector(0,0);
  }
  
  public Object2D(){
    this.forces = new ArrayList<Force>();
    this.netForce = new Force(0, 0);
    this.pos = new PVector(0,0);
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
  
  public void addExternalForce(Force force){
    this.forces.add(force);
  }
  
  public void addExternalForces(Force... forces){
    for(Force force: forces){
      this.forces.add(force);
    }
  }
  
  public void addExternalForces(ArrayList<Force> forces){
    for(Force force: forces){
      this.forces.add(force);
    }
  }
  
  protected void calculateNetForce(){
    this.netForce.sum(this.forces);
  }
  
  protected void updateMotionVectors(){
    //TODO
  }
  
  public abstract void calculateNetForce(PVector setpoint);
  public abstract void draw();
  
}
