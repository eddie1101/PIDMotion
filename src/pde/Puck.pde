class Puck extends Object2D{
  
  private final int r = 15;
  
  public Puck(PVector pos){
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
