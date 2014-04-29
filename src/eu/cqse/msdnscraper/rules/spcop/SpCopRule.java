package eu.cqse.msdnscraper.rules.spcop;

import com.mpdeimos.webscraper.Scrape;
import com.mpdeimos.webscraper.conversion.ConstructConverter;

import eu.cqse.msdnscraper.rules.Rule;

/**
 * A SpCop rule.
 * 
 * @author $Author: hummelb $
 * @version $Rev: 18709 $
 * @ConQAT.Rating YELLOW Hash: F62A7CE3E616EEF21C3C82CCBF50A988
 */
public class SpCopRule implements Rule {
	/** @see #getId() */
	@Scrape(value = "td:nth-child(1)", regex = "(.*):.*")
	public String id;

	/** @see #getMessage() */
	@Scrape(value = "td:nth-child(1)", regex = ".*:(.*)")
	public String message;

	/** @see #getDescription() */
	@Scrape("td:nth-child(2)")
	public String description;

	/** The site to scrape further rule details. */
	@Scrape(value = "td:nth-child(1) a", attribute = "abs:href", converter = ConstructConverter.class)
	public SpCopRuleDetails details;

	/** {@inheritDoc} */
	@Override
	public String getId() {
		return id;
	}

	/** {@inheritDoc} */
	@Override
	public String getMessage() {
		return message;
	}

	/** {@inheritDoc} */
	@Override
	public String getDescription() {
		return description;
	}

	/** {@inheritDoc} */
	@Override
	public String getCategory() {
		return details.category;
	}

	/** {@inheritDoc} */
	@Override
	public String getSeverity() {
		return details.severity;
	}

	/** {@inheritDoc} */
	@Override
	public String getTypeName() {
		return details.typeName;
	}

}
