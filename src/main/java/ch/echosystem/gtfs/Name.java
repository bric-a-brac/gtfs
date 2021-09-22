package ch.echosystem.gtfs;

public abstract class Name extends ID
	{
	protected String name;
	
	public String getName()
		{
		return name;
		}
	
	public void setName(final String name)
		{
		this.name = name;
		}
	}
