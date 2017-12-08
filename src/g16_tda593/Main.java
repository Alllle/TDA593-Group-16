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
		RobotAvatar robot1 = new RobotAvatar(new Point(7, -2), "Robot 1", new Strategy());
		RobotAvatar robot2 = new RobotAvatar(new Point(6, -2), "Robot 2", new Strategy());
		RobotAvatar robot3 = new RobotAvatar(new Point(6, 2), "Robot 3", new Strategy());
		RobotAvatar robot4 = new RobotAvatar(new Point(7, 2), "Robot 4", new Strategy());
		
		Mission mission1 = new Mission(1);
		mission1.addPoint(new Point(-3.5, -3.5));
		mission1.addPoint(new Point(-7, -2));
		
		Mission mission2 = new Mission(2);
		mission2.addPoint(new Point(3.5, -3.5));
		mission2.addPoint(new Point(6, -2));
		
		Mission mission3 = new Mission(3);
		mission3.addPoint(new Point(-3.5, 3.5));
		mission3.addPoint(new Point(-7, 2));
		
		Mission mission4 = new Mission(4);
		mission4.addPoint(new Point(3.5, 3.5));
		mission4.addPoint(new Point(6, 2));
		
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
		
		
		//Bottom right room!
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

		
		Environment environment = new Environment(e);
		environment.addPhysicalRoom(area);
		environment.addPhysicalRoom(area2);
		environment.addPhysicalRoom(area3);
		environment.addPhysicalRoom(area4);
		
		//TODO: Add environment description
		Controller controller = new Controller(robots, environment.getEnvironment(), environment);
		
	/*	controller.addMission(mission1);
		controller.addMission(mission2);
		controller.addMission(mission3);
		controller.addMission(mission4);*/
		controller.addLocationController(new Gatekeeper(new Point(3, 3.5), 3, e));
		controller.addLocationController(new Gatekeeper(new Point(3, -3.5), 3, e));
		
		
		controller.executeMission(robot1);
		controller.executeMission(robot2);
		controller.executeMission(robot3);
		controller.executeMission(robot4);
		
		/*System.out.println("MISSIONS FROM CONTROLLER LIST " + controller.getMissions().size());
		
		int tempCount = 0;
		for(RobotAvatar r : robots) {
			controller.addMissionToRobot(controller.getMissions().get(tempCount), r);
			System.out.println("Robot: " + r.getId() + " is getting mission: " + controller.getMissions().get(tempCount).getId());
			System.out.println("Mission length in main is: " + controller.getMissions().get(tempCount).getPoints().size());
			tempCount++;
			controller.executeMission(r);
		}*/
	
	}
}
