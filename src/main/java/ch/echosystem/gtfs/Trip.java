package ch.echosystem.gtfs;

public final class Trip extends ID
	{
	private String routeId;

	public String getRouteId()
		{
		return routeId;
		}
	
	public void setRouteId(final String routeId)
		{
		this.routeId = routeId;
		}
	}
