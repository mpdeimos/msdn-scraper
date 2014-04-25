package com.mpdeimos.msdnscraper.rules.warnings;

import com.mpdeimos.msdnscraper.rule.Rule;
import com.mpdeimos.msdnscraper.rule.RuleDetails;
import com.mpdeimos.webscraper.Scrape;
import com.mpdeimos.webscraper.ScraperSource;
import com.mpdeimos.webscraper.ScraperSource.ScraperSourceProvider;
import com.mpdeimos.webscraper.conversion.ChildTextSummarizer;

public class WarningRule extends Rule implements ScraperSourceProvider
{
	@Scrape(value = "#content h1.title", regex = ".*(CS\\d*).*")
	public String id;

	@Scrape(
			value = "#mainBody #errorTitleSection, #mainBody > p:matchesOwn(.+)",
			resultIndex = 0)
	public String message;

	@Scrape(
			value = "#mainBody .introduction",
			resultIndex = 0,
			converter = ChildTextSummarizer.class)
	@ChildTextSummarizer.Option(exclude = { "div" })
	public String description;

	@Scrape(value = "#content h1.title", regex = ".*\\((.*)\\).*")
	public String category;

	@Scrape("#curversion")
	public String version;

	private final String url;

	public WarningRule(String url)
	{
		this.url = url;
	}

	@Override
	public ScraperSource getSource()
	{
		return ScraperSource.fromUrl(url);
	}

	@Override
	public RuleDetails getDetails()
	{
		return null;
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
		return category;
	}

	@Override
	public String getSeverity()
	{
		return null;
	}

	@Override
	public String getTypeName()
	{
		return null;
	}

}
