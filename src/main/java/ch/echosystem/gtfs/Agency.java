package ch.echosystem.gtfs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimeZone;

public final class Agency extends Name implements Iterable<Object>
	{
	public enum Header
		{
		agency_id,
		agency_name,
		agency_url,
		agency_timezone
		}

	private String url;
	private TimeZone timezone;

	public String getUrl()
		{
		return url;
		}
	
	public void setUrl(final String url)
		{
		this.url = url;
		}
	
	public TimeZone getTimeZone()
		{
		return timezone;
		}
	
	public void setTimeZone(final TimeZone timezone)
		{
		this.timezone = timezone;
		}

	@Override
	public Iterator<Object> iterator()
		{
		final var list = new ArrayList<Object>();

		list.add(id);
		list.add(name);
		list.add(url);
		list.add(timezone);
		
		return list.iterator();
		}
	}
