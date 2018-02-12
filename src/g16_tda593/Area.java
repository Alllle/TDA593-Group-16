package g16_tda593;

import project.LocationController;
import project.Point;

public abstract class Area {
  private Point center;
  private double radius;
  private boolean occupied;
  private LocationController lc;
  private RobotAvatar owner;

  public Area(Point center, double radius) {
    this.center = center;
    this.radius = radius;
    this.occupied = false;
  }
  
  public void setLc(LocationController l) {
	  this.lc = l;
  }
  
  public void setOwner(RobotAvatar r) {
	  this.owner = r;
  }
  
  public RobotAvatar getOwner() {
	  return this.owner;
  }
  
  
  public LocationController getLc() {
	  return this.lc;
  }

  public void setOccupied(boolean b) {
    this.occupied = b;
  }

  public boolean getOccupied() {
    return this.occupied;
  }

  public Point getCenter() {
    return this.center;
  }

  public double getRadius() {
    return this.radius;
  }
}
