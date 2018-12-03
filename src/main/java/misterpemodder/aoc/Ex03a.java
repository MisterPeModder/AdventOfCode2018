package misterpemodder.aoc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex03a implements Exercise {
  private class Rectangle {
    public final int id;
    public final int x;
    public final int y;
    public final int w;
    public final int h;

    public Rectangle(String spec) {
      // String[] strs = spec.split("#(\\d+)\\s*@\\s*(\\d+),(\\d+):\\s*(\\d+)x(\\d+)");
      String[] strs = spec.split(" ");
      id = Integer.valueOf(strs[0].substring(1));
      String[] xy = strs[2].substring(0, strs[2].length() - 1).split(",");
      x = Integer.valueOf(xy[0]);
      y = Integer.valueOf(xy[1]);
      String[] wh = strs[3].split("x");
      w = Integer.valueOf(wh[0]);
      h = Integer.valueOf(wh[1]);
    }
  }

  private class Grid {
    private final Map<Integer, Map<Integer, Integer>> grid;
    public int occupied = 0;

    public Grid() {
      this.grid = new HashMap<>();
    }

    public void placeRect(Rectangle rect) {
      for (int ry = rect.y, maxy = rect.y + rect.h; ry < maxy; ++ry)
        for (int rx = rect.x, maxx = rect.x + rect.w; rx < maxx; ++rx) {
          Map<Integer, Integer> line = grid.get(ry);
          if (line == null)
            line = new HashMap<>();
          Integer value = line.get(rx);

          if (value != null && value.intValue() != Integer.MAX_VALUE) {
            ++occupied;
            line.put(rx, Integer.MAX_VALUE);
          } else if (value == null)
            line.put(rx, rect.id);
          grid.put(ry, line);
        }
    }

    public void print() {
      int maxX = 0;
      int maxY = 0;

      for (Integer y : grid.keySet()) {
        maxY = maxY < y ? y : maxY;
        for (Integer x : grid.get(y).keySet()) {
          maxX = maxX < x ? x : maxX;
        }
      }

      for (int y = 0; y <= maxY; ++y) {
        Map<Integer, Integer> line = grid.get(y);
        for (int x = 0; x <= maxX; ++x) {
          if (line == null) {
            System.out.print('.');
            continue;
          }
          Integer vx = line.get(x);
          if (vx == null)
            System.out.print('.');
          else if (vx.intValue() == Integer.MAX_VALUE)
            System.out.print('#');
          else
            System.out.print('+');
        }
        System.out.println();
      }
    }
  }

  @Override
  public String launch(List<String> input) {
    Grid grid = new Grid();
    List<Rectangle> rects = new ArrayList<>();

    for (String line : input) {
      rects.add(new Rectangle(line));
      grid.placeRect(new Rectangle(line));
    }

    // verif
    for (int i = 0, len = input.size(); i < len; ++i) {
      Rectangle rect = rects.get(i);
      String res = "#" + rect.id + " @ " + rect.x + "," + rect.y + ": " + rect.w + 'x' + rect.h;
      if (!res.equals(input.get(i))) {
        return "INVALID RECTANGLE: at line " + i + ", id: " + rect.id;
      }
    }

    // grid.placeRect(new Rectangle("#123 @ 3,2: 5x4"));

    // grid.print();
    return Integer.toString(grid.occupied);
  }
}
