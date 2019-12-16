///
/// Contents: Example of using JPanel to draw shapes.
/// Author:   John Aronis
/// Date:     September 2018
///

import java.awt.* ;
import javax.swing.* ;

public class Cloth extends JPanel {

  public Color BACKGROUND_COLOR  = Color.blue ;
  public Color LINE_COLOR        = Color.black ;
  public Color RECTANGLE_COLOR   = Color.yellow ;
  public Color BORDER_COLOR      = Color.black ;
  public int   TEXT_OFFSET       = 6 ;

  public int width, height, pixels ;

  public Cloth(int w, int h, int p) {
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

  public void drawCut(Cut c) {
    Graphics g = this.getGraphics() ;
    g.setColor(LINE_COLOR) ;
    g.drawLine(c.getX1()*pixels,c.getY1()*pixels,c.getX2()*pixels,c.getY2()*pixels) ;
  }

  public void drawGarment(Garment garm) {
    Graphics g = this.getGraphics() ;
    g.setColor(RECTANGLE_COLOR) ;
    g.fillRect(garm.getX()*pixels,garm.getY()*pixels,garm.getWidth()*pixels,garm.getHeight()*pixels) ;
    g.setColor(BORDER_COLOR) ;
    g.drawRect(garm.getX()*pixels,garm.getY()*pixels,garm.getWidth()*pixels,garm.getHeight()*pixels) ;
    g.drawString(garm.getName(),garm.getX()*pixels+TEXT_OFFSET,garm.getY()*pixels+2*TEXT_OFFSET) ;
  }

}

/// End-of-File