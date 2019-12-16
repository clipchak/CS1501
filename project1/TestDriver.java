//Colton Lipchak (cjl99)

import java.util.ArrayList;
public class TestDriver{
  public static int[][] memo;
  
  public static void main(String[] args){
    ArrayList<Pattern> patterns = new ArrayList<Pattern>() ;
    patterns.add(new Pattern(2,2,1,"A")) ;
    patterns.add(new Pattern(2,6,4,"B")) ;
    patterns.add(new Pattern(4,2,3,"C")) ;
    patterns.add(new Pattern(5,3,5,"D")) ;
    int width = 40 ;
    int height = 25 ;
    int pixels = 30 ;
    initializeMemo(width,height,patterns);
    System.out.println("Value of optimal layout: " + optimal(memo.length,memo[0].length,patterns));
  //  printMemo(width,height);
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
    int max = 0; //initialize max variable
    
    // 2 loops - go from width and height of 2d array
    for(int i = 0; i<width; i++){
      for(int j = 0; j<height; j++){
        max=0;
        
        //find max horizontally from 0 to i/2
        for(int h = 0; h<=i/2; h++){
          if(i==width-1){
        //    System.out.println(memo[h][j] + "," + memo[i-h][j]);
           // System.out.println(memo[h][j]);
          }
          if(max<(memo[h][j]+memo[i-h][j])){
            max=(memo[h][j]+memo[i-h][j]);
           // System.out.println("[ " + i + " , " + j + " ]");
          }
        }
        
        //find max vertically from 0 to j/2
        for(int v = 0; v<=j/2; v++){
          if(i==width-1){
           // System.out.println(memo[i][v]);
          }
          if(max<(memo[i][v]+memo[i][j-v])){
            max=(memo[i][v]+memo[i][j-v]);
        //    System.out.println("[ " + i + " , " + j + " ]");
          }
        }
        //System.out.println(max);
        memo[i][j]=max;    //max price stored into clothMatrix 2d array 
      }
    }
    return max;
    
  }
  
  public static void printMemo(int width, int height){
    for(int i = 0; i<memo.length; i++){
      for(int j = 0; j<memo[0].length; j++){
       System.out.println("memoArray[" + i + "][" + j + "] Value: " +memo[i][j]);
      }
    }
  }
}