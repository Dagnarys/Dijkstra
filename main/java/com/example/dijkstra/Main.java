package com.example.dijkstra;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;


import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import static com.example.dijkstra.MainActivity.Begin;
import static com.example.dijkstra.MainActivity.End;


public class Main {



    private static void getRoute(int[] prev, int i, List<Integer> route)
    {
        if (i >= 0) {
            getRoute(prev, prev[i], route);
            route.add(i);
        }
    }

    // Run Dijkstra's algorithm on given graph

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static String shortestPath(Graph graph, int source, int N) {
        // create min heap and push source node having distance 0
        PriorityQueue<Node> minHeap;
        minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        minHeap.add(new Node(source, 0));

        // set infinite distance from source to v initially
        List<Integer> dist = new ArrayList<>(Collections.nCopies(N, Integer.MAX_VALUE));

        // distance from source to itself is zero
        dist.set(source, 0);

        // boolean array to track vertices for which minimum
        // cost is already found
        boolean[] done = new boolean[N];
        done[source] = true;

        // stores predecessor of a vertex (to print path)
        int[] prev = new int[N];
        prev[source] = -1;

        List<Integer> route = new ArrayList<>();

        // run till min heap is empty
        while (!minHeap.isEmpty()) {
            // Remove and return best vertex
            Node node = minHeap.poll();

            // get vertex number
            int u = node.vertex;

            // do for each neighbor v of u
            for (Edge edge : graph.adjList.get(u)) {
                int v = edge.dest;
                int weight = edge.weight;

                // Relaxation step
                if (!done[v] && (dist.get(u) + weight) < dist.get(v)) {
                    dist.set(v, dist.get(u) + weight);
                    prev[v] = u;
                    minHeap.add(new Node(v, dist.get(v)));
                }
            }

            // marked vertex u as done so it will not get picked up again
            done[u] = true;
        }




        int i=Integer.parseInt(End);//finish
        {
            String S;
            if (i != source && dist.get(i) != Integer.MAX_VALUE) {
                getRoute(prev, i, route);
                S = "\nPath (" + source + " -> " + i + "): Minimum Cost = " + dist.get(i) + " and Route is " + route;
                System.out.println(S);
                route.clear();




            }
            else
            {
                S = "Ошибка";
            }
            return S;
        }


    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public static String main()
    {

        int source=Integer.parseInt(Begin);//start
        int N =10;

        // initialize edges as per above diagram
        // (u, v, w) triplet represent undirected edge from
        // vertex u to vertex v having weight w
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1, 1),
                new Edge(1, 0, 1),
                new Edge(1, 2, 1),
                new Edge(2, 1, 1),
                new Edge(0, 3, 1),
                new Edge(3, 0, 1),
                new Edge(3, 4, 1),
                new Edge(4, 3, 1),
                new Edge(2, 4, 1),
                new Edge(4, 2, 1),
                new Edge(1, 3, 1),
                new Edge(3, 1, 1)
        );

        // Set number of vertices in the graph

        // construct graph
        Graph graph = new Graph(edges, N);
        String S = shortestPath(graph, source, N);

        return S;
    }




}

