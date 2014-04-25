package com.mpdeimos.msdnscraper.rule;

import com.mpdeimos.webscraper.ScraperSource;

/**
 * Describes a website containing an overview of rules.
 * 
 * @author mpdeimos
 */
public abstract class RuleProvider implements IRuleProvider
{
	/** The url of the rule overview page. */
	private final String url;

	/** Constructor. */
	public RuleProvider(String url)
	{
		this.url = url;
	}

	/** {@inheritDoc} */
	@Override
	public ScraperSource getSource()
	{
		return ScraperSource.fromUrl(this.url);
	}
}
