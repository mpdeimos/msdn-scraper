package com.mpdeimos.msdnscraper.rule;

import com.mpdeimos.webscraper.ScraperSource.ScraperSourceProvider;

public interface IRuleProvider extends ScraperSourceProvider
{
	public Rule[] getRules();
}
