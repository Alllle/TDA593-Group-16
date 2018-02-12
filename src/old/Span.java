package old;
/*
 * Span is a data type found in area that specifies where the area is.
 * This is to detect whether or not a robot is inside this area.
 * It creates a rectangle starting with x,y pos
 * with width z and height w.
 */
public class Span {
	public float x,y,width,height;
	public Span (float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
}
