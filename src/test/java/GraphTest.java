import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class GTest {

    @Test
    void test1() throws IOException {
        Graph G1 = new Graph("C:\\CSED\\Data structures 2\\Labs\\Shortest-Paths-Algorithms\\src\\test\\java\\tests\\G1test.txt");
        int[] dijParents = new int[G1.size()];
        int[] bellParents = new int[G1.size()];
        int[][] floydParents = new int[G1.size()][G1.size()];
        double[] dijCosts = new double[G1.size()];
        double[] bellCosts = new double[G1.size()];
        double[][] floydCosts = new double[G1.size()][G1.size()];

        //cost and path
        G1.dijkstra(0, dijCosts, dijParents);
        G1.bellman_ford(0, bellCosts, bellParents);
        G1.floyd_warshall(floydCosts, floydParents);

        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);

        assertEquals(5, G1.dijkstra_bellman_cost(dijCosts, 1));
        assertEquals(5, G1.dijkstra_bellman_cost(bellCosts, 1));
        assertEquals(5, G1.floyd_warshall_cost(floydCosts, 0, 1));

        assertEquals(list, G1.dijkstra_bellman_path(dijParents,1));
        assertEquals(list, G1.dijkstra_bellman_path(bellParents,1));
        assertEquals(list, G1.floyd_warshall_path(floydParents,0,1));
    }

    @Test
    void test2() throws IOException {
        Graph G1 = new Graph("C:\\CSED\\Data structures 2\\Labs\\Shortest-Paths-Algorithms\\src\\test\\java\\tests\\G1test.txt");
        int[] dijParents = new int[G1.size()];
        int[] bellParents = new int[G1.size()];
        int[][] floydParents = new int[G1.size()][G1.size()];
        double[] dijCosts = new double[G1.size()];
        double[] bellCosts = new double[G1.size()];
        double[][] floydCosts = new double[G1.size()][G1.size()];

        //cost and path
        G1.dijkstra(1, dijCosts, dijParents);
        G1.bellman_ford(1, bellCosts, bellParents);
        G1.floyd_warshall(floydCosts, floydParents);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0);

        assertEquals(3, G1.dijkstra_bellman_cost(dijCosts, 0));
        assertEquals(3, G1.dijkstra_bellman_cost(bellCosts, 0));
        assertEquals(3, G1.floyd_warshall_cost(floydCosts, 1, 0));

        assertEquals(list, G1.dijkstra_bellman_path(dijParents,0));
        assertEquals(list, G1.dijkstra_bellman_path(bellParents,0));
        assertEquals(list, G1.floyd_warshall_path(floydParents,1,0));
    }

    @Test
    void test3() throws IOException {
        Graph G1 = new Graph("C:\\CSED\\Data structures 2\\Labs\\Shortest-Paths-Algorithms\\src\\test\\java\\tests\\G1test.txt");
        int[] bellParents = new int[G1.size()];
        int[][] floydParents = new int[G1.size()][G1.size()];
        double[] bellCosts = new double[G1.size()];
        double[][] floydCosts = new double[G1.size()][G1.size()];

        //negative cycle
        assertFalse(G1.bellman_ford(0, bellCosts, bellParents));
        assertFalse(G1.floyd_warshall(floydCosts, floydParents));
    }

    @Test
    void test4() throws IOException {
        Graph G2 = new Graph("C:\\CSED\\Data structures 2\\Labs\\Shortest-Paths-Algorithms\\src\\test\\java\\tests\\G2test.txt");
        int[] bellParents = new int[G2.size()];
        int[][] floydParents = new int[G2.size()][G2.size()];
        double[] bellCosts = new double[G2.size()];
        double[][] floydCosts = new double[G2.size()][G2.size()];

        //cost and path
        G2.bellman_ford(0, bellCosts, bellParents);
        G2.floyd_warshall(floydCosts, floydParents);

        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(2);
        list.add(4);
        list.add(6);

        assertEquals(2, G2.dijkstra_bellman_cost(bellCosts, 6));
        assertEquals(2, G2.floyd_warshall_cost(floydCosts, 0, 6));

        assertEquals(list, G2.dijkstra_bellman_path(bellParents,6));
        assertEquals(list, G2.floyd_warshall_path(floydParents,0,6));
    }

    @Test
    void test5() throws IOException {
        Graph G2 = new Graph("C:\\CSED\\Data structures 2\\Labs\\Shortest-Paths-Algorithms\\src\\test\\java\\tests\\G2test.txt");
        int[] bellParents = new int[G2.size()];
        int[][] floydParents = new int[G2.size()][G2.size()];
        double[] bellCosts = new double[G2.size()];
        double[][] floydCosts = new double[G2.size()][G2.size()];

        //negative cycle
        assertFalse(G2.bellman_ford(0, bellCosts, bellParents));
        assertFalse(G2.floyd_warshall(floydCosts, floydParents));
    }

    @Test
    void test6() throws IOException {
        Graph G3 = new Graph("C:\\CSED\\Data structures 2\\Labs\\Shortest-Paths-Algorithms\\src\\test\\java\\tests\\G3test.txt");
        int[] bellParents = new int[G3.size()];
        int[][] floydParents = new int[G3.size()][G3.size()];
        double[] bellCosts = new double[G3.size()];
        double[][] floydCosts = new double[G3.size()][G3.size()];

        //cost and path
        G3.bellman_ford(0, bellCosts, bellParents);
        G3.floyd_warshall(floydCosts, floydParents);

        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(4);

        assertEquals(-4, G3.dijkstra_bellman_cost(bellCosts, 4));
        assertEquals(-4,G3.floyd_warshall_cost(floydCosts, 0, 4));

        assertEquals(list,G3.dijkstra_bellman_path(bellParents,4));
        assertEquals(list,G3.floyd_warshall_path(floydParents,0,4));
    }

    @Test
    void test7() throws IOException {
        Graph G3 = new Graph("C:\\CSED\\Data structures 2\\Labs\\Shortest-Paths-Algorithms\\src\\test\\java\\tests\\G3test.txt");
        int[] bellParents = new int[G3.size()];
        int[][] floydParents = new int[G3.size()][G3.size()];
        double[] bellCosts = new double[G3.size()];
        double[][] floydCosts = new double[G3.size()][G3.size()];

        //negative cycle
        assertFalse(G3.bellman_ford(0, bellCosts, bellParents));
        assertFalse(G3.floyd_warshall(floydCosts, floydParents));
    }

    @Test
    void test8() throws IOException {
        Graph G4 = new Graph("C:\\CSED\\Data structures 2\\Labs\\Shortest-Paths-Algorithms\\src\\test\\java\\tests\\G4test.txt");
        int[] dijParents = new int[G4.size()];
        int[] bellParents = new int[G4.size()];
        int[][] floydParents = new int[G4.size()][G4.size()];
        double[] dijCosts = new double[G4.size()];
        double[] bellCosts = new double[G4.size()];
        double[][] floydCosts = new double[G4.size()][G4.size()];

        //cost and path
        G4.dijkstra(0, dijCosts, dijParents);
        G4.bellman_ford(0, bellCosts, bellParents);
        G4.floyd_warshall(floydCosts, floydParents);

        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(6);

        assertEquals(19, G4.dijkstra_bellman_cost(dijCosts, 6));
        assertEquals(19, G4.dijkstra_bellman_cost(bellCosts, 6));
        assertEquals(19,G4.floyd_warshall_cost(floydCosts, 0, 6));

        assertEquals(list,G4.dijkstra_bellman_path(dijParents,6));
        assertEquals(list,G4.dijkstra_bellman_path(bellParents,6));
        assertEquals(list,G4.floyd_warshall_path(floydParents,0,6));
    }

    @Test
    void test9() throws IOException {
        Graph G4 = new Graph("C:\\CSED\\Data structures 2\\Labs\\Shortest-Paths-Algorithms\\src\\test\\java\\tests\\G4test.txt");
        int[] bellParents = new int[G4.size()];
        int[][] floydParents = new int[G4.size()][G4.size()];
        double[] bellCosts = new double[G4.size()];
        double[][] floydCosts = new double[G4.size()][G4.size()];

        //negative cycle
        assertFalse(G4.bellman_ford(0, bellCosts, bellParents));
        assertFalse(G4.floyd_warshall(floydCosts, floydParents));
    }

    @Test
    void test10() throws IOException {
        Graph G5 = new Graph("C:\\CSED\\Data structures 2\\Labs\\Shortest-Paths-Algorithms\\src\\test\\java\\tests\\G5test.txt");
        int[] bellParents = new int[G5.size()];
        int[][] floydParents = new int[G5.size()][G5.size()];
        double[] bellCosts = new double[G5.size()];
        double[][] floydCosts = new double[G5.size()][G5.size()];

        //cost and path
        G5.bellman_ford(0, bellCosts, bellParents);
        G5.floyd_warshall(floydCosts, floydParents);

        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(4);
        list.add(5);

        assertEquals(0, G5.dijkstra_bellman_cost(bellCosts, 5));
        assertEquals(0,G5.floyd_warshall_cost(floydCosts, 0, 5));
        assertEquals(list,G5.dijkstra_bellman_path(bellParents,5));
        assertEquals(list,G5.floyd_warshall_path(floydParents,0,5));
    }

    @Test
    void test11() throws IOException {
        Graph G5 = new Graph("C:\\CSED\\Data structures 2\\Labs\\Shortest-Paths-Algorithms\\src\\test\\java\\tests\\G5test.txt");
        int[] bellParents = new int[G5.size()];
        int[][] floydParents = new int[G5.size()][G5.size()];
        double[] bellCosts = new double[G5.size()];
        double[][] floydCosts = new double[G5.size()][G5.size()];

        //negative cycle
        assertFalse(G5.bellman_ford(0,bellCosts,bellParents));
        assertFalse(G5.floyd_warshall(floydCosts,floydParents));
    }

    @Test
    void test12() throws IOException {
        Graph G6 = new Graph("C:\\CSED\\Data structures 2\\Labs\\Shortest-Paths-Algorithms\\src\\test\\java\\tests\\G6test.txt");
        int[] dijParents = new int[G6.size()];
        int[] bellParents = new int[G6.size()];
        int[][] floydParents = new int[G6.size()][G6.size()];
        double[] dijCosts = new double[G6.size()];
        double[] bellCosts = new double[G6.size()];
        double[][] floydCosts = new double[G6.size()][G6.size()];

        G6.dijkstra(8, dijCosts, dijParents);
        G6.bellman_ford(8, bellCosts, bellParents);
        G6.floyd_warshall(floydCosts, floydParents);

        //cost and path
        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(1);
        list.add(4);
        list.add(7);
        list.add(6);

        assertEquals(12, G6.dijkstra_bellman_cost(dijCosts, 6));
        assertEquals(12, G6.dijkstra_bellman_cost(bellCosts, 6));
        assertEquals(12,G6.floyd_warshall_cost(floydCosts, 8, 6));

        assertEquals(list,G6.dijkstra_bellman_path(dijParents,6));
        assertEquals(list,G6.dijkstra_bellman_path(bellParents,6));
        assertEquals(list,G6.floyd_warshall_path(floydParents,8,6));
    }

    @Test
    void test13() throws IOException {
        Graph G6 = new Graph("C:\\CSED\\Data structures 2\\Labs\\Shortest-Paths-Algorithms\\src\\test\\java\\tests\\G6test.txt");
        int[] bellParents = new int[G6.size()];
        int[][] floydParents = new int[G6.size()][G6.size()];
        double[] bellCosts = new double[G6.size()];
        double[][] floydCosts = new double[G6.size()][G6.size()];

        //negative cycle
        assertFalse(G6.bellman_ford(8,bellCosts,bellParents));
        assertFalse(G6.floyd_warshall(floydCosts,floydParents));
    }

    @Test
    void test14() throws IOException {
        Graph G7 = new Graph("C:\\CSED\\Data structures 2\\Labs\\Shortest-Paths-Algorithms\\src\\test\\java\\tests\\G7test.txt");
        int[] dijParents = new int[G7.size()];
        int[] bellParents = new int[G7.size()];
        int[][] floydParents = new int[G7.size()][G7.size()];
        double[] dijCosts = new double[G7.size()];
        double[] bellCosts = new double[G7.size()];
        double[][] floydCosts = new double[G7.size()][G7.size()];

        //cost and path
        G7.dijkstra(1, dijCosts, dijParents);
        G7.bellman_ford(1, bellCosts, bellParents);
        G7.floyd_warshall(floydCosts, floydParents);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(0);

        assertEquals(8, G7.dijkstra_bellman_cost(dijCosts, 0));
        assertEquals(8, G7.dijkstra_bellman_cost(bellCosts, 0));
        assertEquals(8,G7.floyd_warshall_cost(floydCosts, 1, 0));

        assertEquals(list,G7.dijkstra_bellman_path(dijParents,0));
        assertEquals(list,G7.dijkstra_bellman_path(bellParents,0));
        assertEquals(list,G7.floyd_warshall_path(floydParents,1,0));
    }

    @Test
    void test15() throws IOException {
        Graph G7 = new Graph("C:\\CSED\\Data structures 2\\Labs\\Shortest-Paths-Algorithms\\src\\test\\java\\tests\\G7test.txt");
        int[] bellParents = new int[G7.size()];
        int[][] floydParents = new int[G7.size()][G7.size()];
        double[] bellCosts = new double[G7.size()];
        double[][] floydCosts = new double[G7.size()][G7.size()];

        //negative cycle
        assertFalse(G7.bellman_ford(1,bellCosts,bellParents));
        assertFalse(G7.floyd_warshall(floydCosts,floydParents));
    }
    @Test
    void test16() throws IOException {
        Graph G8 = new Graph("C:\\CSED\\Data structures 2\\Labs\\Shortest-Paths-Algorithms\\src\\test\\java\\tests\\G8test.txt");
        int[] dijParents = new int[G8.size()];
        int[] bellParents = new int[G8.size()];
        int[][] floydParents = new int[G8.size()][G8.size()];
        double[] dijCosts = new double[G8.size()];
        double[] bellCosts = new double[G8.size()];
        double[][] floydCosts = new double[G8.size()][G8.size()];

        G8.dijkstra(0, dijCosts, dijParents);
        G8.bellman_ford(0, bellCosts, bellParents);
        G8.floyd_warshall(floydCosts, floydParents);

        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(2);
        list.add(6);

        assertEquals(4, G8.dijkstra_bellman_cost(dijCosts, 6));
        assertEquals(4, G8.dijkstra_bellman_cost(bellCosts, 6));
        assertEquals(4,G8.floyd_warshall_cost(floydCosts, 0, 6));
        assertEquals(list,G8.dijkstra_bellman_path(dijParents,6));
        assertEquals(list,G8.dijkstra_bellman_path(bellParents,6));
        assertEquals(list,G8.floyd_warshall_path(floydParents,0,6));
    }
    @Test
    void test17() throws IOException {
        Graph G8 = new Graph("C:\\CSED\\Data structures 2\\Labs\\Shortest-Paths-Algorithms\\src\\test\\java\\tests\\G8test.txt");
        int[] dijParents = new int[G8.size()];
        int[] bellParents = new int[G8.size()];
        int[][] floydParents = new int[G8.size()][G8.size()];
        double[] dijCosts = new double[G8.size()];
        double[] bellCosts = new double[G8.size()];
        double[][] floydCosts = new double[G8.size()][G8.size()];

        G8.dijkstra(3, dijCosts, dijParents);
        G8.bellman_ford(3, bellCosts, bellParents);
        G8.floyd_warshall(floydCosts, floydParents);

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(5);
        list.add(7);

        assertEquals(11, G8.dijkstra_bellman_cost(dijCosts, 7));
        assertEquals(11, G8.dijkstra_bellman_cost(bellCosts, 7));
        assertEquals(11,G8.floyd_warshall_cost(floydCosts, 3, 7));
        assertEquals(list,G8.dijkstra_bellman_path(dijParents,7));
        assertEquals(list,G8.dijkstra_bellman_path(bellParents,7));
        assertEquals(list,G8.floyd_warshall_path(floydParents,3,7));
    }
    @Test
    void test18() throws IOException {
        Graph G8 = new Graph("C:\\CSED\\Data structures 2\\Labs\\Shortest-Paths-Algorithms\\src\\test\\java\\tests\\G8test.txt");
        int[] bellParents = new int[G8.size()];
        int[][] floydParents = new int[G8.size()][G8.size()];
        double[] bellCosts = new double[G8.size()];
        double[][] floydCosts = new double[G8.size()][G8.size()];

        G8.bellman_ford(1, bellCosts, bellParents);
        G8.floyd_warshall(floydCosts, floydParents);

        //negative cycle
        assertFalse(G8.bellman_ford(1,bellCosts,bellParents));
        assertFalse(G8.floyd_warshall(floydCosts,floydParents));
    }
    @Test
    void test19() throws IOException {
        Graph G9 = new Graph("C:\\CSED\\Data structures 2\\Labs\\Shortest-Paths-Algorithms\\src\\test\\java\\tests\\G9test.txt");
        int[] dijParents = new int[G9.size()];
        int[] bellParents = new int[G9.size()];
        int[][] floydParents = new int[G9.size()][G9.size()];
        double[] dijCosts = new double[G9.size()];
        double[] bellCosts = new double[G9.size()];
        double[][] floydCosts = new double[G9.size()][G9.size()];

        G9.dijkstra(0, dijCosts, dijParents);
        G9.bellman_ford(0, bellCosts, bellParents);
        G9.floyd_warshall(floydCosts, floydParents);

        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(2);
        list.add(5);
        assertEquals(6, G9.dijkstra_bellman_cost(dijCosts, 5));
        assertEquals(6, G9.dijkstra_bellman_cost(bellCosts, 5));
        assertEquals(6,G9.floyd_warshall_cost(floydCosts, 0, 5));
        assertEquals(list,G9.dijkstra_bellman_path(dijParents,5));
        assertEquals(list,G9.dijkstra_bellman_path(bellParents,5));
        assertEquals(list,G9.floyd_warshall_path(floydParents,0,5));
    }
    @Test
    void test20() throws IOException {
        Graph G9 = new Graph("C:\\CSED\\Data structures 2\\Labs\\Shortest-Paths-Algorithms\\src\\test\\java\\tests\\G9test.txt");
        int[] bellParents = new int[G9.size()];
        int[][] floydParents = new int[G9.size()][G9.size()];
        double[] bellCosts = new double[G9.size()];
        double[][] floydCosts = new double[G9.size()][G9.size()];

        G9.bellman_ford(1, bellCosts, bellParents);
        G9.floyd_warshall(floydCosts, floydParents);

        //negative cycle
        assertFalse(G9.bellman_ford(0,bellCosts,bellParents));
        assertFalse(G9.floyd_warshall(floydCosts,floydParents));
    }
    @Test
    void test21() throws IOException {
        Graph G10 = new Graph("C:\\CSED\\Data structures 2\\Labs\\Shortest-Paths-Algorithms\\src\\test\\java\\tests\\G10test.txt");
        int[] dijParents = new int[G10.size()];
        int[] bellParents = new int[G10.size()];
        int[][] floydParents = new int[G10.size()][G10.size()];
        double[] dijCosts = new double[G10.size()];
        double[] bellCosts = new double[G10.size()];
        double[][] floydCosts = new double[G10.size()][G10.size()];
        G10.dijkstra(0, dijCosts, dijParents);
        G10.bellman_ford(0, bellCosts, bellParents);
        G10.floyd_warshall(floydCosts, floydParents);

        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);

        assertEquals(8, G10.dijkstra_bellman_cost(dijCosts, 2));
        assertEquals(8, G10.dijkstra_bellman_cost(bellCosts, 2));
        assertEquals(8,G10.floyd_warshall_cost(floydCosts, 0,2));
        assertEquals(list,G10.dijkstra_bellman_path(dijParents,2));
        assertEquals(list,G10.dijkstra_bellman_path(bellParents,2));
        assertEquals(list,G10.floyd_warshall_path(floydParents,0,2));
    }
    @Test
    void test22() throws IOException {
        Graph G10 = new Graph("C:\\CSED\\Data structures 2\\Labs\\Shortest-Paths-Algorithms\\src\\test\\java\\tests\\G10test.txt");
        int[] bellParents = new int[G10.size()];
        int[][] floydParents = new int[G10.size()][G10.size()];
        double[] bellCosts = new double[G10.size()];
        double[][] floydCosts = new double[G10.size()][G10.size()];

        G10.bellman_ford(1, bellCosts, bellParents);
        G10.floyd_warshall(floydCosts, floydParents);

        //negative cycle
        assertFalse(G10.bellman_ford(0,bellCosts,bellParents));
        assertFalse(G10.floyd_warshall(floydCosts,floydParents));
    }
    @Test
    void test23() throws IOException {
        Graph G11 = new Graph("C:\\CSED\\Data structures 2\\Labs\\Shortest-Paths-Algorithms\\src\\test\\java\\tests\\G11test.txt");
        int[] bellParents = new int[G11.size()];
        int[][] floydParents = new int[G11.size()][G11.size()];
        double[] bellCosts = new double[G11.size()];
        double[][] floydCosts = new double[G11.size()][G11.size()];

        G11.bellman_ford(1, bellCosts, bellParents);
        G11.floyd_warshall(floydCosts, floydParents);

        //negative cycle
        assertTrue(G11.bellman_ford(0,bellCosts,bellParents));
        assertTrue(G11.floyd_warshall(floydCosts,floydParents));
    }
}