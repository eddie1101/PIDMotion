abstract class Trajectory{
  
  protected float p = 0;
  protected float i = 0;
  protected float d = 0;
  
  protected PVector target;
  protected Force forceSetpoint;
  protected Object2D object;
  
  public Trajectory(Object2D object){
    this.object = object;
    this.forceSetpoint = new Force(0, 0);
    this.object.addExternalForce(this.forceSetpoint);
    this.target = new PVector(object.getPos().x, object.getPos().y);
  }
  
  public Force getSetpoint(){
    return this.forceSetpoint;
  }
  
  public void setTarget(PVector target){
    this.target = new PVector();
    this.target.set(target);
  }
  
  public void setConstants(float p, float i, float d){
    this.p = p;
    this.i = i;
    this.d = d;
  }
  
  protected abstract void calculateSetpoint();
  public abstract void update();
  
}
