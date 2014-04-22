package com.mpdeimos.msdnscraper.rule;

import com.mpdeimos.webscraper.ScraperSource;
import com.mpdeimos.webscraper.ScraperSource.ScraperSourceProvider;

import java.util.Collection;

/**
 * Describes a website containing an overview of rules.
 * 
 * @author mpdeimos
 */
public abstract class RuleOverview implements ScraperSourceProvider
{
	/** The url of the rule overview page. */
	private final String url;

	/** Constructor. */
	public RuleOverview(String url)
	{
		this.url = url;
	}

	/** {@inheritDoc} */
	@Override
	public ScraperSource getSource()
	{
		return ScraperSource.fromUrl(this.url);
	}

	/** @return A collection of rules described by this overview site. */
	public abstract Collection<? extends Rule> getRules();
}
