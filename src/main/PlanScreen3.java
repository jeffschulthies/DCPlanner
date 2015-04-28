import javax.swing.*;
import java.util.ArrayList;
import itinerary.Itinerary;
import location.types.Activity;

public class PlanScreen3
{

    private PanelHandler handler;
    private JPanel mainPanel;
    private Itinerary currentItinerary;
    private ArrayList<Activity> potentialActivityList;

    public PlanScreen3(PanelHandler panels, Itinerary parentItinerary)
    {
        this.handler = panels;
        this.currentItinerary = parentItinerary;
        this.parseActivities();
    }

    public JPanel getMainPanel()
    {
        return this.mainPanel;
    }

    public void parseActivities()
    {
        FileManager file = new FileManager();
        this.potentialActivityList = file.readActivityFiles();
        for (int i = 0; i < this.potentialActivityList.size(); i++)
        {
            boolean containsTags = false;
            for (int j = 0; j < this.potentialActivityList.get(i).getNumTags(); j++)
            {
                if (compareTags(i, j))
                {
                    containsTags = true;
                }
            }
            if (!containsTags)
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
