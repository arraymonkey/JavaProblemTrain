import org.junit.BeforeClass;
import org.junit.Test;
import java.util.LinkedList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;


public class GraphTest {
    private static Town A, B, C, D, E;
    private static Routes graph;

    @BeforeClass
    public static void createGraph() {
        graph = new Routes();
        graph.addTown(A = new Town('A'));
        graph.addTown(B = new Town('B'));
        graph.addTown(C = new Town('C'));
        graph.addTown(D = new Town('D'));
        graph.addTown(E = new Town('E'));
        graph.addEdge(A, B, 5);
        graph.addEdge(B, C, 4);
        graph.addEdge(C, D, 8);
        graph.addEdge(D, C, 8);
        graph.addEdge(D, E, 6);
        graph.addEdge(A, D, 5);
        graph.addEdge(C, E, 2);
        graph.addEdge(E, B, 3);
        graph.addEdge(A, E, 7);

    }


    @Test
    public void getDistanceTest() {
        assertSame(5, graph.getDistance(A, B));
        assertSame(4, graph.getDistance(B, C));
        assertSame(8, graph.getDistance(C, D));
        assertSame(8, graph.getDistance(D, C));
        assertSame(6, graph.getDistance(D, E));
        assertSame(5, graph.getDistance(A, D));
        assertSame(2, graph.getDistance(C, E));
        assertSame(3, graph.getDistance(E, B));
        assertSame(7, graph.getDistance(A, E));
        assertSame(null, graph.getDistance(B, E));

    }

    @Test
    public void routesDistanceTest() {
        List<Town> routesABC = new LinkedList<Town>();
        routesABC.add(A);
        routesABC.add(B);
        routesABC.add(C);
        assertEquals(9, graph.routesDistance(routesABC));
        List<Town> routesAD = new LinkedList<Town>();
        routesAD.add(A);
        routesAD.add(D);
        assertEquals(5, graph.routesDistance(routesAD));
        List<Town> routesADC = new LinkedList<Town>();
        routesADC.add(A);
        routesADC.add(D);
        routesADC.add(C);
        assertEquals(13, graph.routesDistance(routesADC));
        List<Town> routesAEBCD = new LinkedList<Town>();
        routesAEBCD.add(A);
        routesAEBCD.add(E);
        routesAEBCD.add(B);
        routesAEBCD.add(C);
        routesAEBCD.add(D);
        assertEquals(22, graph.routesDistance(routesAEBCD));
        List<Town> routesAED = new LinkedList<Town>();
        routesAED.add(A);
        routesAED.add(E);
        routesAED.add(D);
        assertEquals(-1, graph.routesDistance(routesAED));
    }

    @Test
    public void possibleRoutesTest() {
        assertEquals(2, graph.possibleRoutesMaxStop(C, C, 0, 3, 0));
        assertEquals(3, graph.possibleRoutesExactStop(A, C, 0, 4));
        assertEquals(9, graph.shortestPath(C, C, 0));
        assertEquals(9, graph.shortestPath(B, B, 0));
        assertEquals(7, graph.shortestPath(E, C, 0));

    }

    @Test
    public void maxRoutesTest() {
        assertEquals(7, graph.findAllPath(C, C, 30));

    }

}
