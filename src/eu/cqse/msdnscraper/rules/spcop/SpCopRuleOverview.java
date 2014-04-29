package eu.cqse.msdnscraper.rules.spcop;

import java.util.Arrays;
import java.util.List;

import com.mpdeimos.webscraper.Scrape;
import com.mpdeimos.webscraper.conversion.DeepScrapeConverter;

import eu.cqse.msdnscraper.rules.Rule;
import eu.cqse.msdnscraper.rules.RuleProvider;

/**
 * Overview site containing several SpCop rules.
 * 
 * @author $Author: hummelb $
 * @version $Rev: 18709 $
 * @ConQAT.Rating YELLOW Hash: 4AC2D131F2FD697C3FC05C5D40C45C2A
 */
public class SpCopRuleOverview extends RuleProvider {
	/** @see #getRules() */
	@Scrape(value = "#mainBody .tableSection tr:has(td)", converter = DeepScrapeConverter.class)
	public SpCopRule[] rules;

	/** Constructor. */
	public SpCopRuleOverview(String url) {
		super(url);
	}

	/** {@inheritDoc} */
	@Override
	public List<? extends Rule> getRules() {
		return Arrays.asList(this.rules);
	}

}
