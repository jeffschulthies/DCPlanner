import location.types.Restaurant;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import location.types.Restaurant;

public class CreateRestaurantScreen
{

    private PanelHandler handler;
    private JPanel mainPanel;
    private JButton backButton;
    private JButton addRestaurantButton;
    private JLabel nameLabel;
    private JLabel addressLabel;
    private JLabel descriptionLabel;
    private JLabel longitudeLabel;
    private JLabel latitudeLabel;
    private JLabel openLabel;
    private JLabel closeLabel;
    private JLabel typeLabel;
    private JLabel priceRangeLabel;
    private JTextField nameField;
    private JTextField addressField;
    private JTextField descriptionField;
    private JTextField longitudeField;
    private JTextField latitudeField;
    private JTextField typeField;
    private JComboBox openTime;
    private JComboBox closeTime;
    private JComboBox openPeriod;
    private JComboBox closePeriod;
    private JComboBox priceRange;
    private ArrayList<Restaurant> restaurantList;

    public CreateRestaurantScreen(PanelHandler panels) throws Exception
    {
        this.handler = panels;
        this.backButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try {
                    handler.pushPanel("adminPanel");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        this.addRestaurantButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (!nameField.getText().isEmpty() && !addressField.getText().isEmpty() && !descriptionField.getText().isEmpty() && !longitudeField.getText().isEmpty() && !latitudeField.getText().isEmpty() && !typeField.getText().isEmpty())
                {
                    FileManager files = null;
                    try {
                        files = new FileManager();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    if (files != null) {
                        restaurantList = files.readRestaurantFiles();
                    }
                    String priceRangeString = (String)(priceRange.getSelectedItem());
                    int priceRangeInt = 0;
                    if (priceRangeString.equals("$"))
                    {
                        priceRangeInt = 0;
                    }
                    else if (priceRangeString.equals("$$"))
                    {
                        priceRangeInt = 1;
                    }
                    else
                    {
                        priceRangeInt = 2;
                    }
                    if (openTime.getSelectedItem() == closeTime.getSelectedItem() && openPeriod.getSelectedItem() == closePeriod.getSelectedItem())
                    {
                        Restaurant newRestaurant = new Restaurant(nameField.getText(), addressField.getText(), restaurantList.size() + 1, descriptionField.getText(), Double.parseDouble(longitudeField.getText()), Double.parseDouble(latitudeField.getText()), null, -1, -1, typeField.getText(), priceRangeInt);
                        restaurantList.add(newRestaurant);
                    }
                    else
                    {
                        String openTwelveHourString = (String)(openTime.getSelectedItem());
                        String closeTwelveHourString = (String)(closeTime.getSelectedItem());
                        int openTwelveHourInt = Integer.parseInt(openTwelveHourString.replace(":", ""));
                        int closeTwelveHourInt = Integer.parseInt(closeTwelveHourString.replace(":", ""));
                        Restaurant newRestaurant = new Restaurant(nameField.getText(), addressField.getText(), restaurantList.size() + 1, descriptionField.getText(), Double.parseDouble(longitudeField.getText()), Double.parseDouble(latitudeField.getText()), null, convertToTwentyFourHourFormat(openTwelveHourInt, (String)(openPeriod.getSelectedItem())), convertToTwentyFourHourFormat(closeTwelveHourInt, (String)(closePeriod.getSelectedItem())), typeField.getText(), priceRangeInt);
                        restaurantList.add(newRestaurant);
                    }
                    files.writeRestaurantFiles(restaurantList);
                    try {
                        handler.pushPanel("adminPanel");
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
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
