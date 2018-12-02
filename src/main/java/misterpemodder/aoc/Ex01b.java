package misterpemodder.aoc;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Ex01b implements Exercise {
  @Override
  public String launch(List<String> lines) {
    int freq = 0;
    Set<Integer> freqs = new HashSet<>();
    while (true) {
      for (String line : lines) {
        freq += Integer.valueOf(line);
        if (freqs.contains(freq))
          return Integer.toString(freq);
        freqs.add(freq);
      }
    }
  }
}
