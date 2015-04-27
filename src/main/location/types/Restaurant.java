package location.types;

import location.Location;

import java.awt.image.BufferedImage;
import java.io.Serializable;

public class Restaurant extends Location implements Serializable
{

	private String type;
	private int priceRange;

	public Restaurant(String name, String address, long id, String description,
					  double longitude, double latitude, BufferedImage image,
					  int openHour, int closeHour, String type,
					  int priceRange)
	{
		super(name, address, id, description, longitude, latitude, image, openHour, closeHour);
		this.type = type;
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

	public int getPriceRange()
	{
		return this.priceRange;
	}
	
	public void setPriceRange(int priceRange)
	{
		this.priceRange = priceRange;
	}
	
}
