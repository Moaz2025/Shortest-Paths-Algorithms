import org.testng.internal.collections.Pair;

import java.io.*;
import java.util.*;

public class Graph {
    private static final double INF = Double.MAX_VALUE / 2 - 1;
    private final int size;
    private final List<Pair<Integer, Double>>[] adjacencyList;
    private final List<Pair<Pair<Integer, Integer>, Double>> edgeList;
    private final double[][] adjacencyMatrix;

    Comparator<Pair<Double, Integer>> pairComparator = Comparator.comparing(Pair::first);

    public Graph(String filePath) throws IOException {
        Scanner scanner = new Scanner(new File(filePath));
        int n = scanner.nextInt(), m = scanner.nextInt();
        adjacencyList = new ArrayList[n];
        edgeList = new ArrayList<>();
        adjacencyMatrix = new double[n][n];
        this.size = n;

        for (int i = 0; i < this.size; i++) {
            adjacencyList[i] = new ArrayList<>();
            Arrays.fill(adjacencyMatrix[i], INF);
            adjacencyMatrix[i][i] = 0;
        }

        for (int i = 0; i < m; i++){
            int v = scanner.nextInt();
            int u = scanner.nextInt();
            double w = scanner.nextDouble();

            adjacencyList[v].add(new Pair<>(u, w));
            edgeList.add(new Pair<>(new Pair<>(v, u), w));
            adjacencyMatrix[v][u] = Math.min(w, adjacencyMatrix[v][u]);
        }
    }

    public void dijkstra(int src, double[] costs, int[] parents){
        for (int i = 0; i < this.size; i++){
            costs[i] = INF;
            parents[i] = -1;
        }

        PriorityQueue<Pair<Double, Integer>> pq = new PriorityQueue<>(pairComparator);

        costs[src] = 0;
        parents[src] = src;
        pq.add(new Pair<>(costs[src], src));

        while (!pq.isEmpty()){
            int node = pq.peek().second();
            assert pq.peek() != null;
            double cost = pq.peek().first();
            pq.poll();

            if (cost > costs[node])
                continue;

            for (Pair<Integer, Double> child : adjacencyList[node]){
                if (costs[node] + child.second() < costs[child.first()]){
                    parents[child.first()] = node;
                    costs[child.first()] = costs[node] + child.second();
                    pq.add(new Pair<>(costs[child.first()], child.first()));
                }
            }
        }
    }

    public boolean bellman_ford(int src, double[] costs, int[] parents){
        boolean negativeCycle = false;

        for (int i = 0; i < this.size; i++){
            costs[i] = INF;
            parents[i] = -1;
        }

        costs[src] = 0;
        parents[src] = src;

        for (int i = 0; i < this.size(); i++) {
            for (Pair<Pair<Integer, Integer>, Double> pairIntegerPair : edgeList) {
                int node = pairIntegerPair.first().first();
                int child = pairIntegerPair.first().second();
                double cost = pairIntegerPair.second();

                if (costs[node] + cost < costs[child]) {
                    if (i == this.size - 1)
                        negativeCycle = true;
                    parents[child] = node;
                    costs[child] = costs[node] + cost;
                }
            }
        }

        return negativeCycle;
    }

    public boolean floyd_warshall(double[][] costs, int[][] predecessors){
        boolean negativeCycle = false;

        for (int i = 0; i < this.size; i++){
            for (int j = 0; j < this.size; j++) {
                costs[i][j] = adjacencyMatrix[i][j];
                if (costs[i][j] == INF) {
                    predecessors[i][j] = -1;
                } else {
                    predecessors[i][j] = i;
                }
            }
        }

        for (int k = 0; k < this.size; k++) {
            for (int i = 0; i < this.size; i++) {
                for (int j = 0; j < this.size; j++) {
                    if (adjacencyMatrix[i][j] > adjacencyMatrix[i][k] + adjacencyMatrix[k][j]) {
                        adjacencyMatrix[i][j] = adjacencyMatrix[i][k] + adjacencyMatrix[k][j];
                        predecessors[i][j] = predecessors[k][j];
                    }
                }
            }
        }

        for (int i = 0; i < this.size; i++) {
            System.arraycopy(adjacencyMatrix[i], 0, costs[i], 0, this.size);
        }

        for (int i = 0; i < this.size(); i++) {
            if (adjacencyMatrix[i][i] < 0)
                negativeCycle = true;
        }

        return negativeCycle;
    }

    public double dijkstra_bellman_cost(double[] costs, int dis) {
        return costs[dis];
    }

    public double floyd_warshall_cost(double[][] costs, int src, int dis) {
        return costs[src][dis];
    }

    public List<Integer> dijkstra_bellman_path(int[] parents, int dis) {
        List<Integer> path = new ArrayList<>();
        while (dis != -1 && dis != parents[dis]){
            path.add(dis);
            dis = parents[dis];
        }
        if (dis == parents[dis])
            path.add(dis);

        Collections.reverse(path);
        return path;
    }

    public List<Integer> floyd_warshall_path(int[][] predecessors, int src, int dis) {
        List<Integer> path = new ArrayList<>();
        while (dis != -1 && dis != src) {
            path.add(dis);
            dis = predecessors[src][dis];
        }
        if (dis == predecessors[src][dis])
            path.add(dis);

        Collections.reverse(path);
        return path;
    }
    public int size(){
        return this.size;
    }
}
