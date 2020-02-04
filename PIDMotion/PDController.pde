class PDController extends Trajectory{
  
  public PDController(Ball ball){
    super(ball); 
  }
  
  @Override
  public void draw(){
    this.updateSetpoint();
    this.applySetpoint();
    ball.draw();
  }
  
  @Override
  protected void updateSetpoint(){
    this.accSetpoint.set(-p * (ball.getPos().x - target.x) - (d * ball.getVel().x), -p * (ball.getPos().y - target.y) - (d * ball.getVel().y));
  }
  
}
