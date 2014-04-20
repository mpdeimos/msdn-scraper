package com.mpdeimos.msdnscraper.rules.spcop;

import com.mpdeimos.msdnscraper.rule.RuleResolver;
import com.mpdeimos.webscraper.Scrape;
import com.mpdeimos.webscraper.ScraperException;
import com.mpdeimos.webscraper.conversion.ConstructConverter;

public class SpCopRuleResolver extends RuleResolver
{
	static final String BASE_URL = "http://docs.spcaf.com/v4/SPCAF_ANALYZER_RULES.html";

	@Override
	protected SpCopRuleOverview[] getRuleOverviewSites()
			throws ScraperException
	{
		RuleCategorySite ruleCategorySite = new RuleCategorySite();
		scrape(BASE_URL, ruleCategorySite);
		return ruleCategorySite.rules;
	}

	public static class RuleCategorySite
	{
		@Scrape(
				value = ".OH_selfTocLinks > div a",
				attribute = "abs:href",
				converter = ConstructConverter.class)
		public SpCopRuleOverview[] rules;
	}
}
