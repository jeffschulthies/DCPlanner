package location;
import java.awt.image.BufferedImage;
import java.io.Serializable;

public class Restaurant extends Location implements RestaurantInterface, Serializable
{

	private String type;
	private String genre;
	private int priceRange;
	
	public Restaurant(String name, String address, long id, String description, BufferedImage image, int openHour, int closeHour, String type, String genre, int priceRange)
	{
		super(name, address, id, description, image, openHour, closeHour);
		this.type = type;
		this.genre = genre;
		this.priceRange = priceRange;
	}
	
	public String getType()
	{
		return this.type;
	}
	
	public void setType(String type)
	{
		this.type = type;
	}
	
	public String getGenre()
	{
		return this.genre;
	}
	
	public void setGenre(String genre)
	{
		this.genre = genre;
	}
	
	public int getPriceRange()
	{
		return this.priceRange;
	}
	
	public void setPriceRange(int priceRange)
	{
		this.priceRange = priceRange;
	}
	
}
