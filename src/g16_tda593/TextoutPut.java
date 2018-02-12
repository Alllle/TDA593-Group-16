package g16_tda593;

import java.util.List;
import java.util.Set;

import project.LocationController;
import simbad.sim.EnvironmentDescription;

public class TextoutPut implements View {
  private Controller controller;

  public TextoutPut(Set<Area> areas, Set<RobotAvatar> robots, EnvironmentDescription ed) {
    controller = new Controller(areas, robots, ed);
  }

  public void update() {
    this.updateRewardPoints();
  }

  public void updateRewardPoints() {
    System.out.println("Current points rewarded are: " +
      controller.getRewardPoints());
  }
}
