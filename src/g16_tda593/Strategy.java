package g16_tda593;

public abstract class Strategy {
	
	private long currentTime;
	

	public long getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(long currentTime) {
		this.currentTime = currentTime;
	}
}
