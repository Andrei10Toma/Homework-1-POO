package Map;

import Vehicle.*;

import java.util.*;

/**
 * class that builds the map and executes the commands from the input file
 * vertexes - number of nodes
 * adjacencyList - the map represented as a oriented graph with adjacency list
 * pq - priority queue used for Dijkstra
 * dist - minimum distance array
 * @author Toma Andrei
 */
public class Map {
    private int vertexes;
    private final ArrayList<ArrayList<Street>> adjacencyList;
    private final PriorityQueue<Street> pq;
    private int[] dist;

    /**
     * constructor for Map.Map object
     * @param vertexes number of nodes
     */
    public Map(int vertexes) {
        this.vertexes = vertexes;
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < vertexes; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        dist = new int[vertexes];
        pq = new PriorityQueue<>(vertexes, new Street());
    }

    /**
     * adds a street to the map with its cost and maximum gauge
     * @param source the point where the new street starts
     * @param dest the point where the new street ends
     * @param cost the cost of the street
     * @param gauge the maximum gauge for the street
     */
    public void addStreet(int source, int dest, int cost, int gauge) {
        Restrictions restriction = new Restrictions(gauge);
        Street e = new Street(dest, cost, restriction);
        adjacencyList.get(source).add(e);
    }

    /**
     * seeks for the index of the destination node
     * @param streets list of streets where the program will seek for destination
     * @param dest the value of destination node
     * @return returns the index of destination node if found, else returns -1
     */
    public int getDestIndex(ArrayList<Street> streets, int dest) {
        for (int i = 0; i < streets.size(); i++) {
            if (streets.get(i).getDest() == dest) {
                return i;
            }
        }
        return -1;
    }

    /**
     * this method implements drive method, which is, in essence, Dijkstra's algorithm implementation;
     * initialise the minimum distance array with the maximum integer value for every vertex, except the source node
     * which is 0;
     * adds the source node to the priority queue and the parent of him to -1 to know the end when the path is printed;
     * elements are extracted from the priority queue until it is empty or until all the nodes have been extracted from it
     * if the priority queue is empty and not all the nodes have been extracted then if the destination node was
     * extracted then a path to the destination node was found, else if the destination was not extracted a path from
     * source to destination does not exist;
     * @param v the vehicle that is driven on the streets from source to dest
     * @param source the point where the vehicle starts to drive
     * @param dest the point where the vehicle should arrive
     */
    public void drive(Vehicle v, int source, int dest) {
        for (int i = 0; i < vertexes; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        int[] parent = new int[vertexes];
        Set<Integer> settled = new HashSet<>();
        Restrictions r = new Restrictions();

        pq.add(new Street(source, 0, r, v));
        parent[source] = -1;
        dist[source] = 0;
        while (settled.size() != vertexes) {
            if (pq.isEmpty() && settled.contains(dest)) {
                break;
            }
            else if (pq.isEmpty() && !settled.contains(dest)) {
                System.out.println("P" + source + " P" + dest + " null");
                return;
            }
            Street e = pq.remove();
            int u = e.getDest();
            settled.add(u);
            neighbours(u, v, parent, settled);
        }
        printDijkstra(parent, dest);
    }

    /**
     * this function will process all the neighbours of extracted vertex u and will update the minimum distance array
     * if the new distance is less than the actual distance, also updates tbe parent of the node and if is not settled
     * add it to the priority queue
     * @param u the minimum distance node that is removed from the priority queue
     * @param v the vehicle that is driven on the streets
     * @param parent the array that saves the parents of the vertexes
     * @param settled set that saves the extracted nodes from the priority queue
     */
    public void neighbours(int u, Vehicle v, int[] parent, Set<Integer> settled) {
        int actualDistance;
        int updatedDistance;

        for (int i = 0; i < adjacencyList.get(u).size(); i++) {
            Street e = adjacencyList.get(u).get(i);
            e.setVehicle(v);
            if (e.getRestrictions().getGaugeLimit() >= v.getGauge()) {
                if (!settled.contains(e.getDest())) {
                    actualDistance = e.getCostTotal();
                    updatedDistance = dist[u] + actualDistance;
                    if (updatedDistance < dist[e.getDest()]) {
                        dist[e.getDest()] = updatedDistance;
                        parent[e.getDest()] = u;
                    }
                    pq.add(new Street(e.getDest(), dist[e.getDest()], e.getRestrictions(), v));
                }
            }
        }
    }

    /**
     * method that prints the path from source to dest, if it exists, and the minimum distance
     * @param parent array which saves the parent of each vertex
     * @param dest destination node
     */
    public void printDijkstra(int[] parent, int dest) {
            printPath(dest, parent);
            System.out.print(dist[dest]);
            System.out.println();
    }

    /**
     * prints the shortest path from source to destination with the help of recursion
     * goes back until the source node is found and then exits the recursion and prints the path from the source node
     * @param destination destination node
     * @param parent array which saves the parent of each vertex
     */
    public void printPath(int destination, int[] parent) {
        if (parent[destination] == -1) {
            System.out.print("P" + destination + " ");
            return;
        }
        printPath(parent[destination], parent);
        System.out.print("P" + destination + " ");
    }

    /**
     * adds a additional cost to the street
     * @param type the type of the restriction
     * @param source the starting point of the street
     * @param dest the ending point of the street
     * @param cost the additional cost
     */
    public void addRestriction(String type, int source, int dest, int cost) {
        int destIndex = this.getDestIndex(adjacencyList.get(source), dest);
        Street e = adjacencyList.get(source).get(destIndex);
        e.getRestrictions().setTrafficJamCost(e.getRestrictions().getTrafficJamCost() + cost);
        e.getRestrictions().setType(type);
    }

    /**
     * getter for Vertexes
     * @return number of vertexes
     */
    public int getVertexes() {
        return vertexes;
    }

    /**
     * setter for vertexes
     * @param vertexes new value of vertexes
     */
    public void setVertexes(int vertexes) {
        this.vertexes = vertexes;
    }

    /**
     * getter for dist array
     * @return minimum distance array
     */
    public int[] getDist() {
        return dist;
    }

    /**
     * setter for dist array
     * @param dist new value for dist
     */
    public void setDist(int[] dist) {
        this.dist = dist;
    }
}
