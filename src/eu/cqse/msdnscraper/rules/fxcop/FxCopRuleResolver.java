package eu.cqse.msdnscraper.rules.fxcop;

import eu.cqse.msdnscraper.rules.RuleProvider;
import eu.cqse.msdnscraper.rules.RuleResolver;

/**
 * Resolver for FxCop Rules. Currently just managed rules are supported.
 * 
 * @author $Author: hummelb $
 * @version $Rev: 18709 $
 * @ConQAT.Rating YELLOW Hash: 9C81CDD6BD7E2F99674BECC6C04E6C5C
 */
public class FxCopRuleResolver extends RuleResolver {
	/** {@inheritDoc} */
	@Override
	protected RuleProvider getRuleProvider() {
		return new ManagedRuleOverview();
	}
}
