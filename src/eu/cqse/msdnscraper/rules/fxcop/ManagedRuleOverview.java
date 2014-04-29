package eu.cqse.msdnscraper.rules.fxcop;

import java.util.Arrays;
import java.util.List;

import com.mpdeimos.webscraper.Scrape;
import com.mpdeimos.webscraper.conversion.DeepScrapeConverter;

import eu.cqse.msdnscraper.rules.Rule;
import eu.cqse.msdnscraper.rules.RuleProvider;

/**
 * Overview site containing several rules.
 * 
 * @author $Author: hummelb $
 * @version $Rev: 18709 $
 * @ConQAT.Rating YELLOW Hash: A81C0262D04E9FA37E832ABD6108084A
 */
public class ManagedRuleOverview extends RuleProvider {
	/** The website containing the rules. */
	private static final String OVERVIEW_URL = "http://msdn.microsoft.com/en-us/library/dd380629.aspx";

	/** The scraped rules. */
	@Scrape(value = "#mainBody .tableSection tr:has(td)", converter = DeepScrapeConverter.class)
	public ManagedRule[] rules;

	/** Constructor. */
	public ManagedRuleOverview() {
		super(OVERVIEW_URL);
	}

	/** {@inheritDoc} */
	@Override
	public List<? extends Rule> getRules() {
		return Arrays.asList(this.rules);
	}
}
