package g16_tda593;

import project.Point;

public class Mission {
	
	private Point[] points;
	private int id;
	
	public Mission(Point[] points, int id) {
		this.points = points;
		this.id = id;
	}
	
	public Point[] getPoints() {
		// TODO Auto-generated method stub
		return this.points;
	}
	
	public int getId() {
		return this.id;
	}

}
