package misterpemodder.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

public class Launcher {
  public static final void main(String[] args) {
    if (args.length != 2) {
      System.out.println("Wrong number of args!");
      System.exit(1);
      return;
    }
    String name = "misterpemodder.aoc.Ex" + args[0];
    try {
      Exercise ex = null;
      Class<?> clazz = Class.forName(name);
      Object obj = clazz.newInstance();
      Path path = Paths.get(args[1]);

      if (obj == null || !(obj instanceof Exercise)) {
        System.err.println("Class " + name + " is not an Exercise!");
        System.exit(2);
        return;
      }
      ex = (Exercise) obj;
      System.out.println("Launching excercise " + args[0] + " with input '" + path + "'");
      System.out.println("====================");
      String result = ex.launch(Files.readAllLines(path));
      System.out.println("====================");
      System.out.println("result: " + result);
    } catch (InstantiationException | ClassNotFoundException e) {
      System.err.println("Couldn't find exercise '" + args[0] + "'");
      System.exit(2);
      return;
    } catch (IOException e) {
      System.err.println("Couldn't read input: " + e.getMessage());
    } catch (Exception e) {
      System.err.println("oups! ");
      e.printStackTrace();
      System.exit(2);
      return;
    }
  }
}
