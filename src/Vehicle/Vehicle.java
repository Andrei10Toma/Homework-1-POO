package Vehicle;

/**
 * this class contains information about every vehicle: type, gauge, cost
 * @author Toma Andrei
 */
abstract public class Vehicle {
    private String type;
    private int gauge;
    private int cost;

    /**
     * constructor for a Vehicle.Vehicle object
     * @param type type of the vehicle("Moped", "Autovehicul", "Autoutilitar")
     * @param gauge gauge of the vehicle
     * @param cost cost of the vehicle
     */
    public Vehicle(String type, int gauge, int cost) {
        this.type = type;
        this.gauge = gauge;
        this.cost = cost;
    }

    /**
     * default constructor for a Vehicle.Vehicle object
     */
    public Vehicle() {
    }

    /**
     * getter for vehicle type
     * @return the type of a vehicle
     */
    public String getType() {
        return type;
    }

    /**
     * setter for vehicle type
     * @param type the new value for type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * getter for gauge of the vehicle
     * @return the gauge of the vehicle
     */
    public int getGauge() {
        return gauge;
    }

    /**
     * setter for gauge of the vehicle
     * @param gauge the new value for the gauge
     */
    public void setGauge(int gauge) {
        this.gauge = gauge;
    }

    /**
     * getter for cost of the vehicle
     * @return the cost of the vehicle
     */
    public int getCost() {
        return cost;
    }

    /**
     * setter for cost of the vehicle
     * @param cost the new value for the cost
     */
    public void setCost(int cost) {
        this.cost = cost;
    }
}