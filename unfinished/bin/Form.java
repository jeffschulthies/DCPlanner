package unfinished.bin;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class Form extends JFrame
{
   public Form()
   {
      JPanel panel = new JPanel();
      panel.setLayout(new BorderLayout());
      
      JButton button1 = new JButton("Restaurant");
      JButton button2 = new JButton("Option");
      JButton button3 = new JButton("Option");
      JButton button0 = new JButton("Exit");
      
      this.setLayout(new GridLayout(3, 3));
      
      panel.add(button1, BorderLayout.EAST);
      panel.add(button2, BorderLayout.SOUTH);
      panel.add(button3, BorderLayout.WEST);
      panel.add(button0, BorderLayout.WEST);
      
      this.add(button1);
      this.add(button2);
      this.add(button3);
      this.add(button0);
      
      this.setSize(300, 300);
      
   }
}