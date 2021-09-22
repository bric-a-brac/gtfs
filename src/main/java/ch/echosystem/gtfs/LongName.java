package ch.echosystem.gtfs;

public abstract class LongName extends Name
	{
	protected String longName;

	public String getLongName()
		{
		return longName;
		}
	
	public void setLongName(final String longName)
		{
		this.longName = longName;
		}
	
	public String getShortName()
		{
		return name;
		}
	
	public void setShortName(final String shortName)
		{
		name = shortName;
		}
	}
