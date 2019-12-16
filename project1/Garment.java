public class Garment{
 
  public int xPosition, yPosition, width, height, value;
  
  public String name;
  
  public Garment(int x, int y, int w, int h, int v, String n){
   xPosition = x;
   yPosition = y;
   width = w;
   height = h;
   value = v;
   name = n;
  }
  
  public int getX(){
   return xPosition;
 }
  public int getY(){
   return yPosition;
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
   return "[" + name + "," + xPosition + "," + yPosition + "]"; 
  }
}