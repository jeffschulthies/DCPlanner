import javax.swing.*;
import itinerary.Itinerary;
import itinerary.ItineraryIterator;
import itinerary.Node;

public class PlanScreen4
{

    private PanelHandler handler;
    private JPanel mainPanel;
    private Itinerary currentItinerary;

    public PlanScreen4(PanelHandler panels, Itinerary parentItinerary)
    {
        this.handler = panels;
        this.currentItinerary = parentItinerary;
        ItineraryIterator iter = this.currentItinerary.itineraryIterator();
        while (iter.hasNext())
        {
            Node curNode = iter.next();
            System.out.println(curNode.getData().getName());
            System.out.println("\tStart Time:" + curNode.getStartTime());
            System.out.println("\tStart Time:" + curNode.getEndTime());
            System.out.println();
        }
    }

    public JPanel getMainPanel()
    {
        return this.mainPanel;
    }

}
