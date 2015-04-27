import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import itinerary.Itinerary;

public class PlanScreen2
{

    private PanelHandler handler;
    private JPanel mainPanel;
    private JButton continueButton;
    private JLabel titleLabel;
    private JLabel mealOneLabel;
    private JLabel mealTwoLabel;
    private JLabel mealThreeLabel;
    private JLabel startTimeOneLabel;
    private JLabel startTimeTwoLabel;
    private JLabel startTimeThreeLabel;
    private JComboBox mealOneTime;
    private JComboBox mealTwoTime;
    private JComboBox mealThreeTime;
    private JComboBox mealOnePeriod;
    private JComboBox mealTwoPeriod;
    private JComboBox mealThreePeriod;
    private JCheckBox enableOneCheckBox;
    private JCheckBox enableTwoCheckBox;
    private JCheckBox enableThreeCheckBox;
    private Itinerary currentItinerary;

    public PlanScreen2(PanelHandler panels, Itinerary parentItinerary)
    {
        this.handler = panels;
        this.currentItinerary = parentItinerary;
        this.continueButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int mealOneTwentyFourHourTime = -1;
                int mealTwoTwentyFourHourTime = -1;
                int mealThreeTwentyFourHourTime = -1;
                if (enableOneCheckBox.isSelected())
                {
                    String mealOneTwelveHourString = (String)(mealOneTime.getSelectedItem());
                    int mealOneTwelveHourInt = Integer.parseInt(mealOneTwelveHourString.replace(":", ""));
                    mealOneTwentyFourHourTime = convertToTwentyFourHourFormat(mealOneTwelveHourInt, (String)(mealOnePeriod.getSelectedItem()));
                }
                if (enableTwoCheckBox.isSelected())
                {
                    String mealTwoTwelveHourString = (String)(mealTwoTime.getSelectedItem());
                    int mealTwoTwelveHourInt = Integer.parseInt(mealTwoTwelveHourString.replace(":", ""));
                    mealTwoTwentyFourHourTime = convertToTwentyFourHourFormat(mealTwoTwelveHourInt, (String)(mealTwoPeriod.getSelectedItem()));
                }
                if (enableThreeCheckBox.isSelected())
                {
                    String mealThreeTwelveHourString = (String)(mealThreeTime.getSelectedItem());
                    int mealThreeTwelveHourInt = Integer.parseInt(mealThreeTwelveHourString.replace(":", ""));
                    mealThreeTwentyFourHourTime = convertToTwentyFourHourFormat(mealThreeTwelveHourInt, (String)(mealThreePeriod.getSelectedItem()));
                }
                currentItinerary.setDiningTimes(mealOneTwentyFourHourTime, mealTwoTwentyFourHourTime, mealThreeTwentyFourHourTime);
                handler.pushPanel("plan3Panel", currentItinerary);
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
