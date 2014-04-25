package com.mpdeimos.msdnscraper.rules.spcop;

import com.mpdeimos.msdnscraper.rule.Rule;
import com.mpdeimos.msdnscraper.rule.RuleDetails;
import com.mpdeimos.webscraper.Scrape;
import com.mpdeimos.webscraper.conversion.ConstructConverter;

public class SpCopRule extends Rule
{
	@Scrape(value = "td:nth-child(1)", regex = "(.*):.*")
	public String id;

	@Scrape(value = "td:nth-child(1)", regex = ".*:(.*)")
	public String message;

	@Scrape("td:nth-child(2)")
	public String description;

	@Scrape(value = "td:nth-child(1) a", attribute = "abs:href",
			converter = ConstructConverter.class)
	public SpCopRuleDetails details;

	@Override
	public RuleDetails getDetails()
	{
		return details;
	}

	@Override
	public String getId()
	{
		return id;
	}

	@Override
	public String getMessage()
	{
		return message;
	}

	@Override
	public String getDescription()
	{
		return description;
	}

	@Override
	public String getCategory()
	{
		return details.category;
	}

	@Override
	public String getSeverity()
	{
		return details.severity;
	}

	@Override
	public String getTypeName()
	{
		return details.typeName;
	}

}
