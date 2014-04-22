package com.mpdeimos.msdnscraper.rules.spcop;

import com.mpdeimos.msdnscraper.rule.RuleResolver;
import com.mpdeimos.webscraper.Scrape;
import com.mpdeimos.webscraper.Scraper;
import com.mpdeimos.webscraper.ScraperException;
import com.mpdeimos.webscraper.ScraperSource;
import com.mpdeimos.webscraper.ScraperSource.ScraperSourceProvider;
import com.mpdeimos.webscraper.conversion.ConstructConverter;

public class SpCopRuleResolver extends RuleResolver
{
	static final String BASE_URL = "http://docs.spcaf.com/v4/SPCAF_ANALYZER_RULES.html";

	@Override
	protected SpCopRuleOverview[] getRuleOverviewSites()
			throws ScraperException
	{
		// FIXME
		RuleCategorySite ruleCategorySite = new RuleCategorySite();
		Scraper.builder().add(ruleCategorySite).build().scrape();
		return ruleCategorySite.rules;
	}

	public static class RuleCategorySite implements ScraperSourceProvider
	{
		@Scrape(
				value = ".OH_selfTocLinks > div a",
				attribute = "abs:href",
				converter = ConstructConverter.class)
		public SpCopRuleOverview[] rules;

		@Override
		public ScraperSource getSource()
		{
			return ScraperSource.fromUrl(BASE_URL);
		}
	}
}
