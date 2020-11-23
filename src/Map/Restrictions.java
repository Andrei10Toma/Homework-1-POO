package Map;

/**
 * class for Map.Restrictions of the street
 * @author Toma Andrei
 */
public class Restrictions {
    private int gaugeLimit;
    private int trafficJamCost;
    private String type;

    /**
     * default  constructor for Map.Restrictions
     */
    public Restrictions(){
    }

    /**
     * constructor for Map.Restrictions with gauge limit
     * @param gaugeLimit maximum accepted gauge on the street
     */
    public Restrictions(int gaugeLimit) {
        this(gaugeLimit, 0);
    }

    /**
     * constructor for Map.Restrictions
     * @param gaugeLimit maximum accepted gauge on the street
     * @param trafficJamCost the additional cost of the street
     */
    public Restrictions(int gaugeLimit, int trafficJamCost) {
        this.gaugeLimit = gaugeLimit;
        this.trafficJamCost = trafficJamCost;
    }

    /**
     * getter for gaugeLimit
     * @return gaugeLimit
     */
    public int getGaugeLimit() {
        return gaugeLimit;
    }

    /**
     * setter for gaugeLimit
     * @param gaugeLimit new value of gaugeLimit
     */
    public void setGaugeLimit(int gaugeLimit) {
        this.gaugeLimit = gaugeLimit;
    }

    /**
     * getter for trafficJamCost
     * @return trafficJamCost
     */
    public int getTrafficJamCost() {
        return trafficJamCost;
    }

    /**
     * setter for trafficJamCost
     * @param trafficJamCost the new value of trafficJamCost
     */
    public void setTrafficJamCost(int trafficJamCost) {
        this.trafficJamCost = trafficJamCost;
    }

    /**
     * getter for type
     * @return type of the traffic jam
     */
    public String getType() {
        return type;
    }

    /**
     * setter for type
     * @param type the new value of type
     */
    public void setType(String type) {
        this.type = type;
    }
}
