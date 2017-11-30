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
		RobotAvatar robot1 = new RobotAvatar(new Point(0, -4), "Robot 1");
		RobotAvatar robot2 = new RobotAvatar(new Point(0, -2), "Robot 2");
		RobotAvatar robot3 = new RobotAvatar(new Point(0, 0), "Robot 3");
		RobotAvatar robot4 = new RobotAvatar(new Point(6, 2), "Robot 4");
		
		Mission mission1 = new Mission(1);
		mission1.addPoint(new Point(-3.5, -3.5));
		
		Mission mission2 = new Mission(2);
		mission2.addPoint(new Point(3.5, -3.5));
		
		Mission mission3 = new Mission(3);
		mission3.addPoint(new Point(-3.5, 3.5));
		
		Mission mission4 = new Mission(4);
		mission4.addPoint(new Point(3.5, 3.5));
		
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
		
		//TODO: Add environment description
		Controller controller = new Controller(robots, new EnvironmentDescription());
		
	/*	controller.addMission(mission1);
		controller.addMission(mission2);
		controller.addMission(mission3);
		controller.addMission(mission4);*/
		
		
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
