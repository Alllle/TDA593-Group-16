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
import project.LocationController;
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
		
		List<Point> mission1 = new LinkedList<Point>();
		List<Point> mission2 = new LinkedList<Point>();
		List<Point> mission3 = new LinkedList<Point>();
		List<Point> mission4 = new LinkedList<Point>();

		
		
		mission1.add(new Point(0, 0));
		mission1.add(new Point(0, -5));
		Strategy s1 = new WaitStrategy(mission1);
		RobotAvatar robot1 = new RobotAvatar(new Point(0, -5), "Robot 1", s1);
		
		mission2.add(new Point(0, 0));
		mission2.add(new Point(-5, 0));
		Strategy s2 = new WaitStrategy(mission2);

		RobotAvatar robot2 = new RobotAvatar(new Point(-5, 0), "Robot 2", s2);
		
		mission3.add(new Point(0, 0));
		mission3.add(new Point(5, 0));
		Strategy s3 = new WaitStrategy(mission3);

		RobotAvatar robot3 = new RobotAvatar(new Point(5, 0), "Robot 3", s3);
		
		mission4.add(new Point(0, 0));
		mission4.add(new Point(0, 5));
		Strategy s4 = new WaitStrategy(mission4);

		RobotAvatar robot4 = new RobotAvatar(new Point(0, 5), "Robot 4", s4);
		//System.out.println(robot4.getStrategy().getMissionPoints() + " is the miss");
		
		robots.add(robot1);
		robots.add(robot2);
		robots.add(robot3);
		robots.add(robot4);
		
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
		Area surgery1 = new PhysicalArea(new Point(-5, 0), 2.5);
		AbstractWall h1 = new HorizontalWall(-7.5f, -2.5f, 2.5f,e, Color.BLUE);
		AbstractWall h2 = new HorizontalWall(-2.5f, 1.25f, 2.5f,e, Color.BLUE);
		AbstractWall h3 = new HorizontalWall(-2.5f, -2.5f, -1.25f,e, Color.BLUE);
				
		//Bottom wall
		AbstractWall v1 = new VerticalWall(2.5f, -7.5f, -2.5f,e, Color.BLUE);
		AbstractWall v2 = new VerticalWall(-2.5f, -7.5f, -2.5f,e, Color.BLUE);
		
		
		PhysicalArea surgery2 = new PhysicalArea(new Point(0, -5), 2.5);
		AbstractWall h4 = new HorizontalWall(2.5f, -7.5f, -2.5f,e, Color.RED);
		AbstractWall h5 = new HorizontalWall(-2.5f, -7.5f, -2.5f,e, Color.RED);
				
		//Bottom wall
		AbstractWall v3 = new VerticalWall(-7.5f, -2.5f, 2.5f,e, Color.RED);
		AbstractWall v4 = new VerticalWall(-2.5f, -2.5f, -1.25f,e, Color.RED);
		AbstractWall v5 = new VerticalWall(-2.5f, 1.25f, 2.5f,e, Color.RED);
		
		
		PhysicalArea surgery3 = new PhysicalArea(new Point(5, 0), 2.5);
		AbstractWall h6 = new HorizontalWall(2.5f, 2.5f, 7.5f,e, Color.PINK);
		AbstractWall h7 = new HorizontalWall(-2.5f, 2.5f, 7.5f,e, Color.PINK);
				
		//Bottom wall
		AbstractWall v6 = new VerticalWall(7.5f, -2.5f, 2.5f,e, Color.PINK);
		AbstractWall v7 = new VerticalWall(2.5f, -2.5f, -1.25f,e, Color.PINK);
		AbstractWall v8 = new VerticalWall(2.5f, 1.25f, 2.5f,e, Color.PINK);

		
		PhysicalArea surgery4 = new PhysicalArea(new Point(0, 5), 2.5);
		
		AbstractWall h8 = new HorizontalWall(7.5f, -2.5f, 2.5f,e, Color.ORANGE);
		AbstractWall h9 = new HorizontalWall(2.5f, -2.5f, -1.25f,e, Color.ORANGE);
		AbstractWall h10 = new HorizontalWall(2.5f, 1.25f, 2.5f,e, Color.ORANGE);
				
		//Bottom wall
		AbstractWall v9 = new VerticalWall(2.5f, 2.5f, 7.5f,e, Color.ORANGE);
		AbstractWall v10 = new VerticalWall(-2.5f, 2.5f, 7.5f,e, Color.ORANGE);
		
		PhysicalArea consult = new PhysicalArea(new Point(0, 0), 2.5);
			
		
		LogicalArea wifi = new LogicalArea(new Point(0,0), 2.5);
		LogicalArea eatingArea = new LogicalArea(new Point(0,0), 2.5);
		Set<Area> areas = new HashSet<Area>();
		surgery1.setLc(new LocationController(new Point(-5, 0), 2.5, e));
		surgery2.setLc(new LocationController(new Point(0, -5), 2.5, e));
		surgery3.setLc(new LocationController(new Point(5, 0), 2.5, e));
		surgery4.setLc(new LocationController(new Point(0, 5), 2.5, e));
		consult.setLc(new LocationController(new Point(0, 0), 2.5, e));
		
		
		areas.add(consult);
		areas.add(surgery1);
		areas.add(surgery2);
		areas.add(surgery3);
		areas.add(surgery4);
		areas.add(wifi);
		areas.add(eatingArea);
			

		AbstractSimulatorMonitor controller = new Controller(areas, robots, e);		
	
	}
}
