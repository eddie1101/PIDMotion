abstract class Trajectory{
  
  protected float p = 0;
  protected float i = 0;
  protected float d = 0;
  
  protected PVector target;
  protected PVector accSetpoint;
  protected Ball ball;
  
  public Trajectory(Ball ball){
    this.ball = ball;
    this.accSetpoint = new PVector(0, 0);
    this.target = new PVector(ball.getPos().x, ball.getPos().y);
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
    this.ball.setpoint(this.accSetpoint);
  }
  
  public abstract void draw();
  protected abstract void updateSetpoint();
  
}
