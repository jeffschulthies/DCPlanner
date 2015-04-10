package location;
import java.awt.image.BufferedImage;

public interface LocationInterface 
{

	public String getName();
	
	public void setName(String name);
	
	public String getAddress();
	
	public void setAddress(String address);
	
	public long getID();
	
	public void setID(long id);
	
	public String getDescription();
	
	public void setDescription(String description);
	
	public BufferedImage getImage();
	
	public void setImage(BufferedImage image);
	
	public int getOpenHour();
	
	public int getCloseHour();
	
	public void setHours(int open, int close);
		
}
