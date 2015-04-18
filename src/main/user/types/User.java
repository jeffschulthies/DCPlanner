package user.types;
import java.io.Serializable;

public class User implements UserInterface, Serializable
{

	private String username;
	private long userID;
	private String password;
	
	public User(String username, long userID, String password)
	{
		this.username = username;
		this.userID = userID;
		this.password = password;
	}
	
	public String getUsername()
	{
		return this.username;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public long getUserID()
	{
		return this.userID;
	}
	
	public void setUserID(long userID)
	{
		this.userID = userID;
	}
	
	public String getPassword()
	{
		return this.password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
}
