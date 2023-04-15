import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String filePath;
        Graph graph;

        System.out.print("Enter graph file path: ");
        while (true) {
            try {
                filePath = scanner.nextLine();
                graph = new Graph(filePath);
                break;
            } catch (java.io.FileNotFoundException e) {
                System.out.print("Wrong file path, please renter the path: ");
            }
        }

        int[] dijParents = new int[graph.size()];
        int[] bellParents = new int[graph.size()];
        int[][] floydParents = new int[graph.size()][graph.size()];
        double[] dijCosts = new double[graph.size()];
        double[] bellCosts = new double[graph.size()];
        double[][] floydCosts = new double[graph.size()][graph.size()];

        graph.dijkstra(0, dijCosts, dijParents);
        graph.bellman_ford(0, bellCosts, bellParents);
        graph.floyd_warshall(floydCosts, floydParents);

        for (int i = 0; i < graph.size(); i++){
            System.out.print(dijParents[i] + " ");
        }
        System.out.println();
        System.out.println();

        for (int i = 0; i < graph.size(); i++){
            System.out.print(dijCosts[i] + " ");
        }
        System.out.println();
        System.out.println();

        for (int i = 0; i < graph.size(); i++){
            System.out.print(bellParents[i] + " ");
        }
        System.out.println();
        System.out.println();

        for (int i = 0; i < graph.size(); i++){
            System.out.print(bellCosts[i] + " ");
        }
        System.out.println();
        System.out.println();

//        while (true) {
//            if (sc.hasNextInt()) {
//                op = sc.nextInt();
//                if (op > 0 && op <= OptionsNumber)
//                    break;
//            }
//            System.out.println("Invalid option number, please enter number from 1 to" + OptionsNumber + ": ");
//        }

        for (int i = 0; i < graph.size(); i++){
            for (int j = 0; j < graph.size(); j++) {
                System.out.print(floydCosts[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < graph.size(); i++){
            for (int j = 0; j < graph.size(); j++) {
                System.out.print(floydParents[i][j] + " ");
            }
            System.out.println();
        }
    }
}
