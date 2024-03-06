
/**
 * Represents a point in space and time, recorded by a GPS sensor.
 *
 * @author YOUR NAME
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.ArrayList;
import java.time.temporal.ChronoUnit;

public class Track {
  private List<Point> points = new ArrayList<>();
  // TODO: Create a stub for the constructor
  public Track(String filename) throws IOException {
    points.clear();
   try {
    readFile(filename);
   } catch (Exception e) {
    throw new GPSException("invalid file name");
   }
      
    

  }

  public Track() {

  }

  // TODO: Create a stub for readFile()
  public void readFile(String filename) throws FileNotFoundException, IOException {

  BufferedReader reader = new BufferedReader(new FileReader(filename));
  String temp;
  reader.readLine();
  while ((temp = reader.readLine()) != null) {
    String[] segments = temp.split(",");         
      if (segments.length == 4) {
        ZonedDateTime time = ZonedDateTime.parse(segments[0]);
        double longi = Double.parseDouble(segments[1]);
        double lati = Double.parseDouble(segments[2]);
        double elev = Double.parseDouble(segments[3]);
        Point point = new Point(time, longi, lati, elev);
        add(point);
      } 
      else{
        throw new GPSException("incorrectly formatted file");
      }   
   reader.close();
  }

   

  }

  // TODO: Create a stub for add()
  public void add(Point point) {
points.add(point);
  }

  // TODO: Create a stub for get()
  public Point get(int index) {
    if (index < size() && index >= 0) {
      return points.get(index);
    }
    else{
      throw new GPSException("index outside bounds of the list size");
    }
  }

  // TODO: Create a stub for size()
  public int size() {
    return points.size();
  }

  // TODO: Create a stub for lowestPoint()
  public Point lowestPoint() {
    int lowTemp = 0;
    for (int i = 0; i < size(); i++) {
      if (get(i).getElevation() < get(lowTemp).getElevation()) {
        lowTemp = i;
      }
    }
    return get(lowTemp);
  }

  // TODO: Create a stub for highestPoint()
  public Point highestPoint() {
    int highTemp = 0;   
    for (int i = 0; i < size(); i++) {
      if (get(i).getElevation() > get(highTemp).getElevation()) {
        highTemp = i;
      }
    }
    return get(highTemp);
  }

  // TODO: Create a stub for totalDistance()
  public double totalDistance() {
    if (size() < 2) {
      throw new GPSException("fewer than 2 points to caculate");
    }
    double totalD = 0;
    for (int i = 1; i < size(); i++) {
double dist = Point.greatCircleDistance(get(i - 1), get(i));
totalD += dist;
    }
    return totalD;
  }

  // TODO: Create a stub for averageSpeed()
  public double averageSpeed() {
    if (size() < 2) {
      throw new GPSException("fewer than 2 points to caculate");
    }
    double seconds = ChronoUnit.SECONDS.between(get(0).getTime(), get(size() - 1).getTime());
    double speed = totalDistance() / seconds;
    return speed; 
  }
}
