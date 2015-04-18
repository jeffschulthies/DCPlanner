package location.types;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Jeff Schulthies
 * .
 */
public class RestaurantTest {

    /*@DataProvider(name = "grill")
    public static Object[][] restaurants(){
        return new Object[][]{grill, true};
    }*/
    private Restaurant grill;

    @BeforeMethod
    public void initializeRestauraunt() {
        grill = new Restaurant("grill", "1959 E", 1, "A place to eat", null, 5, 24, "Italian", 40);
    }


    @Test
    public void testRestaurants() {
        Assert.assertEquals(grill.getName(), "grill");
        Assert.assertEquals(grill.getAddress(), "1959 E");
        Assert.assertEquals(grill.getID(), 1);
        Assert.assertEquals(grill.getDescription(), "A place to eat");
        Assert.assertEquals(grill.getImage(), null);
        Assert.assertEquals(grill.getOpenHour(), 5);
        Assert.assertEquals(grill.getCloseHour(), 24);
        Assert.assertEquals(grill.getType(), "Italian");
        Assert.assertEquals(grill.getPriceRange(), 40);
    }

}