package com.mpdeimos.msdnscraper.rule;

import com.mpdeimos.webscraper.Scraper;
import com.mpdeimos.webscraper.Scraper.ScraperBuilder;
import com.mpdeimos.webscraper.ScraperException;

import java.util.ArrayList;

public abstract class RuleResolver
{
	public final Rule[] resolve() throws ScraperException
	{
		RuleOverview[] ruleOverviewSites = getRuleOverviewSites();
		ScraperBuilder builder = Scraper.builder();
		builder.add(ruleOverviewSites);
		builder.build().scrape();

		ArrayList<Rule> rules = new ArrayList<Rule>();
		for (RuleOverview ruleOverview : ruleOverviewSites)
		{
			rules.addAll(ruleOverview.getRules());
		}

		return rules.toArray(new Rule[rules.size()]);
	}

	protected abstract RuleOverview[] getRuleOverviewSites()
			throws ScraperException;
}
