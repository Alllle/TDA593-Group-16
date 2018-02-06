package g16_tda593;

public class WaitStrategy extends Strategy {
	
	private boolean locked;
	
	public WaitStrategy() {
		this.locked = false;	
	}
	
	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	
}
