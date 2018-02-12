package g16_tda593;

public class PhysicalProcedure implements RewardProcedure {
  public int calculatePoints(Area a) {
    if(a instanceof PhysicalArea) {
      return PHYSICAL_POINTS;
    }
    return 0;
  }
}
