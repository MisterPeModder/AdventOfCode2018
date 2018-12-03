package misterpemodder.aoc;

import java.util.ArrayList;
import java.util.List;

public class Ex03b implements Exercise {

  private class Rectangle {
    public final int id;
    public final int x;
    public final int y;
    public final int w;
    public final int h;

    public Rectangle(String spec) {
      String[] strs = spec.split("^#(\\d+)\\s*@\\s*(\\d+),(\\d+):\\s*(\\d+)x(\\d+)$");
      id = 0;
      x = 0;
      y = 0;
      w = 0;
      h = 0;
    }
  }

  @Override
  public String launch(List<String> input) {
    List<Rectangle> rects = new ArrayList<>();
    for (String line : input)
      rects.add(new Rectangle(line));
    return null;
  }
}
