package g16_tda593;
import project.AbstractRobot;
import project.Point;

public class Robot extends AbstractRobot {
	private Point position;
	private String name;
	private Mission mission;
	private boolean isMoving;
	
	public Robot(Point position, String name) {
		super(position, name);
		this.position = position;
		this.name = name;
	}
	
	public Robot(Point position, String name, Mission mission) {
		super(position, name);
		this.position = position;
		this.name = name;
		this.mission = mission;
	}
	
	/*public void executeMission(){
		int counter = 0;
		Point temp = this.position;
		Point[] points = this.mission.getPoints();
		isMoving = false;
		while(counter < points.length) {
			if(!isMoving) {
				temp = points[counter];
				this.setDestination(points[counter]);
				isMoving = true;
			}
			if(this.isAtPosition(temp)) {
				counter++;
				isMoving = false;
			}
		}
	}*/
	
	public void executeMission() {
		this.setDestination(mission.getPoints()[0]);
	}

	
	public void assignMission(Mission mission){
		this.mission = mission;
		executeMission();
	}
	
	
	/**
	 * strategy is not user in this assignment yet
	public void changeStrategy(Strategy strategy){
	}
	*/
	
	/**
	 * @return Point
	 */
	public Point getPosition(){
		return this.position;
	}
	
	/**
	 * 
	public void notify(){
	}
	*/
	
	/**
	 *
	public int getBatteryStatus(){
		return 0;
	}
	*/
	
	/**
	 *
	 */
	 public void stopEverything(){
		 this.setDestination(this.position);
	 }
}
