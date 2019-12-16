///
/// Contents: Test graphics example.
/// Author:   John Aronis
/// Date:     September 2018
///

import javax.swing.* ;
import java.util.Date ;

public class TestGraphicsExample {

  public static int SYNC = 500 ;   // To fix synchronization problem on some linux systems.

  public static void main(String[] args) {
    GraphicsExample example = new GraphicsExample(50,30,30) ;
    JFrame frame = new JFrame("Graphics Example") ;
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
    frame.getContentPane().add(example) ;
    frame.pack() ;
    frame.setVisible(true) ;
    sleep(SYNC) ;
    example.drawLine(5,10,10,20) ;
    sleep(SYNC) ;
    example.drawRectangle(15,5,10,15,"A Rectangle") ;
  }

  public static void sleep(long milliseconds) {
    Date d ;
    long start, now ;
    d = new Date() ;
    start = d.getTime() ;
    do { d = new Date() ; now = d.getTime() ; } while ( (now - start) < milliseconds ) ;
  }

}

/// End-of-File
