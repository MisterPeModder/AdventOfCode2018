package misterpemodder.aoc;

import java.util.List;

public class Ex01a implements Exercise {
  @Override
  public String launch(List<String> lines) {
    int freq = 0;
    for (String line : lines)
      freq += Integer.valueOf(line);
    return Integer.toString(freq);
  }
}
