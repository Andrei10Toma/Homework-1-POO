package Map;

import Vehicle.*;

import java.util.Comparator;

/**
 * class which describes the street and implements comparator for the usage of the priority queue
 * @author Toma Andrei
 */
public class Street implements Comparator<Street> {
    private int dest;
    private int cost;
    private Restrictions restrictions;
    private Vehicle vehicle;

    /**
     * constructor for street
     * @param dest ending point of the street
     * @param cost cost of the street
     * @param restrictions restrictions like traffic jams, maximum gauge
     */
    public Street(int dest, int cost, Restrictions restrictions) {
        this.dest = dest;
        this.cost = cost;
        this.restrictions = restrictions;
    }

    /**
     * constructor for Map.Street
     * @param dest ending point of the street
     * @param cost the cost of the street
     * @param restrictions restrictions of the street
     * @param vehicle the vehicle that will be driven on the street
     */
    public Street(int dest, int cost, Restrictions restrictions, Vehicle vehicle) {
        this.dest = dest;
        this.cost = cost;
        this.restrictions = restrictions;
        this.vehicle = vehicle;
    }

    /**
     * constructor for Map.Street
     */
    public Street() {
    }

    /**
     * getter for dest
     * @return dest of the street
     */
    public int getDest() {
        return dest;
    }

    /**
     * setter for dest
     * @param dest the new value for dest
     */
    public void setDest(int dest) {
        this.dest = dest;
    }

    /**
     * getter for cost
     * @return cost of the street
     */
    public int getCost() {
        return cost;
    }

    /**
     * setter for cost
     * @param cost the new value for the cost
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * getter for restrictions
     * @return restrictions of the street
     */
    public Restrictions getRestrictions() {
        return restrictions;
    }

    /**
     * setter for restrictions
     * @param restrictions new restrictions
     */
    public void setRestrictions(Restrictions restrictions) {
        this.restrictions = restrictions;
    }

    /**
     * getter for the total cost
     * @return the total cost of the street
     */
    public int getCostTotal() {
        return this.cost * this.vehicle.getCost() + this.restrictions.getTrafficJamCost();
    }

    /**
     * getter for vehicle
     * @return vehicle driven on the street
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * setter for vehicle
     * @param vehicle new value of vehicle
     */
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * compares their total cost; used for the priority queue
     * @param e1 first street
     * @param e2 second street
     * @return result of Integer.compare(e1.getCostTotal, e2.getCostTotal())
     */
    @Override
    public int compare(Street e1, Street e2) {
        return Integer.compare(e1.getCostTotal(), e2.getCostTotal());
    }
}