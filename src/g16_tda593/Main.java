package g16_tda593;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import project.Point;
import project.AbstractRobotSimulator;
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
		
		Set<RobotAvatar> robots = new HashSet<RobotAvatar>();
		robots.add(new RobotAvatar(new Point(6, -4), "1"));
		robots.add(new RobotAvatar(new Point(6, -2), "2"));
		robots.add(new RobotAvatar(new Point(6, 0), "3"));
		robots.add(new RobotAvatar(new Point(6, 2), "4"));
		
		//TODO: Add environment description
		Controller controller = new Controller(robots, new EnvironmentDescription());
	
		LinkedList<Point> missionPoints = new LinkedList<Point>();
		missionPoints.add(new Point(-3.5, -3.5));
		controller.addMission(new Mission(missionPoints, 1));
		missionPoints.clear();
		missionPoints.add(new Point(3.5, -3.5));
		controller.addMission(new Mission(missionPoints, 2));
		missionPoints.clear();
		missionPoints.add(new Point(-3.5, 3.5));
		controller.addMission(new Mission(missionPoints, 3));
		missionPoints.clear();
		missionPoints.add(new Point(3.5, 3.5));
		controller.addMission(new Mission(missionPoints, 4));
		missionPoints.clear();
	
	}
}
