import java.io.IOException;
import java.util.Scanner;

public class App {
    private static final int MAINOPT = 4, SUBOPT_1_2 = 4, SUBOPT_3 = 3;

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
                System.out.print("Invalid file path, please renter the path: ");
            }
        }

        mainMenu(scanner, graph);
    }

    private static void mainHelp(){
        System.out.println("1- s.p from source node to all other nodes");
        System.out.println("2- s.p between all the pairs of nodes");
        System.out.println("3- check for negative cycles");
        System.out.println("4- exit");
        System.out.println();
    }

    private static void subHelp_1_2(){
        System.out.println("1- dijkstra");
        System.out.println("2- bellman-ford");
        System.out.println("3- floyd-warshall");
        System.out.println("4- exit");
        System.out.println();
    }

    private static void subHelp_3(){
        System.out.println("1- bellman-ford");
        System.out.println("2- floyd-warshall");
        System.out.println("3- exit");
        System.out.println();
    }

    private static void invalidOption(int optionsNum){
        System.out.println("Invalid option number, please enter number from 1 to " + optionsNum);
    }
    private static void mainMenu(Scanner sc, Graph g){
        int op;

        mainHelp();
        while (true) {
            System.out.print("Enter option number: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    subMenu1(sc, g);
                    break;
                case 2:
                    subMenu2(sc, g);
                    break;
                case 3:
                    subMenu3(sc, g);
                    break;
                case 4:
                    return;
                default:
                    invalidOption(MAINOPT);
            }
            System.out.println();
        }
    }

    private static void subMenu1(Scanner sc, Graph g){
        int op, src, dis, algorithm;

        subHelp_1_2();
        while (true) {
            System.out.print("Select an algorithm: ");
            algorithm = sc.nextInt();

            if (algorithm == SUBOPT_1_2)
                return;

            System.out.print("Select a source node: ");
            src = sc.nextInt();

            switch (algorithm) {
                case 1:
                    double[] dijCosts = new double[g.size()];
                    int[] dijParents = new int[g.size()];
                    g.dijkstra(src, dijCosts, dijParents);

                    System.out.print("Choose 1 for path cost, 2 for shortest path, 3 for exit: ");
                    op = sc.nextInt();
                    System.out.print("Choose destination node: ");
                    dis = sc.nextInt();

                    if (op == 1)
                        System.out.println(g.dijkstra_bellman_cost(dijCosts, dis));
                    else if (op == 2)
                        System.out.println(g.dijkstra_bellman_path(dijParents, dis));
                    else if (op == 3)
                        return;
                    break;
                case 2:
                    double[] bellCosts = new double[g.size()];
                    int[] bellParents = new int[g.size()];
                    g.bellman_ford(src, bellCosts, bellParents);

                    System.out.print("Choose 1 for path cost, 2 for shortest path, 3 for exit: ");
                    op = sc.nextInt();
                    System.out.print("Choose destination node: ");
                    dis = sc.nextInt();

                    if (op == 1)
                        System.out.println(g.dijkstra_bellman_cost(bellCosts, dis));
                    else if (op == 2)
                        System.out.println(g.dijkstra_bellman_path(bellParents, dis));
                    else if (op == 3)
                        return;
                    break;
                case 3:
                    double[][] floydCosts = new double[g.size()][g.size()];
                    int[][] floydParents = new int[g.size()][g.size()];
                    g.floyd_warshall(floydCosts, floydParents);

                    System.out.print("Choose 1 for path cost, 2 for shortest path, 3 for exit: ");
                    op = sc.nextInt();
                    System.out.print("Choose destination node: ");
                    dis = sc.nextInt();

                    if (op == 1)
                        System.out.println(g.floyd_warshall_cost(floydCosts, src, dis));
                    else if (op == 2)
                        System.out.println(g.floyd_warshall_path(floydParents, src, dis));
                    else if (op == 3)
                        return;
                    break;
                default:
                    invalidOption(SUBOPT_1_2);
            }
            System.out.println();
        }
    }

    private static void subMenu2(Scanner sc, Graph g){
        int op, src, dis, algorithm;

        subHelp_1_2();
        while (true) {
            System.out.print("Select an algorithm: ");
            algorithm = sc.nextInt();

            switch (algorithm) {
                case 1:
                    double[][] dijCosts = new double[g.size()][g.size()];
                    int[][] dijParents = new int[g.size()][g.size()];
                    for (int i = 0; i < g.size(); i++)
                        g.dijkstra(i, dijCosts[i], dijParents[i]);

                    System.out.print("Choose 1 for path cost, 2 for shortest path, 3 for exit: ");
                    while (true) {
                        op = sc.nextInt();
                        System.out.print("Choose source node: ");
                        src = sc.nextInt();
                        System.out.print("Choose destination node: ");
                        dis = sc.nextInt();

                        if (op == 1)
                            System.out.println(g.dijkstra_bellman_cost(dijCosts[src], dis));
                        else if (op == 2)
                            System.out.println(g.dijkstra_bellman_path(dijParents[src], dis));
                        else if (op == 3)
                            return;
                    }
                case 2:
                    double[][] bellCosts = new double[g.size()][g.size()];
                    int[][] bellParents = new int[g.size()][g.size()];
                    for (int i = 0; i < g.size(); i++)
                        g.bellman_ford(i, bellCosts[i], bellParents[i]);

                    System.out.print("Choose 1 for path cost, 2 for shortest path, 3 for exit: ");
                    while (true) {
                        op = sc.nextInt();
                        System.out.print("Choose source node: ");
                        src = sc.nextInt();
                        System.out.print("Choose destination node: ");
                        dis = sc.nextInt();

                        if (op == 1)
                            System.out.println(g.dijkstra_bellman_cost(bellCosts[src], dis));
                        else if (op == 2)
                            System.out.println(g.dijkstra_bellman_path(bellParents[src], dis));
                        else if (op == 3)
                            return;
                    }
                case 3:
                    double[][] floydCosts = new double[g.size()][g.size()];
                    int[][] floydParents = new int[g.size()][g.size()];
                    g.floyd_warshall(floydCosts, floydParents);

                    while (true) {
                        op = sc.nextInt();
                        System.out.print("Choose source node: ");
                        src = sc.nextInt();
                        System.out.print("Choose destination node: ");
                        dis = sc.nextInt();

                        if (op == 1)
                            System.out.println(g.floyd_warshall_cost(floydCosts, src, dis));
                        else if (op == 2)
                            System.out.println(g.floyd_warshall_path(floydParents, src, dis));
                        else if (op == 3)
                            return;
                    }
                case 4:
                    return;
                default:
                    invalidOption(SUBOPT_1_2);
            }
            System.out.println();
        }
    }

    private static void subMenu3(Scanner sc, Graph g){
        int algorithm;

        subHelp_3();
        while (true) {
            System.out.print("Select an algorithm: ");
            algorithm = sc.nextInt();

            switch (algorithm) {
                case 1:
                    double[] bellCosts = new double[g.size()];
                    int[] bellParents = new int[g.size()];
                    if (g.bellman_ford(0, bellCosts, bellParents))
                        System.out.println("There is negative cycle!");
                    else
                        System.out.println("No negative cycles");
                    break;
                case 2:
                    double[][] floydCosts = new double[g.size()][g.size()];
                    int[][] floydParents = new int[g.size()][g.size()];
                    if (g.floyd_warshall(floydCosts, floydParents))
                        System.out.println("There is negative cycle!");
                    else
                        System.out.println("No negative cycles");
                    break;
                case 3:
                    return;
                default:
                    invalidOption(SUBOPT_3);
            }
            System.out.println();
        }
    }
}
