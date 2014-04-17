package com.mpdeimos.msdnscraper.rules;
import com.mpdeimos.webscraper.Scrape;
import com.mpdeimos.webscraper.conversion.ConstructConverter;

public class Rule
{
	@Scrape("td:nth-child(1)")
	public String id;

	@Scrape(value = "td:nth-child(2)", regex = ".*:\\s(.*)")
	public String message;

	@Scrape("td:nth-child(3)")
	public String description;

	@Scrape(value = "td:nth-child(2) a", attribute = "href",
			converter = ConstructConverter.class)
	public RuleDetails details;

}
