package g16_tda593;

import java.awt.Color;
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
		
		
		//EnvironmentDescription e1 = new EnvironmentDescription();
		//AbstractWall a = new HorizontalWall(5f,5f,5f,e1, Color.black);
		
		//Create environment!
		EnvironmentDescription e = new EnvironmentDescription();
		
		
		//Bottom right room!
		PhysicalArea area = new PhysicalArea(0f,0f,5f,5f);
		area.addWall(5f, 3.75f, 5f, 'h', e);
		area.addWall(5f, 0f, 1.25f, 'h', e);
		
		area.addWall(0f, 3.75f, 5f, 'h', e);
		area.addWall(0f, 0f, 1.25f, 'h', e);
		
		//Bottom wall
		area.addWall(5f, 0f, 5f, 'v', e);
		
		area.addWall(0f, 3.75f, 5f, 'v', e);
		area.addWall(0f, 0f, 1.25f, 'v', e);
		
		//Top right room!
		PhysicalArea area2 = new PhysicalArea(0f,-5f,5f,5f);
		area2.addWall(5f, -5f, -3.75f, 'h', e);
		area2.addWall(5f, -1.25f, 0f, 'h', e);
		
		area2.addWall(0f, -5f, -3.75f, 'h', e);
		area2.addWall(0f, -1.25f, 0f, 'h', e);
		
		area2.addWall(-5f, 0f, 5f, 'v', e);
		
		//Bottom right room!
		PhysicalArea area3 = new PhysicalArea(-5f,0f,5f,5f);
		area3.addWall(-5f, 3.75f, 5f, 'h', e);
		area3.addWall(-5f, 0f, 1.25f, 'h', e);
				
		area3.addWall(0f, 3.75f, 5f, 'h', e);
		area3.addWall(0f, 0f, 1.25f, 'h', e);
				
		//Bottom wall
		area3.addWall(5f, -5f, 0f, 'v', e);
			
		area3.addWall(0f, -5f, -3.75f, 'v', e);
		area3.addWall(0f, -1.25f, 0f, 'v', e);
				
		//Top right room!
		PhysicalArea area4 = new PhysicalArea(-5f,-5f,5f,5f);
		area4.addWall(-5f, -5f, -3.75f, 'h', e);
		area4.addWall(-5f, -1.25f, 0f, 'h', e);
				
		area4.addWall(0f, -5f, -3.75f, 'h', e);
		area4.addWall(0f, -1.25f, 0f, 'h', e);
				
		area4.addWall(-5f, -5f, 0f, 'v', e);

		
		Environment environment = new Environment(e);
		environment.addPhysicalRoom(area);
		environment.addPhysicalRoom(area2);
		environment.addPhysicalRoom(area3);
		environment.addPhysicalRoom(area4);
		
		
		//TODO: Add environment description
		Controller controller = new Controller(robots, environment.getEnvironment());
	
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
