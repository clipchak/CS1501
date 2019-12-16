public class Edge {
    public City city1;
    public City city2;
    public double weight;
    public double length;

    public Edge(City city1, City city2){
        this.city1 = city1;
        this.city2 = city2;

        //the length of an edge given as its distance from the other cities x and y values
        double findLength = 0;
        double xLength = Math.abs(city1.x - city2.x);
        double yLength = Math.abs(city1.y - city2.y);
        findLength = xLength + yLength;

        this.length = findLength;

        //weight of an edge is set randomly as a number from 1-50
        this.weight = (int)(Math.random() * 50 + 1);
    }
}
