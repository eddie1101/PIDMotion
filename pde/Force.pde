class physics.Force{
  
  protected PVector force;
  
  public physics.Force(){
    force = new PVector();
  }
  
  public physics.Force(PVector force){
    this.force = force;
  }
  
  public physics.Force(float comp_x, float comp_y){
    this.force = new PVector(comp_x, comp_y);
  }
  
  public PVector vector(){
    return this.force;
  }
  
  public void setVector(PVector force){
    this.force.set(force);
  }
  
  public void setVector(float x, float y){
    this.force.set(new PVector(x, y));
  }
  
  public void addVector(physics.Force force){
    this.force.add(force.vector());
  }
  
  public physics.Force sum_copy(physics.Force... forces){
    physics.Force result = new physics.Force(0, 0);
    for(physics.Force force: forces){
      result.addVector(force);
    }
    result.addVector(this);
    return result;
  }
  
  public physics.Force sum_copy(ArrayList<physics.Force> forces){
    physics.Force result = new physics.Force(0, 0);
    for(physics.Force force: forces){
      result.addVector(force);
    }
    result.addVector(this);
    return result;
  }
  
  public void sum(ArrayList<physics.Force> forces){
    for(physics.Force force: forces){
      this.addVector(force);
      System.out.println("physics.Force Vectors: " + force.vector().x + ", " + force.vector().y);
    }
  }
  
  public void sum(physics.Force... forces){
    for(physics.Force force: forces){
      this.addVector(force);
    }
  }
  
  public physics.Force x(){
    return new physics.Force(this.force.x, 0);
  }
  
  public physics.Force y(){
    return new physics.Force(0, this.force.y);
  }
  
}
