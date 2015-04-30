import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import itinerary.Itinerary;
import itinerary.ItineraryIterator;
import itinerary.Node;
import location.types.Activity;
import location.types.Restaurant;

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
    private JLabel currentTimeLabel;
    private Itinerary currentItinerary;
    private ArrayList<Activity> potentialActivityList;
    private ArrayList<Restaurant> potentialRestaurantList;
    private boolean isRestaurant;
    private int currentTime;
    private int currentActivityIndex;

    public PlanScreen3(PanelHandler panels, Itinerary parentItinerary)
    {
        this.handler = panels;
        this.currentItinerary = parentItinerary;
        this.isRestaurant = false;
        this.currentTime = this.currentItinerary.getTripStartTime();
        this.currentActivityIndex = 0;
        this.parseActivities();
        this.parseRestaurants();
        this.setLabels();
        this.nextButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (isRestaurant)
                {
                    if (currentActivityIndex != potentialRestaurantList.size() - 1)
                    {
                        currentActivityIndex++;
                        setLabels();
                    }
                }
                else
                {
                    if (currentActivityIndex != potentialActivityList.size() - 1)
                    {
                        currentActivityIndex++;
                        setLabels();
                    }
                }
            }
        });
        this.previousButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (isRestaurant)
                {
                    if (currentActivityIndex != potentialRestaurantList.size() - 1)
                    {
                        currentActivityIndex++;
                        setLabels();
                    }
                }
                else
                {
                    if (currentActivityIndex != 0)
                    {
                        currentActivityIndex--;
                        setLabels();
                    }
                }
            }
        });
        this.addButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (currentTime == currentItinerary.getTripStartTime())
                {
                    if (isRestaurant)
                    {
                        currentItinerary.addFirst(potentialRestaurantList.get(currentActivityIndex), currentTime, currentTime + generateActivityLength());
                    }
                    else
                    {
                        currentItinerary.addFirst(potentialActivityList.get(currentActivityIndex), currentTime, currentTime + generateActivityLength());
                    }
                }
                else
                {
                    ItineraryIterator iter = currentItinerary.itineraryIterator();
                    while (iter.hasNext())
                    {
                        iter.next();
                    }
                    if (isRestaurant)
                    {
                        iter.add(potentialRestaurantList.get(currentActivityIndex), currentTime, currentTime + generateActivityLength());
                        isRestaurant = false;
                    }
                    else
                    {
                        iter.add(potentialActivityList.get(currentActivityIndex), currentTime, currentTime + generateActivityLength());
                    }
                }
                currentTime = currentTime + generateActivityLength();
                if (currentTime >= currentItinerary.getTripEndTime())
                {
                    handler.pushPanel("plan4Panel", currentItinerary);
                }
                else
                {
                    currentActivityIndex = 0;
                    parseActivities();
                    parseRestaurants();
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
        if (isRestaurant)
        {
            this.insertNameLabel.setText(this.potentialRestaurantList.get(this.currentActivityIndex).getName());
            this.insertAddressLabel.setText(this.potentialRestaurantList.get(this.currentActivityIndex).getAddress());
            if (this.potentialRestaurantList.get(this.currentActivityIndex).getDescription().length() >= 150)
            {
                String abridgedDescription = this.potentialRestaurantList.get(this.currentActivityIndex).getDescription().substring(0, 147) + "...";
                this.insertDescriptionLabel.setText(abridgedDescription);
            }
            else
            {
                this.insertDescriptionLabel.setText(this.potentialRestaurantList.get(this.currentActivityIndex).getDescription());
            }
            int priceRangeValue = this.potentialRestaurantList.get(this.currentActivityIndex).getPriceRange();
            String priceRangeSymbol = "";
            switch (priceRangeValue)
            {
                case 1: priceRangeSymbol = "$$";
                        break;
                case 2: priceRangeSymbol = "$$$";
                        break;
                default: priceRangeSymbol = "$";
                        break;
            }
            this.insertPriceLabel.setText(priceRangeSymbol);
        }
        else
        {
            this.insertNameLabel.setText(this.potentialActivityList.get(this.currentActivityIndex).getName());
            this.insertAddressLabel.setText(this.potentialActivityList.get(this.currentActivityIndex).getAddress());
            if (this.potentialActivityList.get(this.currentActivityIndex).getDescription().length() >= 150)
            {
                String abridgedDescription = this.potentialActivityList.get(this.currentActivityIndex).getDescription().substring(0, 147) + "...";
                this.insertDescriptionLabel.setText(abridgedDescription);
            }
            else
            {
                this.insertDescriptionLabel.setText(this.potentialActivityList.get(this.currentActivityIndex).getDescription());
            }
            this.insertPriceLabel.setText(Double.toString(this.potentialActivityList.get(this.currentActivityIndex).getPrice()));
        }
        String timePeriod = "";
        int twelveHourInt = currentTime;
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
        this.currentTimeLabel.setText("Current Time: " + newTwelveHourString + " " + timePeriod);
    }

    public int generateActivityLength()
    {
        for (int i = 0; i < this.currentItinerary.getDiningTimes().length; i++)
        {
            if (this.currentItinerary.getDiningTimes()[i] == this.currentTime && this.currentItinerary.getDiningTimes()[i] != -1)
            {
                return 100;
            }
            else if (this.currentItinerary.getDiningTimes()[i] - this.currentTime <= 200 && this.currentItinerary.getDiningTimes()[i] - this.currentTime >= 0 && this.currentItinerary.getDiningTimes()[i] != -1)
            {
                this.isRestaurant = true;
                return this.currentItinerary.getDiningTimes()[i] - this.currentTime;
            }
        }
        if (this.currentItinerary.getTripEndTime() - this.currentTime <= 200)
        {
            return this.currentItinerary.getTripEndTime() - this.currentTime;
        }
        else if (this.currentItinerary.getTripEndTime() - this.currentTime >= 400)
        {
            return 200;
        }
        return 100;
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
            if ((this.currentTime < this.potentialActivityList.get(i).getOpenHour() || this.currentTime > this.potentialActivityList.get(i).getCloseHour()) && (this.potentialActivityList.get(i).getOpenHour() != -1 && this.potentialActivityList.get(i).getCloseHour() != -1))
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

    public void parseRestaurants()
    {
        FileManager file = new FileManager();
        this.potentialRestaurantList = file.readRestaurantFiles();
        for (int i = 0; i < this.potentialRestaurantList.size(); i++)
        {
            if ((this.currentTime < this.potentialRestaurantList.get(i).getOpenHour() || this.currentTime > this.potentialRestaurantList.get(i).getCloseHour()) && (this.potentialRestaurantList.get(i).getOpenHour() != -1 && this.potentialRestaurantList.get(i).getCloseHour() != -1))
            {
                this.potentialRestaurantList.remove(i);
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
