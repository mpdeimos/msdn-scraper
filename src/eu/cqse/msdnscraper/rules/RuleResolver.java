package eu.cqse.msdnscraper.rules;

import java.util.Collection;

import com.mpdeimos.webscraper.Scraper;
import com.mpdeimos.webscraper.Scraper.ScraperBuilder;
import com.mpdeimos.webscraper.ScraperException;

/**
 * Resolves rules from MSDN sites.
 * 
 * @author $Author: hummelb $
 * @version $Rev: 18709 $
 * @ConQAT.Rating YELLOW Hash: 96CC02E80E46C5ECB40B25A668400860
 */
public abstract class RuleResolver {
	/**
	 * Starts the scraper using the rules returned by {@link #getRuleProvider()}
	 */
	public final Rule[] resolve() throws ScraperException {
		IRuleProvider provider = getRuleProvider();
		ScraperBuilder builder = Scraper.builder();
		builder.add(provider);
		builder.build().scrape();

		Collection<? extends Rule> rules = provider.getRules();

		return rules.toArray(new Rule[rules.size()]);
	}

	/** Returns an object that can provide rules. */
	protected abstract IRuleProvider getRuleProvider();
}
