package misterpemodder.aoc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex03b implements Exercise {
  private class Rectangle {
    public final int id;
    public final int x;
    public final int y;
    public final int w;
    public final int h;
    public boolean unclaimed;

    public Rectangle(String spec) {
      String[] strs = spec.split(" ");
      id = Integer.valueOf(strs[0].substring(1));
      String[] xy = strs[2].substring(0, strs[2].length() - 1).split(",");
      x = Integer.valueOf(xy[0]);
      y = Integer.valueOf(xy[1]);
      String[] wh = strs[3].split("x");
      w = Integer.valueOf(wh[0]);
      h = Integer.valueOf(wh[1]);
      unclaimed = true;
    }
  }

  private class Grid {
    private final Map<Integer, Map<Integer, Integer>> grid;

    public Grid() {
      this.grid = new HashMap<>();
    }

    public void placeRect(Rectangle rect, List<Rectangle> rects) {
      for (int ry = rect.y, maxy = rect.y + rect.h; ry < maxy; ++ry)
        for (int rx = rect.x, maxx = rect.x + rect.w; rx < maxx; ++rx) {
          Map<Integer, Integer> line = grid.get(ry);
          if (line == null)
            line = new HashMap<>();
          Integer value = line.get(rx);

          if (rx == 3 && ry == 3) {
            System.out.println(rect.id);
          }
          if (value != null && value.intValue() != Integer.MAX_VALUE) {
            rects.get(value.intValue() - 1).unclaimed = false;
            rect.unclaimed = false;
            line.put(rx, Integer.MAX_VALUE);
          } else if (value == null)
            line.put(rx, rect.id);
          else
            rect.unclaimed = false;
          grid.put(ry, line);
        }
    }
  }

  @Override
  public String launch(List<String> input) {
    Grid grid = new Grid();
    List<Rectangle> rects = new ArrayList<>();

    for (String line : input)
      rects.add(new Rectangle(line));

    for (Rectangle rect : rects)
      grid.placeRect(rect, rects);

    for (Rectangle rect : rects) {
      if (rect.unclaimed)
        return "rectangle #" + rect.id;
    }
    return "not found!";
  }
}
