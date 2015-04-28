import location.types.Activity;
import location.types.Restaurant;
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
    private JButton createRestaurantButton;
    private JButton printRestaurantsButton;
    private ArrayList<Activity> activityList;
    private ArrayList<Restaurant> restaurantList;

    public AdminScreen(PanelHandler panels) throws Exception
    {
        this.handler = panels;
        this.testPlansButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try {
                    handler.pushPanel("plan1Panel");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        this.createActivityButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try {
                    handler.pushPanel("createActivityPanel");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        this.createRestaurantButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try {
                    handler.pushPanel("createRestaurantPanel");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
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
                    System.out.println("\tLongitude: " + activityList.get(i).getLongitude());
                    System.out.println("\tLatitude: " + activityList.get(i).getLatitude());
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
        this.printRestaurantsButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                FileManager files = new FileManager();
                restaurantList = files.readRestaurantFiles();
                for (int i = 0; i < restaurantList.size(); i++) {
                    System.out.println(restaurantList.get(i).getName() + ":");
                    System.out.println("\tAddress: " + restaurantList.get(i).getAddress());
                    System.out.println("\tID: " + restaurantList.get(i).getID());
                    System.out.println("\tDescription: " + restaurantList.get(i).getDescription());
                    System.out.println("\tLongitude: " + restaurantList.get(i).getLongitude());
                    System.out.println("\tLatitude: " + restaurantList.get(i).getLatitude());
                    System.out.println("\tOpen: " + restaurantList.get(i).getOpenHour());
                    System.out.println("\tClose: " + restaurantList.get(i).getCloseHour());
                    System.out.println("\tType: " + restaurantList.get(i).getType());
                    System.out.println("\tPrice Range: " + restaurantList.get(i).getPriceRange());
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
