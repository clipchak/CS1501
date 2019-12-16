import java.util.ArrayList ;
public class ClothCutter{
  public static int[][] memo;
  public int width, height;
  public ArrayList<Pattern> patterns;
  
  public ClothCutter(int width,int height,ArrayList<Pattern> patterns){
    this.width = width;
    this.height = height;
    this.patterns = patterns;
  }
  
  public static void initializeMemo(int width, int height, ArrayList<Pattern> patterns){
    width++;
    height++;
    
    memo = new int[width][height];
    
    for(int i = 0 ; i<patterns.size(); i++){      // for loop to initialize already known pattern values
      Pattern helper = patterns.get(i);
      memo[helper.getWidth()][helper.getHeight()] = helper.getValue();
    }
  }
  
  public static int optimal(int width, int height, ArrayList<Pattern> patterns){
    width++; 
    height++;
    
    int max = 0; //initialize max variable
    
    // 2 loops - go from width and height of 2d array
    for(int i = 0; i<width; i++){
      for(int j = 0; j<height; j++){
        max=0;
        
        //find max horizontally from 0 to i/2
        for(int h = 0; h<=i/2; h++){
          if(max<(memo[h][j]+memo[i-h][j])){
            max=(memo[h][j]+memo[i-h][j]);
            Garment c = new Garment(i,j,i,j,max,"A");
           // System.out.println("[ " + i + " , " + j + " ]");
          }
        }
        
        //find max vertically from 0 to j/2
        for(int v = 0; v<=j/2; v++){
          if(max<(memo[i][v]+memo[i][j-v])){
            max=(memo[i][v]+memo[i][j-v]);
        //    System.out.println("[ " + i + " , " + j + " ]");
          }
        }
        
        memo[i][j]=max;    //max price stored into clothMatrix 2d array 
      }
    }
    return max;
  }
  
  //needs   public int xPosition, yPosition, width, height, value;
  public static Garment[] garments(){
    Garment[] a = new Garment[10];
    return a;
  }
  
  public static Cut[] cuts(){
    Cut[] retval = new Cut[10];
    return retval;
  }
  
  public static int value(){
    return 0;
  }
  
}



