class PDController extends Trajectory{
  
  public PDController(Object2D object){
    super(object); 
  }
  
  @Override
  public void draw(){
    this.updateSetpoint();
    this.applySetpoint();
    object.draw();
  }
  
  @Override
  protected void updateSetpoint(){
    this.accSetpoint.set(-p * (object.getPos().x - target.x) - (d * object.getVel().x), -p * (object.getPos().y - target.y) - (d * object.getVel().y));
  }
  
}
