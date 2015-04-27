package location.types.helper;

import location.Location;
import location.types.Activity;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DefaultLandmarks {
    public ArrayList<Location> dcLandmarks = new ArrayList<Location>();

    public static ArrayList<Activity> createLandmarks() {

        ArrayList<Activity> locations = new ArrayList<Activity>();
        ArrayList<String> defaultTags = createDefaultTags();
        BufferedImage[] images = createDefaultImages();

        // Add activities via this file using the following format.
        // Write the code, commit, and we'll take care of the rest.
        // Reference the Activity class to see what the parameters should be if you must.
        // ALSO USE THE GUI IF YOU CAN!!!!!
        /*Activity loc1 = new Activity("United States Capitol", "East Capitol St NE & First St SE, Washington, DC 20004",
                1, "The United States Capitol, atop Capitol Hill at the eastern end of the National Mall in Washington, D.C.," +
                " is the seat of the United States Congress, the legislative branch of the U.S. federal government, completed in the year 1800." +
                " Though not at the geographic center of the Federal District, the Capitol forms the basis for the District's street-numbering system." +
                " It is the origin point at which the District's four quadrants meet, and around which the city was laid out.", LONGITUDE HERE, LATITUDE HERE,
                null, 0, 2400, defaultTags, 0 );
        Activity loc2 = new Activity("National Mall", "Washington, DC", 2, "The National Mall is a national park in downtown Washington, D.C., the capital of the United States." +
                " The National Park Service administers the National Mall, which is part of its National Mall and Memorial Parks unit.", LONGITUDE HERE, LATITUDE HERE,
                null, 0, 2400, defaultTags, 0);

        locations.add(loc1);
        locations.add(loc2);*/

        return locations;
    }

    public static ArrayList<String> createDefaultTags() {
        ArrayList<String> defaultTags = new ArrayList<String>();
        defaultTags.add("DC");
        defaultTags.add("Monument");
        defaultTags.add("Landmark");
        defaultTags.add("America");
        defaultTags.add("Patriotic");
        return defaultTags;
    }

    public static BufferedImage[] createDefaultImages() {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("resources/testDataIcons/domelogo.png"));
        } catch (IOException e) {
            System.out.println("Error loading img");
        }

        BufferedImage img2 = null;
        try {
            img2 = ImageIO.read(new File("resources/testDataIcons/nationalmall.png"));
        } catch (IOException e) {
            System.out.println("Error loading img");
        }
        //TODO Add [2] [3] etc.
        BufferedImage[] images = new BufferedImage[2];
        images[0] = img;
        images[1] = img2;

        return images;
    }

    //("United States Capitol","East Capitol St NE & First St SE, Washington, DC 20004" )
}