///
/// Contents: Example of using JPanel to draw shapes.
/// Author:   John Aronis
/// Date:     September 2018
///

import java.awt.* ;
import javax.swing.* ;

public class GraphicsExample extends JPanel {

  public Color BACKGROUND_COLOR  = Color.blue ;
  public Color LINE_COLOR        = Color.black ;
  public Color RECTANGLE_COLOR   = Color.yellow ;
  public Color BORDER_COLOR      = Color.black ;
  public int   TEXT_OFFSET       = 6 ;

  public int width, height, pixels ;

  public GraphicsExample(int w, int h, int p) {
    width = w ;
    height = h ;
    pixels = p ;
    setPreferredSize(new Dimension(width*pixels,height*pixels)) ;
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g) ;
    g.setColor(BACKGROUND_COLOR) ;
    g.fillRect(0,0,width*pixels,height*pixels) ;
  }

  public void drawLine(int x1, int y1, int x2, int y2) {
    Graphics g = this.getGraphics() ;
    g.setColor(LINE_COLOR) ;
    g.drawLine(x1*pixels,y1*pixels,x2*pixels,y2*pixels) ;
  }

  public void drawRectangle(int x, int y, int width, int height, String label) {
    Graphics g = this.getGraphics() ;
    g.setColor(RECTANGLE_COLOR) ;
    g.fillRect(x*pixels,y*pixels,width*pixels,height*pixels) ;
    g.setColor(BORDER_COLOR) ;
    g.drawRect(x*pixels,y*pixels,width*pixels,height*pixels) ;
    g.drawString(label,x*pixels+TEXT_OFFSET,y*pixels+2*TEXT_OFFSET) ;
  }

}

/// End-of-File
