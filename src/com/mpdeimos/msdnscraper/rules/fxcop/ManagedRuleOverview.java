package com.mpdeimos.msdnscraper.rules.fxcop;

import com.mpdeimos.msdnscraper.rule.Rule;
import com.mpdeimos.msdnscraper.rule.RuleOverview;
import com.mpdeimos.webscraper.Scrape;
import com.mpdeimos.webscraper.conversion.DeepScrapeConverter;

import java.util.Arrays;
import java.util.List;

public class ManagedRuleOverview extends RuleOverview
{
	@Scrape(value = "#mainBody .tableSection tr:has(td)",
			converter = DeepScrapeConverter.class)
	public ManagedRule[] rules;

	/** Constructor. */
	public ManagedRuleOverview()
	{
		super("http://msdn.microsoft.com/en-us/library/dd380629.aspx"); //$NON-NLS-1$
	}

	/** {@inheritDoc} */
	@Override
	public List<? extends Rule> getRules()
	{
		return Arrays.asList(this.rules);
	}
}
