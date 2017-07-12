/**
 * 
 */
package edu.cnm.deepdive.triangle.route;

/**
 * @author natedaag
 *
 */
public class Route {
  
  public final Route optimal;
  public final Direction direction;
  public final int cumulativeCost;
  
  
  public Route(int cost) {
  optimal = null;
  direction = Direction.TERMINUS;
  cumulativeCost = cost;
  }
  
  public Route(int cost, Route left, Route right) {
    if (left.cumulativeCost <= right.cumulativeCost) {
      optimal = left;
      direction = Direction.LEFT;
      cumulativeCost = left.cumulativeCost + cost;
    } else {
      optimal = right;
      direction = Direction.RIGHT;
      cumulativeCost = right.cumulativeCost + cost;
    }
  }

  public enum Direction {
    LEFT,
    RIGHT,
    TERMINUS;
    
    public String toString() {
      return super.toString().substring(0, 1);
    }
  }
}
