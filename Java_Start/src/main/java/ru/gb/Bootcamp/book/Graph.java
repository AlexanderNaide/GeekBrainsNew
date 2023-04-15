package ru.gb.Bootcamp.book;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private List<List<Integer>> adjList;

    public Graph(List<Edge> list, int n) {
        adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (Edge edge : list) {
            int src = edge.source;
            int dest = edge.dest;

            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
    }

    public static void main(String[] args) {

    }

    public static class Edge{
        int source;
        int dest;

        public Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }
    }
}


