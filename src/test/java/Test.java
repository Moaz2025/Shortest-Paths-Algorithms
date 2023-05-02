import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String BLUE_BACKGROUND = "\u001B[44m";
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String filePath;
        Graph graph;

        String[] paths = {"G1test","G2test","G3test","G4test","test1","test2","test3"};

//        System.out.print("Enter graph file path: ");
//        while (true) {
//            try {
//                filePath = scanner.nextLine();
//                graph = new Graph(filePath);
//                break;
//            } catch (java.io.FileNotFoundException e) {
//                System.out.print("Wrong file path, please renter the path: ");
//            }
//        }
        for(int p=0;p<paths.length;p++)
        {
            filePath = "C:\\CSED\\Data structures 2\\Labs\\Shortest-Paths-Algorithms\\src\\main\\java\\tests\\" +paths[p]+".txt" ;
            graph = new Graph(filePath);
            int[] dijParents = new int[graph.size()];
            int[] bellParents = new int[graph.size()];
            int[][] floydParents = new int[graph.size()][graph.size()];
            double[] dijCosts = new double[graph.size()];
            double[] bellCosts = new double[graph.size()];
            double[][] floydCosts = new double[graph.size()][graph.size()];

            System.out.println(BLUE_BACKGROUND + BLACK +paths[p]+RESET);
            graph.dijkstra(0, dijCosts, dijParents);
            graph.bellman_ford(0, bellCosts, bellParents);
            graph.floyd_warshall(floydCosts, floydParents);
            System.out.println(BLUE+"dijkstra"+RESET);
            System.out.println(RED+"Parents"+YELLOW);
            for (int i = 0; i < graph.size(); i++) {
                System.out.print(dijParents[i] + " ");
            }
            System.out.println();
            System.out.println(RED+"Costs"+YELLOW);
            for (int i = 0; i < graph.size(); i++) {
                System.out.print(dijCosts[i] + " ");
            }
            System.out.println("\n");
            System.out.println(BLUE+"bellman_ford"+RESET);

            System.out.println(RED+"Parents"+YELLOW);
            for (int i = 0; i < graph.size(); i++) {
                System.out.print(bellParents[i] + " ");
            }
            System.out.println();

            System.out.println(RED+"Costs"+YELLOW);
            for (int i = 0; i < graph.size(); i++) {
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
            System.out.println(BLUE+"floyd_warshall"+RESET);

            System.out.println(RED+"Parents"+YELLOW);
            for (int i = 0; i < graph.size(); i++) {
                for (int j = 0; j < graph.size(); j++) {
                    System.out.print(floydParents[i][j] + " ");
                }
                System.out.println();
            }


            System.out.println(RED+"Costs"+YELLOW);
            for (int i = 0; i < graph.size(); i++) {
                for (int j = 0; j < graph.size(); j++) {
                    System.out.print(floydCosts[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println(GREEN+"----------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------"+RESET);
        }
    }
}
