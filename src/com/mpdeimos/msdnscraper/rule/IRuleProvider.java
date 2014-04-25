package com.mpdeimos.msdnscraper.rule;

import com.mpdeimos.webscraper.ScraperSource.ScraperSourceProvider;

import java.util.Collection;

public interface IRuleProvider extends ScraperSourceProvider
{
	public Collection<? extends Rule> getRules();
}
