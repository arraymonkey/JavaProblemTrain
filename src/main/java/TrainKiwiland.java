import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class TrainKiwiland {
    private static Routes graph = new Routes();

    public static void main(String[] args) {
        List<Character> townName = prepFile();
        List<Town> townList = graph.getTownList(townName);
        List<Character> tempList;
        System.out.println("Output #1: " + graph.routesDistance(graph.getTownList(townName.subList(0, 3))));
        tempList = new ArrayList<>();
        tempList.add(townName.get(0));
        tempList.add(townName.get(3));
        System.out.println("Output #2: " + graph.routesDistance(graph.getTownList(tempList)));
        tempList = new ArrayList<>();
        tempList.add(townName.get(0));
        tempList.add(townName.get(3));
        tempList.add(townName.get(2));
        System.out.println("Output #3: " + graph.routesDistance(graph.getTownList(tempList)));
        tempList = new ArrayList<>();
        tempList.add(townName.get(0));
        tempList.add(townName.get(4));
        tempList.add(townName.get(1));
        tempList.add(townName.get(2));
        tempList.add(townName.get(3));
        System.out.println("Output #4: " + graph.routesDistance(graph.getTownList(tempList)));
        tempList = new ArrayList<>();
        tempList.add(townName.get(1));
        tempList.add(townName.get(4));
        tempList.add(townName.get(3));
        try {
            int result = graph.routesDistance(graph.getTownList(tempList));
            if (result < 0) {
                throw new Exception();
            }
            System.out.println("Output #5: " + result);
        } catch (Exception e) {
            System.out.println("Output #5: NO SUCH ROUTE");
        }
        System.out.println("Output #6: " + graph.possibleRoutesMaxStop(townList.get(2), townList.get(2), 0, 3, 0));
        System.out.println("Output #7: " + graph.possibleRoutesExactStop(townList.get(0), townList.get(2), 0, 4));
        System.out.println("Output #8: " + graph.shortestPath(townList.get(2), townList.get(2), 0));
        System.out.println("Output #9: " + graph.shortestPath(townList.get(1), townList.get(1), 0));
        System.out.println("Output #10: " + graph.findAllPath(townList.get(2), townList.get(2), 30));

    }

    private static List<Character> prepFile() {
        List<Character> townName = new ArrayList<>();
        TrainKiwiland obj = new TrainKiwiland();
        String data = obj.getFile("input.txt");
        String[] arr = Pattern.compile("([A-Z])\\w+")
                .matcher(data)
                .results()
                .map(MatchResult::group)
                .toArray(String[]::new);
        for (String str : arr) {
            char strVal = str.charAt(0);
            char strVal2 = str.charAt(1);
            int distance = Character.getNumericValue(str.charAt(2));
            Town t1 = new Town(strVal);
            Town t2 = new Town(strVal2);
            if (!townName.contains(strVal)) {
                townName.add(strVal);
                graph.addTown(t1);
            } else {
                t1 = graph.getTown(strVal);
            }
            if (!townName.contains(strVal2)) {
                townName.add(strVal2);
                graph.addTown(t2);
            } else {
                t2 = graph.getTown(strVal2);
            }
            graph.addEdge(t1, t2, distance);
        }
        return townName;
    }

    private String getFile(String fileName) {

        StringBuilder result = new StringBuilder();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

}
