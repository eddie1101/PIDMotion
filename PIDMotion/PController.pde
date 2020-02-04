class PController extends Trajectory{
  
  public PController(Ball ball){
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
    this.accSetpoint.set(-p * (ball.getPos().x - target.x), -p * (ball.getPos().y - target.y));
  }
  
}
