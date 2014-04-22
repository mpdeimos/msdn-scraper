package com.mpdeimos.msdnscraper.rule;

import com.mpdeimos.webscraper.ScraperSource;
import com.mpdeimos.webscraper.ScraperSource.ScraperSourceProvider;

/**
 * Describes a site containing rule details.
 * 
 * @author mpdeimos
 */
public abstract class RuleDetails implements ScraperSourceProvider
{
	/** The URL of the details site. */
	private final String url;

	/** Constructor. */
	public RuleDetails(String url)
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
