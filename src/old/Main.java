package old;

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
		RobotAvatar robot1 = new RobotAvatar(new Point(-5, 0), "Robot 1", new Strategy());
		RobotAvatar robot2 = new RobotAvatar(new Point(0, -5), "Robot 2", new Strategy());
		RobotAvatar robot3 = new RobotAvatar(new Point(0, 5), "Robot 3", new Strategy());
		RobotAvatar robot4 = new RobotAvatar(new Point(5, 0), "Robot 4", new Strategy());
		
		Mission mission1 = new Mission(1);
		mission1.addPoint(new Point(0, 0));
		mission1.addPoint(new Point(-5, 0));
		
		Mission mission2 = new Mission(2);
		mission2.addPoint(new Point(0, 0));
		mission2.addPoint(new Point(0, -5));
		
		Mission mission3 = new Mission(3);
		mission3.addPoint(new Point(0, 0));
		mission3.addPoint(new Point(0, 5));
		
		Mission mission4 = new Mission(4);
		mission4.addPoint(new Point(0, 0));
		mission4.addPoint(new Point(5, 0));
		
		robot1.setMission(mission1);
		robot2.setMission(mission2);
		robot3.setMission(mission3);
		robot4.setMission(mission4);
		
		robots.add(robot1);
		robots.add(robot2);
		robots.add(robot3);
		robots.add(robot4);
		/*robots.add(new RobotAvatar(new Point(0, -4), "1"));
		robots.add(new RobotAvatar(new Point(0, -2), "2"));
		robots.add(new RobotAvatar(new Point(0, 0), "3"));
		robots.add(new RobotAvatar(new Point(6, 2), "4"));*/
		
		
		//EnvironmentDescription e1 = new EnvironmentDescription();
		//AbstractWall a = new HorizontalWall(5f,5f,5f,e1, Color.black);
		
		//Create environment!
		EnvironmentDescription e = new EnvironmentDescription();
		
		
		/*
		 * Assignment 3 room
		 * 
		 * //Bottom right room!
		PhysicalArea area = new PhysicalArea(0,0,5,5, 20);
		area.addWall(5f, 3.75f, 5f, 'h', e);
		area.addWall(5f, 0f, 1.25f, 'h', e);
		
		area.addWall(0f, 3.75f, 5f, 'h', e);
		area.addWall(0f, 0f, 1.25f, 'h', e);
		
		//Bottom wall
		area.addWall(5f, 0f, 5f, 'v', e);
		
		area.addWall(0f, 3.75f, 5f, 'v', e);
		area.addWall(0f, 0f, 1.25f, 'v', e);
		
		//Top right room!
		PhysicalArea area2 = new PhysicalArea(0,-5,5,5, 20);
		area2.addWall(5f, -5f, -3.75f, 'h', e);
		area2.addWall(5f, -1.25f, 0f, 'h', e);
		
		area2.addWall(0f, -5f, -3.75f, 'h', e);
		area2.addWall(0f, -1.25f, 0f, 'h', e);
		
		area2.addWall(-5f, 0f, 5f, 'v', e);
		
		//Bottom right room!
		PhysicalArea area3 = new PhysicalArea(-5,0,5,5, 20);
		area3.addWall(-5f, 3.75f, 5f, 'h', e);
		area3.addWall(-5f, 0f, 1.25f, 'h', e);
				
		area3.addWall(0f, 3.75f, 5f, 'h', e);
		area3.addWall(0f, 0f, 1.25f, 'h', e);
				
		//Bottom wall
		area3.addWall(5f, -5f, 0f, 'v', e);
			
		area3.addWall(0f, -5f, -3.75f, 'v', e);
		area3.addWall(0f, -1.25f, 0f, 'v', e);
				
		//Top right room!
		PhysicalArea area4 = new PhysicalArea(-5,-5,5,5, 20);
		area4.addWall(-5f, -5f, -3.75f, 'h', e);
		area4.addWall(-5f, -1.25f, 0f, 'h', e);
				
		area4.addWall(0f, -5f, -3.75f, 'h', e);
		area4.addWall(0f, -1.25f, 0f, 'h', e);
				
		area4.addWall(-5f, -5f, 0f, 'v', e);
*/
		
		/*
		 * Assignment 5 room
		 * */
		
		// Första y-led negativt toppen
		// andra x-led negativt höger
		// tredje x-led vänster
		// 2a start 3e stop av vägg längd
		// (-7.5, 2.5) (-7.5, -2.5) (-2.5, -2.5) (-2.5, 2.5)
		PhysicalArea surgery1 = new PhysicalArea(-7.5f, -2.5f,5,5, 20, 0);
		surgery1.addWall(-7.5f, -2.5f, 2.5f, 'h', e, Color.BLUE);
				
		surgery1.addWall(-2.5f, 1.25f, 2.5f, 'h', e, Color.BLUE);
		surgery1.addWall(-2.5f, -2.5f, -1.25f, 'h', e, Color.BLUE);
				
		//Bottom wall
		surgery1.addWall(2.5f, -7.5f, -2.5f, 'v', e, Color.BLUE);
			
		surgery1.addWall(-2.5f, -7.5f, -2.5f, 'v', e, Color.BLUE);
		
		PhysicalArea surgery2 = new PhysicalArea(-2.5f,-7.5f,5,5, 20, 1);
		surgery2.addWall(2.5f, -7.5f, -2.5f, 'h', e, Color.RED);
				
		surgery2.addWall(-2.5f, -7.5f, -2.5f, 'h', e, Color.RED);
				
		//Bottom wall
		surgery2.addWall(-7.5f, -2.5f, 2.5f, 'v', e, Color.RED);
			
		surgery2.addWall(-2.5f, -2.5f, -1.25f, 'v', e, Color.RED);
		surgery2.addWall(-2.5f, 1.25f, 2.5f, 'v', e, Color.RED);
		
		PhysicalArea surgery3 = new PhysicalArea(-2.5f,2.5f,5,5, 20, 2);
		surgery3.addWall(2.5f, 2.5f, 7.5f, 'h', e, Color.PINK);
				
		surgery3.addWall(-2.5f, 2.5f, 7.5f, 'h', e, Color.PINK);
				
		//Bottom wall
		surgery3.addWall(7.5f, -2.5f, 2.5f, 'v', e, Color.PINK);
			
		surgery3.addWall(2.5f, -2.5f, -1.25f, 'v', e, Color.PINK);
		surgery3.addWall(2.5f, 1.25f, 2.5f, 'v', e, Color.PINK);
		
		PhysicalArea surgery4 = new PhysicalArea(2.5f,-2.5f,5f, 5f, 20,3 );
		surgery4.addWall(7.5f, -2.5f, 2.5f, 'h', e, Color.ORANGE);
		
		surgery4.addWall(2.5f, -2.5f, -1.25f, 'h', e, Color.ORANGE);
		surgery4.addWall(2.5f, 1.25f, 2.5f, 'h', e, Color.ORANGE);
		
		surgery4.addWall(2.5f, 2.5f, 7.5f, 'v', e, Color.ORANGE);
		surgery4.addWall(-2.5f, 2.5f, 7.5f, 'v', e, Color.ORANGE);
		
		PhysicalArea consult = new PhysicalArea(-2.5f,-2.5f,5,5f, 20, 4);
			
		
		LogicalArea wifi = new LogicalArea(-2.5f,-2.5f,5,5, 10, 5);
		LogicalArea eatingArea = new LogicalArea(5,10,-2.5f,2.5f, 20, 6);
		
		
		
		Environment environment = new Environment(e);
		environment.addRoom(consult);
		environment.addRoom(surgery1);
		environment.addRoom(surgery2);
		environment.addRoom(surgery3);
		environment.addRoom(surgery4);
		environment.addRoom(wifi);
		environment.addRoom(eatingArea);
		
		Controller controller = new Controller(robots, environment.getEnvironment(), environment);
		
		controller.addArea(consult);
		controller.addArea(surgery1);
		controller.addArea(surgery2);
		controller.addArea(surgery3);
		controller.addArea(surgery4);

		
		controller.addLocationController(new Gatekeeper(new Point(0, -5), 3, e));
		controller.addLocationController(new Gatekeeper(new Point(-5, 0), 3, e));
		controller.addLocationController(new Gatekeeper(new Point(0, 5), 3, e));
		controller.addLocationController(new Gatekeeper(new Point(5, 0), 3, e));
		controller.addLocationController(new Gatekeeper(new Point(0, 0), 3, e));
		
		//Locationcontrollers for assignment 3
		//controller.addLocationController(new Gatekeeper(new Point(3, 3.5), 3, e));
		//controller.addLocationController(new Gatekeeper(new Point(3, -3.5), 3, e));
		
		
		controller.executeMission(robot1);
		controller.executeMission(robot2);
		controller.executeMission(robot3);
		controller.executeMission(robot4);
		
	
	}
}
