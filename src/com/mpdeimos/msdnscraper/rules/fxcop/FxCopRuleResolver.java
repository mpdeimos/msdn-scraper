package com.mpdeimos.msdnscraper.rules.fxcop;

import com.mpdeimos.msdnscraper.rule.RuleOverview;
import com.mpdeimos.msdnscraper.rule.RuleResolver;
import com.mpdeimos.webscraper.ScraperException;

/** Resolver for FxCop Rules. Currently just managed rules are supported. */
public class FxCopRuleResolver extends RuleResolver
{
	/** {@inheritDoc} */
	@Override
	protected RuleOverview[] getRuleOverviewSites()
			throws ScraperException
	{
		return new RuleOverview[] { new ManagedRuleOverview() };
	}
}
