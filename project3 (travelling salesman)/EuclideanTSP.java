import java.util.ArrayList;
import java.util.LinkedList;

public class EuclideanTSP {

    //creates a fully connected graph
    public static ArrayList<Edge> MST(ArrayList<City> cities){
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i< cities.size(); i++) {
            for(int j = 0; j< cities.size(); j++){
                Edge e = new Edge(cities.get(i),cities.get(j));
                edges.add(e);
                //System.out.println("city x value: " +e.city1.x + "\n edge value: " + e.weight);

                //System.out.println("edge num: " + edges.size());
            }

        }

        return edges;
    }

    //creates an MST
    public static ArrayList<City> MSTTour(ArrayList<Edge> edges){

        //add the first city from list of edges to the visited cities list
        ArrayList<String> visitedCities = new ArrayList<>();
        visitedCities.add(edges.get(0).city1.cityName);

        Edge e = edges.get(0);
        int lowestWeight = 0;
        Edge edgeWithLowestWeight = edges.get(0);
        ArrayList<City> returnCities = new ArrayList<>();


       for(int i = 0; i<edges.size(); i++){
            e = edges.get(i);


            // if we switched to next city, add the city with the edge to the city array and reset edge with lowest weight
            if(edgeWithLowestWeight.city1.y != e.city1.y || edgeWithLowestWeight.city1.x != e.city1.x && !returnCities.contains(e.city2.cityName) && !returnCities.contains(e.city1.cityName)){
                returnCities.add(edgeWithLowestWeight.city1);
                returnCities.add(edgeWithLowestWeight.city2);
                visitedCities.add(e.city2.cityName);
                edgeWithLowestWeight = e;
            }

            //find the lowest weighted edge by distance between cities not randomly generated weight
            if(e.length != 0 && e.length < edgeWithLowestWeight.length && !returnCities.contains(e.city2.cityName) && !returnCities.contains(e.city1.cityName) ){
                edgeWithLowestWeight = e;
            }


        }

        return returnCities;
    }

    public static double weight(ArrayList<Edge> edges) {
        double totalWeight = 0;
        for(int i = 0; i<edges.size(); i++){
            totalWeight += edges.get(i).weight;
        }
        return totalWeight;
    }

    public static double length(ArrayList<City> cities) {
        double totalLength = 0;
        for(int i = 0; i<cities.size()-1; i++){
            double xLength = Math.abs(cities.get(i).x - cities.get(i+1).x);
            double yLength = Math.abs(cities.get(i).y - cities.get(i+1).y);
            totalLength = xLength + yLength;
        }
        return totalLength;
    }

}
