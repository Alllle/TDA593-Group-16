package g16_tda593;

import project.LocationController;
import project.Point;
import simbad.sim.EnvironmentDescription;

public class Gatekeeper extends LocationController {
	
	private RobotAvatar currentOwner;
	private Point position;
	private double radius;

	public Gatekeeper(Point pos, double radius, EnvironmentDescription wd) {
		super(pos, radius, wd);
		this.position = pos;
		this.radius = radius;
	}
	
	public Point getCenter() {
		return this.position;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public RobotAvatar getOwner() {
		return currentOwner;
	}
	
	public void setOwner(RobotAvatar r) {
		currentOwner = r;
	}
}
