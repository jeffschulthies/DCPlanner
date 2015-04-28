import javax.swing.*;
import itinerary.Itinerary;

public class PlanScreen4
{

    private PanelHandler handler;
    private JPanel mainPanel;
    private Itinerary currentItinerary;

    public PlanScreen4(PanelHandler panels, Itinerary parentItinerary)
    {
        this.handler = panels;
        this.currentItinerary = parentItinerary;
    }

    public JPanel getMainPanel()
    {
        return this.mainPanel;
    }

}
