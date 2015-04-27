import javax.swing.*;
import itinerary.Itinerary;

public class PlanScreen3
{

    private PanelHandler handler;
    private JPanel mainPanel;
    private Itinerary currentItinerary;

    public PlanScreen3(PanelHandler panels, Itinerary parentItinerary)
    {
        this.handler = panels;
        this.currentItinerary = parentItinerary;
    }

    public JPanel getMainPanel()
    {
        return this.mainPanel;
    }

}
