package misterpemodder.aoc;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Ex02a implements Exercise {

  boolean hasLetters(int num, String line) {
    char[] data = line.toCharArray();
    Map<Character, Integer> chars = new HashMap<>();

    for (char c : data) {
      Integer i = chars.get(c);
      if (i == null)
        chars.put(c, 1);
      else
        chars.put(c, i.intValue() + 1);
    }
    for (Character c : chars.keySet()) {
      Integer i = chars.get(c);
      if (i != null && i.intValue() == num)
        return true;
    }
    return false;
  }

  @Override
  public String launch(List<String> lines) {
    if (lines == null)
      return "Empty input!";
    System.out.println("lines: " + lines.size());
    int twoLetters = 0;
    int threeLetters = 0;

    for (String line : lines) {
      if (hasLetters(2, line))
        ++twoLetters;
      if (hasLetters(3, line))
        ++threeLetters;
    }
    System.out.println("Two letters: " + twoLetters + ", Three letters: " + threeLetters);
    return Integer.toString(twoLetters * threeLetters);
  }
}
