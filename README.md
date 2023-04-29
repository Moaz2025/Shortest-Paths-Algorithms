# Shortest-Paths-Algorithms

## Description

Dijkstra, Bellman-Ford, and Floyd-Warshall are three well-known algorithms for finding the shortest paths in a graph. Each algorithm has its strengths and weaknesses, which makes them suitable for different types of graphs and scenarios. In this report, we will compare and analyze the time and space complexities of these algorithms, as well as their performance on graphs of different sizes and densities.

1. Dijkstra's Algorithm:
Dijkstra's algorithm is a greedy algorithm that finds the shortest path between a single source node and all other nodes in a weighted graph with non-negative edge weights. The algorithm works by maintaining a set of visited nodes and a priority queue of unvisited nodes, sorted by their distance from the source node. The algorithm repeatedly extracts the node with the smallest distance from the priority queue and updates the distances of its neighbors. Dijkstra's algorithm has a time complexity of O(E log V) for a graph with E edges and V vertices, using a priority queue based on a binary heap or a Fibonacci heap. The space complexity is O(V) for the distance array and the priority queue.

2. Bellman-Ford Algorithm:
Bellman-Ford algorithm is a dynamic programming algorithm that finds the shortest path between a single source node and all other nodes in a graph with negative or non-negative edge weights. The algorithm works by relaxing all edges V-1 times, where V is the number of vertices in the graph. The relaxation process updates the distance of each node by considering all its incoming edges and choosing the minimum distance. Bellman-Ford algorithm has a time complexity of O(VE) and a space complexity of O(V) for the distance array.

3. Floyd-Warshall Algorithm:
Floyd-Warshall algorithm is a dynamic programming algorithm that finds the shortest path between all pairs of nodes in a graph with negative or non-negative edge weights. The algorithm works by maintaining a distance matrix that stores the shortest distance between every pair of nodes. The algorithm iteratively updates the distance matrix by considering every intermediate node as a possible path between every pair of nodes. Floyd-Warshall algorithm has a time complexity of O(V^3) and a space complexity of O(V^2) for the distance matrix.

## Analysis

- Time complexity:
Dijkstra's algorithm has the best time complexity among the three algorithms, especially for sparse graphs with few edges. Bellman-Ford algorithm has a time complexity of O(VE), which can be much slower than Dijkstra's algorithm for dense graphs with many edges. Floyd-Warshall algorithm has a time complexity of O(V^3), which can be very slow for large graphs.

- Space complexity:
Dijkstra's algorithm has the same space complexity as Bellman-Ford algorithm, which is O(V). Floyd-Warshall algorithm has a higher space complexity of O(V^2) due to the distance matrix.

- Performance on different graph sizes and densities:
Dijkstra's algorithm is very efficient for sparse graphs with few edges, where it can find the shortest path quickly using a priority queue. Bellman-Ford algorithm can handle graphs with negative edge weights, but it can be slower than Dijkstra's algorithm for dense graphs with many edges. Floyd-Warshall algorithm can handle any type of graph, but it can be very slow for large graphs, especially if the graph is dense.

In general, Dijkstra's algorithm is the best choice for finding the shortest path between a single source node and all other nodes in a sparse graph with non-negative edge weights. Bellman-Ford algorithm is suitable for graphs with negative edge weights or when the graph is not too dense. Floyd-Warshall algorithm is suitable for finding the shortest path between all pairs of nodes in any type of graph, but it can be slow for large dense graphs.
