package unfinished.bin;

import javax.swing.JFrame;
class gui
{
   public static void main(String[] args)   //we have to do "extends" to classes
   {
      Form frame = new Form();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("Restaurant search");
      frame.setVisible(true);
      
   }
}