
/**
 * Represents a point in space and time, recorded by a GPS sensor.
 *
 * @author YOUR NAME
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.ZonedDateTime;

public class Track {
  // TODO: Create a stub for the constructor
  public Track(String filename) throws GPSException {
    // points = new ArrayList<>();
    try {
      readFile(filename);
    } catch (Exception e) {
      throw new GPSException("invalid file name");
    }

  }

  public Track() {

  }

  // TODO: Create a stub for readFile()
  public void readFile(String filename) {

    BufferedReader reader = new BufferedReader(new FileReader(filename));
    String temp;
    while ((temp = reader.readLine()) != null) {
      String[] segments = temp.split(",");
      if (segments.length == 4) {
        ZonedDateTime tme = ZonedDateTime.parse(segments[0].trim());
        double longi = Double.parseDouble(segments[1].trim());
        double lati = Double.parseDouble(segments[2].trim());
        double elev = Double.parseDouble(segments[3].trim());
        Point point = new Point(ZonedDateTime.now(), 0, 0, 0);
        add(point);
      } else {
        throw new GPSException("incorrectly formatted file");
      }
    }

  }

  // TODO: Create a stub for add()
  public void add(Point point) {

  }

  // TODO: Create a stub for get()
  public Point get(int index) {
    Point point = new Point(ZonedDateTime.now(), 0, 0, 0);
    return point;
  }

  // TODO: Create a stub for size()
  public int size() {
    return 0;
  }

  // TODO: Create a stub for lowestPoint()
  public Point lowestPoint() {
    Point point = new Point(ZonedDateTime.now(), 0, 0, 0);
    return point;
  }

  // TODO: Create a stub for highestPoint()
  public Point highestPoint() {
    Point point = new Point(ZonedDateTime.now(), 0, 0, 0);
    return point;
  }

  // TODO: Create a stub for totalDistance()
  public double totalDistance() {
    return 0;
  }

  // TODO: Create a stub for averageSpeed()
  public double averageSpeed() {
    return 0;
  }
}
