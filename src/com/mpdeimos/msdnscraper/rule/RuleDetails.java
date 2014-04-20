package com.mpdeimos.msdnscraper.rule;

/**
 * Describes a site containing rule details.
 * 
 * @author mpdeimos
 */
public abstract class RuleDetails
{
	/** The URL of the details site. */
	private final String url;

	/** Constructor. */
	public RuleDetails(String url)
	{
		this.url = url;
	}

	/** @see #url */
	public String getUrl()
	{
		return this.url;
	}
}
