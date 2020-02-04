class PController extends Trajectory{
  
  public PController(Object2D object){
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
    this.accSetpoint.set(-p * (object.getPos().x - target.x), -p * (object.getPos().y - target.y));
  }
  
}
