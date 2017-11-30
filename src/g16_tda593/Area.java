// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package g16_tda593;

import simbad.sim.EnvironmentDescription;

/************************************************************/
/**
 * 
 */
public abstract class Area {
	
	public Area(Span span) {
		this.span = span;
	}
	
	public Area(float f, float g, float h, float i) {
		this.span = new Span(f,g,h,i);
	}

	/**
	 * 
	 */
	public EnvironmentDescription e = new EnvironmentDescription();
	/**
	 * 
	 */
	public Span span;

	/**
	 * 
	 * @return 
	 */
	public EnvironmentDescription getEnvironment() {
		return e;
	}

	/**
	 * 
	 * @return 
	 */
	public Span getSpan() {
		return span;
	}
};
