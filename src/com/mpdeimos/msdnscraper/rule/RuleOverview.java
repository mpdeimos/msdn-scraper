package com.mpdeimos.msdnscraper.rule;

import java.util.Collection;

/**
 * Describes a website containing an overview of rules.
 * 
 * @author mpdeimos
 */
public abstract class RuleOverview
{
	/** The url of the rule overview page. */
	private final String url;

	/** Constructor. */
	public RuleOverview(String url)
	{
		this.url = url;
	}

	/** @see #url */
	public String getUrl()
	{
		return this.url;
	}

	/** @return A collection of rules described by this overview site. */
	public abstract Collection<? extends Rule> getRules();
}
