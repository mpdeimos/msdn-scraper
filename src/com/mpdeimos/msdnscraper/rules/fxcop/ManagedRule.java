package com.mpdeimos.msdnscraper.rules.fxcop;

import com.mpdeimos.msdnscraper.rule.Rule;
import com.mpdeimos.webscraper.Scrape;
import com.mpdeimos.webscraper.conversion.ConstructConverter;

public class ManagedRule extends Rule
{
	@Scrape("td:nth-child(1)")
	public String id;

	@Scrape(value = "td:nth-child(2)", regex = ".*:\\s(.*)")
	public String message;

	@Scrape("td:nth-child(3)")
	public String description;

	@Scrape(value = "td:nth-child(2) a", attribute = "href",
			converter = ConstructConverter.class)
	public ManagedRuleDetails details;

	@Override
	public ManagedRuleDetails getDetails()
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
		return null;
	}

	@Override
	public String getTypeName()
	{
		return details.typeName;
	}

}
