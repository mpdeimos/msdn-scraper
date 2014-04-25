package com.mpdeimos.msdnscraper.rules.spcop;

import com.mpdeimos.msdnscraper.rule.IRuleProvider;
import com.mpdeimos.msdnscraper.rule.Rule;
import com.mpdeimos.msdnscraper.rule.RuleResolver;
import com.mpdeimos.webscraper.Scrape;
import com.mpdeimos.webscraper.ScraperSource;
import com.mpdeimos.webscraper.ScraperSource.ScraperSourceProvider;
import com.mpdeimos.webscraper.conversion.ConstructConverter;

import java.util.ArrayList;
import java.util.Collection;

public class SpCopRuleResolver extends RuleResolver
{
	static final String BASE_URL = "http://docs.spcaf.com/v4/SPCAF_ANALYZER_RULES.html";

	@Override
	protected RuleCategorySite getRuleProvider()
	{
		return new RuleCategorySite();
	}

	public static class RuleCategorySite implements ScraperSourceProvider,
			IRuleProvider
	{
		@Scrape(
				value = ".OH_selfTocLinks > div a",
				attribute = "abs:href",
				converter = ConstructConverter.class)
		public SpCopRuleOverview[] overviews;

		@Override
		public ScraperSource getSource()
		{
			return ScraperSource.fromUrl(BASE_URL);
		}

		@Override
		public Collection<? extends Rule> getRules()
		{
			ArrayList<Rule> rules = new ArrayList<>();
			for (SpCopRuleOverview overview : overviews)
			{
				rules.addAll(overview.getRules());
			}
			return rules;
		}

	}
}
