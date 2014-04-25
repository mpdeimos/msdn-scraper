package com.mpdeimos.msdnscraper.rules.fxcop;

import com.mpdeimos.msdnscraper.rule.RuleProvider;
import com.mpdeimos.msdnscraper.rule.RuleResolver;

/** Resolver for FxCop Rules. Currently just managed rules are supported. */
public class FxCopRuleResolver extends RuleResolver
{
	/** {@inheritDoc} */
	@Override
	protected RuleProvider getRuleProvider()
	{
		return new ManagedRuleOverview();
	}
}
