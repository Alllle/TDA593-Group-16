package g16_tda593;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import project.AbstractSimulatorMonitor;
import project.LocationController;
import project.Point;
import simbad.sim.EnvironmentDescription;

public class Controller extends AbstractSimulatorMonitor<RobotAvatar> {
  private List<View> observers;
  private RewardController rwc;
  private EnvironmentController ec;
  private RobotController rbc;
  private static long startup = new Date().getTime();

  public Controller(Set<Area> areas, Set<RobotAvatar> robots, EnvironmentDescription ed) {
	 super(robots, ed);
	 this.rwc = new RewardController();
	 this.ec = new EnvironmentController(areas);
	 this.rbc = new RobotController(robots);
	 this.observers = new LinkedList<View>();
  }

  @Override
  public void update(RobotAvatar r) {
	  if(startup + 4000 > (new Date()).getTime()) {
		  return;
	  }

	  if(this.ec.getPermission(r)) {
	   this.rbc.executeMission(r);
      } else {
          r.setDestination(r.getPosition());
      }
      ec.releasePermission(r);
  	  rwc.updateRewardPoints(ec.getAreas(), rbc.getRobots());
  	  notifyObservers();
  }
 

  public int getRewardPoints(){
    return rwc.getRewardPoints();
  }

  public void registerObserver(View v) {
    this.observers.add(v);
  }

  private void notifyObservers() {
    //Add stuff to update
    for(View v : observers) {
      v.update();
    }
  }

  public void addMissionToRobot(List<Point> missionPoints, RobotAvatar r) {
    r.getStrategy().changeMissionPoints(missionPoints);
  }

  public void changeStrategy(Strategy s, RobotAvatar r) {
    //might not be get(r) for a set, possibly change that
    r.changeStrategy(s);
  }

  public void stopEverything() {
    System.out.println("Stopping everything!!!");
    System.exit(0);
  }
}
