package ch.echosystem.gtfs;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public final class GTFS
	{
	private Agency agency;

	public Agency getAgency()
		{
		return agency;
		}
	
	public void setAgency(final Agency agency)
		{
		this.agency = agency;
		}
	
	public static String csvAgency() throws IOException
		{
		final var format = CSVFormat.Builder.create().setHeader(Agency.Header.class).build();

		final var buffer = new StringBuilder();

		try (final var printer = new CSVPrinter(buffer, format))
			{
			printer.print("bus");
			printer.print("Bus Sierrois");
			}
		
		return buffer.toString();
		}
	
	public static void main(String[] args) throws Exception
		{
		System.out.println("GTFS");

		zip();
		}
	
	public static void zip() throws IOException
		{
		try (final var output = new FileOutputStream("bus-sierrois.zip"))
			{
			try (final var zip = new ZipOutputStream(output))
				{
				final var entry = new ZipEntry("agency.txt");

				zip.putNextEntry(entry);

				final var bytes = csvAgency().getBytes();

				zip.write(bytes, 0, bytes.length);
				}
			}
		}
	}
