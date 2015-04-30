import javax.swing.*;
import itinerary.Itinerary;
import itinerary.ItineraryIterator;
import itinerary.Node;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlanScreen4
{

    private PanelHandler handler;
    private JPanel mainPanel;
    private JLabel itineraryLabel;
    private JButton tryAgainButton;
    private JButton logoutButton;
    private Itinerary currentItinerary;

    public PlanScreen4(PanelHandler panels, Itinerary parentItinerary)
    {
        this.handler = panels;
        this.currentItinerary = parentItinerary;
        String resultsString = "<html>";
        ItineraryIterator iter = this.currentItinerary.itineraryIterator();
        while (iter.hasNext())
        {
            Node curNode = iter.next();
            resultsString =  resultsString + "<b>" + curNode.getData().getName() + "</b><br>" + curNode.getData().getAddress() +
                            "<br>" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Start Time:&nbsp;" + convertToTwelveHourTime(curNode.getStartTime()) +
                            "<br>" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;End Time:&nbsp;&nbsp;" + convertToTwelveHourTime(curNode.getEndTime()) +
                            "<br><br>";
        }
        itineraryLabel.setText(resultsString + "</html>");
        this.tryAgainButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                handler.pushPanel("plan1Panel");
            }
        });
        this.logoutButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                handler.pushPanel("startPanel");
            }
        });
    }

    public JPanel getMainPanel()
    {
        return this.mainPanel;
    }

    public String convertToTwelveHourTime(int twentyFourHourTime)
    {
        String timePeriod = "";
        int twelveHourInt = twentyFourHourTime;
        if (twelveHourInt > 1200)
        {
            timePeriod = "PM";
            twelveHourInt = twelveHourInt - 1200;
        }
        else
        {
            timePeriod = "AM";
        }
        String twelveHourString = Integer.toString(twelveHourInt);
        String newTwelveHourString = "";
        if (twelveHourString.length() == 3)
        {
            for (int i = 0; i < twelveHourString.length(); i++)
            {
                if (i == 1)
                {
                    newTwelveHourString = newTwelveHourString + ":";
                }
                newTwelveHourString = newTwelveHourString + twelveHourString.charAt(i);
            }
        }
        else
        {
            for (int i = 0; i < twelveHourString.length(); i++)
            {
                if (i == 2)
                {
                    newTwelveHourString = newTwelveHourString + ":";
                }
                newTwelveHourString = newTwelveHourString + twelveHourString.charAt(i);
            }
        }
        return newTwelveHourString + " " + timePeriod;
    }

}
