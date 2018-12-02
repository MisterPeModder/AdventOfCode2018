package misterpemodder.aoc;

import java.util.List;

public class Ex02b implements Exercise {

  int getLetterDifference(String str1, String str2) {
    if (str1.length() != str2.length())
      return str1.length();
    int diff = 0;
    for (int i = 0, len = str1.length(); i < len; ++i) {
      if (str1.charAt(i) != str2.charAt(i))
        ++diff;
    }
    return diff;
  }

  @Override
  public String launch(List<String> lines) {
    if (lines == null)
      return "Empty input!";
    System.out.println("lines: " + lines.size());
    for (String line : lines) {
      for (String line2 : lines) {
        if (getLetterDifference(line, line2) == 1) {
          StringBuilder builder = new StringBuilder();
          for (int i = 0; i < line.length(); ++i) {
            if (line.charAt(i) == line2.charAt(i))
              builder.append(line.charAt(i));
          }
          System.out.println("key1: " + line + ", key2: " + line2);
          return builder.toString();
        }
      }
    }
    return "keys not found!";
  }
}
