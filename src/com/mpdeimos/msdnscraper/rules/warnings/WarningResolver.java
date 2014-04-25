package com.mpdeimos.msdnscraper.rules.warnings;

import com.mpdeimos.msdnscraper.rule.RuleResolver;
import com.mpdeimos.webscraper.Scrape;
import com.mpdeimos.webscraper.ScraperSource;
import com.mpdeimos.webscraper.conversion.ConstructConverter;

import java.util.Collection;
import java.util.HashMap;

public class WarningResolver extends RuleResolver
{
	static final String BASE_URL = "http://msdn.microsoft.com/en-us/library/ms228296.aspx";

	@Override
	protected WarningOverview getRuleProvider()
	{
		return new RuleCategorySite();
	}

	public static class RuleCategorySite extends WarningOverview
	{
		@Scrape(
				value = "#versionclick #vsPanel > li > a:contains(2008)",
				attribute = "abs:href",
				converter = ConstructConverter.class)
		public WarningOverview[] olderVersions;

		public RuleCategorySite()
		{
			super(BASE_URL);
		}

		@Override
		public ScraperSource getSource()
		{
			return ScraperSource.fromUrl(BASE_URL);
		}

		@Override
		public Collection<WarningRule> getRules()
		{
			HashMap<String, WarningRule> map = new HashMap<>();

			for (WarningRule rule : super.getRules())
			{
				map.put(rule.id, rule);
			}

			for (WarningOverview overview : this.olderVersions)
			{
				for (WarningRule rule : overview.getRules())
				{
					if (!map.containsKey(rule.id))
					{
						map.put(rule.id, rule);
					}
				}
			}
			return map.values();
		}
	}
}
