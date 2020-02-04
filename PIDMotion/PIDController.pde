class PIDController extends Trajectory{
  
  private float position_error_x = 0;
  private float position_error_y = 0;
  
  public PIDController(Ball ball){
    super(ball); 
  }
  
  @Override
  public void setTarget(PVector target){
    this.target = new PVector();
    this.target.set(target);
    this.position_error_x = 0;
    this.position_error_y = 0;
  }
  
  @Override
  public void draw(){
    this.updateSetpoint();
    this.applySetpoint();
    ball.draw();
  }
  
  @Override
  protected void updateSetpoint(){
    position_error_x += (ball.getPos().x - target.x);
    position_error_y += (ball.getPos().y - target.y);
    this.accSetpoint.set(-p * (ball.getPos().x - target.x) - (d * ball.getVel().x) - (i * position_error_x), -p * (ball.getPos().y - target.y) - (d * ball.getVel().y) - (i * position_error_y));
  }
  
}
