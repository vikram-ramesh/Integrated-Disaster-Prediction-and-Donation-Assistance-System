/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicDijsktars;

import java.util.*;

public class Graph {

    private ArrayList<Vertex> vertices;

    public Graph(int numberVertices) {
        vertices = new ArrayList<Vertex>(numberVertices);
        for (int i = 0; i < numberVertices; i++) {
            vertices.add(new Vertex("v" + Integer.toString(i)));
        }
    }
    
    public Graph (ArrayList<Vertex> remaningVertex){
          vertices = new ArrayList<Vertex>(remaningVertex.size());
        for (Vertex v : remaningVertex ) {
            vertices.add(v);
        }
    }
  

    public void addEdge(int src, int dest, double weight) {
        Vertex s = vertices.get(src);
        Edge new_edge = new Edge(vertices.get(dest), weight);
        s.neighbours.add(new_edge);
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    public Vertex getVertex(int vert) {
        return vertices.get(vert);
    }
}
