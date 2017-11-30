package g16_tda593;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import project.Point;
import project.AbstractSimulatorMonitor;
import simbad.sim.AbstractWall;
import simbad.sim.Boundary;
import simbad.sim.EnvironmentDescription;
import simbad.sim.HorizontalBoundary;
import simbad.sim.HorizontalWall;
import simbad.sim.VerticalBoundary;
import simbad.sim.VerticalWall;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		
		Environment e = new Environment();
		
		//Top left room
		PhysicalArea area = new PhysicalArea(5.0f,5.0f,-5.0f,-5.0f);
		area.addWall(5f, 3.5f, 5.0f, 'h');
		
		e.addRoom(area.getEnvironment());
		
		// Should this really be used?
		/*EnvironmentDescription e = new EnvironmentDescription();
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
	e.add(roomWall4); */
	Set<Robot> robots = new HashSet<>();
	List<Mission> missions = new ArrayList<>();
	/*Felix added missions here, not 100% about locations, will try*/
	missions.add(new Mission(new Point[] {new Point(-3.5, -3.5)}, 1));
	missions.add(new Mission(new Point[] {new Point(3.5, -3.5)}, 2));
	missions.add(new Mission(new Point[] {new Point(-3.5, 3.5)}, 3));
	missions.add(new Mission(new Point[] {new Point(3.5, 3.5)}, 4));
	
	Robot robot1 = new Robot(new Point(6, -4), "Robot 1");
	Robot robot2 = new Robot(new Point(6, -2), "Robot 2");
	Robot robot3 = new Robot(new Point(6, 0), "Robot 3");
	Robot robot4 = new Robot(new Point(6, 2), "Robot 4");
	/*Robot robot1 = new Robot(new Point(6, -4), "Robot 1", new Mission(new Point[] {new Point(-3.5, -3.5)}, 1));
	Robot robot4 = new Robot(new Point(6, 2), "Robot 2", new Mission(new Point[] {new Point(3.5, 3.5)}, 2));*/

	robots.add(robot1);
	robots.add(robot2);
	robots.add(robot3);
	robots.add(robot4);

	//robot1.setDestination(new Point(4,2));
	
	/*robot1.setDestination(new Point(-3.5, -3.5));
	robot2.setDestination(new Point(3.5, -3.5));
	robot3.setDestination(new Point(-3.5, 3.5));
	robot4.setDestination(new Point(3.5, 3.5));*/
	
	//robot1.executeMission();
	//robot4.executeMission();
	robot1.assignMission(missions.get(0));
	robot4.assignMission(missions.get(2));
	robot3.assignMission(missions.get(3));
	robot2.assignMission(missions.get(1));
	
	
	}
}
