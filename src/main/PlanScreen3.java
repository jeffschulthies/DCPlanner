import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import itinerary.Itinerary;
import location.types.Activity;

public class PlanScreen3
{

    private PanelHandler handler;
    private JPanel mainPanel;
    private JPanel activityPanel;
    private JButton previousButton;
    private JButton nextButton;
    private JButton addButton;
    private JLabel insertNameLabel;
    private JLabel insertAddressLabel;
    private JLabel insertDescriptionLabel;
    private JLabel insertPriceLabel;
    private JLabel descriptionLabel;
    private JLabel priceLabel;
    private Itinerary currentItinerary;
    private ArrayList<Activity> potentialActivityList;
    private int currentTime;
    private int currentActivityIndex;

    public PlanScreen3(PanelHandler panels, Itinerary parentItinerary)
    {
        this.handler = panels;
        this.currentItinerary = parentItinerary;
        this.currentTime = this.currentItinerary.getTripStartTime();
        this.currentActivityIndex = 0;
        this.parseActivities();
        this.setLabels();
        this.nextButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (currentActivityIndex != potentialActivityList.size() - 1)
                {
                    currentActivityIndex++;
                    setLabels();
                }
            }
        });
        this.previousButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (currentActivityIndex != 0)
                {
                    currentActivityIndex--;
                    setLabels();
                }
            }
        });
    }

    public JPanel getMainPanel()
    {
        return this.mainPanel;
    }

    public void setLabels()
    {
        this.insertNameLabel.setText(this.potentialActivityList.get(this.currentActivityIndex).getName());
        this.insertAddressLabel.setText(this.potentialActivityList.get(this.currentActivityIndex).getAddress());
        this.insertDescriptionLabel.setText(this.potentialActivityList.get(this.currentActivityIndex).getDescription());
        this.insertPriceLabel.setText(Double.toString(this.potentialActivityList.get(this.currentActivityIndex).getPrice()));
    }

    public void parseActivities()
    {
        FileManager file = new FileManager();
        this.potentialActivityList = file.readActivityFiles();
        for (int i = 0; i < this.potentialActivityList.size(); i++)
        {
            boolean fitsUserPrefs = false;
            for (int j = 0; j < this.potentialActivityList.get(i).getNumTags(); j++)
            {
                if (compareTags(i, j))
                {
                    fitsUserPrefs = true;
                }
            }
            if (this.currentItinerary.getFreeOnly() && this.potentialActivityList.get(i).getPrice() > 0)
            {
                fitsUserPrefs = false;
            }
            if (!fitsUserPrefs)
            {
                this.potentialActivityList.remove(i);
                i--;
            }
        }
    }

    public boolean compareTags(int activityIndex, int tagIndex)
    {
        for (int i = 0; i < this.currentItinerary.getTripTags().size(); i++)
        {
            if (this.potentialActivityList.get(activityIndex).getTag(tagIndex).equals(this.currentItinerary.getTripTags().get(i)))
            {
                return true;
            }
        }
        return false;
    }

}
