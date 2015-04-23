import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import location.types.Activity;

public class CreateActivityScreen
{

    private PanelHandler handler;
    private JPanel mainPanel;
    private JButton backButton;
    private JButton addTagButton;
    private JButton addActivityButton;
    private JLabel nameLabel;
    private JLabel addressLabel;
    private JLabel descriptionLabel;
    private JLabel openLabel;
    private JLabel closeLabel;
    private JLabel tagsLabel;
    private JLabel priceLabels;
    private JTextField nameField;
    private JTextField addressField;
    private JTextField descriptionField;
    private JTextField tagsField;
    private JTextField priceField;
    private JComboBox openTime;
    private JComboBox closeTime;
    private JComboBox closePeriod;
    private JComboBox openPeriod;
    private ArrayList<String> currentTags;
    private ArrayList<Activity> activityList;


    public CreateActivityScreen(PanelHandler panels)
    {
        this.handler = panels;
        this.currentTags = new ArrayList<String>();
        this.backButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                handler.pushPanel("adminPanel");
            }
        });
        this.addTagButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (!tagsField.getText().isEmpty())
                {
                    currentTags.add(tagsField.getText());
                    tagsField.setText("");
                }
            }
        });
        this.addActivityButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (!nameField.getText().isEmpty() && !addressField.getText().isEmpty() && !descriptionField.getText().isEmpty() && !priceField.getText().isEmpty())
                {
                    FileManager files = new FileManager();
                    activityList = files.readActivityFiles();
                    String openTwelveHourString = (String)(openTime.getSelectedItem());
                    String closeTwelveHourString = (String)(closeTime.getSelectedItem());
                    int openTwelveHourInt = Integer.parseInt(openTwelveHourString.replace(":", ""));
                    int closeTwelveHourInt = Integer.parseInt(closeTwelveHourString.replace(":", ""));
                    Activity newActivity = new Activity(nameField.getText(), addressField.getText(), activityList.size() + 1, descriptionField.getText(), null, convertToTwentyFourHourFormat(openTwelveHourInt, (String)(openPeriod.getSelectedItem())), convertToTwentyFourHourFormat(closeTwelveHourInt, (String)(closePeriod.getSelectedItem())), currentTags, Double.parseDouble(priceField.getText()));
                    activityList.add(newActivity);
                    files.writeActivityFiles(activityList);
                    handler.pushPanel("adminPanel");
                }
            }
        });
    }

    public JPanel getMainPanel()
    {
        return this.mainPanel;
    }

    private int convertToTwentyFourHourFormat(int twelveHourFormat, String twelveHourPeriod)
    {
        if (twelveHourPeriod.equals("AM"))
        {
            return twelveHourFormat;
        }
        else
        {
            return twelveHourFormat + 1200;
        }
    }

}
