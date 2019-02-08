public class Edge {
    public Town destination;
    public int distance;

    public Edge(Town origin,
                Town destination) {
        this(origin, destination,
                Integer.MAX_VALUE);
    }

    public Edge(Town origin,
                Town destination, int distance) {
        this.destination = destination;
        this.distance = distance;
    }


    public double getdistance() {
        return distance;
    }

}

