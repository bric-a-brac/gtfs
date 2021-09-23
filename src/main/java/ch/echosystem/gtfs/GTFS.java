package ch.echosystem.gtfs;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public final class GTFS
	{
	public static void main(String[] args) throws Exception
		{
		System.out.println("GTFS");

		final var agency = new Agency();

		agency.setId("Bus Sierrois");
		agency.setName("Bus Sierrois");

		zip(agency);
		}
	
	public static void zip(final Agency agency) throws IOException
		{
		try (final var output = new FileOutputStream("bus-sierrois.zip"))
			{
			try (final var zip = new ZipOutputStream(output))
				{
				zipAgency(zip, agency);
				}
			}
		}

	private static void zipAgency(final ZipOutputStream zip, final Agency agency) throws IOException
		{
		final var entry = new ZipEntry("agency.txt");

		zip.putNextEntry(entry);

		final var bytes = csv(Agency.Header.class, Arrays.asList(agency));

		zip.write(bytes, 0, bytes.length);
		}

	private static byte[] csv(final Class<? extends Enum<?>> headers, final List<Iterable<Object>> records) throws IOException
		{
		final var format = CSVFormat.Builder.create().setHeader(headers).build();

		final var buffer = new StringBuilder();

		try (final var printer = new CSVPrinter(buffer, format))
			{
			for (final var record : records)
				{
				printer.printRecord(record);
				}
			}
		
		return buffer.toString().getBytes();
		}
	}
