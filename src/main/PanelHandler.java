import javax.swing.*;
import java.awt.*;
import itinerary.Itinerary;

public class PanelHandler
{

    private JFrame mainFrame;

    public PanelHandler()
    {
        this.mainFrame = new JFrame("DCPlanner - Home");
        this.mainFrame.getContentPane().add(new StartScreen(this).getMainPanel());
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.pack();
        this.mainFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.mainFrame.setVisible(true);
    }

    public void pushPanel(String panelName)
    {
        this.mainFrame.getContentPane().removeAll();
        if (panelName.equals("startPanel"))
        {
            this.mainFrame.getContentPane().add(new StartScreen(this).getMainPanel());
            this.mainFrame.setTitle("DCPlanner - Home");
        }
        else if (panelName.equals("loginPanel"))
        {
            this.mainFrame.getContentPane().add(new LoginScreen(this).getMainPanel());
            this.mainFrame.setTitle("DCPlanner - Login");
        }
        else if (panelName.equals("registerPanel"))
        {
            this.mainFrame.getContentPane().add(new RegisterScreen(this).getMainPanel());
            this.mainFrame.setTitle("DCPlanner - Register");
        }
        else if (panelName.equals("adminPanel"))
        {
            this.mainFrame.getContentPane().add(new AdminScreen(this).getMainPanel());
            this.mainFrame.setTitle("DCPlanner - Admin Control Panel");
        }
        else if (panelName.equals("createActivityPanel"))
        {
            this.mainFrame.getContentPane().add(new CreateActivityScreen(this).getMainPanel());
            this.mainFrame.setTitle("DCPlanner - Create Activity");
        }
        else if (panelName.equals("createRestaurantPanel"))
        {
            this.mainFrame.getContentPane().add(new CreateRestaurantScreen(this).getMainPanel());
            this.mainFrame.setTitle("DCPlanner - Create Restaurant");
        }
        else if (panelName.equals("plan1Panel"))
        {
            this.mainFrame.getContentPane().add(new PlanScreen1(this).getMainPanel());
            this.mainFrame.setTitle("DCPlanner - Step One");
        }
        this.mainFrame.getContentPane().revalidate();
        this.mainFrame.getContentPane().repaint();
    }

    public void pushPanel(String panelName, Itinerary currentItinerary)
    {
        this.mainFrame.getContentPane().removeAll();
        if (panelName.equals("plan2Panel"))
        {
            this.mainFrame.getContentPane().add(new PlanScreen2(this, currentItinerary).getMainPanel());
            this.mainFrame.setTitle("DCPlanner - Step Two");
        }
        else if (panelName.equals("plan3Panel"))
        {
            this.mainFrame.getContentPane().add(new PlanScreen3(this, currentItinerary).getMainPanel());
            this.mainFrame.setTitle("DCPlanner - Step Three");
        }
        this.mainFrame.getContentPane().revalidate();
        this.mainFrame.getContentPane().repaint();
    }

}
