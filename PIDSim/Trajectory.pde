abstract class Trajectory{
  
  protected float p = 0;
  protected float i = 0;
  protected float d = 0;
  
  protected PVector target;
  protected PVector accSetpoint;
  protected Object2D object;
  
  public Trajectory(Object2D object){
    this.object = object;
    this.accSetpoint = new PVector(0, 0);
    this.target = new PVector(object.getPos().x, object.getPos().y);
  }
  
  public PVector getSetpoint(){
    return this.accSetpoint;
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
  
  protected void applySetpoint(){
    //Awaiting implementation of Force
  }
  
  public abstract void draw();
  protected abstract void updateSetpoint();
  
}
