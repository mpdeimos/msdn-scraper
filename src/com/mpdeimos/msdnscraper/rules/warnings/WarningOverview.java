package com.mpdeimos.msdnscraper.rules.warnings;

import com.mpdeimos.msdnscraper.rule.RuleProvider;
import com.mpdeimos.webscraper.Scrape;
import com.mpdeimos.webscraper.conversion.ConstructConverter;

import java.util.Arrays;
import java.util.Collection;

public class WarningOverview extends RuleProvider
{
	@Scrape(
			value = "#tocnav div.toclevel2 > a:contains(Compiler Warning)",
			attribute = "abs:href",
			converter = ConstructConverter.class)
	public WarningRule[] rules;

	/** Constructor. */
	public WarningOverview(String url)
	{
		super(url);
	}

	/** {@inheritDoc} */
	@Override
	public Collection<WarningRule> getRules()
	{
		return Arrays.asList(this.rules);
	}

}
