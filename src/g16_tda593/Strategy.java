package g16_tda593;

public class Strategy {
	
	private boolean locked;
	private long currentTime;
	
	public Strategy() {
		this.locked = false;
	}


	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public long getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(long currentTime) {
		this.currentTime = currentTime;
	}
}
