import java.io.IOException;
import java.util.Scanner;

public class App {

    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String BLUE_BACKGROUND = "\u001B[44m";
    private static final int MAINOPT = 4, SUBOPT_1_2 = 4, SUBOPT_3 = 3;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String filePath;
        Graph graph;

        System.out.print(BLACK+BLUE_BACKGROUND+"Enter graph file path: "+RESET);
        while (true) {
            try {
                filePath = scanner.nextLine();
                graph = new Graph(filePath);
                break;
            } catch (java.io.FileNotFoundException e) {
                System.out.print(RED+"Invalid file path, please renter the path: "+RESET);
            }
        }

        mainMenu(scanner, graph);
    }

    private static void mainHelp(){
        System.out.println(BLUE+"\n1- s.p from source node to all other nodes");
        System.out.println("2- s.p between all the pairs of nodes");
        System.out.println("3- check for negative cycles");
        System.out.println("4- exit"+RESET);
        System.out.println();
    }

    private static void subHelp_1_2(){
        System.out.println(BLUE+"\n1- dijkstra");
        System.out.println("2- bellman-ford");
        System.out.println("3- floyd-warshall");
        System.out.println("4- exit"+RESET);
        System.out.println();
    }

    private static void subHelp_3(){
        System.out.println(BLUE+ "\n1- bellman-ford");
        System.out.println("2- floyd-warshall");
        System.out.println("3- exit"+RESET);
        System.out.println();
    }

    private static void invalidOption(int optionsNum){
        System.out.println(RED+"Invalid option number, please enter number from 1 to " + optionsNum +RESET);
    }

    private static void mainMenu(Scanner sc, Graph g){
        int op;

        mainHelp();
        while (true) {
            System.out.print(BLACK+BLUE_BACKGROUND +"Enter option number: "+RESET);
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
            System.out.print(BLACK + BLUE_BACKGROUND + "Select an algorithm: " + RESET);
            algorithm = sc.nextInt();

            src = -1;
            if (algorithm != SUBOPT_1_2) {
                System.out.print(BLUE + "Select a source node: " + RESET);
                src = sc.nextInt();
            }

            switch (algorithm) {
                case 1:
                    double[] dijCosts = new double[g.size()];
                    int[] dijParents = new int[g.size()];
                    g.dijkstra(src, dijCosts, dijParents);

                    System.out.print(BLUE+"Choose destination node: "+RESET);
                    dis = sc.nextInt();
                    System.out.print(BLUE+"Choose 1 for path cost, 2 for shortest path: "+RESET);
                    op = sc.nextInt();

                    if (op == 1)
                        System.out.println(YELLOW+g.dijkstra_bellman_cost(dijCosts, dis)+RESET);
                    else if (op == 2)
                        System.out.println(YELLOW+g.dijkstra_bellman_path(dijParents, dis)+RESET);
                    else
                        invalidOption(2);
                    break;
                case 2:
                    double[] bellCosts = new double[g.size()];
                    int[] bellParents = new int[g.size()];
                    g.bellman_ford(src, bellCosts, bellParents);

                    System.out.print(BLUE+"Choose destination node: "+RESET);
                    dis = sc.nextInt();
                    System.out.print(BLUE+"Choose 1 for path cost, 2 for shortest path: "+RESET);
                    op = sc.nextInt();

                    if (op == 1)
                        System.out.println(YELLOW+g.dijkstra_bellman_cost(bellCosts, dis)+RESET);
                    else if (op == 2)
                        System.out.println(YELLOW+g.dijkstra_bellman_path(bellParents, dis)+RESET);
                    else
                        invalidOption(2);
                    break;
                case 3:
                    double[][] floydCosts = new double[g.size()][g.size()];
                    int[][] floydParents = new int[g.size()][g.size()];
                    g.floyd_warshall(floydCosts, floydParents);

                    System.out.print(BLUE+"Choose destination node: "+RESET);
                    dis = sc.nextInt();
                    System.out.print(BLUE+"Choose 1 for path cost, 2 for shortest path: "+RESET);
                    op = sc.nextInt();

                    if (op == 1)
                        System.out.println(YELLOW+g.floyd_warshall_cost(floydCosts, src, dis)+RESET);
                    else if (op == 2)
                        System.out.println(YELLOW+g.floyd_warshall_path(floydParents, src, dis)+RESET);
                    else
                        invalidOption(2);
                    break;
                case 4:
                    return;
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
            System.out.print(BLACK+BLUE_BACKGROUND+"Select an algorithm: "+RESET);
            algorithm = sc.nextInt();

            switch (algorithm) {
                case 1:
                    double[][] dijCosts = new double[g.size()][g.size()];
                    int[][] dijParents = new int[g.size()][g.size()];
                    for (int i = 0; i < g.size(); i++)
                        g.dijkstra(i, dijCosts[i], dijParents[i]);

                    while (true) {
                        System.out.print(BLUE+"Choose 1 for path cost, 2 for shortest path, 3 for exit: "+RESET);
                        op = sc.nextInt();

                        if (op == 1) {
                            System.out.print(BLUE+"Choose source node: "+RESET);
                            src = sc.nextInt();
                            System.out.print(BLUE+"Choose destination node: "+RESET);
                            dis = sc.nextInt();
                            System.out.println(YELLOW+g.dijkstra_bellman_cost(dijCosts[src], dis)+RESET);
                        } else if (op == 2){
                            System.out.print(BLUE+"Choose source node: "+RESET);
                            src = sc.nextInt();
                            System.out.print(BLUE+"Choose destination node: "+RESET);
                            dis = sc.nextInt();
                            System.out.println(YELLOW+g.dijkstra_bellman_path(dijParents[src], dis)+RESET);
                        } else if (op == 3)
                            return;
                        else
                            invalidOption(3);
                        System.out.println();
                    }
                case 2:
                    double[][] bellCosts = new double[g.size()][g.size()];
                    int[][] bellParents = new int[g.size()][g.size()];
                    for (int i = 0; i < g.size(); i++)
                        g.bellman_ford(i, bellCosts[i], bellParents[i]);

                    while (true) {
                        System.out.print(BLUE+"Choose 1 for path cost, 2 for shortest path, 3 for exit: "+RESET);
                        op = sc.nextInt();

                        if (op == 1) {
                            System.out.print(BLUE+"Choose source node: "+RESET);
                            src = sc.nextInt();
                            System.out.print(BLUE+"Choose destination node: "+RESET);
                            dis = sc.nextInt();
                            System.out.println(YELLOW+g.dijkstra_bellman_cost(bellCosts[src], dis)+RESET);
                        } else if (op == 2) {
                            System.out.print(BLUE+"Choose source node: "+RESET);
                            src = sc.nextInt();
                            System.out.print(BLUE+"Choose destination node: "+RESET);
                            dis = sc.nextInt();
                            System.out.println(YELLOW+g.dijkstra_bellman_path(bellParents[src], dis)+RESET);
                        } else if (op == 3)
                            return;
                        else
                            invalidOption(3);
                        System.out.println();
                    }
                case 3:
                    double[][] floydCosts = new double[g.size()][g.size()];
                    int[][] floydParents = new int[g.size()][g.size()];
                    g.floyd_warshall(floydCosts, floydParents);

                    while (true) {
                        System.out.print(BLUE+"Choose 1 for path cost, 2 for shortest path, 3 for exit: "+RESET);
                        op = sc.nextInt();

                        if (op == 1) {
                            System.out.print(BLUE+"Choose source node: "+RESET);
                            src = sc.nextInt();
                            System.out.print(BLUE+"Choose destination node: "+RESET);
                            dis = sc.nextInt();
                            System.out.println(YELLOW + g.floyd_warshall_cost(floydCosts, src, dis) + RESET);
                        } else if (op == 2) {
                            System.out.print(BLUE+"Choose source node: "+RESET);
                            src = sc.nextInt();
                            System.out.print(BLUE+"Choose destination node: "+RESET);
                            dis = sc.nextInt();
                            System.out.println(YELLOW+g.floyd_warshall_path(floydParents, src, dis)+RESET);
                        } else if (op == 3)
                            return;
                        else
                            invalidOption(3);
                        System.out.println();
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
            System.out.print(BLACK+BLUE_BACKGROUND+"Select an algorithm: "+RESET);
            algorithm = sc.nextInt();

            switch (algorithm) {
                case 1:
                    double[] bellCosts = new double[g.size()];
                    int[] bellParents = new int[g.size()];
                    if (g.bellman_ford(0, bellCosts, bellParents))
                        System.out.println(RED+"There is negative cycle!"+RESET);
                    else
                        System.out.println(YELLOW+"No negative cycles"+RESET);
                    break;
                case 2:
                    double[][] floydCosts = new double[g.size()][g.size()];
                    int[][] floydParents = new int[g.size()][g.size()];
                    if (g.floyd_warshall(floydCosts, floydParents))
                        System.out.println(RED+"There is negative cycle!"+RESET);
                    else
                        System.out.println(YELLOW+"No negative cycles"+RESET);
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
