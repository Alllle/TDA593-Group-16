package g16_tda593;
/*
 * Span is a datatype found in area that specifies where the area is.
 * This is to detect wether or not a robot is inside this area.
 * It creates a rectangle starting with x,y pos
 * with width z and height w.
 */
public class Span {
	public float x,y,z,w;
	public Span (float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
}
