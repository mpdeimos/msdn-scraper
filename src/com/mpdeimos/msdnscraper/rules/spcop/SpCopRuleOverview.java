package com.mpdeimos.msdnscraper.rules.spcop;

import com.mpdeimos.msdnscraper.rule.Rule;
import com.mpdeimos.webscraper.Scrape;
import com.mpdeimos.webscraper.conversion.DeepScrapeConverter;

import java.util.Arrays;
import java.util.List;

public class SpCopRuleOverview extends
		com.mpdeimos.msdnscraper.rule.RuleOverview
{
	@Scrape(value = "#mainBody .tableSection tr:has(td)",
			converter = DeepScrapeConverter.class)
	public SpCopRule[] rules;

	/** Constructor. */
	public SpCopRuleOverview(String url)
	{
		super(url);
	}

	/** {@inheritDoc} */
	@Override
	public List<? extends Rule> getRules()
	{
		return Arrays.asList(this.rules);
	}

}
