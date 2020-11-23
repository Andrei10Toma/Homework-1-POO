import Map.*;
import Vehicle.*;

import java.io.*;
import java.util.Scanner;

/**
 * the class where the main method is located
 * @author Toma Andrei
 */
public class Test {
    /**
     * This function calls the drive function for a given vehicle type
     *
     * @param b     Vehicle.Bike vehicle type
     * @param m     Vehicle.Motorcycle vehicle type
     * @param c     Vehicle.Car vehicle type
     * @param t     Vehicle.Truck vehicle type
     * @param type  the string vehicle type
     * @param start starting point of the road
     * @param end   the destination where the vehicle will go
     * @param map   the map given as a graph
     */
    public static void driveCase(Vehicle b, Vehicle m, Vehicle c, Vehicle t,
                                 String type, int start, int end, Map map) {
        switch (type) {
            case "b" -> map.drive(b, start, end);
            case "m" -> map.drive(m, start, end);
            case "a" -> map.drive(c, start, end);
            case "c" -> map.drive(t, start, end);
        }
    }

    /**
     * In main method the file is read, is created an instance for every vehicle and, also, the map is created
     * and the commands are interpreted and executed.
     * @param args not used here
     * @throws FileNotFoundException if the it is opened an nonexistent file
     */
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream o = new PrintStream(new File("map.out"));
        System.setOut(o);
        File input = new File("map.in");
        Scanner reader = new Scanner(input);

        Vehicle bike = new Bike();
        Vehicle motorcycle = new Motorcycle();
        Vehicle car = new Car();
        Vehicle truck = new Truck();

        int edges = reader.nextInt();
        int vertex = reader.nextInt();
        Map map = new Map(vertex);
        for (int i = 0; i < edges; i++) {
            map.addStreet(Integer.parseInt(reader.next().replace("P", "")),
                    Integer.parseInt(reader.next().replace("P", "")),
                    reader.nextInt(),
                    reader.nextInt());
        }
        while (reader.hasNext()) {
            String action = reader.next();
            if (!action.equals("drive")) {
                map.addRestriction(action,
                        Integer.parseInt(reader.next().replace("P", "")),
                        Integer.parseInt(reader.next().replace("P", "")),
                        reader.nextInt());
            } else {
                driveCase(bike, motorcycle, car, truck, reader.next(),
                        Integer.parseInt(reader.next().replace("P", "")),
                        Integer.parseInt(reader.next().replace("P", "")),
                        map);
            }
        }
        reader.close();
    }
}