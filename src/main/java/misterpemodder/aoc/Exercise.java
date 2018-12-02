package misterpemodder.aoc;

import java.util.List;

/**
 * Defines an exercise. Implementers MUST have a constructor with no parameters, have their name
 * start with "Ex" and be in the {@see misterpemodder.aoc}
 */
public interface Exercise {
  public String launch(List<String> input);
}
