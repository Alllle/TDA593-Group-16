// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package old;

import old.Sensors;
import project.Point;

/************************************************************/
/**
 * 
 */
public class GPS implements Sensors {
	/**
	 * 
	 */
	private Point value;
	
	public Point getValue() {
		return this.value;
	}
	public void newGPSpositionChangeDetected(Point p) {
		this.value = p;
	}
};