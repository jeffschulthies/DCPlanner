import location.types.Activity;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminScreen
{

    private PanelHandler handler;
    private JPanel mainPanel;
    private JButton testPlansButton;
    private JButton createActivityButton;
    private JButton printActivitiesButton;
    private ArrayList<Activity> activityList;

    public AdminScreen(PanelHandler panels)
    {
        this.handler = panels;
        this.testPlansButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                handler.pushPanel("plan1Panel");
            }
        });
        this.createActivityButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                handler.pushPanel("createActivityPanel");
            }
        });
        this.printActivitiesButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                FileManager files = new FileManager();
                activityList = files.readActivityFiles();
                for (int i = 0; i < activityList.size(); i++)
                {
                    System.out.println(activityList.get(i).getName() + ":");
                    System.out.println("\tAddress: " + activityList.get(i).getAddress());
                    System.out.println("\tID: " + activityList.get(i).getID());
                    System.out.println("\tDescription: " + activityList.get(i).getDescription());
                    System.out.println("\tOpen: " + activityList.get(i).getOpenHour());
                    System.out.println("\tClose: " + activityList.get(i).getCloseHour());
                    System.out.println("\tTags: ");
                    for (int j = 0; j < activityList.get(i).getNumTags(); j++)
                    {
                        System.out.println("\t\t" + activityList.get(i).getTag(j));
                    }
                    System.out.println("\tPrice: " + activityList.get(i).getPrice());
                    System.out.println();
                }
            }
        });
    }

    public JPanel getMainPanel()
    {
        return this.mainPanel;
    }

}
