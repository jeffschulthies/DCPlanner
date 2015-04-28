package location.types;

import location.Location;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;

//Activity - Monuments etc.
public class Activity extends Location implements Serializable
{
	
	private ArrayList<String> tags;
	private double price;

	public Activity(String name, String address, long id, String description,
					double longitude, double latitude, BufferedImage image,
					int openHour, int closeHour, ArrayList<String> tags,
					double price)
	{
		super(name, address, id, description, longitude, latitude, image, openHour, closeHour);
		this.tags = tags;
		this.price = price;
	}

	public ArrayList<String> getTags()
	{
		return this.tags;
	}

	public void addTag(String tag)
	{
		this.tags.add(tag);
	}
	
	public double getPrice()
	{
		return this.price;
	}
	
	public void setPrice(double price)
	{
		this.price = price;
	}
	
}
