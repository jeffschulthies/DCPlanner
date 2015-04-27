package location.types.helper;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Jeff Schulthies
 * .
 */
public class DefaultLandmarksTest {

    @Test
    public void testCreateLandmarks() throws Exception {
        location.types.helper.DefaultLandmarks.createLandmarks();
        System.out.println("done");
    }
}