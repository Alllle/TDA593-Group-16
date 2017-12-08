package g16_tda593;
/*
 * Span is a datatype found in area that specifies where the area is.
 * This is to detect wether or not a robot is inside this area.
 * It creates a rectangle starting with x,y pos
 * with width z and height w.
 */
public class Span {
	public float x1,x2,y1,y2;
	public Span (float x1, float x2, float y1, float y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
}
