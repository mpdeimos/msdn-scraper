package com.mpdeimos.msdnscraper.rules.fxcop;

import com.mpdeimos.msdnscraper.rules.Rule;
import com.mpdeimos.webscraper.Scrape;
import com.mpdeimos.webscraper.conversion.DeepScrapeConverter;

public class ManagedRules
{
	public static final String URL = "http://msdn.microsoft.com/en-us/library/dd380629.aspx";

	@Scrape(value = "#mainBody .tableSection tr:has(td)",
			converter = DeepScrapeConverter.class)
	public Rule[] rules;

	/** @see #rules */
	public Rule[] getRules()
	{
		return rules;
	}
}
