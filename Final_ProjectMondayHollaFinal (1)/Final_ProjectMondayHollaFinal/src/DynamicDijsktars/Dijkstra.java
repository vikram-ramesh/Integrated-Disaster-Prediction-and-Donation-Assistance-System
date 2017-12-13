package DynamicDijsktars;

import java.util.*;

public class Dijkstra {

    private static Graph g;

    public void create(int size) throws Exception {

        // Create a new graph.
        g = new Graph(size);

        // Add the required edges.
//        //Dynamic addition
        Map<Integer, String> zipcode = new HashMap();
        Utility.addZipcode(zipcode);
//
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                if (i != j) {
//                    Double[] latlongVi = Utility.getLatLongPositions(zipcode.get(i));
//                    Double[] latlongVj = Utility.getLatLongPositions(zipcode.get(j));
//                    g.addEdge(i, j, Utility.distance(latlongVi[0], latlongVi[1], latlongVj[0], latlongVj[1], "K"));
//                    System.out.println(" Source-->" + i + "Dest-->" + j +"--->"
//                            + Utility.distance(latlongVi[0], latlongVi[1], latlongVj[0], latlongVj[1], "K"));
//                }
//                Thread.sleep(1000);
//            }
//        }

        Double[] latlongV0 = Utility.getLatLongPositions(zipcode.get(0));
        System.out.println("Lat long for city one" + latlongV0[0] + "" + latlongV0[1]);
        Double[] latlongV1 = Utility.getLatLongPositions(zipcode.get(1));

        System.out.println("Lat long for city one" + latlongV1[0] + "" + latlongV1[1]);

        Double[] latlongV4 = Utility.getLatLongPositions(zipcode.get(4));

        System.out.println("Lat long for city one" + latlongV4[0] + "" + latlongV4[1]);
        Double[] latlongV3 = Utility.getLatLongPositions(zipcode.get(3));
        System.out.println("Lat long for city one" + latlongV3[0] + "" + latlongV3[1]);
        Double[] latlongV2 = Utility.getLatLongPositions(zipcode.get(2));
        System.out.println("Lat long for city one" + latlongV2[0] + "" + latlongV2[1]);

        System.out.println("Distance between city 0 and city 1" + Utility.distance(latlongV0[0], latlongV0[1], latlongV1[0], latlongV1[1], "K"));

        System.out.println("Distance between city 0 and city 4-->" + Utility.distance(latlongV0[0], latlongV0[1], latlongV4[0], latlongV4[1], "K"));
        System.out.println("Distance between city 1 and city 2-->" + Utility.distance(latlongV1[0], latlongV1[1], latlongV2[0], latlongV2[1], "K"));
        System.out.println("Distance between city 1 and city 3-->" + Utility.distance(latlongV1[0], latlongV1[1], latlongV3[0], latlongV3[1], "K"));

        System.out.println("Distance between city 3 and city 4-->" + Utility.distance(latlongV3[0], latlongV3[1], latlongV4[0], latlongV4[1], "K"));
        System.out.println("Distance between city 2 and city 4-->" + Utility.distance(latlongV2[0], latlongV2[1], latlongV4[0], latlongV4[1], "K"));
        System.out.println("Distance between city 2 and city 3-->" + Utility.distance(latlongV2[0], latlongV2[1], latlongV3[0], latlongV3[1], "K"));

        g.addEdge(0, 1, Utility.distance(latlongV0[0], latlongV0[1], latlongV1[0], latlongV1[1], "K"));
        g.addEdge(1, 0, Utility.distance(latlongV1[0], latlongV1[1], latlongV0[0], latlongV0[1], "K"));
        g.addEdge(0, 4, Utility.distance(latlongV0[0], latlongV0[1], latlongV4[0], latlongV4[1], "K"));
        g.addEdge(4, 0, Utility.distance(latlongV4[0], latlongV4[1], latlongV0[0], latlongV0[1], "K"));
        g.addEdge(1, 2, Utility.distance(latlongV1[0], latlongV1[1], latlongV2[0], latlongV2[1], "K"));
        g.addEdge(2, 1, Utility.distance(latlongV2[0], latlongV2[1], latlongV1[0], latlongV1[1], "K"));
        g.addEdge(1, 3, Utility.distance(latlongV1[0], latlongV1[1], latlongV3[0], latlongV3[1], "K"));
        g.addEdge(3, 1, Utility.distance(latlongV3[0], latlongV3[1], latlongV1[0], latlongV1[1], "K"));
        g.addEdge(3, 4, Utility.distance(latlongV3[0], latlongV3[1], latlongV4[0], latlongV4[1], "K"));
        g.addEdge(4, 3, Utility.distance(latlongV4[0], latlongV4[1], latlongV3[0], latlongV3[1], "K"));
        g.addEdge(2, 4, Utility.distance(latlongV2[0], latlongV2[1], latlongV4[0], latlongV4[1], "K"));
        g.addEdge(4, 2, Utility.distance(latlongV4[0], latlongV4[1], latlongV2[0], latlongV2[1], "K"));
        g.addEdge(2, 3, Utility.distance(latlongV2[0], latlongV2[1], latlongV3[0], latlongV3[1], "K"));
        g.addEdge(3, 2, Utility.distance(latlongV3[0], latlongV3[1], latlongV2[0], latlongV2[1], "K"));
        // Calculate Dijkstra.
        // Print the minimum Distance.
//        for (Vertex v : g.getVertices()) {
//            System.out.print("Vertex - " + v + " , Dist - " + v.minDistance + " , Path - ");
//            LinkedList<Vertex> path1 = v.getPath();
//            for (Vertex pathvert : v.path) {
//                System.out.print(pathvert + " ");
//            }
//            System.out.println("" + v);
//        }

    }

    public Graph addGraph( Graph g) throws Exception {
        Graph newGraph = new Graph(g.getVertices());
        Map<Integer, String> zipcode = new HashMap();
       
        
        Utility.addZipcode(zipcode);

        ArrayList<Integer> tempList = new ArrayList<>();
       
        for(Vertex v : newGraph.getVertices()){
            int n = Integer.parseInt(v.toString().substring(1));
            tempList.add(n);
            System.out.println("Remaining Vertices --->" + n);
                   
        }
        
        for (int v = 0; v <newGraph.getVertices().size();v++) {
            
            for (int v1 = 0; v1 <newGraph.getVertices().size();v1++) {
              
                if (v != v1) {
                    Double[] latlongVi = Utility.getLatLongPositions(zipcode.get(v));
                    Double[] latlongVj = Utility.getLatLongPositions(zipcode.get(v1));
                    g.addEdge(v, v1, Utility.distance(latlongVi[0], latlongVi[1], latlongVj[0], latlongVj[1], "K"));
                    System.out.println(" Source-->" + v + "Dest-->" + v1 + "--->"
                            + Utility.distance(latlongVi[0], latlongVi[1], latlongVj[0], latlongVj[1], "K"));
                     Thread.sleep(1000);
                }
            }
            Thread.sleep(1000);
            
        }
        return newGraph;
    }
//
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                if (i != j) {
//                    Double[] latlongVi = Utility.getLatLongPositions(zipcode.get(i));
//                    Double[] latlongVj = Utility.getLatLongPositions(zipcode.get(j));
//                    g.addEdge(i, j, Utility.distance(latlongVi[0], latlongVi[1], latlongVj[0], latlongVj[1], "K"));
//                    System.out.println(" Source-->" + i + "Dest-->" + j +"--->"
//                            + Utility.distance(latlongVi[0], latlongVi[1], latlongVj[0], latlongVj[1], "K"));
//                }
//                Thread.sleep(1000);
//            }
//        }

    

    public void printPath(Graph g) {
        for (Vertex v : g.getVertices()) {
            System.out.print("Vertex - " + v + " , Dist - " + v.minDistance + " , Path - ");
            LinkedList<Vertex> path1 = v.getPath();
            for (Vertex pathvert : v.path) {
                System.out.print(pathvert + " ");
            }
            System.out.println("" + v);
        }
    }

    public Graph getG() {
        return g;
    }

    public void calculate(Vertex source) {
        // Algo:
        // 1. Take the unvisited node with minimum weight.
        // 2. Visit all its neighbours.
        // 3. Update the distances for all the neighbours (In the Priority Queue).
        // Repeat the process till all the connected nodes are visited.

        source.minDistance = 0;
        PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
        queue.add(source);

        while (!queue.isEmpty()) {

            Vertex u = queue.poll();

            for (Edge neighbour : u.neighbours) {
                Double newDist = u.minDistance + neighbour.weight;

                if (neighbour.target.minDistance > newDist) {
                    // Remove the node from the queue to update the distance value.
                    queue.remove(neighbour.target);
                    neighbour.target.minDistance = newDist;

                    // Take the path visited till now and add the new node.s
                    neighbour.target.path = new LinkedList<Vertex>(u.path);
                    neighbour.target.path.add(u);

                    //Reenter the node with new distance.
                    queue.add(neighbour.target);
                }
            }
        }
    }

}
