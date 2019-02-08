import java.util.*;

public class Routes {
    public Map<Town, List<Edge>> routingTable;
    public HashMap<Character, Town> townHashMap;

    public Routes() {
        routingTable = new HashMap<>();
        townHashMap = new HashMap<>();
    }
    void addTown(Town town) {
        if (!townHashMap.containsKey(town.getName())) {
            townHashMap.put(town.getName(), town);
            routingTable.put(town, new LinkedList<>());
        }
    }

    void addEdge(Town origin, Town destination, int distance) {
        Edge edge = new Edge(origin, destination, distance);
        this.routingTable.get(origin).add(edge);
    }

    Town getTown(char townKey) {
        return townHashMap.get(townKey);
    }

    List<Town> getTownList(List<Character> towns) {
        List<Town> townList= new ArrayList<>();
        for(char c: towns){
            townList.add(townHashMap.get(c));

        }
        return townList;
    }

    int routesDistance(List<Town> routes) {
        if (routes.size() <= 2) {
            return getDistance(routes.remove(0), routes.get(0));
        }
        try {
            return getDistance(routes.remove(0), routes.get(0)) + routesDistance(routes);
        } catch (NullPointerException e) {
            return -1;
        }
    }

    Integer getDistance(Town origin, Town destination) {
        for (Edge edge : routingTable.get(origin)) {
            if (edge.destination == destination) {
                return edge.distance;
            }
        }
        return null;
    }

    public int possibleRoutesMaxStop(Town origin, Town destination, int current, int maxStops, int dept) {
        int totalCount = 0;
        if (origin == destination && current <= maxStops && dept != 0) {
            totalCount++;
        }
        for (Edge edge : routingTable.get(origin)) {
            if (current <= maxStops) {
                totalCount += possibleRoutesMaxStop(edge.destination, destination, current + 1, maxStops, dept + 1);
            }
        }
        return totalCount;
    }

    public int possibleRoutesExactStop(Town origin, Town destionation, int current, int stop) {
        int totalCount = 0;
        for (Edge edge : routingTable.get(origin)) {
            if (current != stop) {
                totalCount += possibleRoutesExactStop(edge.destination, destionation, current + 1, stop);
            }
            if (edge.destination == destionation && current == stop) {
                totalCount++;
            }
        }
        return totalCount;
    }

    private int getHeuristic(Edge edge) {
        List<Edge> edgeLinkedList = routingTable.get(edge.destination);
        return edgeLinkedList.size() + edge.distance;
    }


    public int shortestPath(Town origin, Town destnation, int currentDist) {
        Edge currentEdge = null;
        int edgeHeuristic = Integer.MAX_VALUE;
        for (Edge edge : routingTable.get(origin)) {
            if (edge.destination == destnation) {
                return currentDist + edge.distance;
            }
            int heuristic = getHeuristic(edge);
            if (heuristic < edgeHeuristic) {
                edgeHeuristic = heuristic;
                currentEdge = edge;
            }
        }
        return shortestPath(currentEdge.destination, destnation, currentDist + currentEdge.distance);
    }

    int findAllPath(Town origin, Town destination, int maxDist) {
        return allPathMax(origin, destination, maxDist);
    }

    private int allPathMax(Town origin, Town destination, int maxDist) {
        int totalCount = 0;
        for (Edge edge : routingTable.get(origin)) {
            int currentDist = edge.distance;
            if (currentDist < maxDist) {
                totalCount += allPathMax(edge.destination, destination, maxDist - currentDist);
            }
            if (edge.destination == destination && currentDist < maxDist) {
                totalCount++;
            }
        }
        return totalCount;
    }


}





