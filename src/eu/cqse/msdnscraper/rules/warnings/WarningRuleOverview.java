package eu.cqse.msdnscraper.rules.warnings;

import java.util.Arrays;
import java.util.Collection;

import com.mpdeimos.webscraper.Scrape;
import com.mpdeimos.webscraper.conversion.ConstructConverter;

import eu.cqse.msdnscraper.rules.RuleProvider;

/**
 * A C# Compiler warning rule overview site.
 * 
 * @author $Author: hummelb $
 * @version $Rev: 18709 $
 * @ConQAT.Rating YELLOW Hash: 11B041C9C745CABF100D374DDB221813
 */
public class WarningRuleOverview extends RuleProvider {
	/** @see #getRules() */
	@Scrape(value = "#tocnav div.toclevel2 > a:contains(Compiler Warning)", attribute = "abs:href", converter = ConstructConverter.class)
	public WarningRule[] rules;

	/** Constructor. */
	public WarningRuleOverview(String url) {
		super(url);
	}

	/** {@inheritDoc} */
	@Override
	public Collection<WarningRule> getRules() {
		return Arrays.asList(this.rules);
	}
}
