package eu.opends.input;

public class Key {
	private String ID;
	private String description;
	private String[] defaultKeys;
	private String[] keys = null;
	private int keyIndex = 0;
	
	public void setID(String ID)
	{
		this.ID = ID;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public void setDefaultKey(String defaultKey)
	{
		this.defaultKeys[keyIndex++] = defaultKey;
	}
	
	public void setDefaultKeys(String[] defaultKeys)
	{
		this.defaultKeys = defaultKeys;
	}
	
	public String getID()
	{
		return ID;
	}
	
	public String toString()
	{
		return ID;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public String[] getDefaultKeys()
	{
		return defaultKeys;
	}
	
	public void setKeys(String[] keys)
	{
		this.keys = keys;
	}
	
	public String[] getKeys()
	{
		if(keys != null)
			return keys;
		else
			return defaultKeys;
	}
}
