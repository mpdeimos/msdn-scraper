package com.mpdeimos.msdnscraper.rule;

import com.mpdeimos.webscraper.Scraper;
import com.mpdeimos.webscraper.Scraper.ScraperBuilder;
import com.mpdeimos.webscraper.ScraperException;

import java.util.Collection;

public abstract class RuleResolver
{
	public final Rule[] resolve() throws ScraperException
	{
		IRuleProvider provider = getRuleProvider();
		ScraperBuilder builder = Scraper.builder();
		builder.add(provider);
		builder.build().scrape();

		Collection<? extends Rule> rules = provider.getRules();

		return rules.toArray(new Rule[rules.size()]);
	}

	protected abstract IRuleProvider getRuleProvider();
}
