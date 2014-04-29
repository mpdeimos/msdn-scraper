package eu.cqse.msdnscraper.rules.warnings;

import java.util.Collection;
import java.util.HashMap;

import com.mpdeimos.webscraper.Scrape;
import com.mpdeimos.webscraper.ScraperSource;
import com.mpdeimos.webscraper.conversion.ConstructConverter;

import eu.cqse.msdnscraper.rules.RuleResolver;

/**
 * Resolver for C# compiler warnings.
 * 
 * @author $Author: hummelb $
 * @version $Rev: 18709 $
 * @ConQAT.Rating YELLOW Hash: F9DA0F1FA9F3CDC95C503960EA33F9B0
 */
public class WarningRuleResolver extends RuleResolver {
	/** The base URL for scraping warnings from MSDN. */
	static final String BASE_URL = "http://msdn.microsoft.com/en-us/library/ms228296.aspx";

	/** {@inheritDoc} */
	@Override
	protected WarningRuleOverview getRuleProvider() {
		return new RuleVersionSite();
	}

	/** Scrapes compiler warnings for for visual studio 2013 and 2008. */
	public static class RuleVersionSite extends WarningRuleOverview {
		/**
		 * Scrapes the link to VisualStudio 2008 Rules. We could include all
		 * rules found, but it has been shown that just the 2008 and latest
		 * version contain rule changes.
		 */
		@Scrape(value = "#versionclick #vsPanel > li > a:contains(2008)", attribute = "abs:href", converter = ConstructConverter.class)
		public WarningRuleOverview[] olderVersions;

		/** Constructor. */
		public RuleVersionSite() {
			super(BASE_URL);
		}

		/** {@inheritDoc} */
		@Override
		public ScraperSource getSource() {
			return ScraperSource.fromUrl(BASE_URL);
		}

		/** {@inheritDoc} */
		@Override
		public Collection<WarningRule> getRules() {
			HashMap<String, WarningRule> map = new HashMap<>();

			for (WarningRule rule : super.getRules()) {
				map.put(rule.id, rule);
			}

			for (WarningRuleOverview overview : this.olderVersions) {
				for (WarningRule rule : overview.getRules()) {
					if (!map.containsKey(rule.id)) {
						map.put(rule.id, rule);
					}
				}
			}
			return map.values();
		}
	}
}
