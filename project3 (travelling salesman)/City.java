public class City {
    public String cityName;
    public double x;
    public double y;
    public static int numOfCities = 0;
    public int vertexValue;

    public City(String cityName, double cityX, double cityY){
        //set name and coordinates of city
        this.cityName = cityName;
        x = cityX;
        y = cityY;

        //set a vertex value for particular city to be used in adjacency list
        vertexValue = numOfCities;

        numOfCities++;

    }

}
