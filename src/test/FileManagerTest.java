
import location.types.Activity;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

/**
 * Created by Jeff Schulthies
 * .
 */
public class FileManagerTest {

    private FileManager manager;
    private ArrayList<Activity> activitiesList;


    @Test
    public void testReadActivityFiles() throws Exception {
        activitiesList = manager.readActivityFiles();
    }

    @Test
    public void testReadRestaurantFiles() throws Exception {

    }

    @Test
    public void testReadUserFiles() throws Exception {

    }

    @Test
    public void testWriteActivityFiles() throws Exception {

    }

    @Test
    public void testWriteRestaurantFiles() throws Exception {

    }

    @Test
    public void testWriteUserFiles() throws Exception {

    }
}