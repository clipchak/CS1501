public class Pattern{
 
  public int width, height, value;
  public String name;
  
  public Pattern(int w, int h, int v, String n){
   width = w;
   height = h;
   value = v;
   name = n;
  }
  public int getWidth(){
    return width;
  }
  public int getHeight(){
    return height;
  }
  public int getValue(){
    return value;
  }
  public String getName(){
    return name;
  }
  public String toString(){
   return name; 
  }
  
}