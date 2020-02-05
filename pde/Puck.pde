class objects.Puck extends objects.Object2D{
  
  private final int r = 15;
  
  public objects.Puck(PVector pos){
    super(pos);
  }
  
  public void update(){
    this.calculateNetForce();
    this.updateMotionVectors();
    this.draw();
  }
  
  
  protected void draw(){
    stroke(0);
    fill(0);
    ellipse(pos.x, pos.y, r, r);
  }
  
}
