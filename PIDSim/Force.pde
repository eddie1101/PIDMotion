class Force{
  
  protected PVector force;
  
  public Force(){
    force = new PVector();
  }
  
  public Force(PVector force){
    this.force = force;
  }
  
  public Force(float comp_x, float comp_y){
    this.force = new PVector(comp_x, comp_y);
  }
  
  public PVector vector(){
    return this.force;
  }
  
  public void setVector(PVector force){
    this.force.set(force);
  }
  
  public void addVector(Force force){
    this.force.add(force.vector());
  }
  
  public Force sum_copy(Force... forces){
    Force result = new Force(0, 0);
    for(Force force: forces){
      result.addVector(force);
    }
    result.addVector(this);
    return result;
  }
  
  public Force sum_copy(ArrayList<Force> forces){
    Force result = new Force(0, 0);
    for(Force force: forces){
      result.addVector(force);
    }
    result.addVector(this);
    return result;
  }
  
  public void sum(ArrayList<Force> forces){
    for(Force force: forces){
      this.addVector(force);
    }
  }
  
  public void sum(Force... forces){
    for(Force force: forces){
      this.addVector(force);
    }
  }
  
}
