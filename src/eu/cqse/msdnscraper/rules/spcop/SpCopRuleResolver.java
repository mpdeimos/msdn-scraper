package eu.cqse.msdnscraper.rules.spcop;

import java.util.ArrayList;
import java.util.Collection;

import com.mpdeimos.webscraper.Scrape;
import com.mpdeimos.webscraper.ScraperSource;
import com.mpdeimos.webscraper.ScraperSource.ScraperSourceProvider;
import com.mpdeimos.webscraper.conversion.ConstructConverter;

import eu.cqse.msdnscraper.rules.IRuleProvider;
import eu.cqse.msdnscraper.rules.Rule;
import eu.cqse.msdnscraper.rules.RuleResolver;

/**
 * Resolver for SpCop rules.
 * 
 * @author $Author: hummelb $
 * @version $Rev: 18709 $
 * @ConQAT.Rating YELLOW Hash: A42B8F3E5A2AFCB69A9E73887530CD67
 */
public class SpCopRuleResolver extends RuleResolver {
	/** The base url to start scraping from. */
	static final String BASE_URL = "http://docs.spcaf.com/v4/SPCAF_ANALYZER_RULES.html";

	/** {@inheritDoc} */
	@Override
	protected RuleCategorySite getRuleProvider() {
		return new RuleCategorySite();
	}

	/**
	 * The site available via SpCopRuleResolver#BASE_BASE_URL contains links to
	 * overview sites. These are scraped with this object.
	 */
	public static class RuleCategorySite implements ScraperSourceProvider,
			IRuleProvider {
		/** The rule overview sites found on this site. */
		@Scrape(value = ".OH_selfTocLinks > div a", attribute = "abs:href", converter = ConstructConverter.class)
		public SpCopRuleOverview[] overviews;

		/** {@inheritDoc} */
		@Override
		public ScraperSource getSource() {
			return ScraperSource.fromUrl(BASE_URL);
		}

		/** {@inheritDoc} */
		@Override
		public Collection<? extends Rule> getRules() {
			ArrayList<Rule> rules = new ArrayList<>();
			for (SpCopRuleOverview overview : overviews) {
				rules.addAll(overview.getRules());
			}
			return rules;
		}

	}
}
