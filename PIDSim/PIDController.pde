class PIDController extends Trajectory{
  
  private float position_error_x = 0;
  private float position_error_y = 0;
  
  public PIDController(Object2D object){
    super(object); 
  }
  
  @Override
  public void setTarget(PVector target){
    this.target = new PVector();
    this.target.set(target);
    this.position_error_x = 0;
    this.position_error_y = 0;
  }
  
  @Override
  public void update(){
    this.calculateSetpoint();
    object.update();
  }
  
  @Override
  protected void calculateSetpoint(){
    position_error_x += (object.getPos().x - target.x);
    position_error_y += (object.getPos().y - target.y);
    this.forceSetpoint.setVector(-p * (object.getPos().x - target.x) - (d * object.getVel().x) - (i * position_error_x), -p * (object.getPos().y - target.y) - (d * object.getVel().y) - (i * position_error_y));
  }
  
}
