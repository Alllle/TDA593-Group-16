package g16_tda593;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import project.Point;

public class WaitStrategy implements Strategy {
  private long capturedDate;
  private boolean isWaiting = false;
  private List<Point> missionPoints;
 
  
  public WaitStrategy(List<Point> mp) {
	this.missionPoints = mp;
	capturedDate = 0;
  }

  public List<Point> getMissionPoints() {
    return this.missionPoints;
  }

  public Point getNextMissionPoint() {
    return ((LinkedList<Point>) this.missionPoints).peek();
  }

  public Point executeStrategy(RobotAvatar r) {
	if(r.isAtPosition(((LinkedList<Point>) this.missionPoints).peek())) {
		
		if(!isWaiting) {
			this.capturedDate = (new Date()).getTime();
			isWaiting = true;
		}
		if(isWaiting && (new Date()).getTime() - this.capturedDate > 2000) {
			isWaiting = false;
			if(r.getStrategy().getMissionPoints().size() > 1) {
				((LinkedList<Point>) r.getStrategy().getMissionPoints()).poll();
			}
		}
	} else {
		if(isWaiting && (new Date()).getTime() - this.capturedDate > 2000) {
			isWaiting = false;
		} else if(isWaiting) {
			return r.getPosition();
		}
		return getNextMissionPoint();
	}
	return getNextMissionPoint();
  }

  public long getCapturedDate() {
    return this.capturedDate;
  }

  public void setCapturedDate(long date) {
    this.capturedDate = date;
  }
  
  public void setIsWaiting(boolean w) {
	  this.isWaiting = w;
  }
  
  public boolean getIsWaiting() {
	  return this.isWaiting;
  }


  public void changeMissionPoints(List<Point> missionPoints) {
	  this.missionPoints = missionPoints;
	
  }
}
