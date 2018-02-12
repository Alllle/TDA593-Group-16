package g16_tda593;

public class RewardStorage {
  private long capturedDate;
  private int storedPoints;

  public int getStoredPoints() {
    return this.storedPoints;
  }
  public void setStoredPoints(int points) {
    this.storedPoints = this.storedPoints + points;
  }

  public void setCapturedDate(long time) {
    this.capturedDate = time;
  }

  public long getCapturedDate() {
    return this.capturedDate;
  }
}
