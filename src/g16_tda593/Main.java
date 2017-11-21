package g16_tda593;

import java.util.HashSet;
import java.util.Set;
import project.Point;
import project.SimulatorController;
import simbad.sim.AbstractWall;
import simbad.sim.Boundary;
import simbad.sim.EnvironmentDescription;
import simbad.sim.HorizontalBoundary;
import simbad.sim.HorizontalWall;
import simbad.sim.VerticalBoundary;
import simbad.sim.VerticalWall;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		EnvironmentDescription e = new EnvironmentDescription();
		Boundary w1 = new HorizontalBoundary(-5.0f, -5.0f, 5.0f, e);
		e.add(w1);
		Boundary w2 = new HorizontalBoundary(5.0f, -5.0f, 5.0f, e);
		e.add(w2);
		Boundary w3 = new VerticalBoundary(5.0f, -5.0f, 5.0f, e);
		e.add(w3);
		Boundary w4 = new VerticalBoundary(-5.0f, -5.0f, 5.0f, e);
		e.add(w4);
		AbstractWall roomWall1 = new HorizontalWall(-1f, 4.5f, 3.5f, e);
		e.add(roomWall1);
		AbstractWall roomWall2 = new HorizontalWall(-4.5f, 4.5f, 1f, e);
		e.add(roomWall2);
		AbstractWall roomWall3 = new VerticalWall(4.5f, -4.5f, -1f, e);
	e.add(roomWall3);
	AbstractWall roomWall4 = new VerticalWall(1f, -4.5f, -1f, e);
	e.add(roomWall4);
	Set<Robot> robots = new HashSet<>();
	Robot robot1 = new Robot(new Point(6, -4), "Robot 1");
	Robot robot2 = new Robot(new Point(6, -2), "Robot 2");
	Robot robot3 = new Robot(new Point(6, 0), "Robot 3");
	Robot robot4 = new Robot(new Point(6, 2), "Robot 4");
	robots.add(robot1);
	robots.add(robot2);
	robots.add(robot3);
	robots.add(robot4);
	
	//robot1.setDestination(new Point(4,2));
	
	EnvironmentFactory en = new EnvironmentFactory();
	Area area = en.makeEnvironment("assignment3");
	
	SimulatorController controller = new Controller(robots, area.getArea());
	}
}
