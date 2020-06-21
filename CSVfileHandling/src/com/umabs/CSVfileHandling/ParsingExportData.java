package com.umabs.CSVfileHandling;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class ParsingExportData {

	public static void main(String[] args) throws IOException {
		System.out.println(countryInfo(csvRecords(), "Nauru"));
		System.out.println(whichCountryExports(csvRecords(), "Coffee"));
		System.out.println(listExportersTwoProducts(csvRecords(), "gold", "diamond"));
		System.out.println(numberOfExporters(csvRecords(), "gold"));
		System.out.println(bigExporters(csvRecords(), 999999999999L));
	}

	private static Iterable<CSVRecord> csvRecords() throws IOException {
		FileReader fr = new FileReader("exportdata.csv");
		return CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(fr);

	}

	/*
	 * This method returns a string of information about the country or returns “NOT
	 * FOUND” if there is no information about the country.
	 */
	private static String countryInfo(Iterable<CSVRecord> records, String country) {
		// Search for the country in the first column
		for (CSVRecord record : records) {
			String data = record.get(0);
			if (data.equals(country))
				// If found, access each columns of that particular record
				return country + ": " + record.get(1) + " : " + record.get(2);
		}
		// If not found, return "NOT FOUND"
		return "NOT FOUND";
	}

	private static List<String> whichCountryExports(Iterable<CSVRecord> records, String item) {
		List<String> countries = new ArrayList<>();
		// Look for the item in the exports column.
		for (CSVRecord record : records) {
			// If found, add country to list
			if (record.get(1).contains(item.toLowerCase()))
				countries.add(record.get(0));
		}
		return countries;
	}

	/*
	 * This method prints the names of all the countries that have both exportItem1
	 * and exportItem2 as export items.
	 */
	private static List<String> listExportersTwoProducts(Iterable<CSVRecord> records, String exportItem1,
			String exportItem2) {
		List<String> countries = new ArrayList<>();

		for (CSVRecord record : records) {
			String exports = record.get(1);
			if (exports.contains(exportItem1) && exports.contains(exportItem2)) {
				countries.add(record.get(0));
			}
		}
		return countries;
	}

	/* This method returns the number of countries that export exportItem. */
	private static int numberOfExporters(Iterable<CSVRecord> records, String exportItem) {
		return whichCountryExports(records, exportItem).size();
	}
	
	/*
	 * This method prints the names of countries and their Value amount for all
	 * countries whose Value (dollars) string is longer than the amount.
	 */
	private static List<String> bigExporters(Iterable<CSVRecord> records, long amount){
		List<String> bigExporters = new ArrayList<>();
		
		for (CSVRecord record : records) {
			String value=record.get(2).substring(1);
			Long figures = Long.valueOf(value.replace(",", ""));
			if(figures>amount)
				bigExporters.add(record.get(0)+" "+record.get(2));
		}
		return bigExporters;
	}

}
