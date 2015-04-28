import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import itinerary.Itinerary;

public class PlanScreen1
{

    private PanelHandler handler;
    private JPanel mainPanel;
    private JButton continueButton;
    private JLabel titleLabel;
    private JLabel instructionLabel1;
    private JLabel startLabel;
    private JLabel endLabel;
    private JLabel instructionLabel2;
    private JComboBox startTime;
    private JComboBox endTime;
    private JComboBox startPeriod;
    private JComboBox endPeriod;
    private JCheckBox museumsCheckBox;
    private JCheckBox monumentsCheckBox;
    private JCheckBox collegesCheckBox;
    private JCheckBox theatersCheckBox;
    private JCheckBox historicalSitesCheckBox;
    private JCheckBox parksCheckBox;
    private JCheckBox limitToFreeCheckBox;

    public PlanScreen1(PanelHandler panels)
    {
        this.handler = panels;
        this.continueButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String startTwelveHourString = (String)(startTime.getSelectedItem());
                String endTwelveHourString = (String)(endTime.getSelectedItem());
                int startTwelveHourInt = Integer.parseInt(startTwelveHourString.replace(":", ""));
                int endTwelveHourInt = Integer.parseInt(endTwelveHourString.replace(":", ""));
                ArrayList<String> tripTags = new ArrayList<String>();
                boolean freeOnly = false;
                if (museumsCheckBox.isSelected())
                {
                    tripTags.add("museum");
                }
                if (monumentsCheckBox.isSelected())
                {
                    tripTags.add("monument");
                }
                if (collegesCheckBox.isSelected())
                {
                    tripTags.add("college");
                }
                if (theatersCheckBox.isSelected())
                {
                    tripTags.add("theater");
                }
                if (historicalSitesCheckBox.isSelected())
                {
                    tripTags.add("historical");
                }
                if (parksCheckBox.isSelected())
                {
                    tripTags.add("park");
                }
                if (limitToFreeCheckBox.isSelected())
                {
                    freeOnly = true;
                }
                Itinerary currentItinerary = new Itinerary(convertToTwentyFourHourFormat(startTwelveHourInt, (String)(startPeriod.getSelectedItem())), convertToTwentyFourHourFormat(endTwelveHourInt, (String)(endPeriod.getSelectedItem())), freeOnly, tripTags);
                handler.pushPanel("plan2Panel", currentItinerary);
            }
        });
    }

    public JPanel getMainPanel()
    {
        return this.mainPanel;
    }

    private int convertToTwentyFourHourFormat(int twelveHourFormat, String twelveHourPeriod)
    {
        if (twelveHourPeriod.equals("AM") || (twelveHourFormat == 1200 && twelveHourPeriod.equals("PM")))
        {
            return twelveHourFormat;
        }
        else
        {
            return twelveHourFormat + 1200;
        }
    }

}
